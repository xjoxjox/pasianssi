
package pasianssi.util;

import org.junit.Test;
import org.junit.Before;
import pasianssi.domain.Paikka;
import static org.junit.Assert.*;

public class RivienTarkastajaTest {
    private RivienTarkastaja tarkastaja;
    private Paikka a;
    private Paikka b;
    private Paikka c;
    private Paikka d;
    private Paikka e;
    private Paikka f;
    private Paikka g;

    public RivienTarkastajaTest() {
    }
    
    @Before
    public void setUp() {
        tarkastaja = new RivienTarkastaja();
        a = new Paikka(1, 4);
        b = new Paikka(1, 5);
        c = new Paikka(2, 5);
        d = new Paikka(2, 4);
        e = new Paikka(2, 3);
        f = new Paikka(4, 2);
        g = new Paikka(5, 4);
    }
    
    @Test
    public void tarkistaaOikeinOvatkoPaikatSamallaRivilla() {
        assertTrue(tarkastaja.onkoParinPaikatSamallaRivilla(a, b));
    }
    
    @Test
    public void tarkistaaOikeinOvatkoPaikatSamallaRivilla2() {
        assertTrue(tarkastaja.onkoParinPaikatSamallaRivilla(b, c));
    }
    
    @Test
    public void tarkistaaOikeinOvatkoPaikatSamallaRivilla3() {
        assertFalse(tarkastaja.onkoParinPaikatSamallaRivilla(a, c));
    }
    
    @Test
    public void tarkistaaOikeinOvatkoPaikatSamallaRivilla4() {
        assertFalse(tarkastaja.onkoParinPaikatSamallaRivilla(f, g));
    }
    
    @Test
    public void tarkistaaOikeinOvatkoKuvakorttienPaikatSamallaRivilla() {
        assertTrue(tarkastaja.onkoKuvakorttienPaikatSamallaRivilla(c, d, e));
    }
    
    @Test
    public void tarkistaaOikeinOvatkoKuvakorttienPaikatSamallaRivilla2() {
        assertFalse(tarkastaja.onkoKuvakorttienPaikatSamallaRivilla(c, d, b));
    }
    
    @Test
    public void tarkistaaOikeinOvatkoKuvakorttienPaikatSamallaRivilla3() {
        assertFalse(tarkastaja.onkoKuvakorttienPaikatSamallaRivilla(f, g, a));
    }
    
    @Test
    public void tarkistaaOikeinOvatkoKuvakorttienPaikatSamallaRivilla4() {
        assertTrue(tarkastaja.onkoKuvakorttienPaikatSamallaRivilla(a, d, g));
    }
}
