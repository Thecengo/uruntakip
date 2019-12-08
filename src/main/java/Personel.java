import urunler.Urun;

import java.util.ArrayList;
import java.util.List;

public class Personel {

    public String getPersonelAdi() {
        return personelAdi;
    }

    public void setPersonelAdi(String personelAdi) {
        this.personelAdi = personelAdi;
    }

    private String personelAdi;
    List<Urun> urunList;

    public Personel(String personelAdi){
        urunList = new ArrayList<Urun>();
        this.personelAdi = personelAdi;
    }

    @Override
    public String toString() {
        return personelAdi;
    }
}
