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


public class SedaFragment extends Fragment {
    private static final int PERMISSION_REQUEST_CODE = 1;
    String url,btnname;

    Activity titleChange;
    String names [] ={
            "Abuk bişi ne yapiyim",
            "Adam kafasına koymuşssa psikopatsa yapar",
            "Allah aşkına bunları ayırt etmeyi bilelim",
            "Ama böyle anlatmazsan sorduklarımıza cevap vermezsen",
            "Anlamsız saçma bu ne yani",
            "Arkasında durucaksın kardeşim ne dediğinizi kendiniz de bilmiyosunuz",
            "Ayağınızı denk alcaksınız",
            "Ay çok şey konuşcaz dedikodu olcak",
            "Ayıptır kıskançlıktan napıcanızı şaşırdınız",
            "Bak gene beni delirttiler ya hanım hanım oturiyim diyorum",
            "Bana nası pası attı ben o pası nası göğüsledim",
            "Bekle sana çok sözüm var",
            "Ben artık daha kontrollü oturup kalkmaya dikkat ediyorum",
            "Ben, bana yakışır mı bunlar çok ufak şeyler",
            "Ben biliyorum ben yaşadım",
            "Ben hatalarımı göre göre geldim sen sürüngahsın",
            "Ben hiç bi şeyi unutmam",
            "Beni biliyolar ben başka türlü bi kadınım",
            "Ben kimin naptığını mı araştırcam ne biliyim banane",
            "Ben seninle uğraşacam olm",
            "Ben söylediğimin her zaman arkasındayım",
            "Bi kere küfürlü konuşma biiir",
            "Bırakın bunları nasıl önüne geçeriz onları tartışalım",
            "Birazdan anlatıcam eksiksiz",
            "Biz de bi sorun var arkadaşlar",
            "Biz sosyal medyayı kaldıramıyoruz anlayamadık",
            "Böyle bişi var mı ne kadar manasız",
            "Bu cehalete son verin artık",
            "Bu hata ise biz de yaptık",
            "Bu insanların beyni yok mu",
            "Bu iş daha büyük bi iş bak neler çıkarıcam",
            "Bunu talep eden kim izleyen kim",
            "Bu salak saptal düşüncelerden çıkın artık",
            "Çocuklar için allah esirgesin boşluğa düşmesinler",
            "Çok alçak adamsın insanlara belden aşşa vuracak kadar",
            "Dersinizi çalışın da gelin",
            "Gördün mü annem yaa kolayına kaçıyolar",
            "Gücünü istiyorum senin gücün gelsin",
            "Hangi saatte ne çekip yazdın",
            "Hayır hayır hiç böyle bi şeyi kabul etmiyorum",
            "Herkes ne biliyosa anlatsın",
            "Her şey ortaya çıkacak merak etmeyin",
            "Hiç böyle bişi çıktı mı ağzımdan",
            "Kankam dediği adamla öpüştüm o zaman öyleydi yaptım",
            "Karşılaşmayalım diye dua ettim ama allah çıkardı",
            "Kimsenin türkiyede yapamadığını ben yapıcam",
            "Konuş bakim hadi dinliyorum",
            "Lafın adam gibi arkasında duracaksın",
            "Mühim olan bunu medenice halletmek insanca",
            "Ne anlatmak istediğinize çalışın dersinize iyi çalışın",
            "Ne demek bu tekerleme mi yapıyoruz yani",
            "Ne istediğinizi ne anlattığınızı bile bilmiyosunuz",
            "Niye hepsi BEN niye kim benden değişik bişi yaptı",
            "Ona sallıyor buna iftira atıyor soytarı",
            "Saygı duyuyorum saygı duyacaksınız",
            "Senin seçtiğin hayat burdan daha beter bu mu",
            "Sen kimsin hangi vasıfla,nosyonla",
            "Sen unuttun ama ben farkındayım",
            "Sesleri sesime deysin istiyorum",
            "Seyretmesinler o zaman seyretmeyin",
            "Şimdiki aklım olsa yapmazdım o dönem onu gerektiriyodu",
            "Siz kimsiniz kimi eleştiriyosunuz dönün de bi kendinize bakın",
            "Sosyal medyayı bu kadar ciddiye almayın",
            "Soytarı SOYTARISIN",
            "Şu mecrayı doğru kullanmayı öğrenin bi sürü insanın günahına giriyosunuz",
            "Tutuştular tutuştular yanlış yerdesiniz",
            "Ve inanmıcam insanlar da reteleyip yorum yapıyolar",
            "Yeter benim bu başıma gelenler çünkü",
            "Zekiyim böyle bi şeye meydan vermem"
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
            "sample.mp4"

    };

    public SedaFragment() {
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