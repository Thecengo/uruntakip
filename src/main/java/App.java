import java.util.*;

public class App {

    static List<Stok> stokList = new ArrayList<Stok>();

    static Map<Urun,Personel> urunPersonelMap = new LinkedHashMap<Urun, Personel>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ürünVePersonelEkle(scanner);


        for (Map.Entry<Urun, Personel> urunPersonelMap1: urunPersonelMap.entrySet()) {
            System.out.println("urun:" +urunPersonelMap1.getKey() +" personel: " + urunPersonelMap1.getValue());

        }


        for (Stok stok : stokList) {
            System.out.println(stok.getPersonel().getPersonelAdi());
            System.out.println(stok.getUrun().getUrunAdi());
            System.out.println(stok.getUrunAdedi());
        }


    }

    public static void ürünVePersonelEkle(Scanner scanner){

        System.out.println("fjngjknhlkethşk");
        boolean devamEdilsinMi = true;

        Urun urun;
        Personel personel;
        Stok stok;

        String adi;
        int urunAdedi;
        String personelAdi;

        while (devamEdilsinMi){
            System.out.println("Lütfen sebze ve meyve eklemek için seçim yapınız");
            System.out.println("0 - Sebze");
            System.out.println("1 - Meyve");
            System.out.println("Çıkış yapmak için lütfen 0'a basınız");
            int secimRakami = scanner.nextInt();

            scanner.nextLine();
            switch (secimRakami){
                case 0:
                    System.out.println("Lütfen ürün adini giriniz");
                    adi = scanner.nextLine();

                    System.out.println("Lütfen ürün adedi giriniz");
                    urunAdedi = scanner.nextInt();

                    urun = new Sebze(adi);

                    scanner.nextLine();
                    System.out.println("Lütfen personel adi giriniz");
                    personelAdi =  scanner.nextLine();

                    personel = new Personel(personelAdi);

                    stok = new Stok(urun, personel, urunAdedi);

                    stokList.add(stok);

                    urunPersonelMap.put(urun,personel);

                    break;
                case 1:
                    System.out.println("Lütfen ürün adini giriniz");
                    adi = scanner.nextLine();

                    System.out.println("Lütfen ürün adedi giriniz");
                    urunAdedi = scanner.nextInt();

                    urun = new Sebze(adi);

                    System.out.println("Lütfen personel adi giriniz");
                    personelAdi =  scanner.nextLine();

                    personel = new Personel(personelAdi);

                    stok = new Stok(urun, personel, urunAdedi);

                    stokList.add(stok);
                    urunPersonelMap.put(urun,personel);
                    break;
                case 2:
                    devamEdilsinMi = false;
                    break;

            }

        }
    }
}
