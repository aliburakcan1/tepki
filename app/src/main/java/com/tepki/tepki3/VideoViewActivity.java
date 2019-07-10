package com.tepki.tepki3;


import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.io.File;
import java.util.ArrayList;

public class VideoViewActivity extends AppCompatActivity {

    private VideoView vw;
    private InterstitialAd mInterstitialAd;
    int stopPosition;
    private AdView mAdView;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_video_view);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        Bundle extras = getIntent().getExtras();
        //Uri myUri=  Uri.parse(extras.getString("videoUri"));
        Uri uri = Uri.parse(extras.getString("videoUri"));
        //Uri uri = Uri.parse("android.resource://" + getPackageName() +"/"+R.raw.hitler);
        vw= (VideoView)findViewById(R.id.videoView2);
        File file = new File(getCacheDir(),"sample.mp4");
        Uri uri2=Uri.fromFile(file);
        vw.setVideoURI(uri);
        vw.setMinimumWidth(360);
        vw.setMinimumHeight(240);
        vw.start();
        final int[] i = new int[1];
        vw.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                vw.start();
                //Toast.makeText(VideoViewActivity.this, String.valueOf(i[0] + vw.getDuration()),Toast.LENGTH_SHORT).show();
                i[0]++;
                if(vw.getDuration()<5000){
                    if (i[0]==4) {
                        mInterstitialAd = new InterstitialAd(VideoViewActivity.this);
                        mInterstitialAd.setAdUnitId(getApplicationContext().getString(R.string.inter2_ad_unit_id));
                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                        mInterstitialAd.setAdListener(new AdListener(){
                            public void onAdLoaded(){
                                vw.pause();
                                stopPosition = vw.getCurrentPosition();
                                mInterstitialAd.show();
                            }

                            @Override
                            public void onAdClosed() {
                                vw.seekTo(stopPosition);
                                vw.start();
                                super.onAdClosed();
                            }
                        });
                    }
                }else if(vw.getDuration()>5000 && vw.getDuration()<10000) {
                    if(i[0]==3){
                        mInterstitialAd = new InterstitialAd(VideoViewActivity.this);
                        mInterstitialAd.setAdUnitId(getApplicationContext().getString(R.string.inter2_ad_unit_id));
                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                        mInterstitialAd.setAdListener(new AdListener(){
                            public void onAdLoaded(){
                                vw.pause();
                                stopPosition = vw.getCurrentPosition();
                                mInterstitialAd.show();
                            }
                            @Override
                            public void onAdClosed() {
                                vw.seekTo(stopPosition);
                                vw.start();
                                super.onAdClosed();
                            }
                        });
                    }
                } else {
                    if (i[0]==2){
                        mInterstitialAd = new InterstitialAd(VideoViewActivity.this);
                        mInterstitialAd.setAdUnitId(getApplicationContext().getString(R.string.inter2_ad_unit_id));
                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                        mInterstitialAd.setAdListener(new AdListener(){
                            public void onAdLoaded(){
                                vw.pause();
                                stopPosition = vw.getCurrentPosition();
                                mInterstitialAd.show();
                            }
                            @Override
                            public void onAdClosed() {
                                vw.seekTo(stopPosition);
                                vw.start();
                                super.onAdClosed();
                            }
                        });
                    }
                }
            }
        });
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Bundle extras = getIntent().getExtras();
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_video, menu);
        boolean value = CheckIsDataAlreadyInDBorNot(extras.getString("videoUri"));

        if(value==true){

            menu.findItem(R.id.buttonFavori).setIcon(R.drawable.reverselikepng);
        }

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
                boolean result = db.deleteTitle(extras.getString("videoUri"));
                if (result == false) {
                    Toast.makeText(getApplicationContext(), "failure", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Favorilerden çıkarıldı", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                db.openDB();
                long result = db.add(videoUri.toString(), name);
                if (result == 0) {
                    Toast.makeText(getApplicationContext(), "failure", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Favorilere eklendi", Toast.LENGTH_SHORT).show();
                }

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
