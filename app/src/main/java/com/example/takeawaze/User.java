package com.example.takeawaze;

public class User {
    public String USER_PHONE;
    public String USER_NAME;

    public User(String USER_PHONE, String USER_NAME) {
        this.USER_PHONE = USER_PHONE;
        this.USER_NAME = USER_NAME;
    }

    public String getUSER_PHONE() {
        return USER_PHONE;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_PHONE(String USER_PHONE) {
        this.USER_PHONE = USER_PHONE;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }
}
