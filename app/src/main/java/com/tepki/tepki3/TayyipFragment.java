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


public class TayyipFragment extends Fragment{

    private static final int PERMISSION_REQUEST_CODE = 1;
    Activity titleChange;
    String url;
    String btnname;
    String names [] ={
                    "(cık)",
                    "(kalkıp gitme)",
                    "abaküs önünde çalışmasını çarpım tablosunu yeniden gözden geçirmesini tavsiye ediyorum",
                    "aklıselimin yolu tek",
                    "aldığı kararı destekleyen yok",
                    "ama bana özgürlük tanımıyorsunuz",
                    "ama belli ki okumamış",
                    "ama onu size soracak değiliz",
                    "arkadaşımız fransız mı",
                    "asla unutmamalıyız",
                    "bakalım nereye varacak",
                    "baknelersöylüyoneler",
                    "bakın böyle bi yanlış yapmayın",
                    "ben sadece inandığım doğruyu burda söylüyorum",
                    "benden yaşlısın sesin çok yüksek çıkıyor",
                    "beni sıkıştıramazsın",
                    "benim savıma tezime katılmayabilirsiniz zaten bunu sizden beklemiyorum",
                    "benim sesimi bu ülkede sadece millet keser",
                    "bir an evvel harekete geçmeye çağırıyorum",
                    "bir gece ansızın gelebiliriz",
                    "bir kanser gibi adeta yayılıyor",
                    "biz asla ve asla inanmadık",
                    "biz burada böyle bir yapılanmaya asla müsade etmeyiz",
                    "biz de B planımızı C planımızı uygulamaya koyarız",
                    "biz senin geçmişini biliriz",
                    "bize yalan söylediler doğru konuşmadılar",
                    "bizi yönlendirme amacı taşıdığı açıktır",
                    "bizim aramızı açmak istiyorsun",
                    "boşu boşuna makaram sarı bağlar kız söyler gelin ağlar yani yaptığı iş bu",
                    "bu bizi rahatlatır",
                    "bu desteklerimiz devam edicek",
                    "bu güzel etkinliklerin düzenlenmesinde emeği geçenleri tebrik ediyorum",
                    "bu insanların yaşadıkları trajediye kayıtsız kalamazdık",
                    "bu konudaki tavrımız açıktır",
                    "bu niye beni bu kadar seviyo",
                    "bu oyuna ben gelmicem",
                    "bu tür oturumlarda önce nezaketi öğreneceksin otur bakiyim yerine",
                    "bugün git yarın gel",
                    "buna tahammül edemeyenler bu tür şeyleri uyduruyorlar",
                    "bunları artık ciddi olarak ele alalım",
                    "bunların hepsi yalan böyle bir şey söz konusu değil",
                    "bunların kökünü kazıyacağız",
                    "bunların tamamı da ne yazık ki uydurma böyle bir şey söz konusu değil",
                    "bunu ispat ederlerse biz her şeye varız",
                    "bunu çok açık görmemiz lazım",
                    "bunun böyle bilinmesi lazım",
                    "bütün adımları atıyoruz atacağız",
                    "delikanlıysan çık ortaya",
                    "dersler nasıl",
                    "destek olmaya davet ediyorum",
                    "değerli kardeşlerim hiç endişe etmeyin her şey daha güzel olacak",
                    "değişen bi şey olmadı",
                    "doğrusu benim ee geçmiş mazide kalmış bir yazı olarak olabilir ama benim ondan",
                    "doğrusu geçmiş mazide kalmış bir yazı olarak olabilir ama",
                    "endişeyle takip ediyoruz",
                    "esselamu aleykum",
                    "etkisiz hale getirdik",
                    "evdeki hesap çarşıya uymadı",
                    "farklı tedbirlerimiz var ayrı onları da ayrıca devreye sokacağız",
                    "geleceğiniz varsa göreceğiniz de var bunu böyle bilin",
                    "gerektiğinde bu tür adımları atmaktan geri durmayacağız",
                    "gerektiğinde kullanmaktan çekinmeyeceğimiz tüm opsiyonlar önümüzdedir",
                    "geri adım atması şart",
                    "gün ola harman ola",
                    "günaydın",
                    "ha o bizim düşmanımızdır",
                    "hadi yap",
                    "hala bekliyoruz",
                    "hayırlı olmasını diliyorum",
                    "her alanda hedeflerimiz doğrultusunda kararlılıkla yürüyoruz yürüyeceğiz",
                    "her türlü tedbiri aldık alıyoruz",
                    "ikili olarak aramızdaki bir problemden bahsedemem",
                    "insanlık suçudur",
                    "işlem de yanlış sonuç da yanlış",
                    "işte aramızdaki fark budur",
                    "kaldırılması gerektiğini düşünüyoruz",
                    "kayıtsız kalamazdık",
                    "kesinlikle böyle bir amacı yoktur",
                    "kimsenin ne yazdığından ne çizdiğinden ne korktuğumuz ne de çekindiğimiz yok",
                    "kimsenin sesi çıkmıyor",
                    "kusura bakmayın bu söylediğiniz şeyler doğru değil",
                    "kürtlerle asla bir sorunumuz yok",
                    "mağlesef bunlarda o yürek omurga yok omurga olmuş olsa bunu böyle yapardı",
                    "mağlesef ders almıyorlar",
                    "mücadelemizi sürdürmekte kararlıyız",
                    "okul  dönemlerinde dersi kaynatmak için",
                    "olmazsa olmaz bir yer değil",
                    "olmazsa olmaz",
                    "on düşündük bir adım attık",
                    "one minute",
                    "oturacaz sohbetler edecez yemekleri yeyip dağılacaz bunun ne anlamı var",
                    "rakamlarla arası çok iyi değil",
                    "samimi değildir, bu samimiyetsiz yaklaşımını ortadan kaldırması lazım",
                    "sesin çok yüksek çıkıyor bunun sebebi suçluluk psikolojisi",
                    "sevgili dostlar değişimler genelde sancılıdır ama bir o kadar da kaçınılmazdır",
                    "siz benden daha fazla konuşuyorsunuz",
                    "siz burada durup da ne iş yapıyorsunuz",
                    "siz mi susturacaksınız ben mi",
                    "sizlere sevgilerimi saygılarımı sunuyorum kalın sağlıcakla diyorum",
                    "sokucaz",
                    "söyleyin bundan vazgeçsin",
                    "süratle bir çözüm arayışı içerisindeyiz",
                    "taviz yok",
                    "temennimiz bu gayretlerin olumlu sonuç vermesidir",
                    "uygulamaya koyarız",
                    "uzak durulması gerekiyor",
                    "ve yanlış yöntemler bunlar şık olmayan yöntemler",
                    "verdikleri sözleri tutmaya davet ediyorum",
                    "ya nasıl olsun",
                    "yakından takip ediyoruz",
                    "yanlış bi iletişiminiz var önce onu bi düzeltelim",
                    "yeni bir bakış açısı geliştirmeye ihtiyacımız var",
                    "yeterli desteği alamadığımızı özellikle belirtmek istiyorum",
                    "yok hükmünde kabul ediyoruz gayrimeşrudur diyoruz",
                    "yok ya ağğğğ",
                    "yolumuza devam edeceğiz",
                    "yook",
                    "çalışmalıyız",
                    "çirkin yüzünü dünyanın farklı köşelerinde görmeye devam ediyoruz",
                    "çok da meraklı değiliz onu da söyleyeyim",
                    "çok daha fazla gayret göstermeliyiz",
                    "önce ağzınızdan çıkanı kulaklarınızın duyması lazım",
                    "önce kendilerine baksınlar",
                    "öyle bi şey söz konusu değil",
                    "üoğğğğ",
                    "şimdi biz verdiğimiz sözü tutuyoruz",
                    "şu anda bunları konuşmak çok erken" };
    String links []={
            "sample.mp4?alt=media&token=e51e071a-204d-4b8e-9c54-370f31b4411f",
            "sample.mp4?alt=media&token=0ca0db2d-ff5b-4fd4-8741-7d09f6bdccb6",
            "sample.mp4?alt=media&token=542df3b4-62c7-460e-83c6-067cc0d2838a",
            "sample.mp4?alt=media&token=e76f563c-6f22-46f8-ba35-12e4656f4bd2",
            "sample.mp4?alt=media&token=1c6db9d9-f2c0-4dc8-9bb0-ef569239e174",
            "sample.mp4?alt=media&token=6dd2a751-492c-4494-a630-c039217be9b9",
            "sample.mp4?alt=media&token=1a7eda26-aee4-4b92-9d7a-0158efb46431",
            "sample.mp4?alt=media&token=5c7cda42-5449-43df-8213-1f9e367a2f69",
            "sample.mp4?alt=media&token=06d6140d-1afb-4840-9402-61e5e2d5b8d8",
            "sample.mp4?alt=media&token=38d73151-9742-4c06-99fc-26f4d87011e6",
            "sample.mp4?alt=media&token=c7a374cc-c51b-42f2-a7ce-065d31b28175",
            "sample.mp4?alt=media&token=258c4103-4db1-4318-93d8-73f4a05db95a",
            "sample.mp4?alt=media&token=42895f5e-2ee5-46aa-a7c2-19ef41469480",
            "sample.mp4?alt=media&token=678a2ec5-8e14-4404-a319-85b819dfb85e",
            "sample.mp4?alt=media&token=ddd1a445-2d23-4c42-be3f-50250bd31013",
            "sample.mp4?alt=media&token=af8a1571-bd6b-4e9e-85aa-c05c2f56da37",
            "sample.mp4?alt=media&token=b7ef8ff9-6662-44fb-8b59-33e50adad395",
            "sample.mp4?alt=media&token=4ff72add-d0bc-44b7-a142-945b866df83d",
            "sample.mp4?alt=media&token=8682cba2-7ea8-4db9-b6e1-76e99d10da3a",
            "sample.mp4?alt=media&token=b479e609-2758-4fea-979e-c9eb2a3f11f0",
            "sample.mp4?alt=media&token=bed35739-a9e4-481c-9287-21891e96a35c",
            "sample.mp4?alt=media&token=7377f193-ebb1-4ad7-845d-e9d074c80201",
            "sample.mp4?alt=media&token=be6e9fc6-5e5f-4d97-aa20-5b34be3ad4b0",
            "sample.mp4?alt=media&token=72212985-fa14-4fc1-bfe5-ecb134da0466",
            "sample.mp4?alt=media&token=f4a1a2cb-e0bb-47c1-8c63-1a00afad107b",
            "sample.mp4?alt=media&token=31e0ff62-e48f-458b-88bd-8025f2f33164",
            "sample.mp4?alt=media&token=45aaed80-a3c5-4ec5-8af9-8b556e1c3c15",
            "sample.mp4?alt=media&token=1fa297d7-b0a7-47ad-9990-011226eef983",
            "sample.mp4?alt=media&token=a3d97c18-9b9a-4027-933c-77d191fdd4f0",
            "sample.mp4?alt=media&token=fa4c0d92-0717-421e-ba1c-4757cd342dd3",
            "sample.mp4?alt=media&token=c69c7437-d45e-453d-9e42-d03602865531",
            "sample.mp4?alt=media&token=18e7df48-9b28-48ac-ace1-5453f0407385",
            "sample.mp4?alt=media&token=3220a60c-f0b9-4a02-abec-e1bdab03b3cb",
            "sample.mp4?alt=media&token=42bb2151-5d54-4275-9328-6238882e8020",
            "sample.mp4?alt=media&token=44b1459d-c80d-4b53-9cae-40735d38624c",
            "sample.mp4?alt=media&token=b643e890-a193-4f70-b02c-7331f2277004",
            "sample.mp4?alt=media&token=e41cdb1b-fe82-4db8-b945-4dff0c714ae1",
            "sample.mp4?alt=media&token=30ccb49e-4928-48a3-a127-cf7af0431c43",
            "sample.mp4?alt=media&token=e5d2713e-1543-4cec-9d31-be696f20a918",
            "sample.mp4?alt=media&token=100d9a21-20d3-4c38-a5be-6c2023718275",
            "sample.mp4?alt=media&token=458d8789-a852-42d4-b755-0ab2af658329",
            "sample.mp4?alt=media&token=898783a9-b4bd-498a-959b-578d334a47fe",
            "sample.mp4?alt=media&token=a43d7b8d-b2c8-4720-8eb8-42ae2909bb77",
            "sample.mp4?alt=media&token=150fa3cf-f7f2-4781-b2b9-9b450be43be0",
            "sample.mp4?alt=media&token=de569c30-5c13-4d13-9686-0dbfb3b46706",
            "sample.mp4?alt=media&token=331f4395-ab59-4208-afbe-c699d2eb0bac",
            "sample.mp4?alt=media&token=3b6b920a-a7ee-48e2-9f35-814e52d84d24",
            "sample.mp4?alt=media&token=f0730814-7e15-4b4e-81c1-6f7f02c4695c",
            "sample.mp4?alt=media&token=cfb6bd9e-6052-4f14-9041-95c5c1f8abef",
            "sample.mp4?alt=media&token=72d57bc8-1ca1-402a-a2c5-7e54b06de7e4",
            "sample.mp4?alt=media&token=b7037882-d4e5-41df-bbcd-fa58138d84fa",
            "sample.mp4?alt=media&token=3cc14963-ad27-4572-a5cf-bcbf78c177cd",
            "sample.mp4?alt=media&token=69051ae8-8ee1-4385-852f-b31a76080366",
            "sample.mp4?alt=media&token=18b478c4-a2e6-471c-a823-356e83938f75",
            "sample.mp4?alt=media&token=23190ba2-e362-4b57-be9f-8fe4010040e4",
            "sample.mp4?alt=media&token=4098052d-21fe-4e86-b644-1ceb55ff3709",
            "sample.mp4?alt=media&token=eb797d5d-45cc-42df-bd1c-edebf4d4d516",
            "sample.mp4?alt=media&token=5b22a572-d18e-4faa-8a62-adb3d48f5130",
            "sample.mp4?alt=media&token=9f477e32-712d-4b8d-aa82-fc923c0730dc",
            "sample.mp4?alt=media&token=1935f7da-f6bc-4b45-8381-99f57a39c5b6",
            "sample.mp4?alt=media&token=90ac5104-be44-402c-8e98-90d245b88b25",
            "sample.mp4?alt=media&token=c642fab2-9142-4053-aaa3-cdc482d8c7d3",
            "sample.mp4?alt=media&token=76036716-c19e-45da-97cc-59ee61cad802",
            "sample.mp4?alt=media&token=c7bc99f7-033b-413c-a0b2-8d1e8ed31da1",
            "sample.mp4?alt=media&token=f2250b51-898d-49f5-9cd8-1ee7a6c541e3",
            "sample.mp4?alt=media&token=8cc9af52-f92e-4dd2-ac49-c7053af47d52",
            "sample.mp4?alt=media&token=50b9d937-d515-445b-a44b-ba3bfebb9903",
            "sample.mp4?alt=media&token=eb454a7b-3ead-4965-b0ed-0bc4361ed8f8",
            "sample.mp4?alt=media&token=d36ee1cd-dfac-4998-8edc-5d4fd08a4a29",
            "sample.mp4?alt=media&token=b23ccee6-9f33-4d25-9edc-856d64ff808c",
            "sample.mp4?alt=media&token=e3598582-0af2-4390-81df-c27ca247a2de",
            "sample.mp4?alt=media&token=26a033e6-d703-4b09-865f-546eda6106aa",
            "sample.mp4?alt=media&token=c1f1ac6b-478b-4081-ac11-844dfaff14f4",
            "sample.mp4?alt=media&token=2cac1a63-3c9a-420b-aedd-d3b01affe28f",
            "sample.mp4?alt=media&token=ccb0186e-bbf7-47f2-800a-f8c67538863d",
            "sample.mp4?alt=media&token=1fc5d35b-9b53-4328-9d1c-6fa1fadd5004",
            "sample.mp4?alt=media&token=2844b32b-f822-48b6-bcfe-746455a43063",
            "sample.mp4?alt=media&token=a6bd2d33-745b-4974-a606-d292f3b6fe78",
            "sample.mp4?alt=media&token=73cc0b47-ff36-4ff1-9454-e031da14bb5c",
            "sample.mp4?alt=media&token=7dd2887b-8299-4ca6-ba48-6d27aa48fc36",
            "sample.mp4?alt=media&token=f64b2915-4e17-4d17-a2b3-ab5fd6a833f3",
            "sample.mp4?alt=media&token=85266088-c69c-47f1-b04f-e21058d21816",
            "sample.mp4?alt=media&token=c83767b1-5794-42e4-896a-da6d7f4cc695",
            "sample.mp4?alt=media&token=52e03451-3ce8-4a4d-8038-3370b74c8f3f",
            "sample.mp4?alt=media&token=b8c74f44-649a-4266-a0f2-e7ae7bceffe5",
            "sample.mp4?alt=media&token=77977769-7f4f-474e-8d44-6078aca3f0be",
            "sample.mp4?alt=media&token=151d54a2-aa92-49af-964e-9fb6eadc7074",
            "sample.mp4?alt=media&token=d97740a8-9aa2-43b0-a9a7-f22c4fa58ebd",
            "sample.mp4?alt=media&token=7ae66269-b8e5-4e14-b2f0-b3bdcc0304e7",
            "sample.mp4?alt=media&token=1e16794a-8fad-4b4b-84f9-fe644cd7c1d7",
            "sample.mp4?alt=media&token=2405edae-ad0c-4389-a233-1007a90f35af",
            "sample.mp4?alt=media&token=28e4d248-2c2e-4230-a93f-ff7588fc2261",
            "sample.mp4?alt=media&token=0094b43b-02fb-4a18-bb10-5a15783e230e",
            "sample.mp4?alt=media&token=e9767242-b8f6-49b2-8328-99cc858b9ece",
            "sample.mp4?alt=media&token=00fa4d53-5a7c-4d8f-a367-cf1c2bb114ee",
            "sample.mp4?alt=media&token=4da92361-4c96-4a39-bffb-06041192ab2b",
            "sample.mp4?alt=media&token=f18c4fa1-7f2e-4f83-8b77-61c85b3f3cae",
            "sample.mp4?alt=media&token=d2179a6d-012a-44d5-9ff6-5a94af60e077",
            "sample.mp4?alt=media&token=2252a90f-85c6-4cc2-8dd0-021c5c8f6433",
            "sample.mp4?alt=media&token=88fffdb5-35b8-4c7e-9b40-16026204257a",
            "sample.mp4?alt=media&token=01455ea2-bd27-4113-82ad-fc8ec8a637a7",
            "sample.mp4?alt=media&token=98c852f2-50ba-438f-a67d-1fceda4a0eb1",
            "sample.mp4?alt=media&token=9c9aa119-336b-4689-a6c1-c24fb651db05",
            "sample.mp4?alt=media&token=5b4fcdb8-3c68-4b0c-96cd-233da52b57b8",
            "sample.mp4?alt=media&token=c3b8c73f-9a0b-44e0-acf9-ed40ee9a2a86",
            "sample.mp4?alt=media&token=9798c407-a6d8-4aa5-8e49-6ea534f8c025",
            "sample.mp4?alt=media&token=8c80072d-7f50-4541-aaaf-a732773f9af5",
            "sample.mp4?alt=media&token=7a801a31-ef69-4847-8887-6508cde20072",
            "sample.mp4?alt=media&token=aea73dde-c07e-445a-acb6-6dd28b16a9f0",
            "sample.mp4?alt=media&token=fce11317-c74e-4133-a5e1-e4faa828281a",
            "sample.mp4?alt=media&token=239bed1f-14e9-4552-baa6-faaf6e3251a5",
            "sample.mp4?alt=media&token=63195f1a-2ae8-4535-b9eb-5af103f4aad1",
            "sample.mp4?alt=media&token=ad92eda1-5fb8-43ac-aaca-41afd38d5a02",
            "sample.mp4?alt=media&token=7eb3fe8e-9663-4d8a-9db8-952b295af10f",
            "sample.mp4?alt=media&token=59277637-ed48-4b19-8a5d-a652884dfe69",
            "sample.mp4?alt=media&token=f7dd22e6-2694-4244-883f-de6300c21d37",
            "sample.mp4?alt=media&token=7b93c579-6fab-413f-8042-e5bf0c4187a1",
            "sample.mp4?alt=media&token=f2299a36-9bd7-4fd6-b8c9-80cccbe229ea",
            "sample.mp4?alt=media&token=dd19d30b-f22b-489a-a3b8-9a87ac63f22f",
            "sample.mp4?alt=media&token=02d5eaf2-f2d7-409b-94d0-38311e38d6e0",
            "sample.mp4?alt=media&token=3cd82113-c426-4d11-8e3e-f72d3dd83d35",
            "sample.mp4?alt=media&token=48bd406e-f43e-45d0-affb-e210ce51e236",
            "sample.mp4?alt=media&token=3abac869-2a71-4391-a15c-490b8985e4e9",
            "sample.mp4?alt=media&token=3b77151e-851b-4623-bf78-35dcb7bf9d0a",
            "sample.mp4?alt=media&token=e78d5b39-cc52-48b8-9731-873d643fd9e3",
            "sample.mp4?alt=media&token=ec5372b9-2206-48a0-8fe4-06dbdfc9ad93",
            "sample.mp4?alt=media&token=aecb5374-c00a-434d-b306-3c2c42534937"

    };

    public TayyipFragment() {
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