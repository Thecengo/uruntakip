import domain.Musteri;
import domain.Satıs;
import domain.Stok;
import filetransactions.MyFileWriter;
import viewers.Input;
import viewers.StringYazici;

import java.util.Scanner;

public class Satici {

   public static void satisYap(Scanner scanner) {
        Satıs satıs;
        boolean kodYanlıs = true;

        boolean stokYok;

        scanner.nextLine();
        while (kodYanlıs) {
            System.out.println(StringYazici.genelMenuSatisYapGosterYazisi);
            stokYok = App.stokList.isEmpty();

            if (stokYok){
                System.out.println(StringYazici.satilacakUrunYokYazisi);
                App.urunVePersonelEkle(scanner);
            }
            else {
                Goruntuleyici.tumUrunleriGoster(App.stokList);

                String urunKoduIste = Input.stringDegerIste(StringYazici.urunKoduGirinizYazisi, scanner);

                int yeniUrunAdedi;
                int musterininSatınAlacagiMiktar = Input.sayiDegeriIste(StringYazici.musterininKacAdetIstedigiYazisi, scanner);


                boolean urunKoduVar = App.urunKoduVarMı(urunKoduIste);


                try{
                    if (urunKoduVar) {
                        if (App.stokList.get(App.satisIndisi).getUrunAdedi() < musterininSatınAlacagiMiktar) {
                            System.out.println(StringYazici.stogumuzdaIstediginizMiktarBulunmamaktadirYazisi);
                            scanner.nextLine();
                        } else {
                            scanner.nextLine();
                            String musteriAdi = Input.stringDegerIste(StringYazici.musteriAdiGirinizYazisi, scanner);

                            Musteri musteri = new Musteri(musteriAdi);

                            final Stok stok = App.stokList.get(App.satisIndisi);
                            satıs = new Satıs(stok, musteri,musterininSatınAlacagiMiktar);
                            App.satısList.add(satıs);

                            //File write islemi buraya yazılacak

                            MyFileWriter<Satıs> myFileWriter = new MyFileWriter<Satıs>();
                            myFileWriter.dosyayaYaz(StringYazici.satisFilePath, App.satısList);

                            final int urunAdedi = App.stokList.get(App.satisIndisi).getUrunAdedi();
                            yeniUrunAdedi = urunAdedi - musterininSatınAlacagiMiktar;

                            App.stokList.get(App.satisIndisi).setUrunAdedi(yeniUrunAdedi);

                            MyFileWriter<Stok> myFileWriterUpdateStok = new MyFileWriter<Stok>();
                            myFileWriterUpdateStok.dosyayaYaz(StringYazici.stokFilePath, App.stokList);

                            kodYanlıs = false;
                            App.satisIndisi = 0;

                        }
                    }
                    else {
                        scanner.nextLine();
                        throw new MyException("Hatalı ürün kodu girdiniz. Lütfen tekrar deneyiniz");

                    }
                }

                catch (MyException exception){
                    System.out.println(exception.getMessage());
                }


            }
        }
    }
}
