
package pasianssi.pasianssi;

public class Main {
        public static void main(String[] args) {
        
        Pakka pakka = new Pakka();
        Poyta poyta = new Poyta();

        for (int i = 0; i < 13; i++) {
            for (int j = 1; j <= 4; j++) {
                if (j == 1) {
                    Kortti kortti = new Kortti(i, "hertta");
                    pakka.lisaaKortti(kortti);
                }
                if (j ==2 ) {
                    Kortti kortti = new Kortti(i, "ruutu");
                    pakka.lisaaKortti(kortti);
                }
                if (j == 3) {
                    Kortti kortti = new Kortti(i, "risti");
                    pakka.lisaaKortti(kortti);
                }
                if (j == 4) {
                    Kortti kortti = new Kortti(i, "pata");
                    pakka.lisaaKortti(kortti);
                }
            }
        }
        
        for (int z = 1; z <= 5; z++) {
            for (int x = 1; x <= 5; x++) {
                Paikka paikka = new Paikka(z, x);
                poyta.lisaaPaikka(paikka);
            }
        }
    }
}
