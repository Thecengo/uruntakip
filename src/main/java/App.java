import domain.Personel;
import domain.Satıs;
import domain.Stok;
import filetransactions.MyFileWriter;
import urunler.Meyve;
import urunler.Sebze;
import urunler.Urun;
import viewers.Input;
import viewers.StringYazici;

import java.util.*;

public class App {

    static List<Stok> stokList = new ArrayList<Stok>();
    static List<Satıs> satısList = new ArrayList<Satıs>();

    static Stok stok;

    static int satisIndisi = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Goruntuleyici.genelMenuIcerikGoster(scanner);

        for (Stok stok: stokList){
            System.out.println(stok);
        }


    }

    public static boolean urunKoduVarMı(String urunKoduIste) {
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


    private static void arananUruneGoreMiktarGoster(Scanner scanner) {
        String aranacakUrun = Input.stringDegerIste(StringYazici.goruntulemekIstediginizUrunAdiniGirinizYazisi, scanner);
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

            MenuOlusturucu.urunEklemeMenusuIcerikYazdir();

            int secimRakami = scanner.nextInt();

            scanner.nextLine();
            switch (secimRakami) {
                case 0:
                    urunVePersonelEslestir(scanner, 0);
                    break;
                case 1:
                    urunVePersonelEslestir(scanner, 1);
                    break;
                case 2:
                    if (stokList.isEmpty())
                        System.out.println(StringYazici.listeBosYazisi);
                    else
                        Goruntuleyici.tumUrunleriGoster(App.stokList);
                    break;
                case 3:
                    Goruntuleyici.tumUrunleriGoster(App.stokList);
                    arananUruneGoreMiktarGoster(scanner);
                    break;
                case 4:
                    devamEdilsinMi = false;
                    break;
                case 5:
                    MyFileWriter<Stok> myFileWriter = new MyFileWriter<Stok>();
                    myFileWriter.dosyayaYaz(StringYazici.stokFilePath, stokList);
                    break;
            }

        }

    }

    private static void urunVePersonelEslestir(Scanner scanner, int sayi) {
        String urunAdi;
        int urunAdedi;
        Urun urun;

        String personelAdi;
        Personel personel;

        urunAdi = Input.stringDegerIste(StringYazici.urunAdiniGirinizYazisi, scanner);
        urunAdedi = Input.sayiDegeriIste(StringYazici.urunAdediGirinizYazisi, scanner);

        if (sayi == 0)
            urun = new Sebze(urunAdi);
        else
            urun = new Meyve(urunAdi);

        scanner.nextLine();

        personelAdi = Input.stringDegerIste(StringYazici.personelAdiGirinizYazisi, scanner);
        personel = new Personel(personelAdi);

        stok = new Stok(urun, personel, urunAdedi);

        stokList.add(stok);

    }


}
