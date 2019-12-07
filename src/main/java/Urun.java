public abstract class Urun {

    private String urunAdi;

    public Urun(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }



    @Override
    public String toString() {
        return urunAdi;
    }
}
