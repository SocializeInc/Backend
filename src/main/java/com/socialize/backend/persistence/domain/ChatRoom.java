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

    @NotBlank
    @Size(min = 3, max = 25)
    private String name;

    @NotNull
    private Calendar createdAt;

    public ChatRoom() {

    }

    public ChatRoom(Long userId, Long joinUserId, String name, Calendar createdAt) {
        this.userId = userId;
        this.joinUserId = joinUserId;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", name='" + name + '\'' +
                ", createDate=" + createdAt +
                '}';
    }
}
