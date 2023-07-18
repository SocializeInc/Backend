package com.socialize.backend.persistence.repository;

import com.socialize.backend.persistence.domain.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long>, JpaSpecificationExecutor<ChatRoom> {

    @Query("SELECT cR FROM ChatRoom cR WHERE cR.userId = :userId AND cR.joinUserId = :joinUserId")
    ChatRoom roomList(Long userId, Long joinUserId);

    @Query("SELECT cR FROM ChatRoom cR WHERE cR.userId = :id OR cR.joinUserId = :id")
    List<ChatRoom> findRoomsById(Long id);

    @Query("SELECT cR.name FROM ChatRoom cR WHERE cR.id = :id")
    String findRoomNameById(Long id);
}
