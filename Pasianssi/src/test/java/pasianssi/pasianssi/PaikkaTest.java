
package pasianssi.pasianssi;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PaikkaTest {
    private Paikka paikka;
    private Kortti kortti;
    
    public PaikkaTest() {
    }
      @Before
    public void setUp() {
        paikka = new Paikka(3, 3);
        kortti = new Kortti(4, "hertta");
    }

    @Test
    public void konstruktoriAsettaaPaikanPystyrivinOikein() {
        assertEquals(3, paikka.getPystyrivi());
    }
    
    @Test
    public void konstruktoriAsettaaPaikanVaakarivinOikein() {
        assertEquals(3, paikka.getVaakarivi());
    }
    
    @Test
    public void konstruktoriAsettaaPaikanTyhjaksi() {
        assertTrue(paikka.onkoTyhja());
    }
    
    @Test
    public void asettaaKortinOikein() {
        paikka.asetaKortti(kortti);
        assertEquals(kortti, paikka.getKortti());
    }
    
    @Test
    public void asettaaPaikanTaytetyksiKunKorttiLisataan() {
        paikka.asetaKortti(kortti); 
        assertFalse(paikka.onkoTyhja());
    }
    
    @Test
    public void tyhjentaaPaikanOikein() {
        paikka.asetaKortti(kortti);
        paikka.tyhjennaPaikka();
        assertTrue(paikka.onkoTyhja());
    }
}