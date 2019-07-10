package com.tepki.tepki3;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class FavoryActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 1;
    String[] names=new String[1000];
    String[] images=new String[1000] ;
    String url,btnname;
    static ArrayList<String> names2;
    ArrayList<String> images2;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_favory);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        GridView gv=findViewById(R.id.gridView2);
        registerForContextMenu(gv);

        DBAdapter db=new DBAdapter(this,getFavoriler());

        gv.setAdapter(db);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                itemler();
                Intent intent=new Intent(FavoryActivity.this,VideoViewActivity.class);
                intent.putExtra("videoUri",names2.get(i));
                startActivity(intent);
            }
        });

       /* db.openDB();
        Log.w("deneme","gelir mi4");
        Cursor c=db.getAllValues();
        Log.w("deneme","gelir mi5");
        while(c.moveToNext()){
            String name=c.getString(1);
            String name2=c.getString(2);
            Log.w("deneme","gelir mi5");
            //String name2=c.getString(2);
            //String name3=name+" "+name2;
            int i=0;
            Log.w("deneme","gelir mi51");
            names[i]=new String("");
            Log.w("deneme",name);
            Log.w("deneme",name2);
            int a= Integer.parseInt(name2);
            images[i]= new Integer(a);
            Log.w("deneme","gelir mi53");
            i++;
            Log.w("deneme","gelir mi6");
        } */
        db.close();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_favori,menu);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id==R.id.favorin){
            Toast.makeText(this,"Bunlar senin seçtiklerin",Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.button_search){
            Intent i = new Intent(this, SearchActivity.class);
            this.startActivity(i);
            return true;
        }

        if(id==R.id.buttonMainPage){
            Intent i = new Intent(this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            this.startActivity(i);

        }
        if (id == R.id.action_settings) {

            return true;
        }
        if(id==R.id.action_exit){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public ArrayList<Favori> getFavoriler(){
        ArrayList<Favori> favoriler= new ArrayList<>();
        Favori f;
        itemler();

        for(int i=0;i<names2.size();i++){

            f=new Favori(names2.get(i),images2.get(i));

            favoriler.add(f);

        }
        return favoriler;
    }
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        int i = info.position;
        btnname=images2.get(i);
        url=names2.get(i);
        menu.setHeaderTitle("Seç birini, ya da seçme sen bilirsin");
        menu.add( v.getId(),1, 0, "Gönder");
        boolean value = CheckIsDataAlreadyInDBorNot(url);
        if(value==true) menu.add(v.getId(),1,0,"Favorilerden çıkar");

        else menu.add( v.getId(),1, 0, "Favorilere ekle");
        menu.add(v.getId(),1,0,"Tepkiyi indir");

    }
    public boolean onContextItemSelected(MenuItem item) {
        final DBAdapter db=new DBAdapter(this,null);
        if(item.getTitle()=="Favorilerden çıkar"){
            db.openDB();
            boolean result = db.deleteTitle(url);
            if (result == false) {
                Toast.makeText(getApplicationContext(), "failure", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Favorilerden çıkarıldı", Toast.LENGTH_SHORT).show();
            }
            db.close();
        }
        if(item.getTitle()=="Tepkiyi indir"){
            if (Build.VERSION.SDK_INT >= 23)
            {
                if (checkPermission())
                {
                    String externalDirectory= Environment.getExternalStorageDirectory().toString();
                    File folder= new File(externalDirectory + "/Tepki");
                    folder.mkdir();
                    File file = new File(folder,btnname+".mp4");
                    Log.e("deneme", file.toString());
                    if(file.exists()){
                        Toast.makeText(this, "Zaten mevcut", Toast.LENGTH_SHORT).show();
                    } else new DownloadFile(this,btnname).execute(url);
                } else {
                    requestPermission(); // Code for permission
                }
            }
            else
            {
                String externalDirectory= Environment.getExternalStorageDirectory().toString();
                File folder= new File(externalDirectory + "/Tepki");
                folder.mkdir();
                File file = new File(folder,btnname+".mp4");
                if(file.exists()){
                    Toast.makeText(this, "Zaten mevcut", Toast.LENGTH_SHORT).show();
                } else new DownloadFile(this,btnname).execute(url);
            }

        }
        if (item.getTitle() == "Gönder") {
            new DownloadFileAsync(this).execute(url);
        } else if (item.getTitle() == "Favorilere ekle") {


            boolean value = CheckIsDataAlreadyInDBorNot(url);
            if(value==true){
                db.openDB();
                boolean result = db.deleteTitle(url);
                if (result == false) {
                    Toast.makeText(this, "failure", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Favorilerden kaldırıldı.", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                db.openDB();
                long result = db.add(url, btnname);
                if (result == 0) {
                    Toast.makeText(this, "failure", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Favorilere eklendi", Toast.LENGTH_SHORT).show();
                }

                db.close();
            }
        } else {
            return false;
        }
        return true;
    }
    public boolean CheckIsDataAlreadyInDBorNot(String uri){
        ArrayList<String> names2=new ArrayList<>();
        DBAdapter db=new DBAdapter(this,null);
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
    public void itemler (){

        names2=new ArrayList<>();
        images2=new ArrayList<>();
        DBAdapter db=new DBAdapter(this,null);
        db.openDB();
        Cursor c=db.getAllValues();
        while(c.moveToNext()){
            String name=c.getString(1);
            String name2=c.getString(2);
            names2.add(name);


            images2.add(name2);

        }
    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(this, "Write External Storage permission allows us to do store images. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.e("value", "Permission Granted, Now you can use local drive .");
                } else {
                    Log.e("value", "Permission Denied, You cannot use local drive .");
                }
                break;
        }
    }
}
