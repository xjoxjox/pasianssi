
package pasianssi.domain;

import java.util.ArrayList;
/**
 * @author Johanna
 * Luokka luo pöydän paikkoineen. Luokka myös tarkastaa kaikki tyhjät paikat tai 
 * onko korttien välissä tyhjiä paikkoja sekä viimeisen paikan, jossa on kortti.
 */
public class Poyta {
    private ArrayList<Paikka> paikat;
    
    public Poyta() {
        this.paikat = new ArrayList<>(25);
    }
    /**
    * Metodi luo paikat pöydälle.
    * @see pasianssi.domain.Poyta#lisaaPaikka(Paikka)
    */
    public void luoPaikat() {
        for (int z = 1; z <= 5; z++) {
            for (int x = 1; x <= 5; x++) {
                Paikka paikka = new Paikka(z, x);
                lisaaPaikka(paikka);
            }
        }
    }
    /**
    * Metodi lisaa paikan pöydälle.
    * @param paikka pelin alustuksessa syötetty Paikka
    */
    public void lisaaPaikka(Paikka paikka) {
        if (!this.paikat.contains(paikka)) {
            this.paikat.add(paikka);
        }
    }
    /**
    * Metodi palauttaa ArrayListin tyhjistä paikoista.
    * @return pöydän tyhjät Paikat
    */
    public ArrayList<Paikka> getTyhjat() {
        ArrayList<Paikka> tyhjat = new ArrayList<>(25);
        for (Paikka paikka : this.paikat) {
            if (paikka.onkoTyhja()) {
                tyhjat.add(paikka);
            }
        }
        return tyhjat;
    }
    /**
    * Metodi palauttaa ArrayListin valituista paikoista.
    * @return pöydän paikat jotka ovat valittuina
    */
    public ArrayList<Paikka> valitutKortit() {
        ArrayList<Paikka> valitut = new ArrayList<>(3);
        for (Paikka paikka : this.paikat) {
            if (paikka.getValittu()) {
                valitut.add(paikka);
            }
        }
        return valitut;
    }
    
    public ArrayList<Paikka> getPaikat() {
        return this.paikat;
    }
    /**
    * Metodi kertoo onko korttien välissä tyhjiä paikkoja.
    * @see pasianssi.domain.Paikka#onkoTyhja()  
    * @return tyhjät paikat korttien välissä
    */
    public boolean onkoKorttienValissaTyhjia() {
        for (int i = 0; i < this.paikat.size() - 1; i++) {
            if (this.paikat.get(i).onkoTyhja()) {             
                for (int j = i + 1; j < this.paikat.size(); j++) {
                    if (!this.paikat.get(j).onkoTyhja()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /**
    * Metodi palauttaa viimeisen paikan, jossa on kortti.
    * @see pasianssi.domain.Paikka#onkoTyhja() 
    * @return viimeinen paikka jossa kortti
    */
    public Paikka viimeinenPaikkaJossaKortti() {
        Paikka viimeinen = this.paikat.get(0);
        for (int i = 1; i <= this.paikat.size(); i++) {
            if (!this.paikat.get(this.paikat.size() - i).onkoTyhja()) {
                viimeinen = this.paikat.get(this.paikat.size() - i);
                return viimeinen;
            }
        }
        return viimeinen;
    }
}
