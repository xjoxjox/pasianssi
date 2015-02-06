
package pasianssi.domain;

import pasianssi.domain.Kortti;
import pasianssi.domain.Pakka;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PakkaTest {
    private Pakka pakka;
    private Kortti kortti;
    
    public PakkaTest() {
    }
    
    @Before
    public void setUp() {
        pakka = new Pakka();
        kortti = new Kortti(1, "hertta");
    }
    
    @Test
    public void asettaaKortinPakkaan() {
        pakka.lisaaKortti(kortti);
        assertFalse(pakka.onkoTyhja());
    }
    
    @Test
    public void asettaaOikeanArvoisenKortinPakkaan() {
        pakka.lisaaKortti(kortti);
        assertEquals(1, pakka.pakanKortit().get(0).getArvo());
    }
    
    @Test
    public void sekoittaaPakan() {
        Kortti kortti2 = new Kortti(2, "ruutu");
        Kortti kortti3 = new Kortti(7, "ruutu");
        Kortti kortti4 = new Kortti(9, "risti");
        pakka.lisaaKortti(kortti);
        pakka.lisaaKortti(kortti2);
        pakka.lisaaKortti(kortti3);
        pakka.lisaaKortti(kortti4);
        
        pakka.sekoitaPakka();
        boolean sekoitus = true;
        if (pakka.pakanKortit().get(0).getArvo()!=1 && !pakka.pakanKortit().get(0).getMaa().equals("hertta")) {
                sekoitus = false;
        }
        if (pakka.pakanKortit().get(1).getArvo()!=2 && !pakka.pakanKortit().get(1).getMaa().equals("ruutu")) {
                sekoitus = false;
        }
        if (pakka.pakanKortit().get(2).getArvo()!=7 && !pakka.pakanKortit().get(2).getMaa().equals("ruutu")) {
                sekoitus = false;
        }
        if (pakka.pakanKortit().get(3).getArvo()!=9 && !pakka.pakanKortit().get(3).getMaa().equals("risti")) {
                sekoitus = false;
        }
        
        assertFalse(sekoitus);
    }
    
    @Test
    public void poistaaKortinPakasta() {
        pakka.lisaaKortti(new Kortti(3, "hertta"));
        pakka.lisaaKortti(new Kortti(5, "ruutu"));
        pakka.lisaaKortti(kortti);
        pakka.lisaaKortti(new Kortti(13, "hertta"));
        pakka.lisaaKortti(new Kortti(10, "pata"));
        pakka.lisaaKortti(new Kortti(3, "risti"));
        pakka.poistaKortti(kortti);       
        
        assertFalse(pakka.pakanKortit().contains(kortti));
    }
    
    @Test
    public void luoPakanOikein() {
        pakka.luoPakka();
        
        assertEquals(52,pakka.pakanKortit().size());
    }
}