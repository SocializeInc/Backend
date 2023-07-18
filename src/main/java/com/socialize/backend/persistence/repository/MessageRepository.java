package com.socialize.backend.persistence.repository;

import com.socialize.backend.persistence.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long>, JpaSpecificationExecutor<Message> {

    @Query("SELECT m FROM Message m WHERE m.roomId = :id")
    List<Message> findMessageByRoomId(Long id);
}
