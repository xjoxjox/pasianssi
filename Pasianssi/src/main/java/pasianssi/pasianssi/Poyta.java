
package pasianssi.pasianssi;

import java.util.ArrayList;

public class Poyta {
    private ArrayList<Paikka> paikat;
    
    public Poyta() {
        this.paikat = new ArrayList<>(25);
    }
    
    public void lisaaPaikka(Paikka paikka) {
        if (!this.paikat.contains(paikka)) {
            this.paikat.add(paikka);
        }
    }
    
    public ArrayList<Paikka> getTyhjat() {
        ArrayList<Paikka> tyhjat = new ArrayList<>(25);
        for (Paikka paikka : this.paikat) {
            if (paikka.onkoTyhja()) {
                tyhjat.add(paikka);
            }
        }
        return tyhjat;
    }
    
    public ArrayList<Paikka> getPaikat() {
        return this.paikat;
    }
    
    public boolean onkoKorttienValissaTyhjia() {
        for (int i = 0; i < this.paikat.size()-1; i++) {
            if (this.paikat.get(i).onkoTyhja()) {             
                for (int j = i+1; j < this.paikat.size(); j++) {
                    if (!this.paikat.get(j).onkoTyhja()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public Paikka viimeinenPaikkaJossaKortti() {
        Paikka viimeinen = this.paikat.get(0);
        for (int i = 1; i <= this.paikat.size(); i++) {
            if (!this.paikat.get(this.paikat.size()-i).onkoTyhja()) {
                viimeinen = this.paikat.get(this.paikat.size()-i);
                return viimeinen;
            }
        }
        return viimeinen;
    }
}
