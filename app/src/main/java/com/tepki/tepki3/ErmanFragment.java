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


public class ErmanFragment extends Fragment {
    private static final int PERMISSION_REQUEST_CODE = 1;
    String url,btnname;
    Activity titleChange;
    String names [] ={
            "Abi bu ne ya her taraf yalak dolu",
            "Bakıyorum ya tık yok ülkem insanında",
            "Valla var senin ateşin sen nite böylesin akşam ne yedin",
            "Beni yok etseler hepsi kurtulcak da edemiyolar",
            "Ben senin gibileri çok gördüm",
            "Bi de utanmadan sırıtıyo ya sırıtma lan bari",
            "Biz burda kendi aramızda gır gır yaptık eğlendik",
            "Bu adamın bi kaç tahtası eksik deli demeyiz tahtası eksik deriz",
            "Bunları bu hâle kim getiriyo ya",
            "Bunu yapan tam bi dangalak",
            "Bu senin ilacın bu",
            "Çünkü bunlar toplumun tam damarına basmak isteyebilirler",
            "Daha noolur haa daha noolur",
            "Eğer gerizekalı bi tanesi varsa oynamak ister",
            "Helal olsun yakışır aslanım benim",
            "Hepinizi öpüyorum yavrularım benim",
            "Hukukum var ya hukukum var",
            "İsmi önemli değil ali veli hasan",
            "Kim lan bu kim bu ulan kim bu",
            "Muz orta yapın",
            "nah dururdu duramazdı bak ne diyorum duramazdı abi",
            "naparsın devamlı yalarsın",
            "ne güzel bak rahatlıyorum ağzımdan ne güzel şeyler çıkıyo",
            "nerde paralar yavrucum nerde paralar geçti o devirler",
            "Öyle yalakalar var yalıyolar",
            "Sana hesap mı vercem size hesap mı vercem bunlar kim la",
            "Sana mı sorcam lan ne dicemi",
            "sen devam et baya akıllısın ama dikkatli ol",
            "sen busun bu alemi terket rica ediyorum",
            "siz ne kadar yakışıklı çocuklarsınız",
            "sopaynan vuruyo beynimize beynimize",
            "sosyal medyadan yaz yaz banane sana hesap mı vercem",
            "sulandıralım sulandıralım",
            "takke düştü kel göründü",
            "ya kusura bakmayın ben kabul edemiyorum bi de utanmadan gülüyo ya",
            "yalayın yalayın böyle dilinizi atın yalayın",
            "yavvv arkadaşlar bi şeyi çok dikkatli söylüyorum",
            "yemediler yemediler yemedi",
            "yeter lan yeter be"
    };
    String links []={
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

    public ErmanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ahmet, container, false);
        final GridView gridview = view.findViewById(R.id.gridView7);
        AdView mAdView;
        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        gridview.setAdapter(new AhmetAdapter(getContext(),getAhmetler()));
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
        final DBAdapter db=new DBAdapter(getContext(),null);
        if(item.getTitle()=="Favorilerden çıkar"){
            db.openDB();
            boolean result = db.deleteTitle(url);
            if (result == false) {
                Toast.makeText(getContext(), "failure", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Favorilerden çıkarıldı", Toast.LENGTH_SHORT).show();
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

    public ArrayList<Ahmet> getAhmetler(){
        ArrayList<Ahmet> ahmetler=new ArrayList<>();
        Ahmet p;
        for(int i=0;i<names.length;i++){
            p=new Ahmet(names[i],0);
            ahmetler.add(p);
        }
        return ahmetler;
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