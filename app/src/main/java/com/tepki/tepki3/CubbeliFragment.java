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


public class CubbeliFragment extends Fragment {
    private static final int PERMISSION_REQUEST_CODE = 1;
    String url,btnname;

    Activity titleChange;
    String names [] ={
            "İki saat oynuyoo oynuyoo",
            "Acayip zorlaştı ya bu durumda nası geçinilecek",
            "Adamı görüyo musun ne ilim aldı",
            "Adamın bilgisi bilgisayar teknolojisinde kalmış",
            "Adamın kıblesi sofra",
            "Adamlar neler yapıyo haberiniz yok",
            "Adam tanımıyo bilmiyo",
            "Akşama kadar gözümü açamıyorum hele bi nescafe getir",
            "Alıyo cep telefeno naylonu da çıkartmıyo",
            "Allah da yardım eder mi etmez",
            "Allah rezil ettikçe rezil ediyo tövbe et belki yırtarsın",
            "Ama ben daha önceden söyledim kusura bakmayın",
            "Ama malesef çağımızın en büyük hastalıklarından",
            "Ama siz maşallah kurt olmuşsunuz",
            "Anca çarşı pazar dolaşıyor geziyor",
            "Atlayıp zıplıyosun hiç yerinde durmuyosun",
            "Bakarsın yakışıklı adam çirkin karıya tutulmuş",
            "Bak kafasızlık yapma bak",
            "Bak sapığa bak",
            "Bara gitmiyorum bi şey yapmıyorum",
            "Batıldasın dalalettesin felakettesin",
            "Bazen doğru konuşuyo ama böyle bişi olabilir mi",
            "Benim de sana tavsiyem bok ye",
            "Beni mi kandırıyosun ben kaçın kurasıyım",
            "Beni seviyo musun dedi belalara hazır ol dedi",
            "Beni terbiyesiz konuşturma",
            "Beş paralık şehvet ve keyif adamın başına çok büyük bela açar",
            "Beyle bi acaip insanlar var hiç ileriyi düşünmez",
            "Bi geçimsizlik varsa ayrıl",
            "Bir adam zorbalık yapıyor bu tanım da çok uyuyor",
            "Biraz az bilin bee uğraşmayın şu işlerle",
            "Bir dakka içerisinde öyle dünyacı kesilir ki",
            "Bi şey bilmeden çıkıp oraya konuşuyosun",
            "Biz böyle şey duymadık bizim cemaat ilk duyuyo",
            "Böyle hocalık olmaz",
            "Böyle olmak lazım öbür türlü yetişilmez hırstan",
            "Böyle şey olur mu ya az ye ya",
            "Bu bayanlar acaip bişiler ya",
            "Bu hafta bi tivit olayı oldu",
            "Bu işler böyle konuşulur kardeşim müptezelliğin lüzumu yok",
            "Bu kadın kız işine çok dikkat edin",
            "Bu meseleye bu yönden hiç bakmadıydık",
            "Bu ne rezillik ya",
            "Bunların yüzünde meymenet yok",
            "Bunlar mesele değil kitapta var",
            "Bunlar nası konuşuyo arkadaş ya",
            "Bunlar ne sapık adam ya",
            "Bunlar uygun şeyler değil tabi elinde olmaz o başka",
            "Bunu sormak da kolay değil ha",
            "Bura cennet cennet",
            "Bu tıbben sabittir",
            "Cahillik fuzuli",
            "Çok utanmaz adamız biz ya",
            "Çünkü adamlarda maç hastalığı var",
            "Delimidirler manyakmıdırlar bunları tımarhane kabul etmez",
            "Dikkatli olalım kardeşim ya",
            "Dolayısıyla hepimizde aynı huylar var",
            "Dolu olursan batıl fikir sokamaz",
            "Dünya yansa umurlarında değil o meseleye kitleniyolar",
            "Ee allahın elinden gelir benim elimden gelmez ki ya",
            "E şimdi bunlara uyulur mu",
            "E şimdi nolcak",
            "Feci cehennemde azap var ya",
            "Genetiklerimiz uyuyor şifrelerimiz birbirine karışmış",
            "Geziniyosun geziniyosun",
            "Gol atmak nimet değil",
            "Gülerek sevinerek keyf yaparak",
            "Gülmeye ihtiyacın yok ki senin ağlamaya ihtiyacın var",
            "Haine nasib olmaz",
            "Hak ile savaşılmaz batıl ile yücelinmez",
            "Hastalık yok fakirlik yok fors 1500",
            "Herkes haddini bilsin herkes naptığına dikkat etsin",
            "Herkes müftülük yapamaz",
            "İmdat feryat aman",
            "İmreniyorum ya",
            "İş yapmayan adamlarla yürünmez",
            "Kaba etlerine hafifçe vurun",
            "Kaç senede nası değişti yaşanacak halden çıktı",
            "Kafayı neyle yedin ya",
            "Kardeşim bak her şeyi öğrenin burası dersane gibi",
            "Karı bi güzel oldu gözlen BAKILAMIYOR",
            "Kızmak zararlı",
            "Koymayın bi resim ölür müsünüz koymayın görünüyo bu",
            "Koymayın bu resimleri internete ya",
            "Manyak mısın nesin ya",
            "Maşallah demeyin",
            "Maymuna döndü yüzüne BAKILAMIYOR",
            "Millet nelerle uğraşıyo yav",
            "Millet perişan",
            "Ne anlıyosun bu adamdan senin derdin başka",
            "Ne bakıyosunuz saf mısınız?",
            "Ne dediğini bilmez cahillik bi rezalet ya",
            "Ne ağladığı bağırdığı belli değil",
            "Ne filmler çıkartıyolar şu milyona ulaştı şu milyonu geçti",
            "Ne yapmak lazım bilmiyorum",
            "Neyim ben ki ya gariban kulum",
            "Niye böyle oluyo",
            "Niye okudun sen",
            "O karı da seni cehennemde yakar",
            "Okus pokus mu yapıcam",
            "Ortaya atıyolar herkesin mahremi var",
            "PAAT KÜÜÜT",
            "Rastgele yapmak caiz değil",
            "Sakın müzikli şey koymayın bu ne iştir ya",
            "Sanki o herifin fetvası ehli sünnet fetvasıymış",
            "Şaşırıyorum kalıyorum",
            "Sen bişiler yapmaya bak belasız kalmazsın",
            "Sen bozulursun çizgiden çıkar gidersin",
            "Senin yardımın olmazsa olmaz",
            "Sen kaybediyosun kaç saatin boşa gitti yazık değil mi sana",
            "Sen ne anlamaz adamsın insansın be",
            "Sen nimet zannediyon ama millet para kaybediyo",
            "Şeytana da böyle kazık atan ilk defa görüyom",
            "Şimdi burda iki üç saat konuşcam haber olmayacak",
            "Şu kadınların ne işi var internetin şeyine resim atmağ",
            "Terbiyesizlik yapmayın",
            "Tıbben şu anda tıbın tesbidiynen",
            "Tıp bilgisi bu doğru",
            "Uff nere gitsek ya bunaldım",
            "Ulan ne ayıp şeyler bee ne yüzsüzlükler bee",
            "Ulan vay anasını hakkaten olmuş bişi ha",
            "Vah sana x4",
            "Valla bana hoşuma gitti",
            "Vay terbiyesiz adam",
            "Vur buna bi daha",
            "Yabacan işi öğren de yap",
            "Ya bi de zaruret olmayan fuzuli fuzuli",
            "Ya kim inanıyo böyle bişi yok ya",
            "Yalakalıklar yağcılıklar ben yaparım kb",
            "Yani irşadsız kimse kendi başına bişi olamaz",
            "Yapmayın yazık edersiniz yarın gömülüsünüz",
            "Yaptımsa yaptım derim",
            "Yarabbi aklıma mukayyet ol",
            "Ya siz niye anlamıyosunuz kardeşim beni size daha mı açık konuşturcaksınız ya yapmayın ya",
            "Yenerseler bağırıyolar yenilirseler susuyolar",
            "YUH ÇÜŞ",
            "Zorbalığı bıraksınlar"

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

    public CubbeliFragment() {
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