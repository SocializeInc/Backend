package com.socialize.backend.bl.dto.response;

import java.util.List;

public class MessagesGetRoomsResponse {

    private List<MessagesRoomResponse> users;

    public MessagesGetRoomsResponse(List<MessagesRoomResponse> users) {
        this.users = users;
    }

    public List<MessagesRoomResponse> getUsers() {
        return users;
    }

    public void setUsers(List<MessagesRoomResponse> users) {
        this.users = users;
    }
}
