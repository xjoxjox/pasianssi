
package pasianssi.pasianssi;

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
        assertFalse(pakka.onkoPakkaTyhja());
    }
    
    @Test
    public void asettaaOikeanArvoisenKortinPakkaan() {
        pakka.lisaaKortti(kortti);
        assertEquals(1, pakka.pakanKortit().get(0).getArvo());
    }
}