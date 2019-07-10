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


public class KemalFragment2 extends Fragment {

    private static final int PERMISSION_REQUEST_CODE = 1;
    Activity titleChange;
    String url;
    String btnname;
    String names [] ={
            "Açmazsan namertsin",
            "Ama bir şey var bir şey var",
            "Avukatlıksa ben avukatlık yaparım",
            "Ben insan oldukları için üzülüyorum",
            "Ben itiraz ediyorum siz de edin",
            "Ben kime ne anlatacam cehalet desem kaba kaçacak kimyası bozuk ",
            "Ben senin maskeni indirmek zorundayım ve bütün millet görecek",
            "Bir dakika arkadaşlar",
            "Bi şey söylicem de burda söylenmesi ayıp",
            "Bizim onlara boyun eyeceğimizi sanıyorlar kim olurlarsa olsunlar",
            "Böyle bir açıklama yapmak için aklı peynir ekmekle yemiş olmak lazım",
            "Bu adamın bilgi çağından haberi yok insanlığın geldiği evrimden haberi yok bu adamın",
            "Bu doğru değil",
            "Bu işleri türkiyede en iyi biz biliriz",
            "Bunu asla ve asla kabul etmiyoruz",
            "Bunu hakediyo muyuz?Haketmiyoruz",
            "Bunu kabul edemiyorum",
            "Bunu yapmak için ileri derecede gerizekalı olmak lazım?",
            "Bu sorumluluğu küçümsemeyin",
            "Cesaretin varsa çık karşıma",
            "Derhal burayı terket kardeşim",
            "E bunu örnek al niye bunu örnek almıyosun",
            "Ezberlerini kimyalarını bozduk",
            "Gençlere ve kadınlara yanaşacam",
            "Gerçekleri anlatıyoruz varsa bir yanlışımız çıkar burda anlatırlar",
            "Gerizekalılığın da bi düzeyi var",
            "Hayır bi açıklama yapmaya gerek var mı?",
            "Her gelen sizi kandırdı yetmedi mi artık",
            "Herkesle konuşcaz herkesle",
            "Hiç akla gelmeyen projeleri biz ürettik",
            "Hiç kimse unutmasın bir ülkü etrafında hepimiz birleştik",
            "İstediğin kadar kumpas kur yolundan dönen namerttir",
            "Kavga edenleri gerekirse kapının önüne koyacaz",
            "Kim olursanız olun bunun hesabı sorulacak",
            "Kimse kusura bakmasın güçleri yetmez",
            "Konuşmayayım da napiyim son derece sıkıntılı vaziyetteyiz",
            "Lafla olmuyo çaba harcamamız gerekiyo",
            "Lütfen ama lütfen durup düşünün sorun kendinize",
            "Maliye nedir vergi nedir para nasıl harcanır en iyi ben bilirim",
            "Nası bi hoca aklım almadı ama",
            "Nası okumuş nası profesör olmuş anlamakta zorluk çekiyorum",
            "Ne dedik delikanlı olacaksın ufak işlerle uğraşmayacaksın",
            "Neden bu politikayı övüyosunuz hangi gerekçeyle?",
            "Neyimiz eksik güneş mi su mu toprak mı?",
            "Niye itiraz etmiyosunuz hangi gerekçeyle itiraz etmiyosunuz",
            "O koltuklardan ineceksiniz aşşağ",
            "Onlar da insan bizim misafirimiz",
            "Onun çok korktuğunu biliyorum",
            "Onun direnci bizi buralara taşıdı",
            "Parayı bulucam diyosam ben parayı bulurum",
            "Rahatsız oldunuz biliyorum ama beni dinlemek zorundasınız",
            "Senin haberin yoksa ben nabiyim",
            "Senin yargın bizi kurtaramaz hele sen hiç",
            "Sen öyle kararı veremezsin kardeşim",
            "Şimdi değişim zamanı",
            "Şimdi küçük bi filmimiz var onu bi izleyelim",
            "Sizin içinizden bir yürekli insan çıkıp neden itiraz etmedi",
            "Sizleri seviyorum sizlere güveniyorum",
            "Soru sorcaksan araştır",
            "Suçu gizlemek ayrı bi suçtur",
            "Var mısın hodri meydan",
            "Ve hepimiz napıcamızı şaşırdık",
            "Yasadışı işlemler yapıyolar ses çıkarmıyosunuz"
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
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4"

    };


    public KemalFragment2() {
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
        gridview.setAdapter(new KemalAdapter(getContext(),getKemaller()));
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

    public ArrayList<Kemal> getKemaller(){
        ArrayList<Kemal> kemaller=new ArrayList<>();
        Kemal p;
        for(int i=0;i<names.length;i++){
            p=new Kemal(names[i],R.drawable.kemal);
            kemaller.add(p);
        }
        return kemaller;
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