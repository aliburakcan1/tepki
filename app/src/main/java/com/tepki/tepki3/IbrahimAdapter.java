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

public class IbrahimAdapter extends BaseAdapter {
    Context c;
    ArrayList<Ibrahim> ibrahimler;

    public IbrahimAdapter(Context ctx, ArrayList<Ibrahim> ibrahimler){
        this.c=ctx;
        this.ibrahimler=ibrahimler;
    }

    @Override
    public int getCount() {
        return ibrahimler.size();
    }

    @Override
    public Object getItem(int pos) {
        return ibrahimler.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return ibrahimler.indexOf(getItem(pos));
    }

    @Override
    public View getView(final int pos, View convertView, final ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.model2, null);
        }
        final Button button = convertView.findViewById(R.id.button);
        button.setText(ibrahimler.get(pos).getName());
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

class Ibrahim {
    private  String name;
    private int img;

    public Ibrahim(String name, int img){
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
