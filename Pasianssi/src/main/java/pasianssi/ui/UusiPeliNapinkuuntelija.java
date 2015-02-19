
package pasianssi.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pasianssi.domain.Poyta;
import pasianssi.util.TilanteenTarkastaja;


public class UusiPeliNapinkuuntelija implements ActionListener{
    private Kayttoliittyma kl;
    
    public UusiPeliNapinkuuntelija(Kayttoliittyma kl) {
        this.kl = kl;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
            int valinta = JOptionPane.showConfirmDialog(null, "Haluatko varmasti aloittaa uuden pelin?");
            if (valinta==JOptionPane.YES_OPTION) {
            try {
                kl.reset(kl.getFrame().getContentPane());
            } catch (IOException ex) {
                Logger.getLogger(PaikkaLabelHiirenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    }
}
