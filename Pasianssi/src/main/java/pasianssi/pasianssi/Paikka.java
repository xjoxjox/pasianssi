
package pasianssi.pasianssi;

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
    
    public void asetaKortti(Kortti kortti) {
        this.kortti = kortti;
        this.tyhjä = false;
    }
    
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
    
    public void tyhjennaPaikka() {
        this.kortti = null;
        this.tyhjä = true;
    }
}
