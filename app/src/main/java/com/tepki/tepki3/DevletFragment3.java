package com.tepki.tepki3;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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


import java.util.ArrayList;


public class DevletFragment3 extends Fragment {

    Activity titleChange;
    String btnname;
    String names [] ={
            "Akılla izah edilemeyecek bir çarpıklıktır",
            "Aklın karı vicdanın itlafıdır",
            "Aklıyla arasını açmış klinik bir vaka haline gelmiştir",
            "Ayrımcılık yapıyor utanmadan şerefsizce",
            "Bana mısın demiyor sanki duvara konuşuyorum",
            "Be hey densiz kanun tanımaz ahlak bilmez",
            "Bilesin ki bu bayat numaraları kimse yemeyecektir",
            "Bilesin ki günahın büyüktür",
            "Bir kepazeliktir",
            "Böyle bir ülke nereye gidecektir değerli dava arkadaşlarım",
            "Bu kavramlara yabancılık çekenler bizim gibi olamazlar",
            "Bunlara türk milletinin kapısı kalbi kapalıdır",
            "Bunu başaracağınız inancıyla alayınızı",
            "Bu şerefsizlik nesillerden bile çıkmayacaktır",
            "Bu zirvede ne mutabakata varılmışsa milletin huzurunda söylesinler",
            "Çok mu arzuluyosun",
            "Çok yakında eski günlerini mumla arayacak ya kaçacak ya da hesap verecek",
            "Cüretkar olan bu sefilin alnı çatından vurulması haktır",
            "Daha ne kaldı",
            "Daha sorularımız vardır fakat şimdilik bunlar yetecektir",
            "Düğüne giderler zurna,hamama giderler hurna beğenmezler",
            "Dünya başıma yıkılsa dönmem",
            "Dünya gözüyle yediklerini burunlarından getirmezse hayat bana zindan olsun",
            "Fakat ne derse desin neyi bahane gösterirse göstersin her şey meydanda",
            "Hamdolsun eskisine kıyasla daha iyi burdayım",
            "Haydi şuradan",
            "Her gün bize sövüyor yalan söylüyor kimdir bu gafil",
            "İlk kez görüyor ilk kez şahid oluyorum",
            "İnanıyorum ki kasımpaşaya kadar arkana bakmadan kaçacaksın",
            "Kabul etmek mümkün değildir",
            "Kıyamet alameti bu olsa gerek",
            "Makamını inkar etmiş zavallı durumuna düşmüştür",
            "Merak etmeyin onun da zamanı gelecektir",
            "Mesele bitmiş düğüm çözülmüş ülkemizin önü açılmıştır",
            "Mizah gibi şaka gibi",
            "Muhatabımız değil bu soruyu nası sorarsın onu adam yerine mi koyuyorsun",
            "Mutluyum çünkü irade burada inanç burada",
            "Ne kadar hata yapsa da saygı duyulacaktır",
            "Ne kadar omo varsa ne kadar parsil varsa",
            "Peki gençlerin ne düşündüğünü neden önemsemiyorsun",
            "Sana el mi verdi gözünü mü boyadı büyü mü yaptı",
            "Sen bu sözleri ya haplandın da kullandın ya da tehditle söyledin",
            "Senin sorunlarını hepten bitireceğiz",
            "Sen kimsin ve kimi tehdit ediyorsun",
            "Sen nazik birisin bizimle söz düellosuna girme",
            "Sen necisin bre ahlaksız bre kemiksiz",
            "Sen ne diyosun bu ne büyük ihanet",
            "Şerefsizlere sesleniyorum",
            "Sevinçlerimiz kadar hüzünlerimiz de var",
            "Sizler türk milletinin ülkülerini damarlarınızda taşıyorsunuz",
            "Sonuna kadar karşıyız",
            "Söz biliyosanız söyleyin inansınlar bilmiyosanız susun adam sansınlar",
            "Sözlerini kurşun gibi savuran namertler şimdi beni dinleyiniz",
            "Tezgahlarınızı başınıza yıkacağız",
            "Tozumuza yetişemezsin",
            "TC'de isteyen her şeyi kullanamaz sen kullanırsan kendin bilirsin",
            "Ümüğünü tutarak yüce divana gönderecez",
            "Yarın türkiyede kaçacak delik arayacaksınız",
            "Yiyin kudurun için kudurun",
            "Zaman birlik olma zamanı"
    };
    String url=null;

