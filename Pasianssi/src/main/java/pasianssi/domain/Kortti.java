
package pasianssi.domain;
/**
 * Luokka luo kortit, joista Pakka koostuu.
 */
public class Kortti {
    private int arvo;
    private String maa;
    
    public Kortti(int arvo, String maa) {
        if (arvo<1 || arvo>13) {
            throw new IllegalArgumentException("Kortin arvon täytyy olla 1-13");
        }
        boolean oikeamaa = false;
        if (maa.compareTo("hertta")==0 || maa.compareTo("ruutu")==0 || maa.compareTo("risti")==0 || maa.compareTo("pata")==0) {
            oikeamaa = true;
        }
        if (oikeamaa == false) {
            throw new IllegalArgumentException("Kortin maan täytyy olla hertta, ruutu, risti tai pata");
        }
            this.arvo = arvo;
            this.maa = maa;
    }
    
    public int getArvo() {
        return this.arvo;
    }
    
    public String getMaa() {
        return this.maa;
    }
}
