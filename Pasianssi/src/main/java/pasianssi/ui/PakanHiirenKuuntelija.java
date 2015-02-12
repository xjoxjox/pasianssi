
package pasianssi.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import pasianssi.util.Jakaja;

public class PakanHiirenKuuntelija implements MouseListener {
    private Jakaja jakaja;
    private JFrame frame;
    
    public PakanHiirenKuuntelija (Jakaja jakaja, JFrame frame) {
        this.jakaja = jakaja;
        this.frame = frame;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        jakaja.jaaKortit();
        frame.repaint();
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
