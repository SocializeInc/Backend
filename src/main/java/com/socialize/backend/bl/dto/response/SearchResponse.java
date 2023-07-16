package com.socialize.backend.bl.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.socialize.backend.persistence.domain.User;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResponse {

    private List<User> users;

    private String message;

    public SearchResponse(String message) {
        this.message = message;
    }
    public SearchResponse(List<User> users) {
       this.users = users;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
