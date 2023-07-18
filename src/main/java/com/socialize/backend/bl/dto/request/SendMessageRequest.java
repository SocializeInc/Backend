package com.socialize.backend.bl.dto.request;

public class SendMessageRequest {

    private String message;

    private String targetName;

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return "SendMessageRequest{" +
                "message='" + message + '\'' +
                ", targetName='" + targetName + '\'' +
                '}';
    }

}
