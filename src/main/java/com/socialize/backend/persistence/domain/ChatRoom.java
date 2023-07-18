package com.socialize.backend.persistence.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Calendar;

@Entity
@Table( name = "chat_room")
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long userId;


    private Long joinUserId;

    @NotNull
    private Calendar createdAt;

    public ChatRoom() {

    }

    public ChatRoom(Long userId, Long joinUserId, Calendar createdAt) {
        this.userId = userId;
        this.joinUserId = joinUserId;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getJoinUserId() {
        return joinUserId;
    }

    public void setJoinUserId(Long joinUserId) {
        this.joinUserId = joinUserId;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "ChatRoom{" +
                "id=" + id +
                ", userId=" + userId +
                ", joinUserId=" + joinUserId +
                ", createDate=" + createdAt +
                '}';
    }
}