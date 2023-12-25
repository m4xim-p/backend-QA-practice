package com.practice.backend.models.responseEntities;

public class RegistrationResponse {
    private boolean result;
    private String message;
    private String token;

    public RegistrationResponse(boolean result, String message, String token) {
        this.result = result;
        this.message = message;
        this.token = token;
    }

    public RegistrationResponse(boolean result, String message) {
        this.result = result;
        this.message = message;
    }

    public RegistrationResponse(RegistrationResponse response) {
        this.result = response.result;
        this.message = response.message;
        this.token = response.token;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
