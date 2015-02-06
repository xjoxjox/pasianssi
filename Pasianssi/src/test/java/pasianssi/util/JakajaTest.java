
package pasianssi.util;

import pasianssi.domain.Poyta;
import pasianssi.util.Jakaja;
import pasianssi.domain.Paikka;
import pasianssi.domain.Kortti;
import pasianssi.domain.Pakka;
import org.junit.Before;
import org.junit.Test;
import pasianssi.domain.Kortti;
import pasianssi.domain.Paikka;
import pasianssi.domain.Pakka;
import pasianssi.domain.Poyta;
import static org.junit.Assert.*;

public class JakajaTest {
    private Jakaja tyhjaanjakaja;
    private Jakaja tayteenjakaja;
    private Jakaja taytettyynjakaja;
    private Poyta tyhjapoyta;
    private Poyta taytettypoyta;
    private Pakka pakka;
    private Pakka tyhjapakka;
    
    public JakajaTest() {
    }

    @Before
    public void setUp() {
        tyhjapoyta = new Poyta();
        taytettypoyta = new Poyta();
        pakka = new Pakka();
        tyhjapakka = new Pakka();
        
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j <= 4; j++) {
                if (j == 1) {
                    Kortti kortti = new Kortti(i, "hertta");
                    pakka.lisaaKortti(kortti);
                }
                if (j == 2) {
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
                tyhjapoyta.lisaaPaikka(paikka);
            }
        }
        
        for (int z = 1; z <= 5; z++) {
            for (int x = 1; x <= 5; x++) {
                Paikka paikka = new Paikka(z, x);
                taytettypoyta.lisaaPaikka(paikka);
                if ((z==1 || z==2) && (x==2 || x==3 || x==5)) {
                paikka.asetaKortti(pakka.pakanKortit().get(0));
                }
            }
        }
        tyhjaanjakaja = new Jakaja(pakka, tyhjapoyta);
        tayteenjakaja = new Jakaja(tyhjapakka, taytettypoyta);
        taytettyynjakaja = new Jakaja(pakka, taytettypoyta);
    }

    @Test
    public void jakaaKortitOikeinTyhjaanPoytaan() {
        tyhjaanjakaja.jaaKortit();
        int korttienlukumaara = 0;
        for (Paikka paikka : tyhjapoyta.getPaikat()) {
            if (!paikka.onkoTyhja()) {
                korttienlukumaara++;
            }
        }  
        assertEquals(12, korttienlukumaara);
    }
    
    @Test
    public void jakaaKortitOikeinPakasta() {
        taytettyynjakaja.jaaKortit();
        assertFalse(taytettypoyta.onkoKorttienValissaTyhjia());
    }
    
    @Test
    public void siirtaaKortitOikeinTyhjastaPakasta() {
        tayteenjakaja.siirraKortitTyhjiin();
        assertFalse(taytettypoyta.onkoKorttienValissaTyhjia());
    } 
}
