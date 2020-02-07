package com.athk.lpl.Entity;

public class player {
    private String p_name;
    private int p_age;
    private String place;
    private int p_kill;
    private int p_death;
    private int p_assist;
    private String team;

    public String getP_name() {
        return p_name;
    }

    public int getP_age() {
        return p_age;
    }

    public String getPlace() {
        return place;
    }

    public int getP_kill() {
        return p_kill;
    }

    public int getP_death() {
        return p_death;
    }

    public int getP_assist() {
        return p_assist;
    }

    public String getTeam() {
        return team;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public void setP_age(int p_age) {
        this.p_age = p_age;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setP_kill(int p_kill) {
        this.p_kill = p_kill;
    }

    public void setP_death(int p_death) {
        this.p_death = p_death;
    }

    public void setP_assist(int p_assist) {
        this.p_assist = p_assist;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
