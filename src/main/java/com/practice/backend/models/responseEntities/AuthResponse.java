package com.practice.backend.models.responseEntities;

public class AuthResponse {
    private boolean authenticated;
    private String message;

    public AuthResponse(boolean authResult, String message) {
        this.authenticated = authResult;
        this.message = message;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
