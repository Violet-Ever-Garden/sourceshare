package com.athk.lpl.Entity;

public class team {
    private String tname;
    private String location;
    private int win;
    private int lose;

    public String getTname() {
        return tname;
    }

    public String getLocation() {
        return location;
    }

    public int getWin() {
        return win;
    }

    public int getLose() {
        return lose;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }
}
