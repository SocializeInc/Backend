package com.socialize.backend.bl.dto.request;

import jakarta.validation.constraints.NotBlank;

public class MessagesCreateRoomRequest {

    @NotBlank
    private String joinUsername;

    public String getJoinUsername() {
        return joinUsername;
    }

    public void setJoinUsername(String joinUsername) {
        this.joinUsername = joinUsername;
    }

    @Override
    public String toString() {
        return "MessagesCreateRoomRequest{" +
                "joinUsername='" + joinUsername + '\'' +
                '}';
    }
}
