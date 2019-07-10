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

public class MainActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_main);
        setTitle("");
        MobileAds.initialize(this, getApplicationContext().getString(R.string.ADMOB_APP_ID));
        onCreateFunction();

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


        Button bs=findViewById(R.id.button5);
        final Button bt=findViewById(R.id.button9);
        Button bi=findViewById(R.id.button4);
        Button bc=findViewById(R.id.button8);
        Button bf=findViewById(R.id.button7);
        Button bk=findViewById(R.id.button6);
        bi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                View dialoglayout = inflater.inflate(R.layout.activity_communicate, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("İletişim için : ");
                builder.setView(dialoglayout);
                builder.show();
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInterstitialAd = new InterstitialAd(MainActivity.this);
                mInterstitialAd.setAdUnitId(getApplicationContext().getString(R.string.inter_ad_unit_id));
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                mInterstitialAd.setAdListener(new AdListener(){
                    public void onAdLoaded(){
                        mInterstitialAd.show();
                    }
                });
            }
        });
        bs.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                finish();
                startActivity( new Intent(MainActivity.this, SearchActivity.class));
            }
        });

        bc.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
        bf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,FavoryActivity.class));
            }
        });
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
    @SuppressLint("ResourceType")
    public void onCreateFunction(){
        lw_SlideMenu = findViewById(R.id.lw_Menu);
        drawerLayout = findViewById(R.id.drawerLayout);

        // Menü başlıklarını kaynak dosyasından çekiyor
        titles = getResources().getStringArray(R.array.slidemenu_item);

        // icons dizimizi kaynak dosyadan çekiyoruz
        icons = getResources().obtainTypedArray(R.array.icons);
        // Ram i şişirmemek için resimleri yeniden yükler


        items = new ArrayList<>();

        items.add(new SlideMenuItem(titles[0], icons.getResourceId(0, 0)));
        items.add(new SlideMenuItem(titles[1], icons.getResourceId(1, 0)));
        items.add(new SlideMenuItem(titles[2], icons.getResourceId(2, 0)));
        items.add(new SlideMenuItem(titles[3], icons.getResourceId(3, 0)));
        items.add(new SlideMenuItem(titles[4], icons.getResourceId(4, 0)));
        items.add(new SlideMenuItem(titles[5], icons.getResourceId(5, 0)));
        items.add(new SlideMenuItem(titles[6], icons.getResourceId(6, 0)));
        items.add(new SlideMenuItem(titles[7], icons.getResourceId(7, 0)));
        items.add(new SlideMenuItem(titles[8], icons.getResourceId(8, 0)));
        items.add(new SlideMenuItem(titles[9], icons.getResourceId(9, 0)));
        items.add(new SlideMenuItem(titles[10], icons.getResourceId(10, 0)));
        items.add(new SlideMenuItem(titles[11], icons.getResourceId(11, 0)));
        items.add(new SlideMenuItem(titles[12], icons.getResourceId(12, 0)));
        items.add(new SlideMenuItem(titles[13], icons.getResourceId(13, 0)));
        items.add(new SlideMenuItem(titles[14], icons.getResourceId(14, 0)));
        items.add(new SlideMenuItem(titles[15], icons.getResourceId(15, 0)));
        items.add(new SlideMenuItem(titles[16], icons.getResourceId(16, 0)));
        items.add(new SlideMenuItem(titles[17], icons.getResourceId(17, 0)));


        // Açılışta uygulama ismini alıyor
        //appTitle = getSupportActionBar().getTitle();
        // actionBarTitle = items.get(0).getTitle();

        // Menüdeki her list item a click veriyor
        lw_SlideMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                displayPage(i);

                // Her item a tıklanıldığında actionBar daki görünen başlığı değiştiriyor
                actionBarTitle = items.get(i).getTitle();

                // menü tıklamadan sonra kapanıyor
                drawerLayout.closeDrawer(lw_SlideMenu);
            }
        });

        adapter = new SlideMenuAdapter(items, getApplicationContext());
        lw_SlideMenu.setAdapter(adapter);

        // Toggle butonuna click veriyoruz, home butonu gibi davranmasını sağlıyor.
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // toggle nesnesi oluşturuyoruz.
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.opened, R.string.closed) {

            @Override
            public void onDrawerOpened(View drawerView) {


            }

            @Override
            public void onDrawerClosed(View drawerView) {
                getSupportActionBar().setTitle(actionBarTitle);

            }
        };

        // toggle açılıp kapanmasına göre, toggle iconu değiştiriyor.
        toggle.syncState();
        // menü açılıp kapanmasını dinliyoruz.
        drawerLayout.setDrawerListener(toggle);
    }

}
