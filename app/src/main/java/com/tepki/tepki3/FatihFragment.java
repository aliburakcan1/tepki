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


public class FatihFragment extends Fragment{
    private static final int PERMISSION_REQUEST_CODE = 1;
    String url,btnname;

    Activity titleChange;
    String names [] ={
            "Açık konuşacaksak bunları da ifade etmek zorundayım",
            "Açın bakın tekrar açın bakın",
            "Allah yardımcınız olsun",
            "Arkadaşlar kimsenin etrafında dönmüyo dünya",
            "Arkadaşlar şu komediye bakın ya",
            "Bakın size bi örnek vereyim can kulağıyla dinleyin",
            "Bazen istediğiniz gibi yazıp doğruların üzerine perde çekiyosunuz",
            "Ben etiğe aykırı bişi yapamadım",
            "Benim arkamda bana yardım edecek adam görmeliyim",
            "Benim haberim yok onun nerden olsun",
            "Ben yıllardır bu tıraş bıçağını kullanıyorum",
            "Bir dakika sabredemiyo muyuz allah aşkına",
            "Birden bire olayla başka bir hal almaya başladı",
            "Bir tanesi doğru bir",
            "Biz buraya şova gelmedik",
            "Biz her dakka birilerini suçlayan adam değiliz",
            "Böyle bişi nasıl olabilir ya",
            "Bu iki güzel şey birleşmeli artık",
            "Bu kararı haklı çıkarmak için nedenler sıralanıyor",
            "Bunu da o günlerin arşivlerine bakarsanız net bir şekilde ifade etmiştim",
            "Burda herkes prensiplere uymak zorunda",
            "Çocuk oyuncağı değil bunlar çok önemli bi şey",
            "Çünkü ben kendime yakışanı yaparım",
            "Edebimizle adabımızla hizmet ediyoruz nooluyo yaa",
            "Evet söyledim hepsine söyledim",
            "Güvenim yok bi defa",
            "Hakkınızı helal edin",
            "Herkes dikkatli olsun",
            "Hiç yakışmıyor bize biz bambaşka bi ülkeyiz",
            "İnsani ve medeni diyalogları biz her yerde koruyoruz",
            "İnsanların bağlılığını gösteren terazi ağır olsa benimki ağır basar",
            "Kimin kime hizmet ettiği açık",
            "Kurumsallıkta profesyonellikte bi karar alınır ve biter",
            "Nası çıkar nerden çıkar bilmiyorum ama çıkıyor",
            "Nerden çıktı nası çıktı bilmiyorum",
            "Nerde olursam oliyim ben buyum",
            "Noluyor ya siz yargıç mısınız hakim misiniz",
            "OLUM GÖRİYİM SİZİ GÖRİYİM SİZİ",
            "Onu çekmeyin bunu çekin",
            "prestij kaybettirmeye çalışan bi gizli iş var biz tecrübeliyiz",
            "Size güveniyorum size inanıyorum allah yardımcınız olsun",
            "sorduğunuz soru güzel ve gayet açık",
            "şu anda gene başladı herkes yazılmaya",
            "Şu bi gerçekki yakaladım mı bırakmam",
            "Uğraşıcam eskisinden daha hırslı",
            "Var mı böyle şeyler arkadaşlar komik,komedi",
            "Ya ben naaptım yaa",
            "Yani anlatıyorum benim gili bi gündemim yok diyorum",
            "Yani ben ne hakaret ne de jest mimik hakettim",
            "Yani güvenim yok bi defa",
            "Yazmanıza rağmen bilmenize rağmen bana onu da soruyosunuz",
            "Yoldan geçen biri bana soru mu sorcak",
            "Zaten bu konuda hassas davranan yok"
    };
    String links []={
            "sample.mp4?alt=media&token=91fa9076-8bf8-408b-9b7f-0d6e9e19ea8e",
            "sample.mp4?alt=media&token=60b38540-b191-4719-bf24-096b0a3c798d",
            "sample.mp4?alt=media&token=161b0ebe-9fa9-43ff-ae50-12961ab02e4e",
            "sample.mp4?alt=media&token=67c00839-b2cf-4e4f-b66f-5c6ae2adb99a",
            "sample.mp4?alt=media&token=4d61fc83-8e9a-4368-8455-a84ec151cbd9",
            "sample.mp4?alt=media&token=a2754d2c-44c4-48dc-a865-7340f8ff58fa",
            "sample.mp4?alt=media&token=91710281-d14c-4958-8d10-f06016c947eb",
            "sample.mp4?alt=media&token=d85d3cdb-1b95-478f-9296-0fdb022c5c73",
            "sample.mp4?alt=media&token=dde9c47c-7b3b-42a0-939f-580499565de6",
            "sample.mp4?alt=media&token=9edf6a61-eca2-41d8-9f60-c8ebdd22e233",
            "sample.mp4?alt=media&token=499d4ccf-757f-4a3e-91e2-349250a84990",
            "sample.mp4?alt=media&token=e3ff559b-0310-4c20-b801-000f30d03668",
            "sample.mp4?alt=media&token=278caeab-1259-475d-8954-d2423b0750d9",
            "sample.mp4?alt=media&token=e3934af5-dda6-4265-9ce9-37a56845ef16",
            "sample.mp4?alt=media&token=34ba4e6b-f625-4e3f-824a-9621827742d8",
            "sample.mp4?alt=media&token=d8717470-7a99-4464-901f-3b7042946274",
            "sample.mp4?alt=media&token=25393738-48d9-4187-8cb1-289e9355c96c",
            "sample.mp4?alt=media&token=e096503b-d9ae-48bb-abe2-a8d6a11d2cb1",
            "sample.mp4?alt=media&token=53a23263-42d1-4791-b156-ee3974ead315",
            "sample.mp4?alt=media&token=adc986a9-d153-401c-baa0-acdd62629406",
            "sample.mp4?alt=media&token=561ac5fb-4119-4241-bc82-58d7c6496a9f",
            "sample.mp4?alt=media&token=3db6bde9-cc2d-4993-9b13-80c40373678a",
            "sample.mp4?alt=media&token=ecb787c8-a795-42c2-a738-d96eb9b531d7",
            "sample.mp4?alt=media&token=076f6395-f1c3-49db-905d-1080959abf51",
            "sample.mp4?alt=media&token=d6e366bd-2e8c-4ea7-b9c1-b82e840187f3",
            "sample.mp4?alt=media&token=8f97c47a-3e64-435e-b99e-0a1fdc31721d",
            "sample.mp4?alt=media&token=479569f6-8c29-4c32-9b14-7502aa2aad2a",
            "sample.mp4?alt=media&token=7dd16cd2-c736-4653-8db5-ba8adee25b9c",
            "sample.mp4?alt=media&token=d6a1b383-c244-46d6-96fc-b0304c380fc7",
            "sample.mp4?alt=media&token=c4d620cd-0790-4018-bc9e-5114d5b6ad28",
            "sample.mp4?alt=media&token=744e6812-4498-4e60-9eb8-d43aa87a94bc",
            "sample.mp4?alt=media&token=3245218e-4db9-41ea-9409-bda50ffec744",
            "sample.mp4?alt=media&token=3d2cdd3f-dfb2-40eb-9995-556d8a3a6bb9",
            "sample.mp4?alt=media&token=f0e45eec-aa8a-4d1c-a471-b092df206318",
            "sample.mp4?alt=media&token=951aaccc-f854-4065-ad21-3399152b000e",
            "sample.mp4?alt=media&token=2cdfec82-e39c-4369-b14d-8c648a252b44",
            "sample.mp4?alt=media&token=2f9eef2f-cd2e-46d1-b589-491b7ef4f238",
            "sample.mp4?alt=media&token=160257bb-48e7-4bb7-8a4d-bf4efd428bc8",
            "sample.mp4?alt=media&token=36cafcd1-c168-41b2-b3fd-56bfcb08e1f0",
            "sample.mp4?alt=media&token=111ecf38-0d80-490d-b921-39e95a124bd1",
            "sample.mp4?alt=media&token=a23bdbbe-2853-42c2-a23f-47065b1cc3a8",
            "sample.mp4?alt=media&token=41d05d56-a793-4163-a7d7-0b5161458438",
            "sample.mp4?alt=media&token=1abc5dcd-f124-49e8-991a-c93b03dea21c",
            "sample.mp4?alt=media&token=ab37f96f-1a16-42b4-adca-67be0f0e4096",
            "sample.mp4?alt=media&token=292c9061-f6dc-4b0b-96ae-11f3daa3d7c7",
            "sample.mp4?alt=media&token=9acda332-21e0-400e-ac1b-fed2f76d3dbe",
            "sample.mp4?alt=media&token=9c953d48-faf9-4cf8-9bbc-da5a45f4a4ef",
            "sample.mp4?alt=media&token=900075c6-83ef-470a-b82d-07e307e59d83",
            "sample.mp4?alt=media&token=72e3e142-b03d-4904-bd84-c99137f24f04",
            "sample.mp4?alt=media&token=a779a07f-1e82-491e-9a87-145a3dda467a",
            "sample.mp4?alt=media&token=c7ae4a89-9f40-47b1-bc01-929377e888e2",
            "sample.mp4?alt=media&token=18d065de-82ab-407b-87b0-a968c2694145",
            "sample.mp4?alt=media&token=2a4d591a-c3b7-42f2-a12f-46942a0c84da"

    };

    public FatihFragment() {
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