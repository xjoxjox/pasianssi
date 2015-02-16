package pasianssi.ui;


import java.awt.Dimension;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import pasianssi.domain.Paikka;


public class PaikkaLabel extends JLabel {
    private static final int korkeus = 185;
    private static final int leveys = 120;
    private Paikka paikka;
    private ImageIcon kuva;
    
    public PaikkaLabel(Paikka paikka, ImageIcon kuva) throws IOException {
        this.paikka = paikka;
        this.kuva = kuva;
    }
    
    public Paikka getPaikka() {
        return this.paikka;
    }
    
    @Override
    public Dimension getPreferredSize(){
         return new Dimension(leveys, korkeus);
     }
}
