package com.tepki.tepki3;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.File;
import java.util.ArrayList;


public class DevletFragment2 extends Fragment {

    private static final int PERMISSION_REQUEST_CODE = 1;
    Activity titleChange;
    String btnname;
    String url;
    String names [] ={
            "Akılla izah edilemeyecek bir çarpıklıktır",
            "Aklın karı vicdanın itlafıdır",
            "Aklıyla arasını açmış klinik bir vaka haline gelmiştir",
            "Ayrımcılık yapıyor utanmadan şerefsizce",
            "Bana mısın demiyor sanki duvara konuşuyorum",
            "Be hey densiz kanun tanımaz ahlak bilmez",
            "Bilesin ki bu bayat numaraları kimse yemeyecektir",
            "Bilesin ki günahın büyüktür",
            "Bir kepazeliktir",
            "Böyle bir ülke nereye gidecektir değerli dava arkadaşlarım",
            "Bu kavramlara yabancılık çekenler bizim gibi olamazlar",
            "Bunlara türk milletinin kapısı kalbi kapalıdır",
            "Bunu başaracağınız inancıyla alayınızı",
            "Bu şerefsizlik nesillerden bile çıkmayacaktır",
            "Bu zirvede ne mutabakata varılmışsa milletin huzurunda söylesinler",
            "Çok mu arzuluyosun",
            "Çok yakında eski günlerini mumla arayacak ya kaçacak ya da hesap verecek",
            "Cüretkar olan bu sefilin alnı çatından vurulması haktır",
            "Daha ne kaldı",
            "Daha sorularımız vardır fakat şimdilik bunlar yetecektir",
            "Düğüne giderler zurna,hamama giderler hurna beğenmezler",
            "Dünya başıma yıkılsa dönmem",
            "Dünya gözüyle yediklerini burunlarından getirmezse hayat bana zindan olsun",
            "Fakat ne derse desin neyi bahane gösterirse göstersin her şey meydanda",
            "Hamdolsun eskisine kıyasla daha iyi burdayım",
            "Haydi şuradan",
            "Her gün bize sövüyor yalan söylüyor kimdir bu gafil",
            "İlk kez görüyor ilk kez şahid oluyorum",
            "İnanıyorum ki kasımpaşaya kadar arkana bakmadan kaçacaksın",
            "Kabul etmek mümkün değildir",
            "Kıyamet alameti bu olsa gerek",
            "Makamını inkar etmiş zavallı durumuna düşmüştür",
            "Merak etmeyin onun da zamanı gelecektir",
            "Mesele bitmiş düğüm çözülmüş ülkemizin önü açılmıştır",
            "Mizah gibi şaka gibi",
            "Muhatabımız değil bu soruyu nası sorarsın onu adam yerine mi koyuyorsun",
            "Mutluyum çünkü irade burada inanç burada",
            "Ne kadar hata yapsa da saygı duyulacaktır",
            "Ne kadar omo varsa ne kadar parsil varsa",
            "Peki gençlerin ne düşündüğünü neden önemsemiyorsun",
            "Sana el mi verdi gözünü mü boyadı büyü mü yaptı",
            "Sen bu sözleri ya haplandın da kullandın ya da tehditle söyledin",
            "Senin sorunlarını hepten bitireceğiz",
            "Sen kimsin ve kimi tehdit ediyorsun",
            "Sen nazik birisin bizimle söz düellosuna girme",
            "Sen necisin bre ahlaksız bre kemiksiz",
            "Sen ne diyosun bu ne büyük ihanet",
            "Şerefsizlere sesleniyorum",
            "Sevinçlerimiz kadar hüzünlerimiz de var",
            "Sizler türk milletinin ülkülerini damarlarınızda taşıyorsunuz",
            "Sonuna kadar karşıyız",
            "Söz biliyosanız söyleyin inansınlar bilmiyosanız susun adam sansınlar",
            "Sözlerini kurşun gibi savuran namertler şimdi beni dinleyiniz",
            "Tezgahlarınızı başınıza yıkacağız",
            "Tozumuza yetişemezsin",
            "TC'de isteyen her şeyi kullanamaz sen kullanırsan kendin bilirsin",
            "Ümüğünü tutarak yüce divana gönderecez",
            "Yarın türkiyede kaçacak delik arayacaksınız",
            "Yiyin kudurun için kudurun",
            "Zaman birlik olma zamanı"
    };
    String links[]={
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4"

    };


    public DevletFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_devlet2, container, false);
        final GridView gridview = view.findViewById(R.id.gridView7);
        AdView mAdView;
        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        gridview.setAdapter(new DevletAdapter(getContext(),getDevletler()));
        registerForContextMenu(gridview);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(),VideoViewActivity.class);
                intent.putExtra("videoUri",links[i]);
                Button button=view.findViewById(R.id.button);
                intent.putExtra("name",button.getText());
                startActivity(intent);
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

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        int i = info.position;
        url=links[i];
        btnname=names[i];
        menu.setHeaderTitle("Seç birini, ya da seçme sen bilirsin");
        menu.add( v.getId(),1, 0, "Gönder");
        boolean value = CheckIsDataAlreadyInDBorNot(url);
        if(value==true) menu.add(v.getId(),1,0,"Favorilerden çıkar");

        else menu.add( v.getId(),1, 0, "Favorilere ekle");
        menu.add(v.getId(),1,0,"Tepkiyi indir");

    }
    public boolean onContextItemSelected(MenuItem item) {
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
                        Toast.makeText(getContext(), "Zaten mevcut", Toast.LENGTH_SHORT).show();
                    } else new DownloadFile(getContext(),btnname).execute(url);
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
                    Toast.makeText(getContext(), "Zaten mevcut", Toast.LENGTH_SHORT).show();
                } else new DownloadFile(getContext(),btnname).execute(url);
            }

        }
        if (item.getTitle() == "Gönder") {
            new DownloadFileAsync(getContext()).execute(url);
        } else if (item.getTitle() == "Favorilere ekle") {

            final DBAdapter db=new DBAdapter(getContext(),null);
            boolean value = CheckIsDataAlreadyInDBorNot(url);
            if(value==true){
                db.openDB();
                boolean result = db.deleteTitle(url);
                if (result == false) {
                    Toast.makeText(getContext(), "failure", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Favorilerden kaldırıldı.", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                db.openDB();
                long result = db.add(url, btnname);
                if (result == 0) {
                    Toast.makeText(getContext(), "failure", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Favorilere eklendi", Toast.LENGTH_SHORT).show();
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
        DBAdapter db=new DBAdapter(getActivity(),null);
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

    public ArrayList<Devlet> getDevletler(){
        ArrayList<Devlet> devletler=new ArrayList<>();
        Devlet p;
        for(int i=0;i<names.length;i++){
            p=new Devlet(names[i],R.drawable.devlet);
            devletler.add(p);
        }
        return devletler;
    }
    private void startDownload(String url) {
        new DownloadFileAsync(getContext()).execute(url);
    }
    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(getActivity(), "Write External Storage permission allows us to do store images. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
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