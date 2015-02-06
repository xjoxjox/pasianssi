
package pasianssi.util;
import pasianssi.domain.Paikka;
/**
 * Luokka tarkastaa ovatko valitut paikat samalla rivillä.
 */
public class RivienTarkastaja {
    
    public RivienTarkastaja() {
    }
    /**
    * Metodi tarkastaa onko valitun parin paikat samalla rivillä.
    * @param paikka1 ensimmaisenä valittu paikka
    * @param paikka2 toisena valittu paikka
    * @see pasianssi.domain.Paikka#getPystyrivi() 
    * @see pasianssi.domain.Paikka#getVaakarivi()
    * @return onko samalla rivillä
    */
    public boolean onkoParinPaikatSamallaRivilla(Paikka paikka1, Paikka paikka2) {
        if (paikka1.getPystyrivi()==paikka2.getPystyrivi()) {
            return true;
        }
        return paikka1.getVaakarivi()==paikka2.getVaakarivi();
    }
    /**
    * Metodi tarkastaa ovatko valitut kuvakorttien paikat samalla rivillä.
    * @param paikka1 ensimmaisenä valittu paikka
    * @param paikka2 toisena valittu paikka
    * @param paikka3 kolmantena valittu paikka
    * @see pasianssi.domain.Paikka#getPystyrivi() 
    * @see pasianssi.domain.Paikka#getVaakarivi()
    * @return onko samalla rivillä
    */
    public boolean onkoKuvakorttienPaikatSamallaRivilla(Paikka paikka1, Paikka paikka2, Paikka paikka3) {
        if (paikka1.getPystyrivi()==paikka2.getPystyrivi() && paikka2.getPystyrivi()==paikka3.getPystyrivi()) {
            return true;
        }
        return paikka1.getVaakarivi()==paikka2.getVaakarivi() && paikka2.getVaakarivi()==paikka3.getVaakarivi();
    }
}
