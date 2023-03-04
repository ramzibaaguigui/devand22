package com.devfest.api.model;

public class LoginRequest {
    private String email;
    private String password;
    private boolean doctor;

    public static LoginRequest createLoginRequest() {
        return new LoginRequest();
    }

    public LoginRequest withEmail(String email){
        this.email = email;
        return this;
    }

    public LoginRequest isDoctor(boolean doctor) {
        this.doctor = doctor;
        return this;
    }

    public LoginRequest withPassword(String password) {
        this.password = password;
        return this;
    }
}
