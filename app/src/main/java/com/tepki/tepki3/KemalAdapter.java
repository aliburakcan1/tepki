package com.tepki.tepki3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;


import java.util.ArrayList;

/**
 * Created by x on 27.01.2018.
 */

public class KemalAdapter extends BaseAdapter {
    Context c;
    ArrayList<Kemal> kemaller;

    public KemalAdapter(Context ctx, ArrayList<Kemal> kemaller){
        this.c=ctx;
        this.kemaller=kemaller;
    }

    @Override
    public int getCount() {
        return kemaller.size();
    }

    @Override
    public Object getItem(int pos) {
        return kemaller.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return kemaller.indexOf(getItem(pos));
    }

    @Override
    public View getView(final int pos, View convertView, final ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.model2, null);
        }
        final Button button = convertView.findViewById(R.id.button);
        button.setText(kemaller.get(pos).getName());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((GridView)parent).performItemClick(view,pos,0);
            }
        });
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });

        return convertView;
    }
}

class Kemal {
    private  String name;
    private int img;

    public Kemal(String name, int img){
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
