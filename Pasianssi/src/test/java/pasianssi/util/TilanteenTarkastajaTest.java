
package pasianssi.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import pasianssi.domain.Kortti;
import pasianssi.domain.Paikka;
import pasianssi.ui.PaikkaLabel;

/**
 *
 * @author Johanna
 */
public class TilanteenTarkastajaTest {
    private TilanteenTarkastaja tt;
    private PaikkaLabel pl1;
    private PaikkaLabel pl2;
    private PaikkaLabel pl3;
    private PaikkaLabel pl4;
    private PaikkaLabel pl5;
    private PaikkaLabel pl6;
    private PaikkaLabel pl7;
    private PaikkaLabel pl8;
    private Paikka p1;
    private Paikka p2;
    private Paikka p3;
    private Paikka p4;
    private Paikka p5;
    private Paikka p6;
    private Paikka p7;
    private Paikka p8;
    private Kortti A;
    private Kortti Q;
    private Kortti K;
    private Kortti J;
    private Kortti viisi;
    private Kortti kuusi;
    private Kortti kaksi;
    private Kortti yhdeksan;
    
    public TilanteenTarkastajaTest() {
    }
    
    @Before
    public void setUp() throws IOException {
        p1 = new Paikka(2, 4);
        p2 = new Paikka(3, 4);
        p3 = new Paikka(1, 4);
        p4 = new Paikka(5, 5);
        p5 = new Paikka(5, 4);
        p6 = new Paikka(1, 1);
        p7 = new Paikka(1, 2);
        p8 = new Paikka(5, 5);
        A = new Kortti(1, "Hertta");
        Q = new Kortti(12, "Hertta");
        J = new Kortti(11, "Hertta");
        K = new Kortti(13, "Hertta");
        viisi = new Kortti(5, "Hertta");
        kuusi = new Kortti(6, "Hertta");
        kaksi = new Kortti(2, "Hertta");
        yhdeksan = new Kortti(9, "Hertta");
        p1.asetaKortti(Q);
        p2.asetaKortti(K);
        p3.asetaKortti(J);
        p4.asetaKortti(viisi);
        p5.asetaKortti(kuusi);
        p6.asetaKortti(kaksi);
        p7.asetaKortti(yhdeksan);
        p8.asetaKortti(A);
        pl1 = new PaikkaLabel(p1);
        pl2 = new PaikkaLabel(p2);
        pl3 = new PaikkaLabel(p3);
        pl4 = new PaikkaLabel(p4);
        pl5 = new PaikkaLabel(p5);
        pl6 = new PaikkaLabel(p6);
        pl7 = new PaikkaLabel(p7);
        pl8 = new PaikkaLabel(p8);
        ArrayList<PaikkaLabel> paikat = new ArrayList<>();
        paikat.add(pl1);
        paikat.add(pl2);
        paikat.add(pl3);
        paikat.add(pl4);
        paikat.add(pl5);
        paikat.add(pl6);
        paikat.add(pl7);
        paikat.add(pl8);
        tt = new TilanteenTarkastaja(paikat);
    }
    
    @Test
    public void lisaaParitOikein() {
        tt.lisaaParit();
        assertEquals(5, tt.haeParit().size());
    }
}
