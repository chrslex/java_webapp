package com.chrslex.demo.rest;

public class StudentErrorResponse {
    private String message;
    private int status;
    private long timestamp;

    public StudentErrorResponse() {
        this.message = "";
        this.status = -1;
        this.timestamp = 999;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
