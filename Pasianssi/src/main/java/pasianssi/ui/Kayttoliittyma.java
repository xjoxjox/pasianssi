
package pasianssi.ui;

import java.awt.Color;
import pasianssi.domain.Poyta;
import pasianssi.domain.Pakka;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import pasianssi.util.Jakaja;


public class Kayttoliittyma implements Runnable {
    private JFrame frame;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Paras Pasianssi");
        frame.setPreferredSize(new Dimension(1000, 1000));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            luoKomponentit(frame.getContentPane());
        } catch (IOException ex) {
            Logger.getLogger(Kayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
        }

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container con) throws IOException {
        SpringLayout layout = new SpringLayout();
        con.setLayout(layout);
        Pakka pakka = new Pakka();
        pakka.luoPakka();
        Poyta poyta = new Poyta();
        poyta.luoPaikat();
        Jakaja jakaja = new Jakaja(pakka, poyta);
        jakaja.jaaKortit();
        JPanel kortit = new JPanel(new FlowLayout());
        kortit.setPreferredSize(new Dimension(700,1000));
        kortit.setBackground(Color.GREEN);
        for (int i = 0; i < poyta.getPaikat().size(); i++) {
            if (!poyta.getPaikat().get(i).onkoTyhja()) {
                ImageIcon kuva = poyta.getPaikat().get(i).haeKuva();
                PaikkaLabel pl = new PaikkaLabel(poyta.getPaikat().get(i), kuva);
                pl.setPreferredSize(pl.getPreferredSize());
                pl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
                pl.addMouseListener(new PaikkaLabelHiirenKuuntelija(poyta, pl, frame));
                kortit.add(pl);
            }
            else {
                PaikkaLabel pl = new PaikkaLabel(poyta.getPaikat().get(i), null);
                pl.setPreferredSize(pl.getPreferredSize());
                pl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
                pl.addMouseListener(new PaikkaLabelHiirenKuuntelija(poyta, pl, frame));
                kortit.add(pl);
            }
        }
        JButton uusipeli = new JButton("Uusi peli");
        JLabel pakkaLabel = new JLabel();
        pakkaLabel.addMouseListener(new PakanHiirenKuuntelija(jakaja, frame));
        pakkaLabel.setPreferredSize(new Dimension(120,185));
        pakkaLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        layout.putConstraint(SpringLayout.EAST, pakkaLabel,
                             -100,
                             SpringLayout.EAST, con);
        layout.putConstraint(SpringLayout.NORTH, pakkaLabel,
                             5,
                             SpringLayout.NORTH, con);
        layout.putConstraint(SpringLayout.EAST, uusipeli,
                             -115,
                             SpringLayout.EAST, con);
        layout.putConstraint(SpringLayout.NORTH, uusipeli,
                             50,
                             SpringLayout.SOUTH, pakkaLabel);
        con.add(pakkaLabel);
        con.add(uusipeli);
        con.add(kortit);
        con.setBackground(Color.GREEN);
        
    }

    public JFrame getFrame() {
        return frame;
    }

    private ImageIcon createImageIcon(String cUsersxerof_000Picturestmspictures) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
