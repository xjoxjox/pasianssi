
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
import pasianssi.domain.Pakka;
import pasianssi.domain.Poyta;
import pasianssi.util.Jakaja;
import pasianssi.util.TilanteenTarkastaja;

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
    
    public PakanHiirenKuuntelija (Jakaja jakaja, JLabel pakkaLabel, TilanteenTarkastaja tt, Pakka pakka, Poyta poyta,
            ArrayList<PaikkaLabel> paikat, Kayttoliittyma kl, VihjeNapinKuuntelija vnk, JLabel korttienMaara) {
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
        jakaja.jaaKortit();
        for (PaikkaLabel paikka : paikat) {
            paikka.repaint();
        }
        tt.lisaaParit();
        if (!poyta.onkoKorttienValissaTyhjia() && tt.haeParit().isEmpty()) {
            int valinta = JOptionPane.showConfirmDialog(null, "Ei enää poistettavia kortteja\n Aloitetaanko uusi peli?");
                if (valinta==JOptionPane.YES_OPTION) {
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
