
package pasianssi.domain;

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
    
    @Test
    public void eiLuoKorttiaVaarillaArvoilla() {
        boolean tapahtuikovirhe = false;
        try {
            Kortti kortti2 = new Kortti(0, "hertta");
        }
        catch (IllegalArgumentException e) {
            tapahtuikovirhe = true;
        }

        assertTrue(tapahtuikovirhe);
    }
    
    @Test
    public void eiLuoKorttiaVaarillaArvoilla2() {
        boolean tapahtuikovirhe = false;
        try {
            Kortti kortti2 = new Kortti(14, "hertta");
        }
        catch (IllegalArgumentException e) {
            tapahtuikovirhe = true;
        }

        assertTrue(tapahtuikovirhe);
    }
    
    @Test
    public void eiLuoKorttiaVaarillaArvoilla3() {
        boolean tapahtuikovirhe = false;
        try {
            Kortti kortti2 = new Kortti(5, "rata");
        }
        catch (IllegalArgumentException e) {
            tapahtuikovirhe = true;
        }

        assertTrue(tapahtuikovirhe);
    }
    
        @Test
    public void eiLuoKorttiaVaarillaArvoilla4() {
        boolean tapahtuikovirhe = false;
        try {
            Kortti kortti2 = new Kortti(5, "pisti");
        }
        catch (IllegalArgumentException e) {
            tapahtuikovirhe = true;
        }

        assertTrue(tapahtuikovirhe);
    }
}