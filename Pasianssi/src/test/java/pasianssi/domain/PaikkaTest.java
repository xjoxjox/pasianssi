
package pasianssi.domain;

import java.awt.Image;
import java.io.IOException;
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
        kortti = new Kortti(4, "Hertta");
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
    
    @Test
    public void asettaaKortinValituksi() {
        paikka.asetaValituksi();
        assertTrue(paikka.getValittu());
    }
    
    @Test
    public void poistaaKortinValinnan() {
        paikka.asetaValituksi();
        paikka.poistaValinta();
        assertFalse(paikka.getValittu());
    }
    
    @Test
    public void nayttaaOikeinKortinValinnan() {
        paikka.asetaValituksi();
        boolean valinta = paikka.getValittu();
        assertTrue(valinta);
    }
    
    @Test
    public void eiLuoPaikkaaVaarillaArvoilla() {
        boolean tapahtuikovirhe = false;
        try {
            Paikka paikka2 = new Paikka(0, 4);
        }
        catch (IllegalArgumentException e) {
            tapahtuikovirhe = true;
        }

        assertTrue(tapahtuikovirhe);
    }
    
    @Test
    public void eiLuoPaikkaaVaarillaArvoilla2() {
        boolean tapahtuikovirhe = false;
        try {
            Paikka paikka2 = new Paikka(6, 4);
        }
        catch (IllegalArgumentException e) {
            tapahtuikovirhe = true;
        }

        assertTrue(tapahtuikovirhe);
    }
    
    @Test
    public void eiLuoPaikkaaVaarillaArvoilla3() {
        boolean tapahtuikovirhe = false;
        try {
            Paikka paikka2 = new Paikka(4, 6);
        }
        catch (IllegalArgumentException e) {
            tapahtuikovirhe = true;
        }

        assertTrue(tapahtuikovirhe);
    }
    
    @Test
    public void eiLuoPaikkaaVaarillaArvoilla4() {
        boolean tapahtuikovirhe = false;
        try {
            Paikka paikka2 = new Paikka(4, 0);
        }
        catch (IllegalArgumentException e) {
            tapahtuikovirhe = true;
        }

        assertTrue(tapahtuikovirhe);
    }
    
    @Test
    public void hakeeKuvan() throws IOException {
        boolean saikokuvan = false;
        paikka.asetaKortti(kortti);
        Image kuva = paikka.haeKuva();
        if (kuva!=null) {
            saikokuvan = true;
        }
        assertTrue(saikokuvan);
    }
}