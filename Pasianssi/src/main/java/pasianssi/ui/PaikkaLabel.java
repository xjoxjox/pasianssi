package pasianssi.ui;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import pasianssi.domain.Paikka;
/**
 * @author Johanna
 */
public class PaikkaLabel extends JLabel {
    private static final int korkeus = 185;
    private static final int leveys = 120;
    private Paikka paikka;
    private Image kuva;
    
    public PaikkaLabel(Paikka paikka) throws IOException {
        this.paikka = paikka;
        this.kuva = paikka.haeKuva();
    }
    
    public Paikka getPaikka() {
        return this.paikka;
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(leveys, korkeus);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        try {
            this.kuva = paikka.haeKuva();
        } catch (IOException ex) {
            Logger.getLogger(PaikkaLabel.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.paintComponent(g);
        g.drawImage(kuva, 0, 0, null);
    }
}
