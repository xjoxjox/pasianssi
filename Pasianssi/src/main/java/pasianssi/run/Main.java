
package pasianssi.run;

import javax.swing.SwingUtilities;
import pasianssi.ui.Kayttoliittyma;

public class Main {
    public static void main(String[] args) {
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}
