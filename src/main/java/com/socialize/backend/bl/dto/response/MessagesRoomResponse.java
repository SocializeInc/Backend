package com.socialize.backend.bl.dto.response;

public class MessagesRoomResponse {

    private Long Id;

    private String roomName;

    public MessagesRoomResponse(Long id, String roomName) {
        Id = id;
        this.roomName = roomName;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
