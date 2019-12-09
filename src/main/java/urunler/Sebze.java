package urunler;

import urunler.Urun;

public class Sebze extends Urun {

    @Override
    public String getUrunKodu() {
        return super.getUrunKodu().substring(0,3) + getClass().getSimpleName().substring(0,3).toLowerCase() + getUrunId();
    }

    public Sebze(String urunAdi) {
        super(urunAdi);
    }


}
