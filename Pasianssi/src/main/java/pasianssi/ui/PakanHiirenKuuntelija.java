
package pasianssi.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import pasianssi.domain.Pakka;
import pasianssi.domain.Poyta;
import pasianssi.util.Jakaja;
import pasianssi.util.TilanteenTarkastaja;
import pasianssi.tilastot.Tilastot;
/**
 * @author Johanna
 */
public class PakanHiirenKuuntelija extends JFrame implements MouseListener {
    private Jakaja jakaja;
    private JLabel pakkaLabel;
    private Pakka pakka;
    private Poyta poyta;
    private TilanteenTarkastaja tt;
    private ArrayList<PaikkaLabel> paikat;
    private Kayttoliittyma kl;
    private VihjeNapinKuuntelija vnk;
    private JLabel korttienMaara;
    private Timer aika;
    private TimerKuuntelija tk;
    private Tilastot t;
    
    public PakanHiirenKuuntelija(Jakaja jakaja, JLabel pakkaLabel, TilanteenTarkastaja tt, Pakka pakka, Poyta poyta,
            ArrayList<PaikkaLabel> paikat, Kayttoliittyma kl, VihjeNapinKuuntelija vnk, JLabel korttienMaara, Timer aika, TimerKuuntelija tk, Tilastot t) {
        this.jakaja = jakaja;
        this.paikat = paikat;
        this.pakkaLabel = pakkaLabel;
        this.paikat = paikat;
        this.pakka = pakka;
        this.poyta = poyta;
        this.tt = tt;
        this.kl = kl;
        this.vnk = vnk;
        this.korttienMaara = korttienMaara;
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
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.vnk.onkoPaalla()) {
            this.vnk.pois();
        }
        jakaja.jaaKortit();
        for (PaikkaLabel paikka : paikat) {
            paikka.repaint();
        }
        tt.lisaaParit();
        if (!poyta.onkoKorttienValissaTyhjia() && tt.haeParit().isEmpty()) {
            aika.stop();
            int korttiMaara = korttienMaara();
            int sekunnit = tk.getKokonaisSekunnit();
            try {
                t.paivita(sekunnit, korttiMaara, false);
            } catch (IOException ex) {
                Logger.getLogger(PakanHiirenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        if (pakka.onkoTyhja()) {
            URL kuvaURL = getClass().getResource("/loppuR.jpg");
            BufferedImage img = null;
            try {
                img = ImageIO.read(kuvaURL);
            } catch (IOException ex) {
                Logger.getLogger(PakanHiirenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
            }
            pakkaLabel.setIcon(new ImageIcon(img));
        }
        pakkaLabel.repaint();
        this.korttienMaara.setText("Korttien määrä pakassa: " + pakka.pakanKortit().size());
        this.korttienMaara.repaint();
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
