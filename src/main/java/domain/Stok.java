package domain;

import domain.Personel;
import urunler.Urun;

import java.io.Serializable;

public class Stok implements Serializable {

    private Urun urun;
    private Personel personel;
    private int urunAdedi;
    private String urunKodu;


    public Stok(Urun urun, Personel personel, int urunAdedi) {
        this.urun = urun;
        this.personel = personel;
        this.urunAdedi = urunAdedi;
        this.urunKodu = urun.getUrunKodu();
    }


    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }

    public String getUrunKodu() {
        return urunKodu;
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

    @Override
    public String toString() {
        return "domain.Stok{" +
                "urun=" + urun.getUrunAdi() +
                ", personel=" + personel.getPersonelAdi() +
                ", urunAdedi=" + urunAdedi +
                ", urunKodu='" + urunKodu + '\'' +
                '}';
    }
}
