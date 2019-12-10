package domain;

import domain.Musteri;
import domain.Stok;

import java.io.Serializable;

public class Satıs implements Serializable {

    private Stok stok;
    private Musteri musteri;
    private int satısMiktari;

    public Satıs(Stok stok, Musteri musteri, int satısMiktari) {
        this.stok = stok;
        this.musteri = musteri;
        this.satısMiktari = satısMiktari;
    }

    public Stok getStok() {
        return stok;
    }

    public void setStok(Stok stok) {
        this.stok = stok;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public int getSatısMiktari() {
        return satısMiktari;
    }

    public void setSatısMiktari(int satısMiktari) {
        this.satısMiktari = satısMiktari;
    }
}
