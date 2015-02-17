
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
    
    public PakanHiirenKuuntelija (Jakaja jakaja, JLabel pakkaLabel, TilanteenTarkastaja tt, Pakka pakka, Poyta poyta,
            ArrayList<PaikkaLabel> paikat) {
        this.jakaja = jakaja;
        this.paikat = paikat;
        this.pakkaLabel = pakkaLabel;
        this.paikat = paikat;
        this.pakka = pakka;
        this.poyta = poyta;
        this.tt = tt;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        jakaja.jaaKortit();
        for (PaikkaLabel paikka : paikat) {
            paikka.repaint();
        }
        tt.lisaaParit();
        tt.lisaaKuvat();
        if (!poyta.onkoKorttienValissaTyhjia() && tt.haeKuvat().isEmpty() && tt.haeParit().isEmpty()) {
            System.out.println("loppu");
            JOptionPane.showMessageDialog(null, "Ei enää poistettavia kortteja");
        }
        if (pakka.onkoTyhja()) {
            URL kuvaURL = getClass().getResource("/loppu.jpg");
            BufferedImage img = null;
            try {
                img = ImageIO.read(kuvaURL);
            } catch (IOException ex) {
                Logger.getLogger(PakanHiirenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
            }
            pakkaLabel.setIcon(new ImageIcon(img));
        }
        pakkaLabel.repaint();
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
