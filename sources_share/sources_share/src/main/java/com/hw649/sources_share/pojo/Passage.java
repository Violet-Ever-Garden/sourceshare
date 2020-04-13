package com.hw649.sources_share.pojo;

import java.sql.Timestamp;

public class Passage {
    private int id;
    private String title;
    private String introduction;
    private String url;
    private String pwd;
    //state 有 审核中 和 已发布 两种状态
    private String state;
    private Timestamp time;
    private String auth;
    private int praise;
    private String label;
    private int readnum;



    public Passage(){}

    public Passage(String title, String introduction, String url, String pwd, Timestamp time,String state,String auth,int praise,String label) {
        this.title = title;
        this.introduction = introduction;
        this.url = url;
        this.pwd = pwd;
        this.time = time;
        this.state = state;
        this.auth = auth;
        this.praise = praise;
        this.label = label;
        this.readnum=0;
    }

    public int getReadnum() {
        return readnum;
    }

    public void setReadnum(int readnum) {
        this.readnum = readnum;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
