package com.socialize.backend.bl.dto.request;

import jakarta.validation.constraints.NotBlank;

public class SearchRequest {

    @NotBlank
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "SearchRequest{" +
                "data='" + data + '\'' +
                '}';
    }
}
