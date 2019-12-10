package domain;

import urunler.Urun;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Personel implements Serializable {

    public String getPersonelAdi() {
        return personelAdi;
    }

    public void setPersonelAdi(String personelAdi) {
        this.personelAdi = personelAdi;
    }

    private String personelAdi;


    public Personel(String personelAdi){
        this.personelAdi = personelAdi;
    }

    @Override
    public String toString() {
        return personelAdi;
    }
}
