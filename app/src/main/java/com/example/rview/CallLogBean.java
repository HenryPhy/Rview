package com.example.rview;
public class CallLogBean {
    String id;
    String number;
    String time;
    public CallLogBean() {
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CallLogBean(String id, String number, String time) {
        this.id = id;
        this.number = number;
        this.time = time;
    }
}
