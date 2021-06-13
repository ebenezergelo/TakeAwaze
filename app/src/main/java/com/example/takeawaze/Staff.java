package com.example.takeawaze;

public class Staff {
    public String STAFF_NUM;
    public String STAFF_NAME;
    public String RESTAURANT;
    public String STAFF_PASSWORD;

    public Staff(String STAFF_NUM, String STAFF_NAME, String RESTAURANT, String STAFF_PASSWORD) {
        this.STAFF_NUM = STAFF_NUM;
        this.STAFF_NAME = STAFF_NAME;
        this.RESTAURANT = RESTAURANT;
        this.STAFF_PASSWORD = STAFF_PASSWORD;
    }

    public String getSTAFF_NUM() {
        return STAFF_NUM;
    }

    public String getSTAFF_NAME() {
        return STAFF_NAME;
    }

    public String getRESTAURANT() {
        return RESTAURANT;
    }

    public String getSTAFF_PASSWORD() {
        return STAFF_PASSWORD;
    }

    public void setSTAFF_NUM(String STAFF_NUM) {
        this.STAFF_NUM = STAFF_NUM;
    }

    public void setSTAFF_NAME(String STAFF_NAME) {
        this.STAFF_NAME = STAFF_NAME;
    }

    public void setRESTAURANT(String RESTAURANT) {
        this.RESTAURANT = RESTAURANT;
    }

    public void setSTAFF_PASSWORD(String STAFF_PASSWORD) {
        this.STAFF_PASSWORD = STAFF_PASSWORD;
    }
}
