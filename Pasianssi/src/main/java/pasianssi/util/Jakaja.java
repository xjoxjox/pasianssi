
package pasianssi.util;

import pasianssi.domain.Paikka;
import pasianssi.domain.Pakka;
import pasianssi.domain.Poyta;

/**
 * @author Johanna
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
    * @see pasianssi.domain.Poyta#getTyhjat() 
    * @see pasianssi.domain.Pakka#onkoTyhja()
    * @see pasianssi.domain.Pakka#poistaKortti(pasianssi.domain.Kortti) 
    * @see pasianssi.domain.Pakka#pakanKortit() 
    * @see pasianssi.domain.Paikka#asetaKortti(pasianssi.domain.Kortti) 
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
    * @see pasianssi.domain.Poyta#onkoKorttienValissaTyhjia() 
    * @see pasianssi.domain.Poyta#viimeinenPaikkaJossaKortti() 
    * @see pasianssi.domain.Paikka#asetaKortti(pasianssi.domain.Kortti) 
    * @see pasianssi.domain.Paikka#tyhjennaPaikka() 
    */
    public void siirraKortitTyhjiin() {
        while (this.poyta.onkoKorttienValissaTyhjia()) {
            Paikka viimeinen = this.poyta.viimeinenPaikkaJossaKortti();
            this.poyta.getTyhjat().get(0).asetaKortti(viimeinen.getKortti());
            viimeinen.tyhjennaPaikka();
        }
    }
}
