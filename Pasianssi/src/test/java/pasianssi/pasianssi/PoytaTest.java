
package pasianssi.pasianssi;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PoytaTest {
    private Paikka paikka;
    private Poyta poyta;
    
    public PoytaTest() {
    }
    
    @Before
    public void setUp() {
        poyta = new Poyta();
        paikka = new Paikka(3, 3);
    }
   
    @Test
    public void asettaaPaikanPoydalle() {      
        poyta.lisaaPaikka(paikka);
        assertFalse(poyta.getPaikat().isEmpty());
    }
    
    @Test
    public void nayttaaTyhjatOikein() {      
        poyta.lisaaPaikka(paikka);
        poyta.lisaaPaikka(new Paikka(3,4));
        poyta.lisaaPaikka(new Paikka(4,4));
        poyta.lisaaPaikka(new Paikka(1,4));
        assertEquals(4, poyta.getPaikat().size());
    }
    
    @Test
    public void eiAsetaPaikkaaJosSeOnPoydalla() {      
        poyta.lisaaPaikka(paikka);
        poyta.lisaaPaikka(paikka);
        assertEquals(1, poyta.getPaikat().size());
    }   
}