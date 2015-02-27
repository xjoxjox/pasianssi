
package pasianssi.domain;
/**
 * @author Johanna
 * Luokka luo kortit, joista Pakka koostuu.
 */
public class Kortti {
    private int arvo;
    private String maa;
    /**
    * Konstruktorissa tarkistetaan ettei Kortti saa vääriä arvoja.
    * Jos parametrit eivät kelpaa, annetaan virheilmoitus.
    * @param arvo Kortin arvo
    * @param maa Kortin maa
    */
    public Kortti(int arvo, String maa) {
        if (arvo < 1 || arvo > 13) {
            throw new IllegalArgumentException("Kortin arvon täytyy olla 1-13");
        }
        boolean oikeamaa = false;
        if (maa.compareTo("Hertta") == 0 || maa.compareTo("Ruutu") == 0 || maa.compareTo("Risti") == 0 || maa.compareTo("Pata") == 0) {
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
    
    @Override
    public String toString() {
        return Integer.toString(this.arvo) + this.maa;
    }
}
