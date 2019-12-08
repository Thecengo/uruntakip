package urunler;

public abstract class Urun {

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
