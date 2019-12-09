package urunler;

import urunler.Urun;

public class Meyve extends Urun {
    public Meyve(String urunAdi) {
        super(urunAdi);
    }

    @Override
    public String getUrunKodu() {
        return super.getUrunKodu().substring(0,3) + getClass().getSimpleName().substring(0,3).toLowerCase() + getUrunId();
    }
}
