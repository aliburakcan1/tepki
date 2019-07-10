package com.tepki.tepki3;

/**
 * Created by x on 28.07.2017.
 */

public class Player {
    private  String name;
    private String img;

    public Player(String name, String img){
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
