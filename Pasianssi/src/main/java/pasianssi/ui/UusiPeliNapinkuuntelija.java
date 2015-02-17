
package pasianssi.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UusiPeliNapinkuuntelija implements ActionListener{
    private Kayttoliittyma kl;
    
    public UusiPeliNapinkuuntelija(Kayttoliittyma kl) {
        this.kl = kl;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            kl.reset(kl.getFrame().getContentPane());
        } catch (IOException ex) {
            Logger.getLogger(UusiPeliNapinkuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
