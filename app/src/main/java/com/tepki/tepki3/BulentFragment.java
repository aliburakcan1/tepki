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


public class BulentFragment extends Fragment {
    private static final int PERMISSION_REQUEST_CODE = 1;
    String url,btnname;
    Activity titleChange;String names [] ={"Allah aşkınıza ben kabede miyim yoksa bir şov esnasında mıyım?",
            "Allahı anamayacak mıyım tabii ki anacam bana mani olamayacaksınız",
            "Ama lezzetsizdi",
            "Artık insanların sinir sistemlerini zorluyorsunuz",
            "Asından Zsine fevkaladenin fevkinde",
            "Ben çok sağlam kadınım",
            "Ben her an konuşabilirim",
            "Ben hiç rahat yatamıyorum",
            "Beni tanıyanlar bilir son nefesime kadar allah dicem",
            "Ben okudum o öyle değil",
            "Bilene sorun hocalarınız var bu yapılır mı",
            "Bir feryattır gidiyo olacak iş mi",
            "Böyle bir şeyi benim yanımda telaffuz edemezsiniz",
            "Bu kadar katı olma ben de insanım",
            "Bunlar birbirine uymayan benzetmeler allah bana sabır versin",
            "Bu ne manaya geliyo devam devam",
            "Bunlar çok hassas konulardır efenim",
            "Bunlar manasız konuşmalar çok afedersiniz",
            "Dilimin döndüğünce ifade etmeye çalıştım",
            "Dolaylı yoldan laf çarpmalar hiç şık değil",
            "Görüyosunuz",
            "Hadi öpüyorum sizi bay bay",
            "Hatam varsa yüzüme vurun",
            "Hesabını ödetecem ödeyeceksin",
            "Kim dedi bunu isim ver",
            "Ne gerek vardı",
            "Oğlum siz kimi ağırladığınızın farkında mısınız",
            "Oku bakiyim sen",
            "Olur mu öyle saçma şey bunu hemen düzeltin rica ediyorum",
            "Sana dokuz veriyorum",
            "Sana günah",
            "Sana hesap mı verecem neyi beyenip beyenmediyimi",
            "Sen kime sesini yükseltiyosun",
            "Sizler kocaman yalancılarsınız kocaman yalancılar"

    };


    String links []={

            "sample.mp4?alt=media&token=f99ce7ba-066b-4a48-9374-1afaa23ede97",
            "sample.mp4?alt=media&token=0f336921-a861-492d-94ff-15c482744661",
            "sample.mp4?alt=media&token=2dd8e3e6-7ef1-421e-8105-d499a6e994c8",
            "sample.mp4?alt=media&token=62be0e19-0a6f-4e70-af1f-93586525cfe5",
            "sample.mp4?alt=media&token=5ac6a375-090d-4225-90df-65c591f3b9c9",
            "sample.mp4?alt=media&token=212d3b65-c79b-4253-898b-8a36ee09c32a",
            "sample.mp4?alt=media&token=69fa0808-7da4-4d62-847a-1b4b082abc30",
            "sample.mp4?alt=media&token=e697ecae-2e08-4544-a87c-b10081412d0d",
            "sample.mp4?alt=media&token=8b8de019-72f0-44d0-bec9-3f77372f8d80",
            "sample.mp4?alt=media&token=ee8a3ab4-1281-4bf1-a819-5098e4df09fd",
            "sample.mp4?alt=media&token=a4e23620-6ef0-4826-a332-c627c8f66890",
            "sample.mp4?alt=media&token=2fd55b06-915d-422a-8670-a1b1c3c10fa4",
            "sample.mp4?alt=media&token=41ff1459-6b82-4921-ab5f-3e9da1556e92",
            "sample.mp4?alt=media&token=14b6c27d-7fae-499f-b486-213235ed04e4",
            "sample.mp4?alt=media&token=997a938f-3c75-44d0-9b06-c47369282c79",
            "sample.mp4?alt=media&token=d954f7a5-3a3a-48c7-89ba-0a406eac6c53",
            "sample.mp4?alt=media&token=f78a329e-e824-44a0-841b-f3f73cdda910",
            "sample.mp4?alt=media&token=ff8e9b5c-0f29-44f0-986b-365531b4a9ee",
            "sample.mp4?alt=media&token=a88ac195-3c7a-4663-9c5c-8cbb6f0cac93",
            "sample.mp4?alt=media&token=d9ad3980-90b9-478a-b9dc-5c80b36f63c3",
            "sample.mp4?alt=media&token=63e6d2fe-d161-4d10-9da2-a94e9d5a6915",
            "sample.mp4?alt=media&token=9bbe392c-57d2-4ec0-8b05-6ab56fb46746",
            "sample.mp4?alt=media&token=a6c9edcb-976b-48af-b3b1-04fe9a0faa88",
            "sample.mp4?alt=media&token=92a0401e-7255-4add-b434-8c37da017377",
            "sample.mp4?alt=media&token=d1a7ee00-b0df-4a1a-ad76-18908c214709",
            "sample.mp4?alt=media&token=e3cf22d2-72a0-450c-82b8-f514661090f6",
            "sample.mp4?alt=media&token=6d45806d-3c02-42e1-8123-daab426421c1",
            "sample.mp4?alt=media&token=633d0727-dec5-4af8-a5d7-b5a0f8f2aa09",
            "sample.mp4?alt=media&token=9ce67d27-8f2c-4e2d-83de-3c7c8276f843",
            "sample.mp4?alt=media&token=053e4978-9d8e-4403-b09b-725414d03554",
            "sample.mp4?alt=media&token=26681890-283d-43e4-b9ca-afba0113be56",
            "sample.mp4?alt=media&token=5d58f113-3509-4ef2-8f95-08c2bf813dca",
            "sample.mp4?alt=media&token=0a9a3a3f-1584-4091-a5b9-8bd238d4c5b5",
            "sample.mp4?alt=media&token=21ea9019-de61-4ff0-8e04-8fe262cf6b2b"

    };

    public BulentFragment() {
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