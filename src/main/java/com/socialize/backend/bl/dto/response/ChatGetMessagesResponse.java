package com.socialize.backend.bl.dto.response;

import com.socialize.backend.persistence.domain.Message;

import java.util.List;

public class ChatGetMessagesResponse {

    private String roomName;
    private List<Message> messages;

    public ChatGetMessagesResponse(String roomName, List<Message> messages) {
        this.roomName = roomName;
        this.messages = messages;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
