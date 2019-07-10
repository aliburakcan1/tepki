package com.tepki.tepki3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by x on 27.01.2018.
 */

public class TayyipAdapter extends BaseAdapter {
    Context c;
    ArrayList<Tayyip> tayyipler;

    public TayyipAdapter(Context ctx, ArrayList<Tayyip> tayyipler){
        this.c=ctx;
        this.tayyipler=tayyipler;
    }

    @Override
    public int getCount() {
        return tayyipler.size();
    }

    @Override
    public Object getItem(int pos) {
        return tayyipler.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return tayyipler.indexOf(getItem(pos));
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.model, null);
        }
        TextView nameTxt = convertView.findViewById(R.id.nameTv);
        ImageView img = convertView.findViewById(R.id.imageView1);

        nameTxt.setText(tayyipler.get(pos).getName());
        img.setImageResource(tayyipler.get(pos).getImg());

        return convertView;
    }
}

class Tayyip {
    private  String name;
    private int img;

    public Tayyip(String name, int img){
        this.img=img;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
