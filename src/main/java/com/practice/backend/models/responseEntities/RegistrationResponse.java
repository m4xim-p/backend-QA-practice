package com.practice.backend.models.responseEntities;

public class RegistrationResponse {
    private boolean success;
    private String message;

    public RegistrationResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public RegistrationResponse(RegistrationResponse response) {
        this.success = response.success;
        this.message = response.message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
