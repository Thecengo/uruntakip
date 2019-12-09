import viewers.StringYazici;

public class Menu {

    public static void urunEklemeMenusuIcerikYazdir(){

        System.out.println(StringYazici.secimYazisi);
        System.out.println(StringYazici.sebzeYazisi);
        System.out.println(StringYazici.meyveYazisi);
        System.out.println(StringYazici.urunEklemeMenusutumUrunleriGosterYazisi);
        System.out.println(StringYazici.goruntulemekIstediginizUrunAdinaGoreAramaYazisi);
        System.out.println(StringYazici.cikisYazisi);

    }

    public static void genelMenuOlustur(){

        System.out.println(StringYazici.genelMenuSecimYazisi);
        System.out.println(StringYazici.genelMenuUrunEklemeYazisi);
        System.out.println(StringYazici.genelMenuTumUrunleriGosterYazisi);
        System.out.println(StringYazici.genelMenuSatisYapGosterYazisi);
        System.out.println(StringYazici.genelMenuTumSatisleriGosterYazisi);
        System.out.println(StringYazici.genelMenuCikisYapGosterYazisi);
        System.out.println();
    }
}
