package domain;

import java.io.Serializable;

public class Musteri implements Serializable {
    private String musteriAdi;

    public Musteri(String musteriAdi) {
        this.musteriAdi = musteriAdi;
    }

    public String getMusteriAdi() {
        return musteriAdi;
    }

    public void setMusteriAdi(String musteriAdi) {
        this.musteriAdi = musteriAdi;
    }
}
