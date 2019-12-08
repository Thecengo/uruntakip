import urunler.Urun;

import java.util.*;

public class App {

    static List<Stok> stokList = new ArrayList<Stok>();

    static List<Satıs> satısList = new ArrayList<Satıs>();
    static Stok stok;
    static Map<Urun, Personel> urunPersonelMap = new LinkedHashMap<Urun, Personel>();
    static int satisIndisi = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        genelMenuIcerikGoster(scanner);

    }

    private static void genelMenuIcerikGoster(Scanner scanner) {
        boolean devamEdilsinMi = true;

        while (devamEdilsinMi) {
            genelMenuOlustur();
            int secim = sayiDegeriIste(StringYazici.genelMenuSecimYazisi, scanner);
            Satıs satıs;
            switch (secim) {
                case 0:
                    urunVePersonelEkle(scanner);
                    break;
                case 1:
                    tumUrunleriGoster();
                    break;
                case 2:
                    boolean kodYanlıs = true;

                    boolean stokVarMı;

                    scanner.nextLine();
                    while (kodYanlıs) {
                        System.out.println(StringYazici.genelMenuSatisYapGosterYazisi);
                        stokVarMı = stokList.isEmpty();
                        if (stokVarMı){
                            System.out.println(StringYazici.satilacakUrunYokYazisi);
                            urunVePersonelEkle(scanner);
                        }
                        else {
                            tumUrunleriGoster();

                            String urunKoduIste = stringDegerIste(StringYazici.urunKoduGirinizYazisi, scanner);

                            int yeniUrunAdedi;
                            int musterininSatınAlacagiMiktar = sayiDegeriIste(StringYazici.musterininKacAdetIstedigiYazisi, scanner);


                            boolean urunKoduVar = urunKoduVarMı(urunKoduIste);

                                if (urunKoduVar) {
                                    if (stokList.get(satisIndisi).getUrunAdedi() < musterininSatınAlacagiMiktar) {
                                        System.out.println(StringYazici.stogumuzdaIstediginizMiktarBulunmamaktadirYazisi);
                                    } else {
                                        scanner.nextLine();
                                        String musteriAdi = stringDegerIste(StringYazici.musteriAdiGirinizYazisi, scanner);
                                        Musteri musteri = new Musteri(musteriAdi);
                                        satıs = new Satıs(stokList.get(satisIndisi), musteri,musterininSatınAlacagiMiktar);
                                        satısList.add(satıs);
                                        yeniUrunAdedi = stokList.get(satisIndisi).getUrunAdedi() - musterininSatınAlacagiMiktar;
                                        stokList.get(satisIndisi).setUrunAdedi(yeniUrunAdedi);
                                        System.out.println(stokList.get(satisIndisi).getUrun().getUrunAdi()+
                                                " Satışı basarı ile gercekleştirilmiştir."
                                                  +musteri.getMusteriAdi());
                                        kodYanlıs = false;
                                        satisIndisi = 0;

                                    }
                                }
                                else {
                                    scanner.nextLine();
                                    System.out.println("Hatalı ürün kodu girdiniz. Lütfen tekrar deneyiniz");
                                }


                        }
                    }


                    break;
                case 3:
                    if (satısList.isEmpty()) {
                        System.out.println("Henüz satış yapılmamıştır");
                    } else
                    tumSatıslarıGoster();
                    break;
                case 4:
                    System.out.println(StringYazici.genelMenuCikisYapGosterYazisi);
                    break;

            }
        }
    }

    private static boolean urunKoduVarMı(String urunKoduIste) {
        for(Stok stok : stokList){
            if(stok.getUrunKodu().equals(urunKoduIste)){
                return true;
            }
            else{
                satisIndisi++;
            }
        }
        return false;
    }

    private static void tumSatıslarıGoster(){

        System.out.println(StringYazici.duzCizgiYazisi);
        System.out.println(StringYazici.satısiGosterUstYazisi);
        System.out.println(StringYazici.duzCizgiYazisi);

        for(Satıs satıs : satısList){
            System.out.print( satıs.getMusteri().getMusteriAdi());
            System.out.print(girilenAdetKadarTabVer(3).toString() + satıs.getSatısMiktari());
            System.out.print(girilenAdetKadarTabVer(3).toString() + satıs.getStok().getUrun().getUrunAdi());
            System.out.print(girilenAdetKadarTabVer(3).toString() + satıs.getStok().getPersonel());
            System.out.print(StringYazici.altSatirYazicisi + StringYazici.duzCizgiYazisi + StringYazici.altSatirYazicisi);
        }
    }

    private static void tumUrunleriGoster() {

        System.out.println(StringYazici.duzCizgiYazisi);
        System.out.println(StringYazici.tumUrunleriGosterUstYazisi);
        System.out.println(StringYazici.duzCizgiYazisi);

        for (Stok stok : stokList) {
            System.out.print(stok.getPersonel().getPersonelAdi());
            System.out.print(girilenAdetKadarTabVer(3).toString() + stok.getUrun().getUrunAdi());
            System.out.print(girilenAdetKadarTabVer(3).toString() + stok.getUrunAdedi());
            System.out.print(girilenAdetKadarTabVer(3).toString() + stok.getUrunKodu() + StringYazici.altSatirYazicisi);
            System.out.println(StringYazici.duzCizgiYazisi);

        }
    }

    private static void arananUruneGoreMiktarGoster(Scanner scanner) {
        String aranacakUrun = stringDegerIste(StringYazici.goruntulemekIstediginizUrunAdiniGirinizYazisi, scanner);

        String urunAdi = null;
        int toplam = 0;

        for (Stok stok : stokList) {
            urunAdi = stok.getUrun().getUrunAdi();
            if (aranacakUrun.equals(urunAdi)) {
                toplam = toplam + stok.getUrunAdedi();
            }
        }
        System.out.println(urunAdi + StringYazici.tabYazisi + toplam);
    }

    public static void urunVePersonelEkle(Scanner scanner) {

        boolean devamEdilsinMi = true;

        while (devamEdilsinMi) {

            urunEklemeMenusuIcerikYazdir();

            int secimRakami = scanner.nextInt();

            scanner.nextLine();
            switch (secimRakami) {
                case 0:
                    urunMapListOlustur(scanner, 0);
                    break;
                case 1:
                    urunMapListOlustur(scanner, 1);
                    break;
                case 2:
                    if (stokList.isEmpty())
                        System.out.println(StringYazici.listeBosYazisi);
                    else
                        tumUrunleriGoster();
                    break;
                case 3:
                    tumUrunleriGoster();
                    arananUruneGoreMiktarGoster(scanner);
                    break;
                case 4:
                    devamEdilsinMi = false;
                    break;

            }

        }

    }



    private static void genelMenuOlustur(){

        System.out.println(StringYazici.genelMenuSecimYazisi);
        System.out.println(StringYazici.genelMenuUrunEklemeYazisi);
        System.out.println(StringYazici.genelMenuTumUrunleriGosterYazisi);
        System.out.println(StringYazici.genelMenuSatisYapGosterYazisi);
        System.out.println(StringYazici.genelMenuTumSatisleriGosterYazisi);
        System.out.println(StringYazici.genelMenuCikisYapGosterYazisi);
        System.out.println();
    }

    private static void urunMapListOlustur(Scanner scanner, int sayi) {
        String urunAdi;
        int urunAdedi;
        Urun urun;

        String personelAdi;
        Personel personel;



        urunAdi = stringDegerIste(StringYazici.urunAdiniGirinizYazisi, scanner);
        urunAdedi = sayiDegeriIste(StringYazici.urunAdediGirinizYazisi, scanner);

        if (sayi == 0)
            urun = new Sebze(urunAdi);
        else
            urun = new Meyve(urunAdi);

        scanner.nextLine();

        personelAdi = stringDegerIste(StringYazici.personelAdiGirinizYazisi, scanner);
        personel = new Personel(personelAdi);

        stok = new Stok(urun, personel, urunAdedi);
        stokList.add(stok);

        urunPersonelMap.put(urun,personel);
    }

    public static void urunEklemeMenusuIcerikYazdir(){

        System.out.println(StringYazici.secimYazisi);
        System.out.println(StringYazici.sebzeYazisi);
        System.out.println(StringYazici.meyveYazisi);
        System.out.println(StringYazici.urunEklemeMenusutumUrunleriGosterYazisi);
        System.out.println(StringYazici.goruntulemekIstediginizUrunAdinaGoreAramaYazisi);
        System.out.println(StringYazici.cikisYazisi);

    }

    public static String stringDegerIste(String girilecekDeger, Scanner scanner){
        System.out.println(girilecekDeger);
        return scanner.nextLine();
    }

    public static int sayiDegeriIste(String girilecekSayi, Scanner scanner){
        System.out.println(girilecekSayi);
        return scanner.nextInt();
    }

    public static StringBuilder girilenAdetKadarTabVer(int tabAdedi){

        StringBuilder stringBuilder = new StringBuilder(StringYazici.tabYazisi);
        for (int i = 0 ; i < tabAdedi ;i++){
            stringBuilder.append(StringYazici.tabYazisi);
        }
           return stringBuilder;
    }



}
