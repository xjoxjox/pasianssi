
package pasianssi.ui;

import pasianssi.domain.Poyta;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import pasianssi.domain.Paikka;
import pasianssi.util.ParienTarkastaja;
import pasianssi.util.RivienTarkastaja;

public class PaikkaLabelHiirenKuuntelija implements MouseListener {
    private Poyta poyta;
    private PaikkaLabel label;
    private ParienTarkastaja pt;
    private RivienTarkastaja rt;
    private JFrame frame;
    
    public PaikkaLabelHiirenKuuntelija(Poyta poyta, PaikkaLabel label, JFrame frame) {
        this.poyta = poyta;
        this.label = label;
        this.frame = frame;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        ArrayList<Paikka> valitut = poyta.valitutKortit();
        if (valitut.isEmpty()) {
            label.getPaikka().asetaValituksi();
        }
        else if (valitut.size()==1) {
            if (!pt.ovatkoValitutKuvakortteja(label.getPaikka().getKortti(), valitut.get(0).getKortti())) {
                if (pt.ovatkoValitutKortitPari(label.getPaikka().getKortti(), valitut.get(0).getKortti()) &&
                        rt.onkoParinPaikatSamallaRivilla(label.getPaikka(), valitut.get(0))) {
                    label.getPaikka().tyhjennaPaikka();
                    valitut.get(0).tyhjennaPaikka();
                    valitut.get(0).poistaValinta();
                }
                else {
                    valitut.get(0).poistaValinta();
                }
            }
            else {
                if (rt.onkoParinPaikatSamallaRivilla(label.getPaikka(), valitut.get(0))){
                    label.getPaikka().asetaValituksi();
                }
                else {
                    valitut.get(0).poistaValinta();
                }
            }
        }
        else {
            if (pt.ovatkoValitutKuvakorttejaJarjestyksessa(valitut.get(0).getKortti(), label.getPaikka().getKortti()) &&
                        rt.onkoParinPaikatSamallaRivilla(label.getPaikka(), valitut.get(0))) {
                    label.getPaikka().tyhjennaPaikka();
                    valitut.get(0).tyhjennaPaikka();
                    valitut.get(0).poistaValinta();
                    valitut.get(1).tyhjennaPaikka();
                    valitut.get(1).poistaValinta();
                }
                else {
                    valitut.get(0).poistaValinta();
                    valitut.get(1).poistaValinta();
                }
        }
        this.frame.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
