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
import java.util.Arrays;


public class AhmetFragment extends Fragment{

    private static final int PERMISSION_REQUEST_CODE = 1;
    Activity titleChange;
    String url;
    String btnname;
    String names [] ={
            "Abi kesinlikle yumuşatıcı bir etkisi var",
            "Ah canım kıyamam şuna bak ya",
            "Ama onu hepimizden ayıran en önemli özellik ne biliyo musun",
            "Aramızda garip bi iletişim doğdu",
            "Arızalısınız",
            "Aşk üstündür lafım yok",
            "Aslında çok naumslu şereflidir aç kalırsa yer",
            "Aslında hiç fena değilmiş ha",
            "Aslında sakindir biraz iri olmakla birlikte",
            "Ay ay ay hareketlere bak tam hokkabaz hareketleri",
            "Aynı yemekten yeriz aynı sudan içeriz",
            "Bak çok önemli bilgidir bu makara değil ha",
            "Bakın ben sihirbaz değilim hiç de sevmem",
            "Bakın beyler bu atmosfer gayri ahlaki",
            "Bakın bunlar insansa ben hayvanım",
            "Bakın işte bu bozuk sistem",
            "Bananeağğ",
            "Ben adamın vüücut dili ve hareketlerinden anlarım",
            "Ben bana yakın olan insanları bozarım hepinizi ben bozdum",
            "Ben boş konuşmam boş konuşmam",
            "Ben böyleyim kardeşim işinize gelirse",
            "Ben çamurdan çıktım her türlü alemi bilirim",
            "Beni daha yakından tanımak ister misin",
            "Benim angajman kurallarım çok açıktır",
            "Ben şimdi bişi söylicem çok aykırı gelcek",
            "Ben size dediğimde düşüncektin şimdi nooldu popon mu yandı",
            "Beyler ne demiştim ben sizin fare tuttuğunuz yerde ben kedi öpüyodum",
            "Beyler siz fesatsınız",
            "Böyle söylediğimde ne yalan var yapmayın gözünüzü sevim",
            "Bi dakka ya müsaade eder misiniz",
            "Bi şey söylemiyorum piç ettiniz lafımı",
            "Böyle olmaz ben keriz değilim",
            "Bu islama uygun mudur değil midir",
            "Bu kabul edilemez",
            "Buna ikinci sınıf bir algı yönetimi denir",
            "Bundan şeref duydum en ufak gocunmadım",
            "Bu olayı sulandırmanızdan dolayı size teessüflerimi bildiriyorum",
            "Çoğunuz yıkanmazsınız pissiniz",
            "Çok mütevelli yaşıyan hidayete ermiş bi ağbin",
            "Değişik bi heyecan yaşamak ister misin",
            "Dur bakim biraz havaya girersem söylicem",
            "Efendilik kandırmacadır",
            "Eğer türk gençliği rap dinliyosa yazıklar olsun",
            "Elini indiriyosun kimsiniz kardeşim siz",
            "Enteresan bi tip ağbi",
            "Esas problemin ne biliyo musun",
            "Fare zehiri içmiş gibi manasız işler yapıyo biliyo musun",
            "Fotoğraf var elimde",
            "Garip gevşedim rahatladım",
            "Gel beni test et istediğin soruyu sor harbi cevap vercem",
            "Gönlümüzü biraz açalım",
            "Gülmeniz falan bitti mi sapık kardeşler",
            "Hadi birinin maçası yiyosa bana böyle şaka yapsınlar",
            "Hadi gidin bakın işinize yazıklar olsun",
            "Hata yaparsam özür dilerim",
            "Hepimiz hanım köylüyüz diğer bi deyişle karı köpeğiyiz",
            "Hepimiz yavşağız bee",
            "Hiç biriniz dostum falan değilsiniz",
            "Hicv bu hicv",
            "İlk defa bi kahkaha attım pardon dedim",
            "İnstagram kullananlar hastadır",
            "İnstagram teşhirciliktir sevmedim",
            "İşte o el emeğidir sizin bilmediğiniz",
            "İstersem gelirim istersem gelmem",
            "Kapitalist bi dünyada yaşıyoruz telif hakları diye bişi var",
            "Kendinizi bu kadar büyük görmeyin ya kimsiniz siz",
            "Kes kardeşim o saçları kes beğenmedim",
            "Kıvırdığım zamanlar da oldu ama artık kıvırmıyorum",
            "Konuşturmayın beni",
            "LAAN",
            "Masonları hiç sevmem kıvırcak halim yok",
            "Nabıcaktım adamı dağa kaldırıp bilmem ne mi yapacaktım",
            "Ne ablası kardeşim ne ablası",
            "Ne anlamda söylediğimi ister misin öğrenmek",
            "Nefes alışından napıcağını biliyorum",
            "Ne tövbesi ne tövbesi",
            "Ne var bunda bu hakaret mi ya",
            "Ne var bunda iyice sapıttınız",
            "Rap sevmem yapanı da sevmem",
            "Saçından başından bıyıklarından utanmalıdır",
            "Şaka şaka espri yaptım",
            "Seni ben yetiştirdim tıpkı rambodaki gibi",
            "Senin en büyük talihsizliğin doğmuş olman",
            "Seni kılına zarar gelse biz panterleşiyoruz",
            "Seni sevmiyorum lan",
            "Sen kimsin ulan",
            "Sen yalan söylüyosun",
            "Seven adam her gün sever",
            "Şimdi istediğin soruyu sor buyur",
            "Simsiyah saçları simsiyah sakallarıyla oldukça yakışıklı genç bir adam",
            "Sıvacıdır kimseyle ters düşmez",
            "Sizin fare tuttuğunuz yerde ben kedi öpüyodum",
            "Tepki olması geri adım atacağım anlamına gelmez",
            "Tipe bak sanki yoğurtçu biliyo musun",
            "Türk halkı tvde gördüğü insanları ulaşılmaz zanneder",
            "Ya beni bi gün şöyle görürseniz yüzüme tükürün",
            "Ya kes şunu efendi gibi",
            "Yapamaz sağlığı yetmez adam zor yürüyo ya",
            "Yutubda var kardeşim bunlar bende yalan yok",
            "Zaten sen benim kim olduğumu biliyo musun tribini sevmem"};
    String links []={"sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
            "sample.mp4",
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

    public AhmetFragment() {
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