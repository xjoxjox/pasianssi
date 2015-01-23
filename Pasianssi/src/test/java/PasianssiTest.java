/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pasianssi.pasianssi.Kortti;
import pasianssi.pasianssi.Paikka;

/**
 *
 * @author Johanna
 */
public class PasianssiTest {
    
    public PasianssiTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void konstruktoriAsettaaKortinArvonOikein() {
        Kortti kortti = new Kortti(1, "hertta");

        int arvo = kortti.getArvo(); 

        assertEquals(1, arvo);
    }
    
    @Test
    public void konstruktoriAsettaaKortinMaanOikein() {
        Kortti kortti = new Kortti(1, "hertta");

        String maa = kortti.getMaa(); 

        assertEquals("hertta", maa);
    }
    
    @Test
    public void konstruktoriAsettaaPaikanPystyrivinOikein() {
        Paikka paikka = new Paikka(1, 1);

        int pystyrivi = paikka.getPystyrivi(); 

        assertEquals(1, pystyrivi);
    }
    
    @Test
    public void konstruktoriAsettaaPaikanVaakarivinOikein() {
        Paikka paikka = new Paikka(1, 1);

        int vaakarivi = paikka.getVaakarivi(); 

        assertEquals(1, vaakarivi);
    }
    
    @Test
    public void konstruktoriAsettaaPaikanTyhjaksi() {
        Paikka paikka = new Paikka(1, 1);

        boolean tyhja = paikka.onkoTyhja(); 

        assertEquals(true, tyhja);
    }
    
    @Test
    public void palauttaaOikeanArvonJosPaikassaOnKortti() {
        Paikka paikka = new Paikka(1, 1);
        Kortti kortti = new Kortti(1, "hertta");
        
        paikka.asetaKortti(kortti);
        boolean tyhja = paikka.onkoTyhja(); 

        assertEquals(false, tyhja);
    }
}
