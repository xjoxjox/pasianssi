
package pasianssi.util;

import org.junit.Test;
import org.junit.Before;
import pasianssi.domain.Paikka;
import static org.junit.Assert.*;
import pasianssi.domain.Kortti;

public class RivienTarkastajaTest {
    private RivienTarkastaja tarkastaja;
    private Paikka a;
    private Paikka b;
    private Paikka c;
    private Paikka d;
    private Paikka e;
    private Paikka f;
    private Paikka g;
    private Kortti Q;
    private Kortti K;
    private Kortti J;
    private Kortti Viisi;

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
        g = new Paikka(3, 4);
        Q = new Kortti(12, "Hertta");
        K = new Kortti(13, "Hertta");
        J = new Kortti(11, "Hertta");
        Viisi = new Kortti(5, "Hertta");
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
    public void tarkistaaOikeinOvatkoKuvakortitVierekkainJaSamallaRivilla() {
        a.asetaKortti(J);
        d.asetaKortti(Q);
        g.asetaKortti(K);
        assertTrue(tarkastaja.onkoKuvakortitVierekkäin(a, d, g));
    }
    
    @Test
    public void tarkistaaOikeinOvatkoKuvakortitVierekkainJaSamallaRivilla2() {
        a.asetaKortti(Q);
        d.asetaKortti(J);
        g.asetaKortti(K);
        assertFalse(tarkastaja.onkoKuvakortitVierekkäin(a, d, g));
    }
    
    @Test
    public void tarkistaaOikeinOvatkoKuvakortitVierekkainJaSamallaRivilla3() {
        f.asetaKortti(J);
        g.asetaKortti(Q);
        a.asetaKortti(K);
        assertFalse(tarkastaja.onkoKuvakortitVierekkäin(f, g, a));
    }
    
    @Test
    public void tarkistaaOikeinOvatkoKuvakortitVierekkainJaSamallaRivilla4() {
        e.asetaKortti(K);
        d.asetaKortti(Q);
        c.asetaKortti(J);
        assertTrue(tarkastaja.onkoKuvakortitVierekkäin(d, c, e));
    }
    
    @Test
    public void tarkistaaOikeinOvatkoKuvakortitVierekkainJaSamallaRivilla5() {
        a.asetaKortti(K);
        d.asetaKortti(Q);
        g.asetaKortti(Viisi);
        assertFalse(tarkastaja.onkoKuvakortitVierekkäin(a, d, g));
    }
}
