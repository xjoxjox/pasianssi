
package pasianssi.domain;


/**
 * Luokka luo paikat, joista Pöytä koostuu, sekä asettaa ja poistaa Kortit paikasta.
 */
public class Paikka {
    private int pystyrivi;
    private int vaakarivi;
    private Kortti kortti;
    private boolean tyhjä;
    private boolean valittu;
    
    public Paikka(int pystyrivi, int vaakarivi) {
        if (pystyrivi<1 || pystyrivi>5) {
            throw new IllegalArgumentException("Pystyrivin arvon täytyy olla 1-5");
        }
        if (vaakarivi<1 || vaakarivi>5) {
            throw new IllegalArgumentException("Vaakarivin arvon täytyy olla 1-5");
        }
        this.pystyrivi = pystyrivi;
        this.vaakarivi = vaakarivi;
        this.tyhjä = true;
        this.valittu = false;
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
    
     public boolean getValittu() {
         return this.valittu;
    }
    /**
    * Metodi asettaa paikan valituksi.
    */
    public void asetaValituksi() {
        this.valittu = true;
    }
    /**
    * Metodi poistaa paikan valinnan.
    */
    public void poistaValinta() {
        this.valittu = false;
    }
    /**
    * Metodi ottaa kortin pois paikasta.
    */
    public void tyhjennaPaikka() {
        this.kortti = null;
        this.tyhjä = true;
    }
}
