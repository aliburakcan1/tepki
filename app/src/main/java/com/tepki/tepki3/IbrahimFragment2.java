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


public class IbrahimFragment2 extends Fragment {

    private static final int PERMISSION_REQUEST_CODE = 1;
    Activity titleChange;
    String url,btnname;
    String names [] ={
            "(bilumum övgüler)Allah seni esirgesin uzun ömür versin",
            "Aklı fikri varsa onun yanında ol",
            "Allahın selameti başına olsun hadi güle güle",
            "I am bi şeye benzemiyor",
            "Bakın bu bomboş bi iş yap yalan bi iş",
            "Bakın burdan hanımlara sesleniyorum",
            "Bakın edep denen şey çok önemlidir",
            "Bak şerefsiz evladıyım ağlamamak için kendimi zor tutuyorum",
            "Bak yemin billah ediyorum bütün şeyler ona çalıştı",
            "Ben biraz güzelden anlarım anam söylemesi aybolmasın da",
            "Beni biraz yorsana",
            "Beni kimse askıya almaz almadı da",
            "Ben konuşmama kararı aldım",
            "Ben ölçecem ben tescil verecem",
            "Ben senin dostun değilim arkadaşın da değilim",
            "Ben tescil ettim olay tamamdır",
            "Ben yalan söylemem sana",
            "Beşyüz oyun oynansa bir tane alması mümkün değil",
            "Beyle bi saygısız yok kafamın tasını da attırmayın",
            "Bi şey görürsem ya kadınımı öldürmem lazım ya kendimi öldürmem lazım",
            "Biz burda x 5",
            "Biz burdayız diğerlerini arıyorum arıyorum bulamıyorum",
            "Böyle bişi yok utanın hakkaten utanın ya",
            "Bu iş bu kadar basit değil saygı denen bi şey var",
            "Bunaldım ama haaa",
            "Bunaldım artık haa",
            "Bunla ilgili çok başka farklı farklı şeyler anlatmıcam",
            "Bunu da taklit etsinler de göriyim",
            "Bunun altında bi şey arama olum biz de hile yok",
            "Çıplak öyle net görüyorum seni pırıl pırıl",
            "Çok güzel çok seksapel",
            "Dünyada en önemli şey hırsızlıktır ürettiğimiz şeyleri çalıyolar",
            "Dünyanın en bombası bu cep telefonu",
            "Du yu andırsitend?",
            "Eeee işi bileceksin",
            "Flört furt firt arkadaş ne oluyor aym yu firend",
            "Gerizeka bunu yazmakla ne yani alıp veremediğin siğdıremidığın",
            "Güzel abim güzel ablam bilmeden neden yargıya varıyosun",
            "Hayret bişi yav",
            "Hele bi cigara yakın",
            "Hiç tanıdınız mı ben tanıdım adam gibi adam yeminle",
            "HÖÖT HÖÖT lan",
            "Kusura bakma bunları bilmiyosunuz anlatmak zorundayım",
            "La gardaş vururken merhametli vurun",
            "La bi gelir misin lütfen",
            "Millet seviyorken sana illet olmak düşüyor",
            "Müsaade ederseniz anlaşacaz",
            "Ne kadar anlayışsızsınız ya",
            "Ne lidılı ayem bik",
            "Nerden penaltı la",
            "Nereye gidiyosun",
            "Neyin peşindeyiz hepimizin gideceği yer aynı aynı",
            "Of ulan of",
            "Ölçümlere göre tescilli damgalı",
            "10 üzerinden 1 değil 2 değil ... 10'sa 10",
            "Özüme inmeden mağarama gelmeden ne çektiğimi nerden bileceksin",
            "Peki huzursuz oluyo musunuz huzursuz ediyo musunuz ne anladım",
            "Programı terket",
            "Şahane saygılar sunuyorum",
            "Sanane la sana giren çıkan ne arkadaş",
            "Sana orda verilcek bi cevabım vardı fakat verirsem şerefsizim",
            "Şarlatan seni elime alırsam feriştahın çocuğu elimden alamaz",
            "Seksapelliği çağrıştırır düşüncesi var ama öyle bişi yok",
            "Sen atma kulun kurbanın oliyim sen atma",
            "Sen bunları canı gönülden yazıyosun ben ağlamam mı zannediyosun",
            "Senin yok demenle yok olmuyo arkadaş",
            "Şimdi abi bi milyon tane bu ne ya",
            "Şimdi beni iyice kulak vererek dinleyin",
            "Şimdi kendime bakiyem bakiyem 19 yaşındaki çocuk gibi valla",
            "Siz kimsiniz yani",
            "Şu hareketi anlamış değilim çocuğum",
            "Süp süp süper harika",
            "Töbe yarabbi töbe kendine gel olm",
            "Twitter çıktı çıkalı işin cılkı çıktı cıcığı çıktı",
            "Ulan sen var ya pis herif allah cezanı verecek",
            "Ulan şerefsiz bak sana söylüyorum bak",
            "Verin bize ödülü bak neler yapıyoruz",
            "Yalan yanlış haberlerden bıktım artık",
            "Yaşın kaç başın kaç la",
            "Yav ne yapim gitmişseniz sabah 5 akşam 9 ben hiç gitmedim nasolcak",
            "Yemin billah ediyorum hıçkıra hıçkıra ağlamak istiyorum",
            "Yıpratmayalım kıskanmayalım",
            "Yu andırsitennndd"
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

    public IbrahimFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ibrahim2, container, false);
        final GridView gridview = view.findViewById(R.id.gridView7);
        AdView mAdView;
        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        gridview.setAdapter(new IbrahimAdapter(getContext(),getIbrahimler()));
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

    public ArrayList<Ibrahim> getIbrahimler(){
        ArrayList<Ibrahim> ibrahimler=new ArrayList<>();
        Ibrahim p;
        for(int i=0;i<names.length;i++){
            p=new Ibrahim(names[i],0);
            ibrahimler.add(p);
        }
        return ibrahimler;
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