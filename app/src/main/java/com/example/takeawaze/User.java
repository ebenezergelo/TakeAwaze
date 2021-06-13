package com.example.takeawaze;

public class User {
    public String USER_CELLNUM;
    public String USER_NAME;

    public User(String USER_CELLNUM, String USER_NAME) {
        this.USER_CELLNUM = USER_CELLNUM;
        this.USER_NAME = USER_NAME;
    }

    public String getUSER_CELLNUM() {
        return USER_CELLNUM;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_CELLNUM(String USER_CELLNUM) {
        this.USER_CELLNUM = USER_CELLNUM;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }
}
