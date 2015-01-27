
package pasianssi.pasianssi;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Luokka luo pakan, joka sekoitetaan ja josta jaetaan kortit pöydälle.
 */
public class Pakka {
    private final ArrayList<Kortti> pakka;
    
    public Pakka() {
        this.pakka = new ArrayList<>(52);
    }
    /**
    * Metodi lisää kortin pakkaan.
    * @param kortti pelin alustuksessa syötetty kortti
    */
    public void lisaaKortti(Kortti kortti) {
        pakka.add(kortti);
    }
    /**
    * Metodi sekoittaa pakan.
    */
    public void sekoitaPakka() {
        Collections.shuffle(pakka);   
    }
    /**
    * Metodi poistaa kortin pakasta.
    * @param kortti Jakaja luokan syöttämä kortti
    */
    public void poistaKortti(Kortti kortti) {
        this.pakka.remove(kortti);
    }
    /**
    * Metodi tarkistaa onko pakka tyhjä.
    * @return pakan tyhjyys
    */
    public boolean onkoTyhja() {
        return pakka.isEmpty();
    }
    /**
    * Metodi palauttaa pakan kortit ArrayListinä.
    * @return pakan kortit
    */
    public ArrayList<Kortti> pakanKortit() {
        return this.pakka;
    }
}
