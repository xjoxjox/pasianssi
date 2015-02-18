
package pasianssi.util;
import java.util.Arrays;
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
    * Metodi tarkastaa ovatko valitut kuvakortit vierekkäisillä paikoilla.
    * @param paikka1 ensimmaisenä valittu paikka
    * @param paikka2 toisena valittu paikka
    * @param paikka3 kolmantena valittu paikka
    * @see pasianssi.domain.Paikka#getPystyrivi() 
    * @see pasianssi.domain.Paikka#getVaakarivi()
    * @see pasianssi.util.RivienTarkastaja#onkoKuvakortitJarjestyksessa(Paikka, Paikka, Paikka)
    * @return onko vierekkäisillä paikoilla ja jarjestyksessa
    */
    public boolean onkoKuvakortitVierekkäin(Paikka paikka1, Paikka paikka2, Paikka paikka3) {
        if (paikka1.getPystyrivi()==paikka2.getPystyrivi() && paikka2.getPystyrivi()==paikka3.getPystyrivi()) {
            int p1i = paikka1.getVaakarivi();
            int p2i = paikka2.getVaakarivi();
            int p3i = paikka3.getVaakarivi();
            int[] paikat = {p1i,p2i,p3i};
            Arrays.sort(paikat);
            if ((paikat[0]+1==paikat[1]) && (paikat[1]+1==paikat[2])) {
                if (paikat[0]==p1i) {
                    if (paikat[1]==p2i) {
                        return onkoKuvakortitJarjestyksessa(paikka1,paikka2,paikka3);
                    }
                    else {
                        return onkoKuvakortitJarjestyksessa(paikka1,paikka3,paikka2);
                    }
                }
                else if (paikat[0]==p2i) {
                    if (paikat[1]==p1i) {
                        return onkoKuvakortitJarjestyksessa(paikka2,paikka1,paikka3);
                    }
                    else {
                        return onkoKuvakortitJarjestyksessa(paikka2,paikka3,paikka1);
                    }
                }
                else {
                    if (paikat[1]==p2i) {
                        return onkoKuvakortitJarjestyksessa(paikka3,paikka2,paikka1);
                    }
                    else {
                        return onkoKuvakortitJarjestyksessa(paikka3,paikka1,paikka2);
                    }
                }
            }
        }
        if (paikka1.getVaakarivi()==paikka2.getVaakarivi() && paikka2.getVaakarivi()==paikka3.getVaakarivi()) {
            int p1i = paikka1.getPystyrivi();
            int p2i = paikka2.getPystyrivi();
            int p3i = paikka3.getPystyrivi();
            int[] paikat = {p1i,p2i,p3i};
            Arrays.sort(paikat);
            if ((paikat[0]+1==paikat[1]) && (paikat[1]+1==paikat[2])) {
                if (paikat[0]==p1i) {
                    if (paikat[1]==p2i) {
                        return onkoKuvakortitJarjestyksessa(paikka1,paikka2,paikka3);
                    }
                    else {
                        return onkoKuvakortitJarjestyksessa(paikka1,paikka3,paikka2);
                    }
                }
                else if (paikat[0]==p2i) {
                    if (paikat[1]==p1i) {
                        return onkoKuvakortitJarjestyksessa(paikka2,paikka1,paikka3);
                    }
                    else {
                        return onkoKuvakortitJarjestyksessa(paikka2,paikka3,paikka1);
                    }
                }
                else {
                    if (paikat[1]==p2i) {
                        return onkoKuvakortitJarjestyksessa(paikka3,paikka2,paikka1);
                    }
                    else {
                        return onkoKuvakortitJarjestyksessa(paikka3,paikka1,paikka2);
                    }
                }
            }
        }
         return false;
    }
    /**
    * Metodi tarkastaa ovatko valitut kuvakortit oikeassa järjestyksessä.
    * @param paikka1 paikka jolla pienin indeksi pöydällä
    * @param paikka2 paikka jolla toiseksi pienin indeksi pöydällä
    * @param paikka3 paikka jolla suurin indeksi pöydällä
    * @see pasianssi.domain.Kortti#getArvo() 
    * @return onko kortit oikeassa jarjestyksessa
    */
    public boolean onkoKuvakortitJarjestyksessa(Paikka paikka1, Paikka paikka2, Paikka paikka3) {
        if (paikka1.getKortti().getArvo()==11) {
            if (paikka2.getKortti().getArvo()==12) {
                if (paikka3.getKortti().getArvo()==13) {
                    return true;
                }
            }
        }
        else {
            if (paikka3.getKortti().getArvo()==11) {
                if (paikka2.getKortti().getArvo()==12) {
                    if (paikka1.getKortti().getArvo()==13) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
