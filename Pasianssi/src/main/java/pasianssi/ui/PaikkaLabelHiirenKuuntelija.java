
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
import pasianssi.tilastot.Tilastot;
/**
 * @author Johanna
 */
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
    private TimerKuuntelija tk;
    private Tilastot t;
    
    public PaikkaLabelHiirenKuuntelija(Poyta poyta, PaikkaLabel label, ParienTarkastaja pt, RivienTarkastaja rt, TilanteenTarkastaja tt, 
            Pakka pakka, ArrayList<PaikkaLabel> valitut, Kayttoliittyma kl, VihjeNapinKuuntelija vnk, Timer aika, TimerKuuntelija tk, Tilastot t) {
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
        this.tk = tk;
        this.t = t;
    }
    
    public int korttienMaara() {
        int pakanKortit = pakka.pakanKortit().size();
        int poydanTyhjat = 25 - poyta.getTyhjat().size();
        return pakanKortit + poydanTyhjat;
    }
    
    public String kaytettyAika() {
        int s = tk.getKokonaisSekunnit();
        int tunnit = s / 360;
        int minuutit = s / 60;
        if (minuutit > 59) {
            minuutit = minuutit % 60;
        }
        int sekunnit = s;
        if (sekunnit > 59) {
            sekunnit = sekunnit % 60;
        }
        String sTeksti = Integer.toString(sekunnit);
        String mTeksti = Integer.toString(minuutit);
        String tTeksti = Integer.toString(tunnit);
        if (sekunnit < 10) {
            sTeksti = "0" + sekunnit;
        }
        if (minuutit < 10) {
            mTeksti = "0" + minuutit;
        }
        if (tunnit < 10) {
            tTeksti = "0" + tunnit;
        }
        String kAika = tTeksti + ":" + mTeksti + ":" + sTeksti;
        return kAika;
    }
    
    public void lopetus() throws IOException {
        aika.stop();
        int korttiMaara = korttienMaara();
        int sekunnit = tk.getKokonaisSekunnit();
        t.paivita(sekunnit, korttiMaara, false);
        int pelatut = t.getPelatut();
        int lapaistyt = t.getLapaistyt();
        int kmKorttiMaara = t.keskimaarainenKorttienMaara();
        String kmAika = t.keskimaarainenAika();
        double lp = t.lapaisyProsentti();
        int valinta = JOptionPane.showConfirmDialog(null, "Ei enää poistettavia kortteja. \n\n"
                                                           + "Pelatut pelit: " + pelatut + "\n"
                                                           + "Läpäistyt pelit: " + lapaistyt + " (" + lp + "%)\n"
                                                           + "Kortteja jäljellä: " + korttienMaara() + "\n"
                                                           + "Keskimäärin kortteja jäänyt peleissä: " + kmKorttiMaara + "\n"
                                                           + "Käytit aikaa: " + kaytettyAika() + "\n"
                                                           + "Keskimääräinen aika peleissä: " + kmAika + "\n"
                                                           + "\n"
                                                           + "Aloitetaanko uusi peli?");
        if (valinta == JOptionPane.YES_OPTION) {
            try {
                kl.reset(kl.getFrame().getContentPane());
            } catch (IOException ex) {
                Logger.getLogger(PaikkaLabelHiirenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void lapaisy() throws IOException {
        aika.stop();
        int sekunnit = tk.getKokonaisSekunnit();
        t.paivita(sekunnit, 0, true);
        int pelatut = t.getPelatut();
        int lapaistyt = t.getLapaistyt();
        int kmKorttiMaara = t.keskimaarainenKorttienMaara();
        String kmAika = t.keskimaarainenAika();
        double lp = t.lapaisyProsentti();
        int valinta = JOptionPane.showConfirmDialog(null, "Läpi meni! \n\n"
                                                           + "Pelatut pelit: " + pelatut + "\n"
                                                           + "Läpäistyt pelit: " + lapaistyt + " (" + lp + "%)\n"
                                                           + "Kortteja jäljellä: " + korttienMaara() + "\n"
                                                           + "Keskimäärin kortteja jäänyt peleissä: " + kmKorttiMaara + "\n"
                                                           + "Käytit aikaa: " + kaytettyAika() + "\n"
                                                           + "Keskimääräinen aika peleissä: " + kmAika + "\n"
                                                           + "\n"
                                                           + "Aloitetaanko uusi peli?");;
        if (valinta == JOptionPane.YES_OPTION) {
            try {
                kl.reset(kl.getFrame().getContentPane());
            } catch (IOException ex) {
                Logger.getLogger(PaikkaLabelHiirenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.vnk.onkoPaalla()) {
            this.vnk.pois();
        }
        if (label.getPaikka().onkoTyhja()) {
            return;
        } else if (valitut.isEmpty()) {
            valitut.add(label);
            label.getPaikka().asetaValituksi();
        } else if (valitut.size() == 1) {
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
                        try {
                            lopetus();
                        } catch (IOException ex) {
                            Logger.getLogger(PaikkaLabelHiirenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (poyta.getTyhjat().size() == 25 && pakka.onkoTyhja()) {
                        try {
                            lapaisy();
                        } catch (IOException ex) {
                            Logger.getLogger(PaikkaLabelHiirenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    valitut.get(0).getPaikka().poistaValinta();
                    valitut.get(0).repaint();
                    valitut.clear();
                }
            } else {
                if (rt.onkoParinPaikatSamallaRivilla(label.getPaikka(), valitut.get(0).getPaikka())) {
                    label.getPaikka().asetaValituksi();
                    valitut.add(label);
                } else {
                    valitut.get(0).getPaikka().poistaValinta();
                    valitut.get(0).repaint();
                    valitut.clear();
                }
            }
        } else {
            if (rt.onkoKuvakortitVierekkain(label.getPaikka(), valitut.get(0).getPaikka(), valitut.get(1).getPaikka())) {
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
                    try {
                        lopetus();
                    } catch (IOException ex) {
                        Logger.getLogger(PaikkaLabelHiirenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (poyta.getTyhjat().size() == 25 && pakka.onkoTyhja()) {
                    try {
                        lapaisy();
                    } catch (IOException ex) {
                        Logger.getLogger(PaikkaLabelHiirenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
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