package urunler;

import java.io.Serializable;

public abstract class Urun implements Serializable {

    private static int urunId;
    private String urunAdi;

    private String urunKodu;

    public Urun(String urunAdi) {
        this.urunAdi = urunAdi;
        urunId++;
    }

    public String getUrunKodu() {
        return urunAdi + "@" +urunId ;
    }


    public String getUrunAdi() {

        return urunAdi;
    }

    public int getUrunId() {
        return urunId;
    }

    @Override
    public String toString() {

        return urunAdi;
    }
}
