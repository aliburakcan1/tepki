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


public class PolatFragment extends Fragment {
    private static final int PERMISSION_REQUEST_CODE = 1;
    String url,btnname;

    Activity titleChange;
    String names [] ={
            "(kutuyu açar)",
            "(telefon düşer)",
            "ağır laf kolay kolay kimse kaldıramaz",
            "Akılsızca hareket etmenin manası yok",
            "Aklına mukayet ol akıl çok değerli bi şey",
            "Allahım",
            "Banane senin rüyandan",
            "Ben bitti demeden bitmez",
            "Benim oynamaya vaktim yok",
            "Ben sana selam vermiceksin demedim mi lan",
            "Ben sizi tanımıyorum sizi buraya göndereni de tanımıyorum",
            "Ben tehdit etmem pişman ederim",
            "Bırakmam bırakmam",
            "Bu kafayı dağıtmazsam devreyi yakcam",
            "Bundan sonra sadece benim dediklerimi yapacaksınız",
            "Burda benim sözümün üstüne söz söyleyecek varsa gitsin onların hizmetine girsin",
            "Canının acımamasının nedeni bugüne kadar beni tanımamasıdır",
            "Kaybedecek şeyi olan insanlar yalan söyler benim yok",
            "dünyayı bize güldürmek mi istiyolar",
            "e beni hiç alakadar etmez",
            "gelecekleri varsa görecekleri de var",
            "gördüğünüz gibi elimde bi bomba var",
            "güzel güzel hep böyle benim sözümü dinleyin",
            "hakkımda biraz şeyler öğrenmişsin ama en önemli şeyi öğrenememişsin",
            "hapçıya bak çekmiş malı konuşuyo bunu ayıltmak lazım",
            "hayırdır yine neye sevgin kabardı senin",
            "hepimizin iyiliği için istemeye istemeye evet",
            "her şey yeni başlıyo",
            "hiç bişi bilmiyorum",
            "hiç bi yere gitmiyosun",
            "lafı bana söylediler size noluyo kardeşim",
            "lira değil dolar",
            "nasıl bu kadar aptalca bişi yaptığını anlatmanı istiyorum",
            "ne diceksen de sonra kapat telefonu",
            "nerden biliyosun",
            "neresinden dönersen dön dönek derler",
            "neyi ne zaman anlatacağımı sen bana öğretemezsin",
            "noluyo lan size hepiniz mi kafayı yediniz",
            "önce benim sorunumu çözün sonra napıyosanız yapın",
            "onun etrafında erkekler görmeye dayanamıyosun di mi çok kıskançsın",
            "öyle bakarsan her şey benim yüzümden ben napim",
            "planım milanım yok",
            "sana mı sorcam lan nabıcamı",
            "seni çok seviyorum lan",
            "sen de kimsin seni tanıyamadım",
            "sen hala benle pazarlık mı yapıyosun",
            "sen ne zaman çağırsan gelirim",
            "sen sen ol bi daha benle pazarlık yapma",
            "şerefin olsa bu işleri yapmazsın",
            "şu an öleceğimi bilsem haksızlığın karşısında olurum",
            "tarih tekerrür etmesin diye burdayım",
            "Var mı lan şansını başka denemek isteyen",
            "var tabi olmaz olur mu",
            "ya sizin kulağınız işitmiyo mu sizi de yardımınızı da istemiyorum",
            "yeteeeer"
    };
    String links []={
            "sample.mp4?alt=media&token=863856e8-388d-47a6-bf8f-714fb7f82cd0",
            "sample.mp4?alt=media&token=2e4fa74b-fe6d-45ff-abdc-a1bfc90275cd",
            "sample.mp4?alt=media&token=67901c75-4a29-403b-8127-66aabe0d3189",
            "sample.mp4?alt=media&token=cfddde2c-7cf7-4be4-8f65-82afc9483e1a",
            "sample.mp4?alt=media&token=91a1125f-9760-4b69-acf1-e1671e843535",
            "sample.mp4?alt=media&token=c22001f8-39f5-4f75-bda0-5649d042c377",
            "sample.mp4?alt=media&token=f80155b6-1012-4099-9e2d-3960854590ec",
            "sample.mp4?alt=media&token=df12b25e-ddaa-4dc3-bae8-f8527389f1db",
            "sample.mp4?alt=media&token=3c3629f4-53e3-44b7-a954-00aa1f066783",
            "sample.mp4?alt=media&token=c38906d2-f217-48a8-a132-a0cd3f16cb8d",
            "sample.mp4?alt=media&token=5ec14a12-e858-46ca-880e-6d84dc1f5161",
            "sample.mp4?alt=media&token=85d0dce7-5ed4-4fb8-8a89-787656bc603e",
            "sample.mp4?alt=media&token=5b3fad28-b867-4140-b21f-0386e99421d3",
            "sample.mp4?alt=media&token=be15086c-368a-4b9d-8044-f080f4f0ea2b",
            "sample.mp4?alt=media&token=c0f1a39d-84e7-4fc1-af79-9a97113bfb7d",
            "sample.mp4?alt=media&token=382f0d3d-72e9-43a1-a25e-11758d686ed9",
            "sample.mp4?alt=media&token=0037e34b-65ea-43b7-81ea-e05c1b757095",
            "sample.mp4?alt=media&token=c857de73-a41c-4981-86f5-1488b4d9b24a",
            "sample.mp4?alt=media&token=91169b91-6cf9-44f4-819d-3d7765fbfddc",
            "sample.mp4?alt=media&token=180cff63-359a-4963-a4b7-8cac52045ca9",
            "sample.mp4?alt=media&token=0f40151e-6520-4680-8a41-380b74750dd6",
            "sample.mp4?alt=media&token=cbd31b75-1df1-437c-8a89-fdceb2dfc1ad",
            "sample.mp4?alt=media&token=73842fd2-f9ed-48d0-81f3-d24f0e1899cd",
            "sample.mp4?alt=media&token=b069ecc7-093d-4e3b-9ad3-39f5c3fe9373",
            "sample.mp4?alt=media&token=11d4cc38-88c4-4f5e-9ddb-0a8fb654c7da",
            "sample.mp4?alt=media&token=3db5d498-c454-4807-8043-7c771766c515",
            "sample.mp4?alt=media&token=3a6d9bf3-2b3f-4142-9a93-bfaff38868d7",
            "sample.mp4?alt=media&token=2bc2aeab-cacf-48ec-91f5-aca684835f35",
            "sample.mp4?alt=media&token=d17e0de7-271d-4942-ad66-aea255ca81d0",
            "sample.mp4?alt=media&token=e97b5b60-9b0d-4e5f-accf-7dcb11885c25",
            "sample.mp4?alt=media&token=1c1e615a-e35d-445c-bbb5-8ed87878c57d",
            "sample.mp4?alt=media&token=80e986a2-d383-4500-b381-34c30140f500",
            "sample.mp4?alt=media&token=530825b8-fa87-491a-936b-243a8f9112d8",
            "sample.mp4?alt=media&token=8edfcf55-3494-4a5d-9334-8a854239d6be",
            "sample.mp4?alt=media&token=84381576-3e71-4861-9345-3c81610f7951",
            "sample.mp4?alt=media&token=84543608-8ed2-43ae-a6fb-c4ac562f77e7",
            "sample.mp4?alt=media&token=efab7308-6c65-4be4-a137-66ee52c2b209",
            "sample.mp4?alt=media&token=538088e7-8412-4d26-9da7-6ec059a2317b",
            "sample.mp4?alt=media&token=4bd660d4-fb35-431b-90e7-8f1fdfe93800",
            "sample.mp4?alt=media&token=76b54bd8-5b98-4f11-a283-8c07b26478f3",
            "sample.mp4?alt=media&token=d69afd56-fa27-40f9-9584-a9bad0f7fadf",
            "sample.mp4?alt=media&token=c17b3c78-eb2f-4e26-866c-23e706266fcb",
            "sample.mp4?alt=media&token=566e6c24-7c5a-4788-a3ca-a8b172eeb821",
            "sample.mp4?alt=media&token=1a2d73dd-8e85-446f-b0a4-6354945c6afa",
            "sample.mp4?alt=media&token=3b08f11c-3791-40d3-b4e5-005aa657d1e7",
            "sample.mp4?alt=media&token=28889fc2-6219-4475-a017-50ae0b3424cd",
            "sample.mp4?alt=media&token=82d6214a-1a65-48e9-9d14-21385b020d5d",
            "sample.mp4?alt=media&token=3ce218ed-8338-47b9-a79e-78aaac0a8155",
            "sample.mp4?alt=media&token=9b7e780d-5431-4370-b93d-24b57451d937",
            "sample.mp4?alt=media&token=dbb4eb40-a410-41c6-80a6-871bed18ee15",
            "sample.mp4?alt=media&token=465d313f-d88f-441f-8c97-493304346351",
            "sample.mp4?alt=media&token=cc6823e3-072b-4063-a11b-4f5c5132cdb2",
            "sample.mp4?alt=media&token=65622e9c-3e3e-47e7-96b0-f2a1e3f92b13",
            "sample.mp4?alt=media&token=461d0268-d6a5-414c-aac8-cbf699ca9b7d",
            "sample.mp4?alt=media&token=1f653fdd-5cb7-4841-ba57-c41a1f05ed02"

    };

    public PolatFragment() {
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