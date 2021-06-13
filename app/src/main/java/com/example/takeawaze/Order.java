package com.example.takeawaze;

public class Order {
    public int ORDER_NUM;
    public String USER_NUM;
    public String STAFF_NUM;
    public String STATUS;
    public boolean RATING;

    public Order(int ORDER_NUM, String USER_NUM, String STAFF_NUM, String STATUS, boolean RATING) {
        this.ORDER_NUM = ORDER_NUM;
        this.USER_NUM = USER_NUM;
        this.STAFF_NUM = STAFF_NUM;
        this.STATUS = STATUS;
        this.RATING = RATING;
    }

    public int getORDER_NUM() {
        return ORDER_NUM;
    }

    public String getUSER_NUM() {
        return USER_NUM;
    }

    public String getSTAFF_NUM() {
        return STAFF_NUM;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public boolean isRATING() {
        return RATING;
    }

    public void setORDER_NUM(int ORDER_NUM) {
        this.ORDER_NUM = ORDER_NUM;
    }

    public void setUSER_NUM(String USER_NUM) {
        this.USER_NUM = USER_NUM;
    }

    public void setSTAFF_NUM(String STAFF_NUM) {
        this.STAFF_NUM = STAFF_NUM;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public void setRATING(boolean RATING) {
        this.RATING = RATING;
    }
}
