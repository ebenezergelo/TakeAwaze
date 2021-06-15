package com.example.takeawaze;

public class Order {
    public int ORDER_NUM;
    public String USER_NAME;
    public String STAFF_NAME;
    public String RESTAURANT;
    public String STATUS;
    public String TIME;
    public int RATING;

    public Order(int ORDER_NUM, String USER_NAME, String STAFF_NAME,
                 String RESTAURANT, String STATUS, String TIME, int RATING) {
        this.ORDER_NUM = ORDER_NUM;
        this.USER_NAME = USER_NAME;
        this.STAFF_NAME = STAFF_NAME;
        this.RESTAURANT = RESTAURANT;
        this.STATUS = STATUS;
        this.TIME = TIME;
        this.RATING = RATING;
    }

    public int getORDER_NUM() {
        return ORDER_NUM;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public String getSTAFF_NAME() {
        return STAFF_NAME;
    }

    public String getRESTAURANT() {
        return RESTAURANT;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public String getTIME() {
        return TIME;
    }

    public int isRATING() {
        return RATING;
    }

    public void setORDER_NUM(int ORDER_NUM) {
        this.ORDER_NUM = ORDER_NUM;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public void setSTAFF_NAME(String STAFF_NAME) {
        this.STAFF_NAME = STAFF_NAME;
    }

    public void setRESTAURANT(String RESTAURANT) {
        this.RESTAURANT = RESTAURANT;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public void setTIME(String TIME) {
        this.TIME = TIME;
    }

    public void setRATING(int RATING) {
        this.RATING = RATING;
    }
}
