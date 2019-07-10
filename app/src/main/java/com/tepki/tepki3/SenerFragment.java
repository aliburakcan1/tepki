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


public class SenerFragment extends Fragment  {
    private static final int PERMISSION_REQUEST_CODE = 1;
    String url,btnname;

    Activity titleChange;
    String names [] ={
            "Aaa her boka itiraz ediyosun be",
            "AA kalbimi kırdın ben gidiyorum",
            "Allah sizi inandırsın son aylarda çok kötü günler geçirdik",
            "Ama kendimi yetiştirdim ben binlerce kitap okudum",
            "Aman efendim siz verdikten sonra niye istemiyim",
            "Ama sen gerçekten bitmişsin yoksun sen",
            "Bak şimdi kızmışım dinime imanıma",
            "Bak sonra pişman olma ha",
            "Başkalarınınkine el veriliyor bana neden uzanmadı o el",
            "Baskın var",
            "Ben böyle şakaları hiç sevmem ha",
            "Ben bütün bunları niye yaptım hala bilmiyorum",
            "Benim de hakkım değil mi sevdalanmak",
            "Beni gibisini nah bulursun",
            "Beni terk etti",
            "Bi daha işlerine karışmam sonra ben kötü oluyorum canım",
            "Böyle tedbirsizlik yapılır mı",
            "Bugün içinde bana evet diyecekmişsiniz gibi bi his var",
            "Bu para bize bi gün yetmez",
            "Çocukları da kendi gibi yetiştircekse ohooo",
            "Daha ne kadar yaşarım bilmiyem senden vazgeçmem",
            "Dedim ki biri daha gidiyo",
            "Efendim sevgiler saygılar",
            "Fotoğraftan çekenden nefret ederim",
            "Gayra git sen daha çok gençsin yazıktır sana",
            "Geliyorum eşkıyalar geliyorum",
            "Gör bak bu sefer belimi doğrultuyorum",
            "Hepimiz hayallerimizin kurbanıyız",
            "Her şeye rağmen bi gün çıkıp gelebilirim",
            "Her şeyimi kaybettim her şeyimi",
            "İçim yaniyir bu aşktan hayatta sevgiden hiç şansım olmadı",
            "İnsan adam mışsın bu iyiliğini unutmıcam",
            "İnsan yaptığı iyiliği söylemez asaleti varsa",
            "Irz düşmanı alçak namussuz",
            "İşin en acıklı kısmı da gene dünyaya gelsem aynı şeyler yapardım",
            "Kerata asinin teki hiç laf dinlemiyor",
            "Kimse ne aradı ne sordu",
            "Konuşma lan",
            "Mahvoldum",
            "Nası bu kadar kötü oynayabiliyosun yahu",
            "Nasılsa bırakıp gidecekler sen daha önce tüy",
            "Ne çabuk bitirim oldun be anam",
            "Ne demek bitti",
            "Ne diyosun lan sen",
            "Ne hakkın var senin bu insanları bekletmeye",
            "Neree gidiseniz dönün geri",
            "Ne var nee rahatsız ettin beni tamam mı",
            "Niye hayatımı boşa hayaller için mahvettim bilmiyorum",
            "Oh iyi yapirsin namissiz",
            "Önceden çirkin geliyodun ama sen farklısın tutuldum sana",
            "Paramız olsa reklam yaparız",
            "Peki öyle olsun",
            "Puu adi herif manyaksın ulan sen",
            "Rezil oldum mahvoldum",
            "Rica ederim sen benden daha namussuzsun",
            "Sanatçılar,kolej mezunları bir de ben",
            "Sanki kalbimin iyi tarafıydın",
            "Selammış selamünaleyküm desene zındık",
            "Sen bunları bilmiyosun",
            "Sen bu rezaleti bırak da ilerde olacak rezaleti düşün",
            "Seni adi herif seni",
            "Senin silahta mermi ters dönmüş evlat dikkat et kendini vurma",
            "Sen şimdi ki çocukları bilmiyo musun hepsi piç",
            "Sizden uzakta hasretinize dayanamıyorum ya",
            "Tuhaf bi durum acı çekmeye meyilli olmak",
            "Ulan peygamber misin be çıldırcam be",
            "Uzun zamandır beladan uzak sakin bi hayat sürüyorum",
            "Vay gavat iftiracı pezevenk",
            "Verdik kurtulduk siz de verin siz de kurtulun",
            "Ya allah ya muhammed sen bana guvvet ver ya hamza",
            "Ya hu insan bu kadar hıyar olur mu",
            "Yalnız biraz sermaye istiyor",
            "Yaptım ama sor niye yaptım",
            "Yetmez yetmiyor yetmeezzz yeetmiiyyoorr",
            "Yok canım o kadar da görgüsüz değilim"
    };
    String links []={
            "sample.mp4?alt=media&token=628d0b67-42a7-42c6-8f48-4f3aca87e6ae",
            "sample.mp4?alt=media&token=a9e6b333-4ab0-4f0e-9167-0ad661ee861b",
            "sample.mp4?alt=media&token=88d4bca3-993a-4c3c-944b-81669a4615d7",
            "sample.mp4?alt=media&token=2b493a59-a46d-4bc3-aabf-1d35451ff0cf",
            "sample.mp4?alt=media&token=083e9db9-2246-4014-92c1-9ebdcf87b0c9",
            "sample.mp4?alt=media&token=d19b0c2e-5758-422a-8ce3-9c46ab5573e9",
            "sample.mp4?alt=media&token=08e65ceb-bf41-4dfd-a87e-06e6710fea32",
            "sample.mp4?alt=media&token=545ffdd4-d93d-4514-b806-8df0798cdb68",
            "sample.mp4?alt=media&token=25fb3baa-44cf-4244-9252-54d3a8368c9a",
            "sample.mp4?alt=media&token=8a26ced7-54df-4772-9668-6a4a8944a89f",
            "sample.mp4?alt=media&token=a855d2b4-b902-4fe4-b13a-9011bbf34db6",
            "sample.mp4?alt=media&token=6aaead6a-d357-4129-8eeb-6f802158b7aa",
            "sample.mp4?alt=media&token=35be754e-68b2-440d-8a9f-8401923f4dc7",
            "sample.mp4?alt=media&token=6e561642-4e37-40ca-ac17-f897f10ed25c",
            "sample.mp4?alt=media&token=8e595bcb-a157-4476-befa-7567210b9b45",
            "sample.mp4?alt=media&token=ec2f49a1-e4af-474a-b015-dea6d0bb79e1",
            "sample.mp4?alt=media&token=71d78304-209e-47bc-bee9-dbaa1fb5ee48",
            "sample.mp4?alt=media&token=43704210-33f2-4442-b7ae-8bcf2f8c2945",
            "sample.mp4?alt=media&token=e610e5d9-3dac-488e-9140-863b8150daa1",
            "sample.mp4?alt=media&token=19be9e01-6224-45f1-aff5-813d42301332",
            "sample.mp4?alt=media&token=8e41851d-2159-4a50-bfb6-b6b0470da82b",
            "sample.mp4?alt=media&token=f79b0348-8be7-4368-aed1-1cee204cbf2e",
            "sample.mp4?alt=media&token=da0b92fa-b87d-4c85-8fa5-d8269fa3c31a",
            "sample.mp4?alt=media&token=e8b450f1-6042-4a4a-9ed5-2e9dafdaec41",
            "sample.mp4?alt=media&token=32ecef44-9c6d-4dc6-9a47-84efad505676",
            "sample.mp4?alt=media&token=dd140490-463d-414a-9df9-ae8d07410b47",
            "sample.mp4?alt=media&token=d316f0ea-9003-4b31-8f3f-0b4b7bd97d8d",
            "sample.mp4?alt=media&token=d71f23c8-7147-44f9-8fa3-b2f8be41c9bd",
            "sample.mp4?alt=media&token=e5ba6db0-1ee9-4f1a-921b-872f666b4d61",
            "sample.mp4?alt=media&token=35d67d10-82ce-42b8-92ab-2acdb7ff8606",
            "sample.mp4?alt=media&token=125f0e5b-1ae5-41f1-a09e-03d461b44a76",
            "sample.mp4?alt=media&token=9d951b8b-e63d-4fef-8ab5-2764564fd91f",
            "sample.mp4?alt=media&token=f98f9d80-2018-4ee5-afa7-84de384368d0",
            "sample.mp4?alt=media&token=b3e98bf8-6fc2-46bf-b8db-849e88093eed",
            "sample.mp4?alt=media&token=75eae806-dffe-4b7a-83fa-178e54e0aaff",
            "sample.mp4?alt=media&token=ce5c496f-962e-4a86-8876-cf40dd1058d3",
            "sample.mp4?alt=media&token=506d1c7b-c5cf-45cd-ae74-21007f13bdcd",
            "sample.mp4?alt=media&token=4abaa194-5862-48af-ad21-566e805676e6",
            "sample.mp4?alt=media&token=5a0eb6a5-2eab-4caa-8071-44b3516fa682",
            "sample.mp4?alt=media&token=5bb07da7-ff06-4dd4-baf1-64039ee1cdba",
            "sample.mp4?alt=media&token=60e2d39f-c26e-4f67-8187-72adccf75b30",
            "sample.mp4?alt=media&token=83742d26-aa78-4154-b41e-5dccf3d4312b",
            "sample.mp4?alt=media&token=5eaec659-b6e7-4b43-abf3-297895268350",
            "sample.mp4?alt=media&token=c3c11604-bff6-4d3e-8a31-d9c54cfbcbeb",
            "sample.mp4?alt=media&token=174b11bc-1780-46cf-9831-cb1742ef37d4",
            "sample.mp4?alt=media&token=5c72b504-6e52-4913-9ab8-c696b8622a4f",
            "sample.mp4?alt=media&token=6fbb43ec-8349-4fab-9a47-e974b972576b",
            "sample.mp4?alt=media&token=9417c08c-8551-49aa-aaf4-5aefd4822f15",
            "sample.mp4?alt=media&token=3592a932-2524-4cce-8007-6f69f0ebc364",
            "sample.mp4?alt=media&token=8c37537e-2bc9-44f5-b041-d4722ee2c635",
            "sample.mp4?alt=media&token=91db32e0-7d3a-4f3f-bfd8-93f7b9528d94",
            "sample.mp4?alt=media&token=c6b71264-9e69-452b-ad04-1b0633fa9ef6",
            "sample.mp4?alt=media&token=0d4d95df-dea6-4f02-a32d-04016f9f4a1e",
            "sample.mp4?alt=media&token=804c06b1-996e-4fed-87a7-2b06db277681",
            "sample.mp4?alt=media&token=026930f0-7476-4181-86ea-c046b73caa0c",
            "sample.mp4?alt=media&token=090de0ba-a4da-4aa1-91a2-c4dbaa410011",
            "sample.mp4?alt=media&token=346571b6-9dd9-4cf0-a60d-7af161079081",
            "sample.mp4?alt=media&token=0740e5ec-104f-4b5b-88c6-4823d89ac871",
            "sample.mp4?alt=media&token=160ce36b-9247-4379-9998-e590f2ed196e",
            "sample.mp4?alt=media&token=c4cbfa0f-ce99-47e1-8bcb-0b151e6b5426",
            "sample.mp4?alt=media&token=c88e40db-1040-42b1-8aa0-f1e07ebd9b86",
            "sample.mp4?alt=media&token=5c4e6d05-c036-44ff-bece-2717e1122aae",
            "sample.mp4?alt=media&token=14bb9ad4-8dcc-478a-b6a3-ed79376ace80",
            "sample.mp4?alt=media&token=3a7b90aa-8950-4735-84cd-3185b91c3c2a",
            "sample.mp4?alt=media&token=b1a9cb0f-fe7e-40b7-97f0-9a75af82e6af",
            "sample.mp4?alt=media&token=82533623-c254-4f74-8497-6340ec8be425",
            "sample.mp4?alt=media&token=ae90fb85-9a60-49e5-af3f-0e8a97dc8a95",
            "sample.mp4?alt=media&token=a76ba6e8-ac16-4eb1-978d-daad79c49523",
            "sample.mp4?alt=media&token=171c898f-ba4a-43d2-b8d3-d069e5c9e4a0",
            "sample.mp4?alt=media&token=a65603b5-a765-4fcc-9d62-563b1c3916c6",
            "sample.mp4?alt=media&token=6070724e-56f5-4344-8873-ef87a7c1aa3a",
            "sample.mp4?alt=media&token=70689385-9008-4f6d-b10d-8fd3d111751c",
            "sample.mp4?alt=media&token=1d01bef7-bfc0-4150-be0a-5e6d41e7c3ca",
            "sample.mp4?alt=media&token=d7e18156-b9a5-4136-adde-00d1da7e6bd8",
            "sample.mp4?alt=media&token=d0a29472-7dad-443a-afe9-6a050229b9a2"
    };

    public SenerFragment() {
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