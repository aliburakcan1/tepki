package com.tepki.tepki3;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


import java.util.ArrayList;


public class TayyipFragment2 extends Fragment implements View.OnLongClickListener {

    Activity titleChange;
    String names [] ={"ya sen gerizekalı mısın?","hadi yap hadi yap hadi yap hadi yap"};


    public TayyipFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tayyip2, container, false);
        titleChange.setTitle("Facebook");
        GridView gridview = view.findViewById(R.id.gridView7);
        gridview.setAdapter(new TayyipAdapter(getContext(),getTayyipler()));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Toast.makeText(getContext(),i+"",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getContext(),i+"",Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    // Activity metodunu fragment içinde kullanmak içi attach işlemi yapıyoruz
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        titleChange = (MainActivity) activity;
    }

    @Override
    public boolean onLongClick(View view) {
        switch(view.getId()){
            case R.id.imageButton1:
                registerForContextMenu(view);
                break;
            case R.id.imageButton2:
                break;
            default:
                break;
        }
        return false;
    }
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0, v.getId(), 0, "Gönder");
        menu.add(0, v.getId(), 0, "Favorilere ekle");
    }
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Gönder") {

        } else if (item.getTitle() == "Action 2") {
            Toast.makeText(getContext(), "Action 2 invoked", Toast.LENGTH_SHORT).show();
        } else {
            return false;
        }
        return true;
    }

    public ArrayList<Tayyip> getTayyipler(){
        ArrayList<Tayyip> tayyipler=new ArrayList<>();
        Tayyip p;
        for(int i=0;i<names.length;i++){
            p=new Tayyip(names[i],R.drawable.tayyip);
            tayyipler.add(p);
        }
        return tayyipler;
    }
}