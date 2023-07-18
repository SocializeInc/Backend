package com.socialize.backend.controller;

import com.socialize.backend.bl.dto.request.MessagesCreateRoomRequest;
import com.socialize.backend.bl.dto.request.SendMessageRequest;
import com.socialize.backend.bl.dto.response.MessagesGetRoomsResponse;
import com.socialize.backend.bl.dto.response.ChatGetMessagesResponse;
import com.socialize.backend.bl.dto.response.MessagesRoomResponse;
import com.socialize.backend.persistence.domain.ChatRoom;
import com.socialize.backend.persistence.domain.Message;
import com.socialize.backend.persistence.repository.ChatRoomRepository;
import com.socialize.backend.persistence.repository.MessageRepository;
import com.socialize.backend.persistence.repository.UserRepository;
import com.socialize.backend.persistence.service.ChatRoomService;
import com.socialize.backend.security.service.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/socialize/api/messages")
public class MessageController {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatRoomService chatRoomService;
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    @Autowired
    public MessageController(ChatRoomRepository chatRoomRepository, ChatRoomService chatRoomService, MessageRepository messageRepository, UserRepository userRepository) {
        this.chatRoomRepository = chatRoomRepository;
        this.chatRoomService = chatRoomService;
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    @PostMapping(value = "/createRoom", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> createChatRoom(@Valid @RequestBody MessagesCreateRoomRequest messagesCreateRoomRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        String receiverUsername = messagesCreateRoomRequest.getJoinUsername();

        ChatRoom room = chatRoomRepository.findRoomByParticipantIds(userPrincipal.getId(), userRepository.findIdByUsername(receiverUsername));
        if (room != null){
            return ResponseEntity.ok(room.getId());
        }

        if (userPrincipal.getId().equals(userRepository.findIdByUsername(receiverUsername))){
            return ResponseEntity.badRequest().body("You cant create a chatroom with yourself!");
        }

        ChatRoom chatRoom = new ChatRoom(userPrincipal.getId(), userRepository.findIdByUsername(receiverUsername), Calendar.getInstance());
        chatRoomRepository.save(chatRoom);

        return ResponseEntity.ok(chatRoom.getId());
    }


    @GetMapping("/getRooms")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> getRooms() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        List<ChatRoom> rooms = chatRoomRepository.findRoomsByUserId(userPrincipal.getId());

        List<MessagesRoomResponse> roomsResponse = new ArrayList<>();
        rooms.stream()
                .forEach(room -> {
                    if (room.getJoinUserId().equals(userPrincipal.getId())) {
                        roomsResponse.add(new MessagesRoomResponse(room.getId(), userRepository.findUsernameById(room.getUserId())));
                    } else {
                        roomsResponse.add(new MessagesRoomResponse(room.getId(), userRepository.findUsernameById(room.getJoinUserId())));
                    }
                });

        return ResponseEntity.ok(new MessagesGetRoomsResponse(roomsResponse));
    }

    @GetMapping("/{id}/getMessages")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> getMessages(@PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        List<Message> messages = messageRepository.findMessageByRoomId(id);
        String roomName;

        if (chatRoomRepository.findRoomById(id).getJoinUserId().equals(userPrincipal.getId())) {
            roomName = userRepository.findUsernameById(chatRoomRepository.findRoomById(id).getUserId());
        } else {
            roomName = userRepository.findUsernameById(chatRoomRepository.findRoomById(id).getJoinUserId());
        }

        return ResponseEntity.ok(new ChatGetMessagesResponse(roomName, messages));
    }

    @PostMapping("/{id}/sendMessage")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> getMessages(@PathVariable Long id, @Valid @RequestBody SendMessageRequest sendMessageRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        Message message = new Message(sendMessageRequest.getMessage(), userPrincipal.getId(), userRepository.findIdByUsername(sendMessageRequest.getTargetName()), Calendar.getInstance(), false, id);
        messageRepository.save(message);

        return ResponseEntity.ok("Message sent");
    }
}
