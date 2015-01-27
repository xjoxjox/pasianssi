
package pasianssi.pasianssi;
/**
 * Luokka jakaa kortit pöydälle hallitsevan tilanteen mukaan.
 */
public class Jakaja {
    private Pakka pakka;
    private Poyta poyta;
    
    public Jakaja(Pakka pakka, Poyta poyta) {
        this.pakka = pakka;
        this.poyta = poyta;
    }
    /**
    * Metodi jakaa kortit pöydän tyhjiin paikkoihin ja jos pakka on tyhjä, 
    * siirtää käsittelyn metodiin siirraKortitTyhjiin().
    * @see pasianssi.pasianssi.Poyta#getTyhjat() 
    * @see pasianssi.pasianssi.Pakka#onkoTyhja()
    * @see pasianssi.pasianssi.Pakka#poistaKortti(pasianssi.pasianssi.Kortti) 
    * @see pasianssi.pasianssi.Pakka#pakanKortit() 
    * @see pasianssi.pasianssi.Paikka#asetaKortti(pasianssi.pasianssi.Kortti) 
    */
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
    /**
    * Metodi siirtää pöydän viimeisenä olevan kortin ensimmäiseen tyhjään paikkaan, 
    * kunnes korttien välissä ei ole tyhjiä paikkoja.
    * @see pasianssi.pasianssi.Poyta#onkoKorttienValissaTyhjia() 
    * @see pasianssi.pasianssi.Poyta#viimeinenPaikkaJossaKortti() 
    * @see pasianssi.pasianssi.Paikka#asetaKortti(pasianssi.pasianssi.Kortti) 
    * @see pasianssi.pasianssi.Paikka#tyhjennaPaikka() 
    */
    public void siirraKortitTyhjiin() {
        while (this.poyta.onkoKorttienValissaTyhjia()) {
            Paikka viimeinen = this.poyta.viimeinenPaikkaJossaKortti();
            this.poyta.getTyhjat().get(0).asetaKortti(viimeinen.getKortti());
            viimeinen.tyhjennaPaikka();
        }
    }
}
