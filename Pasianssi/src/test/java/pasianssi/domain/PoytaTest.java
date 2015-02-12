
package pasianssi.domain;

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
    public void nayttaaPaikatOikein() {      
        poyta.lisaaPaikka(paikka);
        poyta.lisaaPaikka(new Paikka(3,4));
        poyta.lisaaPaikka(new Paikka(4,4));
        poyta.lisaaPaikka(new Paikka(1,4));
        assertEquals(4, poyta.getPaikat().size());
    }
    
    @Test
    public void nayttaaTyhjatPaikatOikein() {      
        poyta.lisaaPaikka(paikka);
        poyta.lisaaPaikka(new Paikka(3,4));
        poyta.lisaaPaikka(new Paikka(4,4));
        poyta.lisaaPaikka(new Paikka(1,4));
        assertEquals(4, poyta.getTyhjat().size());
    }
    
    @Test
    public void nayttaaValitutPaikatOikein() {
        Paikka paikka2 = new Paikka(3,4);
        Paikka paikka3 = new Paikka(4,4);
        paikka.asetaValituksi();
        paikka2.asetaValituksi();
        paikka3.asetaValituksi();
        poyta.lisaaPaikka(paikka);
        poyta.lisaaPaikka(paikka2);
        poyta.lisaaPaikka(paikka3);
        assertEquals(3, poyta.valitutKortit().size());
    }
    @Test
    public void palauttaaOikeanArvonJosKorttienValissaOnTyhjiaPaikkoja() {
        paikka.asetaKortti(new Kortti(1, "Hertta"));
        Paikka paikka2 = new Paikka(3,4);
        Paikka paikka3 = new Paikka(4,4);
        paikka3.asetaKortti(new Kortti(4, "Hertta"));
        Paikka paikka4 = new Paikka(1,4);
        paikka4.asetaKortti(new Kortti(6, "Hertta"));
        Paikka paikka5 = new Paikka(2,5);
        Paikka paikka6 = new Paikka(1,2);
        paikka6.asetaKortti(new Kortti(8, "Hertta"));
        poyta.lisaaPaikka(paikka);
        poyta.lisaaPaikka(paikka2);
        poyta.lisaaPaikka(paikka3);
        poyta.lisaaPaikka(paikka4);
        poyta.lisaaPaikka(paikka5);
        poyta.lisaaPaikka(paikka6);
        
        assertTrue(poyta.onkoKorttienValissaTyhjia());
    }
    
    @Test
    public void palauttaaOikeanPaikanJossaViimeinenKortti() {
        paikka.asetaKortti(new Kortti(1, "Hertta"));
        Paikka paikka2 = new Paikka(3,4);
        Paikka paikka3 = new Paikka(4,4);
        paikka3.asetaKortti(new Kortti(4, "Hertta"));
        Paikka paikka4 = new Paikka(1,4);
        paikka4.asetaKortti(new Kortti(6, "Hertta"));
        Paikka paikka5 = new Paikka(2,5);
        paikka5.asetaKortti(new Kortti(8, "Hertta"));
        Paikka paikka6 = new Paikka(1,2);
        
        poyta.lisaaPaikka(paikka);
        poyta.lisaaPaikka(paikka2);
        poyta.lisaaPaikka(paikka3);
        poyta.lisaaPaikka(paikka4);
        poyta.lisaaPaikka(paikka5);
        poyta.lisaaPaikka(paikka6);
        
        assertEquals(paikka5, poyta.viimeinenPaikkaJossaKortti());
    }
    
    @Test
    public void luoPaikatOikein() {
        poyta.luoPaikat();
        
        assertEquals(25,poyta.getPaikat().size());
    }
}