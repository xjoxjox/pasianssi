
package pasianssi.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class OhjeNapinKuuntelija implements ActionListener{
    private VihjeNapinKuuntelija vnk;
    
    public OhjeNapinKuuntelija(VihjeNapinKuuntelija vnk) {
        this.vnk = vnk;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
        JOptionPane.showMessageDialog(null, "Pelissä tarkoituksena on tyhjentääpakka ja pöytä korteista.\n"
                                            + "Kortit voidaan poistaa pareina, jos niiden summa on 11 ja \n"
                                            + "ne sijaitsevat samalla pysty- tai vaakarivillä. Kuvakortit \n"
                                            + "voidaan poistaa samalta pysty- tai vaakariviltä, jos niiden \n"
                                            + "välissä ei ole muita kortteja ja ne valitaan järjestyksessä J, Q, K \n"
                                            + "tai K, Q, J. Kun pareja tai järjestyksessä olevia kuvakortteja ei \n"
                                            + "enää löydy pöydältä, jaetaan pakasta lisää kortteja klikkaamalla pakkaa.\n"
                                            + "Kun pakka on tyhjä, siirretään pakkaa klikkaamalla pöydän kortteja \n"
                                            + "niin ettei niiden väliin jää tyhjiä paikkoja. Viimeisenä oleva kortti \n"
                                            + "siirretään aina ensimmäiseen tyhjään paikkaan. Peli on mennyt läpi, \n"
                                            + "kun pakka sekä pöytä ovat tyhjät korteista. Jos et löydä pareja, voit \n"
                                            + "käyttää Vihje-painiketta, joka näyttää valittavissa olevan parin.");
    }
}
