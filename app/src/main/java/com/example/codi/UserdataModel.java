package com.example.codi;

import java.io.File;

public class UserdataModel {
    private String ID;
    private String Nickname;
    private String Pwd;
    private File Profile;
    private String ClosetID;

    public UserdataModel(String id, String nick, String pwd, File profile, String closetid) {
        this.ID = id;
        this.Nickname = nick;
        this.Pwd = pwd;
        this.Profile = profile;
        this.ClosetID = closetid;
    }

    public void setID(String id) {
        this.ID = id;
    }

    public void  setNickname(String nickname) {
        this.Nickname = nickname;
    }

    public void setPwd(String pwd) {
        this.Pwd = pwd;
    }

    public void setProfile(File profile) {
        this.Profile = profile;
    }

    public void setClosetID(String closetID) {
        this.ClosetID = closetID;
    }

    public String getID() {
        return  ID;
    }
    public String getNickname() {
        return Nickname;
    }
    public String getPwd() {
        return Pwd;
    }
    public String getClosetID() {
        return ClosetID;
    }

    public File getProfile() {
        return Profile;
    }
}
