package com.tepki.tepki3;

/**
 * Created by x on 10.08.2017.
 */

public class Favori {
    private  String name;
    private String img;

    public Favori(String name, String img){
        this.img=img;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
