
package pasianssi.util;

import java.util.HashMap;
import pasianssi.domain.Kortti;
/**
 * Luokka tarkastaa ovatko valitut kortit pareja tai kuvakortteja järjestyksessä.
 * Parit ovat HashMapissä.
 */
public class ParienTarkastaja {
    private HashMap<Integer, Integer> parit;
    
    public ParienTarkastaja() {
        this.parit = new HashMap<>();
        this.parit.put(1, 10);
        this.parit.put(2, 9);
        this.parit.put(3, 8);
        this.parit.put(4, 7);
        this.parit.put(5, 6);
    }
    /**
    * Metodi tarkastaa onko kortti kuvakortti.
    * @param kortti1 valittu kortti
    * @see pasianssi.domain.Kortti#getArvo() 
    * @return kuvakortti
    */
    private boolean onkoKuvakortti(Kortti kortti) {
        return kortti.getArvo() == 11
        || kortti.getArvo() == 12
        || kortti.getArvo() == 13;
    }
    /**
    * Metodi tarkastaa ovatko valitut kortit kuvakortteja.
    * @param kortti1 ensimmäiseksi valittu kortti
    * @param kortti2 toiseksi valittu kortti
    * @see pasianssi.util.ParienTarkastaja#onkoKuvakortti(Kortti) 
    * @return kuvakortteja
    */
    public boolean ovatkoValitutKuvakortteja(Kortti kortti1, Kortti kortti2) {
        return onkoKuvakortti(kortti1) && onkoKuvakortti(kortti2);
    }
    /**
    * Metodi tarkastaa ovatko kortit pari.
    * @param kortti1 ensimmäiseksi valittu kortti
    * @param kortti2 toiseksi valittu kortti
    * @see pasianssi.domain.Kortti#getArvo()
    * @return pari
    */
    public boolean ovatkoValitutKortitPari(Kortti kortti1, Kortti kortti2) {
        if (this.parit.containsKey(kortti1.getArvo())) {
            if (this.parit.get(kortti1.getArvo()).equals(kortti2.getArvo())) {
                return true;
            }
        }
        if (this.parit.containsKey(kortti2.getArvo())) {
            if (this.parit.get(kortti2.getArvo()).equals(kortti1.getArvo())) {
                return true;
            }
        }
        return false;
    }
    /**
    * Metodi tarkastaa ovatko valitut kuvakortit järjestyksessä.
    * @param kortti1 ensimmäiseksi valittu kortti
    * @param kortti2 kolmanneksi valittu kortti
    * @see pasianssi.domain.Kortti#getArvo()
    * @return kuvakortit järjestyksessä
    */
    public boolean ovatkoValitutKuvakorttejaJarjestyksessa(Kortti kortti1, Kortti kortti2) {
        return (kortti1.getArvo()==11 && kortti2.getArvo()==13) || (kortti2.getArvo()==11 && kortti1.getArvo()==13);
    }
}
