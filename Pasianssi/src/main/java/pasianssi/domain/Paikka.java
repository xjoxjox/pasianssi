
package pasianssi.domain;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
/**
 * @author Johanna
 * Luokka luo paikat, joista Pöytä koostuu, sekä asettaa ja poistaa Kortit paikasta.
 */
public class Paikka {
    private int pystyrivi;
    private int vaakarivi;
    private Kortti kortti;
    private boolean tyhja;
    private boolean valittu;
    /**
    * Konstruktorissa tarkistetaan ettei Paikka saa vääriä arvoja.
    * Jos parametrit eivät kelpaa, annetaan virheilmoitus.
    * @param pystyrivi pystyrivin numero
    * @param vaakarivi vaakarivin numero
    */
    public Paikka(int pystyrivi, int vaakarivi) {
        if (pystyrivi < 1 || pystyrivi > 5) {
            throw new IllegalArgumentException("Pystyrivin arvon täytyy olla 1-5");
        }
        if (vaakarivi < 1 || vaakarivi > 5) {
            throw new IllegalArgumentException("Vaakarivin arvon täytyy olla 1-5");
        }
        this.pystyrivi = pystyrivi;
        this.vaakarivi = vaakarivi;
        this.tyhja = true;
        this.valittu = false;
    }
    /**
    * Metodi asettaa kortin paikkaan.
    * @param kortti Jakaja luokan syöttämä kortti
    */
    public void asetaKortti(Kortti kortti) {
        this.kortti = kortti;
        this.tyhja = false;
    }
    /**
    * Metodi palauttaa totuusarvona onko paikka tyhjä.
    * @return paikan tyhjyys
    */
    public boolean onkoTyhja() {
        return this.tyhja;
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
        this.tyhja = true;
    }
    /**
    * Metodi hakee oikean kuvan paikalle, jos siinä on kortti.
    * @throws java.io.IOException jos kuvaa ei löydy
    * @see pasianssi.domain.Paikka#kuvaNegaatio(BufferedImage)
    * @return Kortin kuva
    */
    public Image haeKuva() throws IOException {
        Image kuva = null;
        if (onkoTyhja()) {
            return kuva;
        } else if (!getValittu()) {
            String tiedosto = getKortti().toString();
            URL kuvaURL = getClass().getResource("/" + tiedosto + "R.jpg");
            BufferedImage img = ImageIO.read(kuvaURL);
            kuva = img;
        } else {
            String tiedosto = getKortti().toString();
            URL kuvaURL = getClass().getResource("/" + tiedosto + "R.jpg");
            BufferedImage img = ImageIO.read(kuvaURL);
            kuvaNegaatio(img);
            kuva = img;
        }
        return kuva;
    }
    /**
    * Metodi tuottaa annetusta kuvasta kuvan jossa on värit negaationa.
    * @param kuva valitun Paikan kuva.
    * @return kuva negaationa
    */
    private BufferedImage kuvaNegaatio(BufferedImage kuva) {
        int leveys = kuva.getWidth();
        int korkeus = kuva.getHeight();
        for (int x = 0; x < leveys; x++) {
            for (int y = 0; y < korkeus; y++) {
                int rGB = kuva.getRGB(x, y);
                int r = Math.abs(((rGB >>> 16) & 0xff) - 255);
                int g = Math.abs(((rGB >>> 8) & 0xff) - 255);
                int b = Math.abs((rGB & 0xff) - 255);
                kuva.setRGB(x, y, (r << 16) | (g << 8) | b);
            }
        }        
        return kuva;
    }
}
