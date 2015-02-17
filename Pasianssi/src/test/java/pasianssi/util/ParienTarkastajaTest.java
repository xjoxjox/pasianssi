
package pasianssi.util;

import org.junit.Before;
import org.junit.Test;
import pasianssi.domain.Kortti;
import static org.junit.Assert.*;

public class ParienTarkastajaTest {
    private ParienTarkastaja tarkastaja;
    private Kortti J;
    private Kortti Q;
    private Kortti K;
    private Kortti kaksi;
    private Kortti viisi;
    private Kortti kuusi;
    private Kortti yhdeksan;
    private Kortti kolme;
    
    public ParienTarkastajaTest() {
    }
    
    @Before
    public void setUp() {
        tarkastaja = new ParienTarkastaja();
        J = new Kortti(11, "Hertta");
        Q = new Kortti(12, "Hertta");
        K = new Kortti(13, "Hertta");
        kaksi = new Kortti(2, "Hertta");
        viisi = new Kortti(5, "Hertta");
        kuusi = new Kortti(6, "Hertta");
        yhdeksan = new Kortti(9, "Hertta");
        kolme = new Kortti(3, "Hertta");
    }

    @Test
    public void tarkistaaOikeinOvatkoKortitKuvakortteja() {
        assertTrue(tarkastaja.ovatkoValitutKuvakortteja(J, Q));
    }
    
    @Test
    public void tarkistaaOikeinOvatkoKortitKuvakortteja2() {
        assertFalse(tarkastaja.ovatkoValitutKuvakortteja(kolme, Q));
    }
    
    @Test
    public void tarkistaaOikeinOvatkoKortitKuvakortteja3() {
        assertFalse(tarkastaja.ovatkoValitutKuvakortteja(kolme, viisi));
    }
    
    @Test
    public void tarkistaaOikeinOvatkoKortitPareja() {
        assertTrue(tarkastaja.ovatkoValitutKortitPari(kuusi, viisi));
    }
    
    @Test
    public void tarkistaaOikeinOvatkoKortitPareja2() {
        assertTrue(tarkastaja.ovatkoValitutKortitPari(viisi, kuusi));
    }
    
    @Test
    public void tarkistaaOikeinOvatkoKortitPareja3() {
        assertTrue(tarkastaja.ovatkoValitutKortitPari(kaksi, yhdeksan));
    }
    
    @Test
    public void tarkistaaOikeinOvatkoKortitPareja4() {
        assertTrue(tarkastaja.ovatkoValitutKortitPari(yhdeksan, kaksi));
    }
    
    @Test
    public void tarkistaaOikeinOvatkoKortitPareja5() {
        assertFalse(tarkastaja.ovatkoValitutKortitPari(yhdeksan, kolme));
    }
    
        @Test
    public void tarkistaaOikeinOvatkoKortitPareja6() {
        assertFalse(tarkastaja.ovatkoValitutKortitPari(kolme, J));
    }
    
        @Test
    public void tarkistaaOikeinOvatkoKortitPareja7() {
        assertFalse(tarkastaja.ovatkoValitutKortitPari(J, viisi));
    }
    
        @Test
    public void tarkistaaOikeinOvatkoKortitPareja8() {
        assertFalse(tarkastaja.ovatkoValitutKortitPari(kaksi, kaksi));
    }
    
    @Test
    public void tarkistaaOikeinOvatkoKuvakortitJarjestyksessa() {
        assertTrue(tarkastaja.ovatkoValitutKuvakorttejaJarjestyksessa(J, K, Q));
    }
    
    @Test
    public void tarkistaaOikeinOvatkoKuvakortitJarjestyksessa2() {
        assertTrue(tarkastaja.ovatkoValitutKuvakorttejaJarjestyksessa(K, J, Q));
    }
    
    @Test
    public void tarkistaaOikeinOvatkoKuvakortitJarjestyksessa3() {
        assertFalse(tarkastaja.ovatkoValitutKuvakorttejaJarjestyksessa(J, Q, K));
    }
    
    @Test
    public void tarkistaaOikeinOvatkoKuvakortitJarjestyksessa4() {
        assertFalse(tarkastaja.ovatkoValitutKuvakorttejaJarjestyksessa(Q, J, K));
    }
    
    @Test
    public void tarkistaaOikeinOvatkoKuvakortitJarjestyksessa5() {
        assertFalse(tarkastaja.ovatkoValitutKuvakorttejaJarjestyksessa(J, viisi, Q));
    }
    
    @Test
    public void tarkistaaOikeinOvatkoKuvakortitJarjestyksessa6() {
        assertFalse(tarkastaja.ovatkoValitutKuvakorttejaJarjestyksessa(viisi, J, Q));
    }
}
