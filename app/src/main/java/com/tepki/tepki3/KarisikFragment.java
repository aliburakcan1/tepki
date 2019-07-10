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


public class KarisikFragment extends Fragment{

    private static final int PERMISSION_REQUEST_CODE = 1;
    Activity titleChange;
    String url;
    String btnname;
    String names [] ={
                            "(2.tekil şahıs iyelik ekli küfür) oğlu",
                            "(delirme gibi bi şey)",
                            "(evine mimar girmiş teyze çığlığı)",
                            "(hunharca gülüş)",
                            "(ilerle ilerle gibi bi hareket)",
                            "(karpuzun göbeğini avuçlayıp ağza götürürken erol taş gülüşü)",
                            "(yaşlanma)",
                            "(yılın gavatı ödül töreni)",
                            "10 defa okudum ne dediğini anlayamadım",
                            "a-a-a-allahına kurban",
                            "adamın asabını bozma terbiyesiz herif sanata ve sanatçıya saygın olsun",
                            "allah belanızı versin x3",
                            "allahuekber wuhuu",
                            "allahın zibidisi",
                            "allahınız yok mu lan sizin",
                            "ama lütfen ben burdayken ağırlığıma uygun hareket edin",
                            "ama olmuyor olmuyor",
                            "aman aman aman pu pu sakın olmasın",
                            "arkadaşlar siz ne anlatıyosunuz",
                            "bak allah bir bakın bakın allah bir aallaahh biir",
                            "bana saksı muamelesi yapamazsınız",
                            "bas git burdan adamı hasta etme",
                            "ben büyük bir sanatçıyım gelmiş geçmiş en büyük sanatçılardan biriyim",
                            "ben tekim x4",
                            "beni terbiyesiz konuşturma",
                            "beyleer ben de burdayım",
                            "Birbirimizi Kandırmayalım yalan konuşmayalım ikiyüzlülük yapmayalım",
                            "bitir demediniz mi lan",
                            "bitiririm dedim mi bitiririm",
                            "bizce de çok doğru tespit bu",
                            "boşuna konuşuyosun boşuna hiç anlamı olmayan konuşmalar yapıyosun",
                            "boşuna konuşuyosunuz boşuna hiç anlamı olmayan konuşmalar yapıyosunuz",
                            "bu arkadaşın sıkıntısı ne acaba",
                            "bu telefonu ben nabacam eger görüsmezsem aha gırdım telefonu",
                            "budur reyting ben reytingi çok iyi bilirimi heheeyy neler yaparım",
                            "çakala bak beni kendi silahımla vuruyo",
                            "Çılgınsın Man",
                            "çok canım sıkılıyo",
                            "çoluk çocuğu dinliyosunuz beni dinlemiyosunuz niçin bunu yapıyosunuz olmuyor",
                            "dayanamıyoom dayanamıyooom",
                            "derhal burayı terket",
                            "döner bıçaklarıyla dalalım",
                            "efendi oldukça beni eziyolarx3",
                            "en büyük fener be alkışla",
                            "en büyük üstadlara danışsınlar en büyük",
                            "en son yaptığın terbiyesizliği daha unutmadım",
                            "en çok bana soracaksınız en çok bana",
                            "farkettim abi espri yaptın ama biliyosun durumu gülemiyorum",
                            "for what why what is this what",
                            "gaza gelme hemen",
                            "gül gül öldük",
                            "gülmeye çalıştım",
                            "güzel para kanka güzel para",
                            "hadi oradan lan şerefsiz",
                            "Hadi yap",
                            "hay canım ya seni öpeceğim",
                            "hele bi düşüneyim",
                            "herkes konuşuyor bana hiç laf gelmedi niye böyle yapıyosunuz",
                            "hiç aklıma gelmedi",
                            "ileri gittin gittiğin yer iyi bi yer değil",
                            "kafam patateze döndü ha",
                            "kardeşime dedim yenicez dedim ve aynısı oldu bee",
                            "kitle  godumun kapısını bi daha giremesin",
                            "Komik mi lan bu",
                            "kullanacaksın ama kafayı taktın mı işin kötü hikmetine fazla şaapmamak lazım",
                            "kör oldum kör oldum görmüyorum",
                            "la olum bu benim büyüğüm elimi kaldırcam aybolcak",
                            "laf etti balkabaa koy tabaa ye sabaa",
                            "lan bana numara yapma",
                            "lan böyle bi teknoloji mi varmış",
                            "lan manyağım",
                            "meğer sen ne tatlı şeymişin",
                            "mümkünse bi daha benle konuşma",
                            "ne kadar komik ığağağ",
                            "nedir bu ikiyüzlülük herkes iki yüzlü",
                            "no god please no nooooooo",
                            "olm bunlar coştu lan",
                            "örneğiniz kim",
                            "restine rest ulan",
                            "ruhlarımız karşı karşıya gelecekse seninki benimkinin önünde diz çöker tövbe ister",
                            "rüyalarx3 gerçek olsa",
                            "sen benimkini görseydin",
                            "sen bilir kişi misin sen uzman mısın sen kimsin lan",
                            "Sen Cumhurbaşkanı Mısın tarih uzmanı mısın sen ne anlarsın",
                            "sen hangi alanda uzmansın bana söyler misin hangi alanda senin uzmanlığın",
                            "sen kimsin la",
                            "Sen Ne Konuşuyosun Lan Değişik",
                            "sen oçsun",
                            "seni ilk gördüm dedim ki ulan ne garılar var be",
                            "sıkılıyorum daralıyorum isyan ediyorum isyan",
                            "taam taam inandım taam",
                            "tecavüze uğramış galba yüzünde öyle bi ifade var",
                            "terbiyesizlik yapma ya terbiyesiz adam biz burada hizmet yapıyoruz",
                            "teşekkür ederim allahım seni çok seviyorum allahım",
                            "teşekkür ederiz",
                            "ulan ne ayıp şeyler be",
                            "vah benim memleketim vah",
                            "ya delirdiniz mi lan",
                            "ya siz niye anlamıyosunuz",
                            "yaaa pelin kardeş",
                            "yalan onlar inanma",
                            "yani buna rol çalmak derler",
                            "yani yuf sana her şeyi yapabilirsin sen artık çünkü o kadar karaktersiz birisin",
                            "yarabbi ne kadar fukarayız yavv bu ne haksızlık yavv noluyo yavv",
                            "yeter",
                            "yumruğu ağzına vurduğum gibi",
                            };
    String links []={
            "sample.mp4?alt=media&token=e57028a7-eaf0-4e94-a7d8-073b1d128750",
            "sample.mp4?alt=media&token=a183918a-4765-47ab-a93f-5c402707cd06",
            "sample.mp4?alt=media&token=831e9cee-e198-4cfa-9b5c-6c0a9d449331",
            "sample.mp4?alt=media&token=ed2bb575-14e7-419c-a83b-46d82f5b9300",
            "sample.mp4?alt=media&token=2e39e62c-0470-40a6-bc02-d95c24974c46",
            "sample.mp4?alt=media&token=e17e33cd-8216-4076-a533-639441109cbe",
            "sample.mp4?alt=media&token=efb2555b-d148-47df-9032-53d3c778dc25",
            "sample.mp4?alt=media&token=bfe34373-42bd-4bf8-aad6-0d0fdcd157c5",
            "sample.mp4?alt=media&token=7989708f-a38e-426e-8515-5f0c4c90d809",
            "sample.mp4?alt=media&token=73b692be-5860-42d0-acea-fdd55fa7d5c1",
            "sample.mp4?alt=media&token=85d02ede-f1f4-4ca8-b7a8-64f3115ec8a4",
            "sample.mp4?alt=media&token=fa943438-ba8a-4c27-bb77-654aa01a3517",
            "sample.mp4?alt=media&token=220824f1-c849-4a92-8c1b-e0a172fccd82",
            "sample.mp4?alt=media&token=9e7e367a-1ccf-4fab-b572-be93107f4549",
            "sample.mp4?alt=media&token=b533400a-5b41-453d-abb9-50e74e96c5d5",
            "sample.mp4?alt=media&token=1068fe6c-a23c-4e3f-9e71-3a98aef99e21",
            "sample.mp4?alt=media&token=9691cc77-7048-4ccb-83d7-477111a4deb4",
            "sample.mp4?alt=media&token=f2f78060-65eb-420f-a4d8-24f847c38f91",
            "sample.mp4?alt=media&token=3f4940bf-3ad9-4d75-92c8-bc8b2915353d",
            "sample.mp4?alt=media&token=386044aa-7d78-4daa-b3f1-cc5fbb47de77",
            "sample.mp4?alt=media&token=6878798b-3073-4306-b9c0-a80abbfb56b0",
            "sample.mp4?alt=media&token=7c33df9f-ba65-4216-8d67-a88ee5861355",
            "sample.mp4?alt=media&token=573efb2d-2214-4f37-841f-6bd9bd6e10f1",
            "sample.mp4?alt=media&token=2528921f-4ece-4061-98ff-438a499afabd",
            "sample.mp4?alt=media&token=1032bed3-cd03-47ca-9c0b-0c7ef39ae360",
            "sample.mp4?alt=media&token=9ecdebb0-0e16-438e-b5aa-73afaae2ca0e",
            "sample.mp4?alt=media&token=99f02936-26dc-4159-8778-43fab9cdd41a",
            "sample.mp4?alt=media&token=4d286827-6309-4674-9875-f03cb8b9728f",
            "sample.mp4?alt=media&token=383208e6-e7f8-4350-9596-f74ebab72d82",
            "sample.mp4?alt=media&token=bb5a432d-d1c8-451c-8462-f0ef1e218861",
            "sample.mp4?alt=media&token=07df38fb-324a-445f-9907-d7cf47e8288e",
            "sample.mp4?alt=media&token=6460d685-8a9c-4d2c-acc9-eb84c476ebc7",
            "sample.mp4?alt=media&token=ca274f3f-5a02-4dd2-a481-eb752b343bb8",
            "sample.mp4?alt=media&token=1c4ec44c-7fd6-4f06-b5fe-09dc2c7ab550",
            "sample.mp4?alt=media&token=76f30549-e1f5-419d-9cbd-25f6e8f88e53",
            "sample.mp4?alt=media&token=b659a15d-9d20-4c88-82ef-e7f2aaa8d0e4",
            "sample.mp4?alt=media&token=df9c3ffb-1a5a-44ad-9673-95acc9111921",
            "sample.mp4?alt=media&token=7086f57f-070b-4685-b06f-47e3a3abc56c",
            "sample.mp4?alt=media&token=a84e2438-50eb-4a53-8fda-b794ed0a8861",
            "sample.mp4?alt=media&token=33612af1-18a7-4263-bc01-62ca7070dbb6",
            "sample.mp4?alt=media&token=0aa898b6-93fd-42f9-8456-0c27ef5961c3",
            "sample.mp4?alt=media&token=a93ed72d-77b4-4e1f-91a7-0fff88ec32af",
            "sample.mp4?alt=media&token=0b008ed4-139f-4cca-bad2-cd2c8bd1965a",
            "sample.mp4?alt=media&token=8c209934-5f3e-4cdd-9531-6316a697945b",
            "sample.mp4?alt=media&token=01b36bc9-51c5-4cb5-af33-d6e0def8ebe8",
            "sample.mp4?alt=media&token=5757ca3e-451a-4ae1-ab46-4a8b82dd032a",
            "sample.mp4?alt=media&token=9fc65ff9-2114-4ea2-b14b-3d7325abc33b",
            "sample.mp4?alt=media&token=cd43de21-2517-4c67-a5f6-1991301a0bc3",
            "sample.mp4?alt=media&token=74532321-e7f1-49a5-becd-dd0bede53e39",
            "sample.mp4?alt=media&token=31a0f3e0-6d08-41dc-b7df-d459279f8ce9",
            "sample.mp4?alt=media&token=ecb46db5-c758-40f9-8b87-d301e28a6785",
            "sample.mp4?alt=media&token=ede44374-4296-4610-bb17-23d717404c2d",
            "sample.mp4?alt=media&token=f8f82238-09a8-400e-af00-8cb90103d7ce",
            "sample.mp4?alt=media&token=e8ebfb1d-d791-4a24-8f59-6a0a7922ff11",
            "sample.mp4?alt=media&token=b0a3b4b0-639d-4284-84a6-00dbcba8ca77",
            "sample.mp4?alt=media&token=98367d4e-edbc-4f1f-b089-b361c573cc59",
            "sample.mp4?alt=media&token=2e79b2f0-eb68-4035-9135-06feabd3b0c2",
            "sample.mp4?alt=media&token=0eb7697a-ab19-4ae6-a5bc-f1f7e5302143",
            "sample.mp4?alt=media&token=9134dce8-6ef5-49d9-82e5-ff2dbee9482d",
            "sample.mp4?alt=media&token=316b0885-9ded-49e7-b97b-47bb8b29cd21",
            "sample.mp4?alt=media&token=e3779fba-9cef-463b-a157-5a841eca3aee",
            "sample.mp4?alt=media&token=68bc4633-cabb-4fc5-bfab-4a765136eec8",
            "sample.mp4?alt=media&token=935098ef-3561-413f-9972-ef4e50ef6b7e",
            "sample.mp4?alt=media&token=1794feda-ff5a-4323-94ea-da026905674d",
            "sample.mp4?alt=media&token=bc2574aa-4863-4b4a-b612-95d626651753",
            "sample.mp4?alt=media&token=4b94ed5b-f6ce-4a1e-9883-069f5eac07ff",
            "sample.mp4?alt=media&token=5f03f39c-19c5-4786-9c1d-26d7a0c385c9",
            "sample.mp4?alt=media&token=d203cdaa-9c5c-4cd1-8ee8-a3a7d4e74402",
            "sample.mp4?alt=media&token=c8262310-00e7-4834-b022-f45823d0a5a0",
            "sample.mp4?alt=media&token=e6cbca4d-e57f-4286-9c78-8f78bd15daf1",
            "sample.mp4?alt=media&token=761f02bb-44ed-4eec-bc0e-c5334b4c523a",
            "sample.mp4?alt=media&token=0417d905-f3fa-41b2-bca2-87845d392fb2",
            "sample.mp4?alt=media&token=450c34e8-a495-4ece-98d9-6b8e1a0e567b",
            "sample.mp4?alt=media&token=f19df186-18ee-4bd1-976a-91767b8e74d8",
            "sample.mp4?alt=media&token=5c6dcfc8-66a6-4364-915b-0147a1f26fe7",
            "sample.mp4?alt=media&token=90707c74-eef1-40b2-8874-47e3495cfe44",
            "sample.mp4",
            "sample.mp4?alt=media&token=1c1f3934-c7fc-4fa3-a90f-5c221bc954e5",
            "sample.mp4?alt=media&token=114c5e56-ad23-407d-bbbb-6e5d30467374",
            "sample.mp4?alt=media&token=5fd11920-20d3-474a-ba40-48bf7d2f7f20",
            "sample.mp4?alt=media&token=1fe8a93f-1fbf-4022-a679-7fcef8d23858",
            "sample.mp4?alt=media&token=6110e513-5fbb-4db3-b155-fa2a5c85f4f0",
            "sample.mp4?alt=media&token=73f8acde-ffb2-47e3-8320-bf624c9e3a89",
            "sample.mp4?alt=media&token=314846ec-a67e-44d3-ad47-d708391306c0",
            "sample.mp4?alt=media&token=e56795f3-6817-445b-b454-edc73aa44d93",
            "sample.mp4?alt=media&token=16331585-2a4a-415f-9d5f-512fd797712d",
            "sample.mp4?alt=media&token=95828f9d-c994-433c-9239-8521d6052d88",
            "sample.mp4?alt=media&token=ed2ab236-a4c0-4a75-a840-d0c835fc2547",
            "sample.mp4?alt=media&token=5fe95ba3-b367-41a2-99dd-ca37b7e9ccd8",
            "sample.mp4?alt=media&token=89f7ff5a-57da-4915-8bfe-4509ff34b017",
            "sample.mp4?alt=media&token=b6e48a6b-b6b7-4bef-ba6c-9584c0e7fd0a",
            "sample.mp4?alt=media&token=715eb7f3-80f6-418d-af2b-1cfa44d43dd9",
            "sample.mp4?alt=media&token=c654b148-17ef-4149-97b7-3bbee1355d7e",
            "sample.mp4?alt=media&token=0ef8fd34-71a7-4f86-9da2-d71139b63c1a",
            "sample.mp4?alt=media&token=46717894-67b1-42e0-8301-e9b04ed96e57",
            "sample.mp4?alt=media&token=6e633d52-72b9-4a18-8694-4a95407a1876",
            "sample.mp4?alt=media&token=adb8539c-b8d7-4938-976d-47dd6ac3850f",
            "sample.mp4?alt=media&token=1624a68a-28e1-4329-be13-dcdf9f9d5a9c",
            "sample.mp4?alt=media&token=9f68702b-6331-43e4-9ced-bf0cd6610304",
            "sample.mp4?alt=media&token=7df800b0-e3f3-4ec5-b85f-913eb55513c1",
            "sample.mp4?alt=media&token=6e7910dd-982a-444a-8ac7-2f4109997729",
            "sample.mp4?alt=media&token=35539a03-e23d-4b17-bda3-a6d97bff7fb7",
            "sample.mp4?alt=media&token=84d86064-bb7b-4f23-9cf4-c888f1ac4995",
            "sample.mp4?alt=media&token=30d6edef-ba40-4c23-9dfa-95c1eb1c044d",
            "sample.mp4?alt=media&token=2bebd63e-48bf-46d4-ab64-1e0077a10698",
            "sample.mp4?alt=media&token=140e575f-64d9-4787-aa96-a58151d8b7bb"

    };

    public KarisikFragment() {
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
        menu.add(v.getId(), 1, 0, "Tepkiyi indir");
        boolean value = CheckIsDataAlreadyInDBorNot(url);
        if(value==true) menu.add(v.getId(),1,0,"Favorilerden çıkar");

        else menu.add( v.getId(),1, 0, "Favorilere ekle");

        Log.e("deneme", String.valueOf(i));

    }
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Gönder") {
            new DownloadFileAsync(getContext()).execute(url);
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

        else if (item.getTitle() == "Favorilere ekle") {

            final DBAdapter db=new DBAdapter(getActivity(),null);
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
                Log.e("deneme",url+btnname);
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