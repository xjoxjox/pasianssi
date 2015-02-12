package pasianssi.ui;


import java.awt.Dimension;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.JLabel;
import pasianssi.domain.Paikka;


public class PaikkaLabel extends JLabel {
    private static final int korkeus = 185;
    private static final int leveys = 120;
    private Paikka paikka;
    private Icon kuva;
    
    public PaikkaLabel(Paikka paikka) throws IOException {
        this.paikka = paikka;
    }
    
    public Paikka getPaikka() {
        return this.paikka;
    }
    
    @Override
    public Dimension getPreferredSize(){
         return new Dimension(leveys, korkeus);
     }
}
