public class Stok {

    private Urun urun;
    private Personel personel;
    private int urunAdedi;

    public Stok(Urun urun, Personel personel, int urunAdedi) {
        this.urun = urun;
        this.personel = personel;
        this.urunAdedi = urunAdedi;
    }

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }

    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }

    public int getUrunAdedi() {
        return urunAdedi;
    }

    public void setUrunAdedi(int urunAdedi) {
        this.urunAdedi = urunAdedi;
    }


}
