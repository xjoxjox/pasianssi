
package pasianssi.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
/**
 * @author Johanna
 */
public class TimerKuuntelija implements ActionListener {
    private JLabel aika;
    private int tunnit;
    private int minuutit;
    private int sekunnit;
    private int kokonaisSekunnit;
    
    public TimerKuuntelija(JLabel aika) {
        this.aika = aika;
        this.tunnit = 0;
        this.minuutit = 0;
        this.sekunnit = 0;
        this.kokonaisSekunnit = 0;
    }
    
    public int getKokonaisSekunnit() {
        return this.kokonaisSekunnit;
    }
    
    public int getTunnit() {
        return this.tunnit;
    }
    
    public int getMinuutitit() {
        return this.minuutit;
    }
    
    public int getSekunnit() {
        return this.sekunnit;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.kokonaisSekunnit++;
        if (this.sekunnit < 59) {
            this.sekunnit++;
        } else if (this.sekunnit == 59) {
            this.sekunnit = 0;
            if (this.minuutit < 59) {
                this.minuutit++;
            } else if (this.minuutit == 59) {
                this.minuutit = 0;
                if (this.tunnit < 100) {
                    this.tunnit++;
                } else {
                    this.tunnit = 0;
                }
            }
        }
        String sTeksti = Integer.toString(this.sekunnit);
        String mTeksti = Integer.toString(this.minuutit);
        String tTeksti = Integer.toString(this.tunnit);
        if (this.sekunnit < 10) {
            sTeksti = "0" + this.sekunnit;
        }
        if (this.minuutit < 10) {
            mTeksti = "0" + this.minuutit;
        }
        if (this.tunnit < 10) {
            tTeksti = "0" + this.tunnit;
        }
        aika.setText(tTeksti + ":" + mTeksti + ":" + sTeksti);
        aika.repaint();
    }
}
