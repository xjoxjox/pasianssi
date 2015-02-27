
package pasianssi.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import pasianssi.util.TilanteenTarkastaja;
/**
 * @author Johanna
 */
public class VihjeNapinKuuntelija implements ActionListener {
    private TilanteenTarkastaja tt;
    private int kerrat;
    private boolean paalla;
    private ArrayList<PaikkaLabel> vihjeena;
    
    public VihjeNapinKuuntelija(TilanteenTarkastaja tt) {
        this.tt = tt;
        this.kerrat = 1;
        this.paalla = false;
    }
    
    public void nollaaKerrat() {
        this.kerrat = 0;
    }
    
    public boolean onkoPaalla() {
        return this.paalla;
    }
    
    public void poisPaalta() {
        this.paalla = false;
        this.kerrat = 1;
        this.vihjeena.clear();
    }
    
    public ArrayList<PaikkaLabel> getLista() {
        return this.vihjeena;
    }
    
    public void pois() {
        if (this.vihjeena.isEmpty()) {
            poisPaalta();
        } else if (this.vihjeena.size() == 2) {
            this.vihjeena.get(0).getPaikka().poistaValinta();
            this.vihjeena.get(1).getPaikka().poistaValinta();
            this.vihjeena.get(0).repaint();
            this.vihjeena.get(1).repaint();
            this.vihjeena.clear();
        } else {
            this.vihjeena.get(0).getPaikka().poistaValinta();
            this.vihjeena.get(1).getPaikka().poistaValinta();
            this.vihjeena.get(2).getPaikka().poistaValinta();
            this.vihjeena.get(0).repaint();
            this.vihjeena.get(1).repaint();
            this.vihjeena.get(2).repaint();
            this.vihjeena.clear();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (onkoPaalla()) {
            pois();
        }
        this.vihjeena = new ArrayList<>();
        HashSet<PaikkaLabel[]> parit = tt.haeParit();
        PaikkaLabel[] paikkaset = null;
        if (parit != null && !parit.isEmpty()) {
            this.paalla = true;
            int parimaara = 0;
            for (PaikkaLabel[] paikka : parit) {
                parimaara++;
            }
            if (this.kerrat > parimaara) {
                this.kerrat = 1;
            }
            int i = 1;
            for (PaikkaLabel[] paikat:parit) {
                if (i == this.kerrat) {
                    paikkaset = paikat;
                }
                i++;
            }
            PaikkaLabel paikka1 = paikkaset[0];
            PaikkaLabel paikka2 = paikkaset[1];
            this.vihjeena.add(paikka1);
            this.vihjeena.add(paikka2);
            paikka1.getPaikka().asetaValituksi();
            paikka2.getPaikka().asetaValituksi();
            paikka1.repaint();
            paikka2.repaint();
            if (paikkaset.length == 3) {
                PaikkaLabel paikka3 = paikkaset[2];
                this.vihjeena.add(paikka3);
                paikka3.getPaikka().asetaValituksi();
                paikka3.repaint();
            }
            this.kerrat++;
        }
    }
}