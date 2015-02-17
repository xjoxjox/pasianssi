
package pasianssi.ui;

import pasianssi.domain.Poyta;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pasianssi.domain.Pakka;
import pasianssi.util.ParienTarkastaja;
import pasianssi.util.RivienTarkastaja;
import pasianssi.util.TilanteenTarkastaja;

public class PaikkaLabelHiirenKuuntelija extends JFrame implements MouseListener {
    private Poyta poyta;
    private Pakka pakka;
    private PaikkaLabel label;
    private ParienTarkastaja pt;
    private RivienTarkastaja rt;
    private TilanteenTarkastaja tt;
    private ArrayList<PaikkaLabel> valitut;
    
    public PaikkaLabelHiirenKuuntelija(Poyta poyta, PaikkaLabel label, ParienTarkastaja pt, RivienTarkastaja rt, TilanteenTarkastaja tt, 
            Pakka pakka, ArrayList<PaikkaLabel> valitut) {
        this.valitut = valitut;
        this.poyta = poyta;
        this.pakka = pakka;
        this.label = label;
        this.pt = pt;
        this.rt = rt;
        this.tt = tt;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (label.getPaikka().onkoTyhja()) {
        }
        else if (valitut.isEmpty()) {
            valitut.add(label);
            label.getPaikka().asetaValituksi();
        }
        else if (valitut.size()==1) {
            if (!pt.ovatkoValitutKuvakortteja(label.getPaikka().getKortti(), valitut.get(0).getPaikka().getKortti())) {
                if (pt.ovatkoValitutKortitPari(label.getPaikka().getKortti(), valitut.get(0).getPaikka().getKortti()) &&
                        rt.onkoParinPaikatSamallaRivilla(label.getPaikka(), valitut.get(0).getPaikka())) {
                    label.getPaikka().tyhjennaPaikka();
                    valitut.get(0).getPaikka().tyhjennaPaikka();
                    valitut.get(0).getPaikka().poistaValinta();
                    valitut.get(0).repaint();
                    valitut.clear();
                    tt.lisaaParit();
                    tt.lisaaKuvat();
                    if (!poyta.onkoKorttienValissaTyhjia() && tt.haeKuvat().isEmpty() && tt.haeParit().isEmpty()) {
                        System.out.println("loppu");
                        JOptionPane.showMessageDialog(null, "Ei enää poistettavia kortteja");
                    }
                }
                else {
                    valitut.get(0).getPaikka().poistaValinta();
                    valitut.get(0).repaint();
                    valitut.clear();
                }
            }
            else {
                if (rt.onkoParinPaikatSamallaRivilla(label.getPaikka(), valitut.get(0).getPaikka())){
                    label.getPaikka().asetaValituksi();
                    valitut.add(label);
                }
                else {
                    valitut.get(0).getPaikka().poistaValinta();
                    valitut.get(0).repaint();
                    valitut.clear();
                }
            }
        }
        else {
            if (pt.ovatkoValitutKuvakorttejaJarjestyksessa(valitut.get(0).getPaikka().getKortti(), label.getPaikka().getKortti(), valitut.get(1).getPaikka().getKortti()) &&
                        rt.onkoParinPaikatSamallaRivilla(label.getPaikka(), valitut.get(0).getPaikka()) && 
                            rt.onkoKuvakortitVierekkäin(label.getPaikka(), valitut.get(0).getPaikka(), valitut.get(1).getPaikka())) {
                    label.getPaikka().tyhjennaPaikka();
                    valitut.get(0).getPaikka().tyhjennaPaikka();
                    valitut.get(0).getPaikka().poistaValinta();
                    valitut.get(1).getPaikka().tyhjennaPaikka();
                    valitut.get(1).getPaikka().poistaValinta();
                    valitut.get(0).repaint();
                    valitut.get(1).repaint();
                    valitut.clear();
                    tt.lisaaParit();
                    tt.lisaaKuvat();
                    if (!poyta.onkoKorttienValissaTyhjia() && tt.haeKuvat().isEmpty() && tt.haeParit().isEmpty()) {
                        System.out.println("loppu");
                        JOptionPane.showMessageDialog(null, "Ei enää poistettavia kortteja");
                    }
                }
                else {
                    valitut.get(0).getPaikka().poistaValinta();
                    valitut.get(1).getPaikka().poistaValinta();
                    valitut.get(0).repaint();
                    valitut.get(1).repaint();
                    valitut.clear();
                }
        }
        label.repaint();
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
