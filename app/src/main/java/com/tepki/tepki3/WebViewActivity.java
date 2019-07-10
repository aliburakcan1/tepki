package com.tepki.tepki3;


import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class WebViewActivity extends AppCompatActivity {

    private VideoView vw;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_web_view);
        Bundle extras = getIntent().getExtras();
        StorageReference mStorageRef;
        mStorageRef = FirebaseStorage.getInstance().getReference();
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl("gs://molten-reserve-178711.appspot.com/");
        Toast.makeText(this,String.valueOf(mStorageRef.child("bulentersoy/amalezzetsizdi").getDownloadUrl()),Toast.LENGTH_SHORT).show();
        storageRef.child("bulentersoy/amalezzetsizdi.mp4").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                new DownloadFileAsync(WebViewActivity.this).execute(String.valueOf(uri));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });
       // StorageReference storageRef = storage.getReferenceFromUrl(this.getString(R.string.storage_path));
       // Uri uri = storageRef.child("groups/pizza.png").getDownloadUrl().getResult();
    }
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public boolean CheckIsDataAlreadyInDBorNot(String uri){
        ArrayList<String> names2=new ArrayList<>();
        DBAdapter db=new DBAdapter(this,null);
        db.openDB();
        Log.w("deneme","gelir mi4");
        Cursor c=db.getAllValues();
        while(c.moveToNext()){
            String name=c.getString(1);
            names2.add(name);
            Log.w("denemeka",name);
        }
        if (names2.contains(uri)){
            Log.w("denemek","11");
            return true;
        }
        else{
            Log.w("deneme1","12");
            return false;
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Bundle extras = getIntent().getExtras();
        Log.w("deneme1","4");
        MenuInflater inflater = getMenuInflater();
        Log.w("deneme1","9");
        inflater.inflate(R.menu.menu_video, menu);
        Log.w("deneme1","5");
        boolean value = CheckIsDataAlreadyInDBorNot(extras.getString("videoUri"));
        Log.w("deneme1","6");
        if(value==true){
            Log.w("deneme1","7");
            menu.findItem(R.id.buttonFavori).setIcon(R.drawable.resim);
            Log.w("deneme1","8");
        }
        Log.w("deneme1","10");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.geriButonu){
            onBackPressed();
            return true;
        }
        if(id == R.id.button_search){
            Intent i = new Intent(this, SearchActivity.class);
            this.startActivity(i);
            return true;
        }
        if(id==R.id.buttonFavori){
            final DBAdapter db=new DBAdapter(this,null);
            Bundle extras = getIntent().getExtras();
            Uri videoUri = Uri.parse(extras.getString("videoUri"));
            String name= extras.getString("name");
            boolean value = CheckIsDataAlreadyInDBorNot(extras.getString("videoUri"));
             if(value==true){
                db.openDB();
                Log.w("deneme1","14");
                boolean result = db.deleteTitle(extras.getString("videoUri"));
                if (result == false) {
                    Toast.makeText(getApplicationContext(), "failure", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "silindi", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                db.openDB();
                Toast.makeText(this,"girdi",Toast.LENGTH_SHORT).show();
                long result = db.add(videoUri.toString(), name);
                Toast.makeText(this,videoUri.toString()+name,Toast.LENGTH_SHORT).show();
                if (result == 0) {
                    Toast.makeText(getApplicationContext(), "failure", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "eklendi", Toast.LENGTH_SHORT).show();
                }
                Log.w("denemek1", videoUri.toString());

                db.close();
            }
        }
        if(id==R.id.button_paylas){
            Bundle extras = getIntent().getExtras();
            //Intent shareIntent = new Intent(Intent.ACTION_SEND);
            new DownloadFileAsync(this).execute(extras.getString("videoUri"));
        }
        if (id == R.id.action_settings) {
            return true;
        }
        if(id==R.id.action_exit){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
