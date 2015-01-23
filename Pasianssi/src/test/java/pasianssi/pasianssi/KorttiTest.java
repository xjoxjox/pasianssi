
package pasianssi.pasianssi;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KorttiTest {
        private Kortti kortti;
        
    public KorttiTest() {
    }
    
    @Before
    public void setUp() {
        kortti = new Kortti(5, "hertta");
    }
    
    @Test
    public void konstruktoriAsettaaKortinArvonOikein() {
        assertEquals(5, kortti.getArvo());
    }
    
    @Test
    public void konstruktoriAsettaaKortinMaanOikein() {   
        assertEquals("hertta", kortti.getMaa());
    }
}