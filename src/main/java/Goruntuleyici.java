import domain.Satıs;
import domain.Stok;
import filetransactions.FileInput;
import filetransactions.Inputable;
import filetransactions.MyFileWriter;
import viewers.Input;
import viewers.StringYazici;

import java.util.List;
import java.util.Scanner;

public class Goruntuleyici {


    public static void tumSatıslarıGoster(List<Satıs> satısList){

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

    public static void tumUrunleriGoster(List<Stok> stokList) {


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


    public static void genelMenuIcerikGoster(Scanner scanner) {
        boolean devamEdilsinMi = true;

        Inputable<Satıs> satisInputable = new FileInput<Satıs>();
        List<Satıs> dosyadanOkunanSatisListesi = satisInputable.dosyadanOku(StringYazici.stokFilePath);

        while (devamEdilsinMi) {
            MenuOlusturucu.genelMenuOlustur();
            int secim = Input.sayiDegeriIste(StringYazici.genelMenuSecimYazisi, scanner);
            Satıs satıs;
            switch (secim) {
                case 0:
                    App.urunVePersonelEkle(scanner);
                    break;
                case 1:
                    Inputable<Stok> stokInputable = new FileInput<Stok>();
                    List<Stok> dosyadanOkunanListe = stokInputable.dosyadanOku(StringYazici.stokFilePath);

                    tumUrunleriGoster(dosyadanOkunanListe);
                    break;
                case 2:
                    Satici.satisYap(scanner);
                    break;
                case 3:
                    if (App.satısList.isEmpty()) {
                        System.out.println(StringYazici.henüzSatisYapilmamistirYazisi);
                    } else
                        Goruntuleyici.tumSatıslarıGoster(dosyadanOkunanSatisListesi);
                    break;
                case 4:
                    System.out.println(StringYazici.genelMenuCikisYapGosterYazisi);
                    devamEdilsinMi = false;
                    break;

            }
        }
    }
    public static StringBuilder girilenAdetKadarTabVer(int tabAdedi){

        StringBuilder stringBuilder = new StringBuilder(StringYazici.tabYazisi);
        for (int i = 0 ; i < tabAdedi ;i++){
            stringBuilder.append(StringYazici.tabYazisi);
        }
        return stringBuilder;
    }
}
