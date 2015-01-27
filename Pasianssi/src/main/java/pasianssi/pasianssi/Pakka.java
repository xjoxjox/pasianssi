
package pasianssi.pasianssi;

import java.util.ArrayList;
import java.util.Collections;

public class Pakka {
    private final ArrayList<Kortti> pakka;
    
    public Pakka() {
        this.pakka = new ArrayList<>(52);
    }
    
    public void lisaaKortti(Kortti kortti) {
        pakka.add(kortti);
    }
    
    public void sekoitaPakka() {
        Collections.shuffle(pakka);   
    }
    
    public void poistaKortti(Kortti kortti) {
        this.pakka.remove(kortti);
    }
    
    public boolean onkoTyhja() {
        return pakka.isEmpty();
    }
    
    public ArrayList<Kortti> pakanKortit() {
        return this.pakka;
    }
}