    public DevletFragment3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_devlet2, container, false);
        final GridView gridview = view.findViewById(R.id.gridView7);
        gridview.setAdapter(new DevletAdapter(getContext(),getDevletler()));
        registerForContextMenu(gridview);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        //sample.mp4
                        Button button= view.findViewById(R.id.button);
                        Intent intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517254815-inljhlBq8MhjR23nxYIIkrJEEmLg3aKDMj%2BSj5tOJhU%3D";
                        intent.putExtra("videoUri",url);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 1:
                        //sample.mp4
                        intent = new Intent(getActivity(), VideoViewActivity.class);
                        url="sample.mp4?token=1517317245-RXfGUEhnLiI560fLWIDDwia2Q3AtFF5OFAiHIa%2BKnpE%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517317265-dJXQspdYQew2SFdZiGlpKQRAPqAzGORUipDW3yZc3rs%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 3:
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517317270-9ub6T7Gx%2F%2Bc7Cb28S%2BeUQUJTs777PAjNo6zPZbo1aB0%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 4:
                        //sample.mp4
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517317282-QZUxGCIx3EfIKw4aHfBDJgl7yPtgptV5cyL%2BGMMRvXg%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        Log.e("deneme","1");
                        break;
                    case 5:
                        //sample.mp4
                        //Toast.makeText(getContext(),i+"",Toast.LENGTH_SHORT).show();
                        intent = new Intent(getActivity(), VideoViewActivity.class);
                        url="sample.mp4?token=1517317365-6ZePsaav2n6RgjlLc9%2FyAQDRcpKdSH0D4W1B9caxC%2BU%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        Log.e("deneme","2");
                        break;
                    case 6:
                        intent = new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517317365-pbaC1iRsMLwktTLMDYPUI55Pjl%2FHtjD5soiN8ktcgHc%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 7:
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319139-cJ11JdBwkvyzjZARcehqvD%2FnFde8jUeVFxHI92xUwrE%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 8:
                        //sample.mp4
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319148-8ylH5DzXDYsfWRoQLyK%2Fx4s8Lu8g6AZzEYdvq19290w%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        Log.e("deneme","1");
                        break;
                    case 9:
                        //sample.mp4
                        //Toast.makeText(getContext(),i+"",Toast.LENGTH_SHORT).show();
                        intent = new Intent(getActivity(), VideoViewActivity.class);
                        url = "sample.mp4?token=1517319174-WiDpHO44XAI%2FtTswTqVdbK1jW2dvnKVcFe3pTqd8V%2Fw%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        Log.e("deneme","2");
                        break;
                    case 10:
                        intent = new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319228-PfSLYm1MVNfCbeBf%2Bgz1mPOTfxJucW%2Fe6TIJHywSawI%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 11:
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319134-zOltGMYPUq%2B96RygdHp%2BVPY%2BHAu%2B5zL25xoT5J%2B3PEM%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 12:
                        //sample.mp4
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319193-Wd39aSPSo3ydxl5GRlOGU6Hk9r3UUOygAx%2Bo5QJ5iCA%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 13:
                        //sample.mp4
                        //Toast.makeText(getContext(),i+"",Toast.LENGTH_SHORT).show();
                        intent = new Intent(getActivity(), VideoViewActivity.class);
                        url = "sample.mp4?token=1517319149-%2BwUxyBOVYujdRxunFb7n7RDIBmvkKV6RgKKbjTsBxAk%3D4";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 14:
                        intent = new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319233-i%2B6NnDeZhaOBnHAYTG9thBa3xK%2BdSJTlehtszdseIes%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 15:
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319174-vDtxePY9Ornq2e2LNZUan1jPCLNq1Jx3ympMXLs4iOI%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 16:
                        //sample.mp4
                        button= view.findViewById(R.id.button);
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319104-glF%2FJlrrw2O5aPU3aDTtzi5bQgjKRY59rfX1TwC2ncg%3D";
                        intent.putExtra("videoUri",url);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 17:
                        //sample.mp4
                        intent = new Intent(getActivity(), VideoViewActivity.class);
                        url="sample.mp4?token=1517319393-fF4Oh6WCsd08f5xSjSsrVc3IpZaoLxnUbGZELu93s%2Fw%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 18:
                        intent = new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319438-fqnTSs1m%2F%2BR0BPvWUId%2Bs0OUAqHck2B4Biovu69Fvr0%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 19:
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319228-cBlT8jHOzqqAidT%2Bxd2Z%2BaIMc6Qfzx6UeUjgaiPBO%2Fk%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 20:
                        //sample.mp4
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319313-rZa3tHPeR50ZAW1hT0KgVYzLalbUFMzOnHeyheVxAy4%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 21:
                        //sample.mp4
                        //Toast.makeText(getContext(),i+"",Toast.LENGTH_SHORT).show();
                        intent = new Intent(getActivity(), VideoViewActivity.class);
                        url="sample.mp4?token=1517319209-ib%2B9OUchukuRXH5Z3U%2FQlwfSEpu55W8zWt1TIeCOY5w%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 22:
                        intent = new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319121-UUETNlELx5FMoQSVI4FrFi0Pr8DokhIlkjFPkoHpz7U%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 23:
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319099-4n7Q7%2Ba8AamqcQUkaiJJ8wEv1kFuV%2BZ80w0ZzpEJ8jw%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 24:
                        //sample.mp4
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319053-riBdRFHjSoOqWS8iYftYlTdg7dz4vn2UcCfB0i8XNmM%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        Log.e("deneme","1");
                        break;
                    case 25:
                        //sample.mp4
                        //Toast.makeText(getContext(),i+"",Toast.LENGTH_SHORT).show();
                        intent = new Intent(getActivity(), VideoViewActivity.class);
                        url = "sample.mp4?token=1517319180-d2RZerl9%2F44aRsvU4qd2nECyF8XKv8JWJ71RMm1ctUE%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        Log.e("deneme","2");
                        break;
                    case 26:
                        intent = new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319089-q8gepXAhkK8FD%2FIpzyZrwbYsqpJR5CmBHaEckgOwDpE%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 27:
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319113-2rTfeQ4TBN9HNaD5n1c6p9VGe2osttvk3gT1OlnICa4%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 28:
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319139-6PMAiDcyZB8k6qovv%2FNjqueVZZlbDW%2Bdk3scA7F%2FuaE%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 29:
                        intent = new Intent(getActivity(), VideoViewActivity.class);
                        url = "sample.mp4?token=1517319093-%2Bqjwd6v0uZBwIhGqe331eF3Smf0iCAgbUEsetF4sY3Q%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 30:
                        intent = new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319180-Pd2vWbGPgLhGdDOyxL5gjjH43nA%2Brz%2FU7rMUOoIY41g%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 31:
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319311-tWkGPBKXLEhc8gZ75MCC8k0oVLtL3bv9U79Tb7uTpNE%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 32:
                        intent = new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319383-1u6BiAC2B9TtWDBucqnWo9lkG4XJraaM%2BjtadVna9zg%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 33:
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319263-O51NZ11n2zCFFt6UIhrpfvYeIvhsYX7SenE6osx6Cts%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 34:
                        //sample.mp4
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319290-QkCpF9A8Dt3987NWQSGZW4ue0BcORtFYaCg9UXXV8jA%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        Log.e("deneme","1");
                        break;
                    case 35:
                        //sample.mp4
                        //Toast.makeText(getContext(),i+"",Toast.LENGTH_SHORT).show();
                        intent = new Intent(getActivity(), VideoViewActivity.class);
                        url="sample.mp4?token=1517319323-7nhgFaIrkB6lBHvCCe%2B4UudT5zVS%2FYXX3ON32cROoS0%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        Log.e("deneme","2");
                        break;
                    case 36:
                        intent = new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319293-lJ3zwy1q2ubio1a6V8cl6QrZeJatt1D0%2FIT2Fxa28WU%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 37:
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319121-v6BGpH4kNrO2sNCOFPRTV%2BXiikpidFrec28YpRSwwJU%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 38:
                        //sample.mp4
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319293-ufbmEIo8TR96hniu%2B64dFCoWfc6QugcN3wr%2FamDXnxk%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        Log.e("deneme","1");
                        break;
                    case 39:
                        //sample.mp4
                        //Toast.makeText(getContext(),i+"",Toast.LENGTH_SHORT).show();
                        intent = new Intent(getActivity(), VideoViewActivity.class);
                        url = "sample.mp4?token=1517319348-Jpq0cOUEZ71eUo3dZSbuipPbfqVFeKmNpHdC9fo3yGI%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        Log.e("deneme","2");
                        break;
                    case 40:
                        intent = new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319343-v2ImsaaztRgQ0fsKvptfDOZnVids76R6cRmpRz%2BcVgU%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 41:
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319123-GntrpcmhM4uXFivTmfTWxQXQ4JfyYFyaqyi20hyy33I%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 42:
                        //sample.mp4
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319163-nLO5%2Fea1H0S3ZAijd%2BEeyy0cC5qfHt6XqKIdXzuX2EI%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 43:
                        //sample.mp4
                        //Toast.makeText(getContext(),i+"",Toast.LENGTH_SHORT).show();
                        intent = new Intent(getActivity(), VideoViewActivity.class);
                        url = "sample.mp4?token=1517319228-aAQ8oq4tzX4qPlpIIRGbRXq6oIfbpeDv6J8UQzoYOXA%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 44:
                        intent = new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319153-QA0ddO3Ftcp7UUk4XpiZibLpIT0D1mhCwSZ5nVZxDHE%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 45:
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319239-mZFYMSN8C5nWEfr%2Bi4lWeXy%2FhIuwr5eBl68aRAbIngg%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 46:
                        //sample.mp4
                        button= view.findViewById(R.id.button);
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319248-EC8WmsgVpiy8WCy4zbgkul7JpnhrD7C8X2%2FQXqJixL0%3D";
                        intent.putExtra("videoUri",url);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 47:
                        //sample.mp4
                        intent = new Intent(getActivity(), VideoViewActivity.class);
                        url="sample.mp4?token=1517319263-jgqyS36DVFQMFmAJ39npadSjqqhFOtj8mNB2OtblfPQ%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 48:
                        intent = new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319198-V0EQ7LmBY2vQWClDipQbA3cGKHvY4UcCEaKy0dXslRs%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 49:
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319193-DytOCWGEGtHR5%2Bm%2FFkLvBLECgEgiCfklJa0qhIPbJLQ%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 50:
                        //sample.mp4
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319329-4NDdvpHbsp%2BQJ3zORXCPma6LLjDU6oZCbkuqGffrQYo%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        Log.e("deneme","1");
                        break;
                    case 51:
                        //sample.mp4
                        //Toast.makeText(getContext(),i+"",Toast.LENGTH_SHORT).show();
                        intent = new Intent(getActivity(), VideoViewActivity.class);
                        url="sample.mp4?token=1517319263-ks%2BAEl6Tnw6bZS1j%2Bt%2B7oQy6v5okUX9v35lP0%2BHgnzk%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        Log.e("deneme","2");
                        break;
                    case 52:
                        intent = new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319333-Vnd4hLFo4hxHgVV30J3A4hyhYkgN%2BdMUVpVgePrxy4s%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 53:
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319193-TkeqhfWp7plGWliq08LE%2FK7i%2BMn%2BkGjMA24RNyVGFV8%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 54:
                        //sample.mp4
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319300-iYSAxadG5DdIZJ5Wf9gRRNdVmfhN4pSxD30tGPhmYiA%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        Log.e("deneme","1");
                        break;
                    case 55:
                        //sample.mp4
                        //Toast.makeText(getContext(),i+"",Toast.LENGTH_SHORT).show();
                        intent = new Intent(getActivity(), VideoViewActivity.class);
                        url = "sample.mp4?token=1517319413-5iHmbVkAxBdILTe3xk3qEhYjzvFKY7NX%2FmQqfIgdins%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        Log.e("deneme","2");
                        break;
                    case 56:
                        intent = new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319399-F%2FUjuxwcr0AcRYEb%2FWsT3IufxxBAKzlN01KmDMA%2FaIc%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 57:
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319180-LZxE9Jar1NQ09X0sUoj7FQw%2B1%2Fsev%2Fmr870sd5E653M%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 58:
                        //sample.mp4
                        intent=new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319148-H3nZXl929kIVGkry5uPtCpU%2B7GDPl7eRkv83SsoCJN0%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 59:
                        //sample.mp4
                        intent = new Intent(getActivity(), VideoViewActivity.class);
                        url = "sample.mp4?token=1517319163-XIx0fjcv95CbZqHkhjJaHPVfjRrb5F3YKmfmJ4iO1%2BM%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                    case 60:
                        intent = new Intent(getActivity(),VideoViewActivity.class);
                        url="sample.mp4?token=1517319233-i%2B6NnDeZhaOBnHAYTG9thBa3xK%2BdSJTlehtszdseIes%3D";
                        intent.putExtra("videoUri",url);
                        button= view.findViewById(R.id.button);
                        intent.putExtra("name",button.getText());
                        startActivity(intent);
                        break;
                }
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
        Button button=info.targetView.findViewById(R.id.button);
        btnname= (String) button.getText();
        menu.setHeaderTitle("Seç birini, ya da seçme sen bilirsin");
        menu.add( v.getId(),1, 0, "Gönder");
        boolean value = CheckIsDataAlreadyInDBorNot(url);
        if(value==true) menu.add(v.getId(),1,0,"Favorilerden çıkar");

        else menu.add( v.getId(),1, 0, "Favorilere ekle");


    }
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Gönder") {
            new DownloadFileAsync(getContext()).execute(url);
        } else if (item.getTitle() == "Favorilere ekle") {

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

    public ArrayList<Devlet> getDevletler(){
        ArrayList<Devlet> devletler=new ArrayList<>();
        Devlet p;
        for(int i=0;i<names.length;i++){
            p=new Devlet(names[i],R.drawable.devlet);
            devletler.add(p);
        }
        return devletler;
    }
    private void startDownload(String url) {
        new DownloadFileAsync(getContext()).execute(url);
    }
}