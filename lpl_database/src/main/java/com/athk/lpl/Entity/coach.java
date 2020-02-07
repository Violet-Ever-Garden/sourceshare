package com.athk.lpl.Entity;

public class coach {
    private String cname;
    private String team;
    private String nationality;
    private int cage;

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setCage(int cage) {
        this.cage = cage;
    }

    public String getCname() {
        return cname;
    }

    public String getTeam() {
        return team;
    }

    public String getNationality() {
        return nationality;
    }

    public int getCage() {
        return cage;
    }
}
