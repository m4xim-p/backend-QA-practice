package com.practice.backend.models.responseEntities;

public class AuthResponse {
    private boolean authenticated;
    private String message;
    private String token;


    public AuthResponse(boolean authResult, String message) {
        this.authenticated = authResult;
        this.message = message;
    }

    public AuthResponse(boolean authResult, String message, String token) {
        this.authenticated = authResult;
        this.message = message;
        this.token = token;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
