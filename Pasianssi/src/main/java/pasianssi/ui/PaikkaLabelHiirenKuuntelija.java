
package pasianssi.ui;

import pasianssi.domain.Poyta;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
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
    private Kayttoliittyma kl;
    private VihjeNapinKuuntelija vnk;
    private Timer aika;
    
    public PaikkaLabelHiirenKuuntelija(Poyta poyta, PaikkaLabel label, ParienTarkastaja pt, RivienTarkastaja rt, TilanteenTarkastaja tt, 
            Pakka pakka, ArrayList<PaikkaLabel> valitut, Kayttoliittyma kl, VihjeNapinKuuntelija vnk, Timer aika) {
        this.valitut = valitut;
        this.poyta = poyta;
        this.pakka = pakka;
        this.label = label;
        this.pt = pt;
        this.rt = rt;
        this.tt = tt;
        this.kl = kl;
        this.vnk = vnk;
        this.aika = aika;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.vnk.onkoPaalla()) {
            if (this.vnk.getLista().size()==2) {
                this.vnk.getLista().get(0).getPaikka().poistaValinta();
                this.vnk.getLista().get(1).getPaikka().poistaValinta();
                this.vnk.getLista().get(0).repaint();
                this.vnk.getLista().get(1).repaint();
                this.vnk.poisPaalta();
            }
            else {
                this.vnk.getLista().get(0).getPaikka().poistaValinta();
                this.vnk.getLista().get(1).getPaikka().poistaValinta();
                this.vnk.getLista().get(2).getPaikka().poistaValinta();
                this.vnk.getLista().get(0).repaint();
                this.vnk.getLista().get(1).repaint();
                this.vnk.getLista().get(2).repaint();
                this.vnk.poisPaalta();
            }
        }
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
                    if (!poyta.onkoKorttienValissaTyhjia() && tt.haeParit().isEmpty()) {
                        aika.stop();
                        int valinta = JOptionPane.showConfirmDialog(null, "Ei enää poistettavia kortteja\n Aloitetaanko uusi peli?");
                        if (valinta==JOptionPane.YES_OPTION) {
                            try {
                                kl.reset(kl.getFrame().getContentPane());
                            } catch (IOException ex) {
                                Logger.getLogger(PaikkaLabelHiirenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    if (poyta.getTyhjat().size()==25 && pakka.onkoTyhja()) {
                        aika.stop();
                        JOptionPane.showMessageDialog(null, "Läpi meni!");
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
            if (rt.onkoKuvakortitVierekkäin(label.getPaikka(), valitut.get(0).getPaikka(), valitut.get(1).getPaikka())) {
                    label.getPaikka().tyhjennaPaikka();
                    valitut.get(0).getPaikka().tyhjennaPaikka();
                    valitut.get(0).getPaikka().poistaValinta();
                    valitut.get(1).getPaikka().tyhjennaPaikka();
                    valitut.get(1).getPaikka().poistaValinta();
                    valitut.get(0).repaint();
                    valitut.get(1).repaint();
                    valitut.clear();
                    tt.lisaaParit();
                    if (!poyta.onkoKorttienValissaTyhjia() && tt.haeParit().isEmpty()) {
                        aika.stop();
                        int valinta = JOptionPane.showConfirmDialog(null, "Ei enää poistettavia kortteja\n Aloitetaanko uusi peli?");
                        if (valinta==JOptionPane.YES_OPTION) {
                            try {
                                kl.reset(kl.getFrame().getContentPane());
                            } catch (IOException ex) {
                                Logger.getLogger(PaikkaLabelHiirenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    if (poyta.getTyhjat().size()==25 && pakka.onkoTyhja()) {
                        aika.stop();
                        JOptionPane.showMessageDialog(null, "Läpi meni!");
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
