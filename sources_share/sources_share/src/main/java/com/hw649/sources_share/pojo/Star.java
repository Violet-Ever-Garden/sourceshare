package com.hw649.sources_share.pojo;

public class Star {
    private int id;
    private int passage;
    private String auth;

    public Star(){}

    public Star(int passage, String auth) {
        this.passage = passage;
        this.auth = auth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassage() {
        return passage;
    }

    public void setPassage(int passage) {
        this.passage = passage;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }
}
