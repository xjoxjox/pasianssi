
package pasianssi.pasianssi;

import java.util.ArrayList;
import java.util.Random;

public class Pakka {
    private ArrayList<Kortti> pakka;
    private ArrayList<Kortti> sekoitettu;
    
    public Pakka() {
        this.pakka = new ArrayList<Kortti>(52);
        this.sekoitettu = new ArrayList<Kortti>(52);
    }
    
    public void lisaaKortti(Kortti kortti) {
        pakka.add(kortti);
    }
    
    public void sekoitaPakka() {
        Random r = new Random();
        int j = 52;
        for (int i = 0; i < 52; i++) {
            int indeksi = r.nextInt(j);
            sekoitettu.add(pakka.get(indeksi));
            pakka.remove(indeksi);
            j--;
        }
    }
    
    public void poistaKortti(Kortti kortti) {
        this.sekoitettu.remove(kortti);
        this.pakka.add(kortti);
    }
    
    public boolean onkoSekoitettuTyhja() {
        return sekoitettu.isEmpty();
    }
    
    public boolean onkoPakkaTyhja() {
        return pakka.isEmpty();
    }
    
    public ArrayList<Kortti> pakanKortit() {
        return this.pakka;
    }
    
    public ArrayList<Kortti> sekoitetunPakanKortit() {
        return this.sekoitettu;
    }
}
