package com.athk.lpl.Entity;

public class match {
    private String mID;
    private String winner;
    private String loser;
    private String mvp;
    private String m_time;

    public void setmID(String mID) {
        this.mID = mID;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setLoser(String loser) {
        this.loser = loser;
    }

    public void setMvp(String mvp) {
        this.mvp = mvp;
    }

    public void setM_time(String m_time) {
        this.m_time = m_time;
    }

    public String getmID() {
        return mID;
    }

    public String getWinner() {
        return winner;
    }

    public String getLoser() {
        return loser;
    }

    public String getMvp() {
        return mvp;
    }

    public String getM_time() {
        return m_time;
    }
}
