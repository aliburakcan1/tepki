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


public class AzizFragment extends Fragment{
    private static final int PERMISSION_REQUEST_CODE = 1;
    String url,btnname;

    Activity titleChange;
    String names [] ={
            "(Kapıyı açamaz) Neresi burası",
            "AA a yoğhöyle yok",
            "Adaletli yönetim istiyoruz",
            "Akşam maç var hadiseleri hızlandıralım",
            "Ama ben tedirginim bunu bilin",
            "Ama çok ayıp ya",
            "Ama huzur kalmadı burda",
            "Anlayana sivrisinek saz hikayesi",
            "Bak güzel kardeşim yalan söylemiceksin",
            "Bak lütfen bu konularda hassasım",
            "Bak teklifim geçerlidir",
            "Başkanın kimdir senin patronun kimdir",
            "Başka noktalara gideceğini gördüğüm için ikaz ediyorum hepinizi",
            "Ben bunu yapamam yapmam",
            "Ben hiç bi şeyden çekinmem yüzüne söylerim",
            "Beni daha fazla konuşturma detaylara girerim altından kalkamazlar",
            "Beni fazla konuşturmasınlar bak çok şey biliyorum",
            "Beni güldürüyosunuz ya",
            "Benim damarımda kan başka akar",
            "Benim hiç bir cemaatle hiç bir siyasi şeyle bağlantım yok",
            "Beni tehdit kamçılar",
            "Ben tehditlerden korkamam beni tanımamışlar",
            "Bi gün gel anlatayım sana",
            "Bilin ooyoğhoyle yok bilin",
            "Bırak bunları",
            "Biz bi şey öğrenelim diye uğraşıyoruz siz bi şeyler yapıyonuz yanlış bunlar",
            "Bizim hayatımız stresli maalesef",
            "Bizim üzerimizden para kazanıp bize hakaret ha",
            "Biz öyle korkak adamlar değiliz",
            "Biz pişman değiliz yaptıklarımızdan",
            "Biz sizin iç işlerinize karışmıyoruz siz de benimkine karışmayın",
            "Biz uygularız biz yaptırırız biz söyleriz",
            "Böyle bişi yok abi devletin kurumları var kurumları",
            "Böyle şeyler yanlış şeyler ayıp şeyler",
            "Bugün çıkarsınlar o günki tapeleri görsünler",
            "Bugüne kadar nasıl saygılıysam yarın da saygılıyım",
            "Bugüne kadar sabrettim",
            "Bunca zaman hakaret ettiniz tivitırlarda şurda burda bişi demedim",
            "Bundan sonra gülücem çekeceeem gülücem",
            "Bunlar ayrı konular anlatmak istemiyorum",
            "Bunlar timsah gözyaşları kimseyi de kandırmasınlar",
            "Bunu herkes böyle bilsin böyle hareket etsin yanlış yapıyoruz",
            "Bunu yaratanlar biziz herkes pay çıkarmasın",
            "Bunu yazmak da söylemek de aptallık olur",
            "Buranın gerçekleri var kardeşim",
            "Burası yangın yerine döner",
            "Burda söyle herkes duysun doğru mu ?",
            "Bu süreci yaşamak bizler için çok zor oluyo",
            "Cezalarla bu iş olmaz bura para alıp yan gelip yatma yeri değil",
            "Çünkü kültürümüz yok kültür",
            "Çekilmezsem nolur?",
            "Dediğim doğru di mi?",
            "Devletin vergileriyle dağıtıyolar ahkam kesiyolar",
            "E orda sizin gibi zihniyet yok ki",
            "Gençler dedik gençler de yanlış yapıyo",
            "Gerektiğinde kızcaz bağırcaz siz hiç kavga etmiyo musunuz?",
            "Habercilik artık bu değil bilim ilerledi teknik ilerledi",
            "Hadi iyakşamlar",
            "Hepimiz üzülüyoruz bu işin tadı da kaçar",
            "Herkes korkuyo kaçıyo biz burdayız sonuna kadar",
            "Her şeyi söylicem dosyayı koyucam buraya",
            "Hiç bişi yok boşuna konuşuyosunuz beni de konuşturuyosunuz",
            "İşte nooldu bu ooldu şu tarihte bu ooldu",
            "Karalamak kötü kullanmak avrupada yok",
            "Kavgayı içinizde yapın niye bizi meşgul ediyosunuz",
            "Konuşcaksa gelsin burda konuşsun",
            "Konuşma beni dinle ben ne diyosam onu dinle",
            "Muhalefete karşı değilim eğer aklı başındaysa",
            "Nankörlük etmesinler beni başka türlü de konuşturmasınlar",
            "Ne biçim yorumlar yapıyolar ya el insaf yani ya",
            "Neyle yapıcaksın kardeşim neyle parayı nerden bulup getireceksin",
            "Neymiş o söyle ya konuşuyoz",
            "Neyse bu kadar söyledim yeter",
            "Onları uyarıyorum onları rezil ederim",
            "Onu bilin ve doğruları yazın tamam mı",
            "Örfe uymayarak hakaret ediyolar bize",
            "Öyle duydum haberiniz olsun",
            "Öyle 3 tane bacaksıza hesap vermem yani",
            "Rahat ol sen rahat",
            "Sana şunu söyliyim alınıyosun",
            "Sen anlamıyosun yaşını büyüt",
            "Senin anlattığın şeyleri ben başka türlü anlarım",
            "Senin duyguları bilmiyosun yaşamadın mı",
            "Sen kimsin lan sen kimsin böyle şey olmaz",
            "Sen okumuş insansın yapma",
            "Sen otur muhatap olma benle",
            "Şeref sözü",
            "Sıkıntı olmaması için hepimizin aklı selim düşünmemiz lazım",
            "Siz muhatap olmayın",
            "Söyle korkma",
            "Şunu da bilirim her gecenin sabahı olmaz",
            "Tamam hepimiz kızıyoruz ama insanca bakmak lazım",
            "Terbiyesizler ahlaksızlar bu kadar ağır hakaret ediyorum",
            "Türk sporu ilerlemez",
            "Ya bunları geçin baba ya ayıp ya",
            "Ya ne güzel hayatınız varmış sizin ya ",
            "Yani ne olduğunu bilmeden kavramadan haber yapıyosunuz ayıp",
            "Yanlış yazıp kamu oyunu yanıltmayın",
            "Ya yine konuşuyosunuz yine kavga ediyosunuz ya",
            "Yazmasan daha iyiydi"    };String links []={
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
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

    public AzizFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_yildiz2, container, false);
        /* Arrays.sort(links, new Comparator<String>() {
            public int compare(String str1, String str2) {
                String substr1=str1.substring(61);
                String substr2=str2.substring(61);
                return substr1.compareTo(substr2);
            }
        }); */
        Log.e("deneme",links.toString());
        //Toast.makeText(getContext(),links[1].charAt(),Toast.LENGTH_SHORT).show();
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