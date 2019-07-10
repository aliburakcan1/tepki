package com.tepki.tepki3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.List;

public class DenemeActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    ListView lw_SlideMenu;
    SlideMenuAdapter adapter;

    List<SlideMenuItem> items;
    String[] titles;
    TypedArray icons;
    CharSequence actionBarTitle, appTitle;
    String fragment_name = "";
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @SuppressWarnings("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.berkay);
        setTitle("");
        MobileAds.initialize(this, "---ad-id---");

        ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.DISCONNECTED
                && conMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.DISCONNECTED) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("İnternetin yoksa tepkilere ulaşamazsın.")
                    .setCancelable(false)
                    .setPositiveButton("Anladım, sal beni", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
            ((MyApplication) this.getApplication()).setSomeVariable(0);
        }


        Button bk=findViewById(R.id.button11);
        bk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(lw_SlideMenu);
            }
        });

        // Açılışta facebook ekranı gelecek

    }

    private void displayPage(int position) {


        Fragment fragment = null;
        invalidateOptionsMenu();

        switch (position)
        {

            case 0:
                ((RelativeLayout)findViewById(R.id.container)).removeAllViews();
                fragment = new TayyipFragment();
                fragment_name = "TayyipFragment";
                break;
            case 1:
                ((RelativeLayout)findViewById(R.id.container)).removeAllViews();
                fragment = new KemalFragment2();
                fragment_name = "KemalFragment2";
                break;
            case 2:
                ((RelativeLayout)findViewById(R.id.container)).removeAllViews();
                fragment = new DevletFragment2();
                fragment_name = "DevletFragment2";
                break;
            case 3:
                ((RelativeLayout)findViewById(R.id.container)).removeAllViews();
                fragment = new IbrahimFragment2();
                fragment_name = "IbrahimFragment2";
                break;
            case 4:
                ((RelativeLayout)findViewById(R.id.container)).removeAllViews();
                fragment = new YildizFragment2();
                fragment_name = "YildizFragment2";
                break;
            case 5:
                ((RelativeLayout)findViewById(R.id.container)).removeAllViews();
                fragment = new MahmutFragment();
                fragment_name = "MahmutFragment";
                break;
            case 6:
                ((RelativeLayout)findViewById(R.id.container)).removeAllViews();
                fragment = new BulentFragment();
                fragment_name = "BulentFragment";
                break;
            case 7:
                ((RelativeLayout)findViewById(R.id.container)).removeAllViews();
                fragment = new SedaFragment();
                fragment_name = "SedaFragment";
                break;
            case 8:
                ((RelativeLayout)findViewById(R.id.container)).removeAllViews();
                fragment = new PolatFragment();
                fragment_name = "PolatFragment";
                break;
            case 9:
                ((RelativeLayout)findViewById(R.id.container)).removeAllViews();
                fragment = new CubbeliFragment();
                fragment_name = "CubbeliFragment";
                break;
            case 10:
                ((RelativeLayout)findViewById(R.id.container)).removeAllViews();
                fragment = new FatihFragment();
                fragment_name = "FatihFragment";
                break;
            case 11:
                ((RelativeLayout)findViewById(R.id.container)).removeAllViews();
                fragment = new AzizFragment();
                fragment_name = "AzizFragment";
                break;
            case 12:
                ((RelativeLayout)findViewById(R.id.container)).removeAllViews();
                fragment = new ErmanFragment();
                fragment_name = "ErmanFragment";
                break;
            case 13:
                ((RelativeLayout)findViewById(R.id.container)).removeAllViews();
                fragment = new AhmetFragment();
                fragment_name = "AhmetFragment";
                break;
            case 14:
                ((RelativeLayout)findViewById(R.id.container)).removeAllViews();
                fragment = new SenerFragment();
                fragment_name = "SenerFragment";
                break;
            case 15:
                ((RelativeLayout)findViewById(R.id.container)).removeAllViews();
                fragment = new CuneytFragment();
                fragment_name = "CuneytFragment";
                break;
            case 16:
                ((RelativeLayout)findViewById(R.id.container)).removeAllViews();
                fragment = new BurhanFragment();
                fragment_name = "BurhanFragment";
                break;
            case 17:
                ((RelativeLayout)findViewById(R.id.container)).removeAllViews();
                fragment = new KarisikFragment();
                fragment_name = "KarisikFragment";
                break;
            default:
                break;
        }

        if(fragment != null){

            // Fragment transaction nesnesi ile fragment ekranları arasında geçiş sağlıyor
            FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.container, fragment).addToBackStack(fragment_name).commit();

            // Stack te bulunan fragment sayısını alıyor
            int count = getSupportFragmentManager().getBackStackEntryCount();

            if(count!=0) {
                // Son fragment alınıyor
                FragmentManager.BackStackEntry backStackEntry = getSupportFragmentManager().getBackStackEntryAt(count - 1);

                // Son fragment ile seçilen fragment aynı ise eski fragment siliniyor
                if (backStackEntry.getName().contains(fragment_name)) {
                    getSupportFragmentManager().popBackStack();
                }
            }
        }
    }

    @Override
    public void onBackPressed() {

        // fragment sayısı bir ise uygulamadan çıkıyor
        if(getSupportFragmentManager().getBackStackEntryCount() != 1)
            super.onBackPressed();


        else {
            finish();
        }
    }

    @Override
    public void setTitle(CharSequence title) {

        getSupportActionBar().setTitle(title);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        MenuItem mi=menu.findItem(R.id.buttonMainPage);
        if(fragment_name!="") mi.setVisible(false);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        // toggle icona tıklanıldığında menünün açılmasını sağlıyor
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        if(id==R.id.buttonMainPage){
            Toast.makeText(this,"Anasayfan dediysek sana özel bi şey değil",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.buttonMainPage2){
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }
        if(id == R.id.button_search){
            Intent i = new Intent(this, SearchActivity.class);
            this.startActivity(i);
            return true;
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
