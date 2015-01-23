
package pasianssi.pasianssi;

import java.util.ArrayList;

public class Poyta {
    private ArrayList<Paikka> paikat;
    private ArrayList<Paikka> tyhjat;
    
    public Poyta() {
        this.paikat = new ArrayList<Paikka>(25);
    }
    
    public ArrayList<Paikka> getTyhjat() {
        for (int i = 0; i < this.paikat.size(); i++) {
            if (this.paikat.get(i).onkoTyhja()) {
                this.tyhjat.add(this.paikat.get(i));
            }
        }
        return this.tyhjat;
    }
}
