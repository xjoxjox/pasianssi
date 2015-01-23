
package pasianssi.pasianssi;

public class Kortti {
    private int arvo;
    private String maa;
    private Pakka pakka;
    
    public Kortti(int arvo, String maa) {
        this.arvo = arvo;
        this.maa = maa;
    }
    
    public int getArvo() {
        return this.arvo;
    }
    
    public String getMaa() {
        return this.maa;
    }
}
