
package pasianssi.pasianssi;
/**
 * Luokka luo paikat, joista Pöytä koostuu, sekä asettaa ja poistaa Kortit paikasta.
 */
public class Paikka {
    private int pystyrivi;
    private int vaakarivi;
    private Kortti kortti;
    private boolean tyhjä;
    
    public Paikka(int pystyrivi, int vaakarivi) {
        this.pystyrivi = pystyrivi;
        this.vaakarivi = vaakarivi;
        this.tyhjä = true;
    }
    /**
    * Metodi asettaa kortin paikkaan.
    * @param kortti Jakaja luokan syöttämä kortti
    */
    public void asetaKortti(Kortti kortti) {
        this.kortti = kortti;
        this.tyhjä = false;
    }
    /**
    * Metodi palauttaa totuusarvona onko paikka tyhjä.
    * @return paikan tyhjyys
    */
    public boolean onkoTyhja() {
        return this.tyhjä;
    }
    
    public Kortti getKortti() {
        return this.kortti;
    }
    
    public int getPystyrivi() {
        return this.pystyrivi;
    }
    
     public int getVaakarivi() {
        return this.vaakarivi;
    }
    /**
    * Metodi ottaa kortin pois paikasta.
    */
    public void tyhjennaPaikka() {
        this.kortti = null;
        this.tyhjä = true;
    }
}
