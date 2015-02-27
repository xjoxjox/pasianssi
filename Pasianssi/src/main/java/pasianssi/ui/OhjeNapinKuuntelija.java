
package pasianssi.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 * @author Johanna
 */
public class OhjeNapinKuuntelija implements ActionListener {
    private VihjeNapinKuuntelija vnk;
    
    public OhjeNapinKuuntelija(VihjeNapinKuuntelija vnk) {
        this.vnk = vnk;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.vnk.onkoPaalla()) {
            this.vnk.pois();
        }
        JOptionPane.showMessageDialog(null, "Pelissä tarkoituksena on tyhjentää pakka ja pöytä korteista.\n"
                                            + "Kortit voidaan poistaa pareina, jos niiden summa on 11 ja \n"
                                            + "ne sijaitsevat samalla pysty- tai vaakarivillä. Kuvakortit \n"
                                            + "voidaan poistaa samalta pysty- tai vaakariviltä, jos niiden \n"
                                            + "välissä ei ole muita kortteja ja ne ovat järjestyksessä J, Q, K \n"
                                            + "tai K, Q, J. Kortit voidaan valita missä järjestyksessä tahansa, \n"
                                            + "kunhan niiden järjestys vain pöydällä on oikea. \n"
                                            + "Peli aloitetaan painamalla pakkaa, jolloin kortit jaetaan pöydälle. \n"
                                            + "Aika kuitenkin lasketaan jo siitä, kun uusi peli aloitetaan, vaikka \n"
                                            + "kortteja ei ole vielä jaettu pöydälle. \n"
                                            + "Kun pareja tai järjestyksessä olevia kuvakortteja ei enää löydy \n"
                                            + "pöydältä, jaetaan pakasta lisää kortteja klikkaamalla pakkaa.\n"
                                            + "Kun pakka on tyhjä, jaetaan kortit pöydän tyhjiin paikkoihin klikkaamalla \n"
                                            + "pakkaa. Kortit siirtyvät niin, että viimeisenä oleva kortti pöydällä \n"
                                            + "siirretään aina ensimmäiseen tyhjään paikkaan pöydällä. \n"
                                            + "Jos ei löydä pareja tai poistettavia kuvakortteja, painamalla \"Vinkki\"-nappia \n"
                                            + "näkee mahdolliset poistettavat korttiparit/kuvakorttiryhmät. Jos ei nappia \n"
                                            + "painammalla tapahdu mitään, ainut mahdollisuus on klikata pakkaa ja jakaa \n"
                                            + "lisää kortteja/siirtää pöydällä olevia kortteja. \n"
                                            + "Jos mahdollisia poistoja ei enää ole, eikä pakkaa voi käyttää, peli päättyy ja \n"
                                            + "siitä ilmoitetaan pelaajalle. \n"
                                            + "Peli on mennyt läpi, kun pakka sekä pöytä ovat tyhjät korteista.");
    }
}
