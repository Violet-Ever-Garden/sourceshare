package com.hw649.sources_share.pojo;

import java.sql.Date;
import java.sql.Timestamp;

public class Comment {
    private int id;
    private String auth;
    private int passage;
    private String text;
    private Date time;

    public Comment(){}

    public Comment(String auth, int passage, String text) {
        this.auth = auth;
        this.passage = passage;
        this.text = text;
        this.time = new java.sql.Date(new java.util.Date().getTime());
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public int getPassage() {
        return passage;
    }

    public void setPassage(int passage) {
        this.passage = passage;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
