package com.example.codi;

import java.io.File;
import java.util.ArrayList;

public class ClosetModel {

    String ClosetID;
    ArrayList<Top> top;
    ArrayList<Pants> pants;

    public ClosetModel() {
        top = new ArrayList<>();
        pants = new ArrayList<>();
    }

    public void setClosetID(String closetID) {
        this.ClosetID = closetID;
    }

    public void setPants(Pants pants) {
        this.pants.add(pants);
    }

    public void setTop(Top top) {
        this.top.add(top);
    }

    public Pants getPants(int index) {
        return pants.get(index);
    }

    public Top getTop(int index) {
        return top.get(index);
    }

    public String getClosetID() {
        return ClosetID;
    }
}

class Top {
    String kinds;
    String ID;
    File image;

    public Top() {}

    public Top(String kinds, String ID, File image) {
        this.ID = ID;
        this.kinds = kinds;
        this.image = image;
    }

    public void setKinds(String kinds) {
        this.kinds = kinds;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getKinds() {
        return kinds;
    }

    public String getID() {
        return ID;
    }

    public File getImage() {
        return image;
    }
}

class Pants {
    String kinds;
    String ID;
    File image;

    public Pants() {}

    public Pants(String kinds, String ID, File image) {
        this.ID = ID;
        this.kinds = kinds;
        this.image = image;
    }

    public void setKinds(String kinds) {
        this.kinds = kinds;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getKinds() {
        return kinds;
    }

    public File getImage() {
        return image;
    }

    public String getID() {
        return ID;
    }
}
