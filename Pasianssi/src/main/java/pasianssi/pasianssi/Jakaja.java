
package pasianssi.pasianssi;

public class Jakaja {
    private Pakka pakka;
    private Poyta poyta;
    
    public Jakaja(Pakka pakka, Poyta poyta) {
        this.pakka = pakka;
        this.poyta = poyta;
    }
    
    public void jaaKortit() {
        while (true) {
            if (poyta.getTyhjat().isEmpty()) {
                break;
            }
            if (this.pakka.onkoTyhja()) {
                siirraKortitTyhjiin();
                break;
            }
            this.poyta.getTyhjat().get(0).asetaKortti(this.pakka.pakanKortit().get(0));
            this.pakka.poistaKortti(this.pakka.pakanKortit().get(0));
        }
    }
    
    public void siirraKortitTyhjiin() {
        while (this.poyta.onkoKorttienValissaTyhjia()) {
            Paikka viimeinen = this.poyta.viimeinenPaikkaJossaKortti();
            this.poyta.getTyhjat().get(0).asetaKortti(viimeinen.getKortti());
            viimeinen.tyhjennaPaikka();
        }
    }
}
