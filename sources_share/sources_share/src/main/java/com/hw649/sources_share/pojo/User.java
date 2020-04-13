package com.hw649.sources_share.pojo;

import javax.security.auth.message.callback.PrivateKeyCallback;
import java.util.Date;

public class User {
    private String email;
    private String name;
    private String pwd;
    private Date time;
    private String perms;
    private String signature;
    private int age;
    public User(){ }
    public User(String email, String name, String pwd, Date time, String perms,  String signature, int age) {
        this.email = email;
        this.name = name;
        this.pwd = pwd;
        this.time = time;
        this.perms = perms;
        this.signature = signature;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
