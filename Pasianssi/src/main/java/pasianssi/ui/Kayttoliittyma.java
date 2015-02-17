
package pasianssi.ui;

import java.awt.Color;
import pasianssi.domain.Poyta;
import pasianssi.domain.Pakka;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import pasianssi.util.Jakaja;
import pasianssi.util.ParienTarkastaja;
import pasianssi.util.RivienTarkastaja;
import pasianssi.util.TilanteenTarkastaja;


public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private Pakka pakka;
    private Poyta poyta;
    private Jakaja jakaja;
    private ParienTarkastaja pt;
    private RivienTarkastaja rt;
    private TilanteenTarkastaja tt;
    private JPanel kortit;
    private JLabel pakkaLabel;
    private ArrayList<PaikkaLabel> valitut;
    private ArrayList<PaikkaLabel> paikat;

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
        reset(con);
    }

    public JFrame getFrame() {
        return frame;
    }
    
    public void reset(Container con) throws IOException {
        con.removeAll();
        con.revalidate();
        con.repaint();
        SpringLayout layout = new SpringLayout();
        con.setLayout(layout);
        pakka = new Pakka();
        pakka.luoPakka();
        pakka.sekoitaPakka();
        poyta = new Poyta();
        poyta.luoPaikat();
        jakaja = new Jakaja(pakka, poyta);
        pt = new ParienTarkastaja();
        rt = new RivienTarkastaja();
        kortit = new JPanel(new FlowLayout());
        kortit.setPreferredSize(new Dimension(700,1000));
        kortit.setBackground(Color.GREEN);
        valitut = new ArrayList<>();
        paikat = new ArrayList<>();
        tt = new TilanteenTarkastaja(paikat);
        for (int i = 0; i < poyta.getPaikat().size(); i++) {
            PaikkaLabel pl = new PaikkaLabel(poyta.getPaikat().get(i));
            paikat.add(pl);
            pl.setPreferredSize(pl.getPreferredSize());
            pl.addMouseListener(new PaikkaLabelHiirenKuuntelija(poyta, pl, pt, rt, tt, pakka, valitut));
            kortit.add(pl);
            pl.repaint();
        }
        pakkaLabel = new JLabel();
        if (!pakka.onkoTyhja()) {
            URL kuvaURL = getClass().getResource("/tausta.jpg");
            BufferedImage img = ImageIO.read(kuvaURL);
            pakkaLabel.setIcon(new ImageIcon(img));
            pakkaLabel.repaint();
        }
        JButton uusipeli = new JButton("Uusi peli");
        UusiPeliNapinkuuntelija upnk = new UusiPeliNapinkuuntelija(this);
        uusipeli.addActionListener(upnk);
        pakkaLabel.addMouseListener(new PakanHiirenKuuntelija(jakaja, pakkaLabel, tt, pakka, poyta, paikat));
        pakkaLabel.setPreferredSize(new Dimension(120,185));
        pakkaLabel.setBackground(Color.DARK_GRAY);
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
        con.add(kortit);
        con.add(uusipeli);
        con.setBackground(Color.GREEN);
    }

    private ImageIcon createImageIcon(String cUsersxerof_000Picturestmspictures) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
