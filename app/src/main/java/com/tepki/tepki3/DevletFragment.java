package com.tepki.tepki3;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;


import java.util.ArrayList;

public class DevletFragment extends Fragment implements View.OnLongClickListener {

    Activity titleChange;
    String url=null;
    String imgUri=null;
    ImageButton ib1;
    ImageButton ib2;
    ImageButton ib3;
    ImageButton ib4;
    ImageButton ib5;
    ImageButton ib6;
    ImageButton ib7;
    ImageButton ib8;
    ImageButton ib9;
    ImageButton ib10;

    public DevletFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        titleChange.setTitle("Google Plus");
        return inflater.inflate(R.layout.fragment_devlet, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ib1 = getActivity().findViewById(R.id.imageButton1);
        ib2 =  getActivity().findViewById(R.id.imageButton2);
        ib3 = getActivity().findViewById(R.id.imageButton3);
        ib4 =  getActivity().findViewById(R.id.imageButton4);
        ib5 = getActivity().findViewById(R.id.imageButton5);
        ib6 =  getActivity().findViewById(R.id.imageButton6);
        ib7 = getActivity().findViewById(R.id.imageButton7);
        ib8 =  getActivity().findViewById(R.id.imageButton8);
        ib9 =  getActivity().findViewById(R.id.imageButton9);
        ib10 =getActivity().findViewById(R.id.imageButton10);

        ib1.setOnLongClickListener(this);
        ib2.setOnLongClickListener(this);
        ib3.setOnLongClickListener(this);
        ib4.setOnLongClickListener(this);
        ib5.setOnLongClickListener(this);
        ib6.setOnLongClickListener(this);
        ib7.setOnLongClickListener(this);
        ib8.setOnLongClickListener(this);
        ib9.setOnLongClickListener(this);
        ib10.setOnLongClickListener(this);

        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DevletFragment.this.getActivity(),VideoViewActivity.class);
                String url="https://video-frx5-1.xx.fbcdn.net/v/t42.1790-2/26055017_202826290279082_8660131662039875584_n.mp4?efg=eyJ2ZW5jb2RlX3RhZyI6InN2ZV9zZCJ9&oh=8329cef14c3935d0a1f45b17c39a796c&oe=5A6D3ADC";
                intent.putExtra("videoUri",url);
                startActivity(intent);
            }
        });
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DevletFragment.this.getActivity(),VideoViewActivity.class);
                String url="https://content-na.drive.amazonaws.com/cdproxy/templink/w3yPekt_JT5HA4hdZ-FeybCx7O67N1l37lMlmfn8LKMeJxFPc";
                intent.putExtra("videoUri",url);
                startActivity(intent);
            }
        });
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DevletFragment.this.getActivity(),VideoViewActivity.class);
                String url="https://sendvid.com/6m4qh4ac.mp4";
                intent.putExtra("videoUri",url);
                startActivity(intent);
            }
        });
        ib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DevletFragment.this.getActivity(),VideoViewActivity.class);
                String url="https://sendvid.com/erun8n8a.mp4";
                intent.putExtra("videoUri",url);
                startActivity(intent);
            }
        });
        ib5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DevletFragment.this.getActivity(),VideoViewActivity.class);
                String url="https://sendvid.com/t0i3hg56.mp4";
                intent.putExtra("videoUri",url);
                startActivity(intent);
            }
        });
        ib6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DevletFragment.this.getActivity(),VideoViewActivity.class);
                String url="https://sendvid.com/gzkig9p7.mp4";
                intent.putExtra("videoUri",url);
                startActivity(intent);
            }
        });
        ib7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DevletFragment.this.getActivity(),VideoViewActivity.class);
                String url="https://sendvid.com/mk167s04.mp4";
                intent.putExtra("videoUri",url);
                startActivity(intent);
            }
        });
        ib8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DevletFragment.this.getActivity(),VideoViewActivity.class);
                String url="https://sendvid.com/esmcvwq8.mp4";
                intent.putExtra("videoUri",url);
                startActivity(intent);
            }
        });
        ib9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(DevletFragment.this.getActivity(),VideoViewActivity.class);
                String url="https://sendvid.com/kfqa6rms.mp4";
                intent.putExtra("videoUri",url);
                startActivity(intent);
            }
        });
        ib10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DevletFragment.this.getActivity(),VideoViewActivity.class);
                String url="https://sendvid.com/8hxy8lwr.mp4";
                intent.putExtra("videoUri",url);
                startActivity(intent);
            }
        });

    }
    private void startDownload(String url) {
        new DownloadFileAsync(getContext()).execute(url);
    }

    // Activity metodunu fragment içinde kullanmak içi attach işlemi yapıyoruz
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        titleChange = (MainActivity) activity;
    }

    public boolean onLongClick(View view) {
        switch(view.getId()){
            case R.id.imageButton1:
                url="https://video-frx5-1.xx.fbcdn.net/v/t42.1790-2/26055017_202826290279082_8660131662039875584_n.mp4?efg=eyJ2ZW5jb2RlX3RhZyI6InN2ZV9zZCJ9&oh=8329cef14c3935d0a1f45b17c39a796c&oe=5A6D3ADC";
                imgUri="android.resource://com.example.x.tepki3/" + R.drawable.tumblr;
                registerForContextMenu(view);
                break;
            case R.id.imageButton2:
                url="https://sendvid.com/z7g5cosa.mp4";
                imgUri="android.resource://com.example.x.tepki2/" + R.drawable.facebook;
                registerForContextMenu(view);
                break;
            case R.id.imageButton3:
                url="https://sendvid.com/6m4qh4ac.mp4";
                registerForContextMenu(view);
                break;
            case R.id.imageButton4:
                url="https://sendvid.com/erun8n8a.mp4";
                registerForContextMenu(view);
                break;
            case R.id.imageButton5:
                url="https://sendvid.com/t0i3hg56.mp4";
                registerForContextMenu(view);
                break;
            case R.id.imageButton6:
                url="https://sendvid.com/gzkig9p7.mp4";
                registerForContextMenu(view);
                break;
            case R.id.imageButton7:
                url="https://sendvid.com/mk167s04.mp4";
                registerForContextMenu(view);
                break;
            case R.id.imageButton8:
                url="https://sendvid.com/esmcvwq8.mp4";
                registerForContextMenu(view);
                break;
            case R.id.imageButton9:
                url="https://sendvid.com/kfqa6rms.mp4";
                registerForContextMenu(view);
                break;
            case R.id.imageButton10:
                url="https://sendvid.com/8hxy8lwr.mp4";
                registerForContextMenu(view);
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
        if(CheckIsDataAlreadyInDBorNot(url)==true){
            menu.add(0,v.getId(),0,"Favorilerden cikar");
        }
        else {
            menu.add(0, v.getId(), 0, "Favorilere ekle");
        }
    }
    public boolean onContextItemSelected(MenuItem item) {
        final DBAdapter db=new DBAdapter(getActivity().getApplicationContext(),null);
        if (item.getTitle() == "Gönder") {
            startDownload(url);
        }
        if (item.getTitle() == "Favorilere ekle") {
            db.openDB();
            long result = db.add(url, imgUri);
            if (result == 0) {
                Toast.makeText(getContext(), "failure", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "eklendi", Toast.LENGTH_SHORT).show();
            }
                db.close();
            }
        if (item.getTitle() == "Favorilerden cikar") {
            db.openDB();
            boolean result = db.deleteTitle(url);
            if (result == false) {
                Toast.makeText(getContext(), "failure", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "silindi", Toast.LENGTH_SHORT).show();
            }
        }
        return true;
    }

    public boolean CheckIsDataAlreadyInDBorNot(String uri){
        ArrayList<String> names2=new ArrayList<>();
        DBAdapter db=new DBAdapter(getActivity().getApplicationContext(),null);
        db.openDB();
        Cursor c=db.getAllValues();
        while(c.moveToNext()){
            String name=c.getString(1);
            names2.add(name);
        }
        if (names2.contains(uri)){
            return true;
        }
        else{
            return false;
        }
    }
}
