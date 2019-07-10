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


public class CuneytFragment extends Fragment {
    private static final int PERMISSION_REQUEST_CODE = 1;
    String url,btnname;

    Activity titleChange;
    String names [] ={
            "Artık bu memlekette yeriniz yok hazırlanın",
            "Artık sorma güzel kız çok geç",
            "Aslında hepinizi benim geldiğim yere götürmek lazım",
            "Baban bu işi çok iyi bilirdi",
            "Bana bak efendi senin paran benim için bi boka yaramaz",
            "Başka kapıya kızım",
            "Ben ezenleri ezerim soyanları soyarım",
            "Beni iyi dinleyin dişimle tırnağımla geldim ben bu yere",
            "Bi kadına kurşun sıkacak kadar kalleş değilim",
            "Ben yıkılmam",
            "Bırak onu iliklerine kadar yaşayan ben benim gibiler anlatsınlar",
            "Bunlar böyledir atam işte",
            "Bunları gören insan mutluluğu nerde bulur",
            "Bu orsblar öyle orsbuki cemiyette saygı da görüyolar",
            "Buraya geldim ölümü göze alarak geldi",
            "Çıkın gidin buradan döverim seni hepinizi döverim ulen",
            "Hayatımın kırık dökük parçalarından yeni bi adam oluşturcam",
            "Hıncını aldın mı güzel kız hadi devam et",
            "İğrenmekten geberiyorum kusmucam tüküriciim hepsinin suratına",
            "İhanetini anlat kahpeliğini anlat",
            "İt köpek salmak mertlik değil işte geldim hadi paylaşalım kozumuzu",
            "İyi ki önce sen vurdun prensibimdir bana vurmayana vurmam",
            "Lağım faresi insanlıktan zerren yok",
            "Para nerden geliyo diye sordun mu hiç",
            "Sana hırladım hepinize hırladım",
            "Senin marifetin bu seni gidi hain domuz seni seni vicdansız seni",
            "Sen ve senin gibiler artık kaybettiniz",
            "Size kızmıyorum bile çöplük itisiniz ikiniz de",
            "Susun lan",
            "Tam bir roman konusu olursun sen harika"
                };
    String links []={
            "sample.mp4?alt=media&token=d07881f8-4436-4a1f-8132-a4f57b6ce6ed",
            "sample.mp4?alt=media&token=5ba0ddcd-3f76-4d39-801b-a60b9b7665df",
            "sample.mp4?alt=media&token=8279b6f4-f36f-4326-a898-16de2bc6edb5",
            "sample.mp4?alt=media&token=d7ed5559-f267-4ee7-95a4-3a150a5dee3a",
            "sample.mp4?alt=media&token=b903b1f3-0d8c-44d3-8f5c-fc0fc5cc844c",
            "sample.mp4?alt=media&token=c7c03b31-12b8-48c0-93f1-d9721a2e06c5",
            "sample.mp4?alt=media&token=d59acc27-d223-4a7c-8c39-40aeffe8b45c",
            "sample.mp4?alt=media&token=0ea164ee-4c9c-478f-af0e-9fd4670042c8",
            "sample.mp4?alt=media&token=a1f60115-89b6-4d43-94d4-cf09399d782e",
            "sample.mp4?alt=media&token=64255700-9e5d-41be-846a-09efd488221c",
            "sample.mp4?alt=media&token=ac185de4-f354-4fb3-9fb4-436e10af20cc",
            "sample.mp4?alt=media&token=ea702a39-5956-4615-acdc-350131a803bf",
            "sample.mp4?alt=media&token=b4d98061-bb42-466f-a1a7-eca4e1915346",
            "sample.mp4?alt=media&token=e5d13b57-01e1-42df-9f34-eef406c6d2a9",
            "sample.mp4?alt=media&token=3b38dc28-16c7-4bf1-a8d9-08fe1788b3a9",
            "sample.mp4?alt=media&token=3aa501a8-1805-4298-974c-5f7803e3b578",
            "sample.mp4?alt=media&token=82d13845-206c-43d7-9d71-fb7d8cf935ba",
            "sample.mp4?alt=media&token=33184f47-af5e-48fc-a4e2-b0fd9494a38c",
            "sample.mp4?alt=media&token=dd858c91-2068-4472-88bb-36e7118398df",
            "sample.mp4?alt=media&token=cb0f21e4-b6e4-4152-a5d9-1e17a5b803e2",
            "sample.mp4?alt=media&token=8dd36f32-94d0-4b00-a1ff-cd290e16bbee",
            "sample.mp4?alt=media&token=5618dcf2-7789-4c4f-ae5b-298ff78217f4",
            "sample.mp4?alt=media&token=d16918e1-0ff9-4094-a432-6b74b29e648b",
            "sample.mp4?alt=media&token=8b3430a8-aefa-41b1-9d7e-6ae94a39c534",
            "sample.mp4?alt=media&token=7a92b290-7789-4d0d-acfe-e22b323c0ce9",
            "sample.mp4?alt=media&token=ef2a4649-2cf2-4c5f-8b67-71d2716e3bfa",
            "sample.mp4?alt=media&token=290d0cbb-fa34-4883-b989-effac14c168d",
            "sample.mp4?alt=media&token=ecd97d8e-1b1c-47a5-87d2-a09e11c7d317",
            "sample.mp4?alt=media&token=1e1858fb-c6e1-4b10-93f2-f60d62634495",
            "sample.mp4?alt=media&token=13c5327a-d770-4ebe-88d1-93ead3b8a255"

    };

    public CuneytFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_yildiz2, container, false);
        final GridView gridview = view.findViewById(R.id.gridView7);
        AdView mAdView;
        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        gridview.setAdapter(new YildizAdapter(getContext(),getYildizlar()));
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

    public ArrayList<Yildiz> getYildizlar(){
        ArrayList<Yildiz> yildizlar=new ArrayList<>();
        Yildiz p;
        for(int i=0;i<names.length;i++){
            p=new Yildiz(names[i],0);
            yildizlar.add(p);
        }
        return yildizlar;
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