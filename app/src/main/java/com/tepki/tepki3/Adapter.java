package com.tepki.tepki3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;


import java.util.ArrayList;

/**
 * Created by x on 28.07.2017.
 */

public class Adapter extends BaseAdapter implements Filterable {
    Context c;
    ArrayList<Player> players;
    ArrayList<Player> filterList;
    CustomFilter filter;

    public  Adapter(Context ctx,ArrayList<Player> players){
        this.c=ctx;
        this.players=players;
        this.filterList=players;
    }

    @Override
    public int getCount() {
        return players.size();
    }

    @Override
    public Object getItem(int pos) {
        return players.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return players.indexOf(getItem(pos));
    }

    @Override
    public View getView(final int pos, View convertView, final ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.model2, null);
        }
        Button button = convertView.findViewById(R.id.button);

        button.setText(players.get(pos).getName());
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

    @Override
    public Filter getFilter() {
        if(filter==null){
            filter=new CustomFilter();
        }

        return filter;
    }

    class CustomFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results=new FilterResults();
            if(constraint !=null && constraint.length()>0){
                constraint=constraint.toString().toUpperCase();
                ArrayList<Player>filters=new ArrayList<Player>();
                for (int i=0;i<filterList.size();i++){
                    if(filterList.get(i).getName().toUpperCase().contains(constraint)){
                        Player p=new Player(filterList.get(i).getName(),filterList.get(i).getImg());
                        filters.add(p);
                    }
                }
                results.count=filters.size();
                results.values=filters;
            }else{
                results.count=filterList.size();
                results.values=filterList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            players=(ArrayList<Player>)results.values;
            notifyDataSetChanged();

        }
    }
}
