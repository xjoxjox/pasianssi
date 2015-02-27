
package pasianssi.tilastot;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Johanna
 * Luokka pitää yllä pelin tilastoja.
 */
public class Tilastot {
    private int pelatutPelit;
    private int lapaistytPelit;
    private int ajat;
    private int korttienMaara;
    private File tilastot;
    private File aikatilasto;
    private File korttienmaarat;
 /**
 * Konstruktorissa haetaan tiedostoista tilastoja.
 * @throws java.io.FileNotFoundException jos tiedostoa ei löydy
 * @throws java.io.IOException jos kirjoitus ei onnistu
 */
    public Tilastot() throws FileNotFoundException, IOException {
        this.tilastot = new File("C:\\Users\\Johanna\\Documents\\GitHub\\pasianssi\\Pasianssi\\tilastot.txt");
        if (!tilastot.exists()) {
            tilastot.createNewFile();
            try { 
                FileWriter fw = new FileWriter(tilastot.getAbsoluteFile());
                try (BufferedWriter bw = new BufferedWriter(fw)) {
                    tilastot.delete();
                    bw.write("0");
                    bw.newLine();
                    bw.write("0");
                    bw.close();
                    fw.close();
                } catch (IOException e) {
                    e.getStackTrace();
                }
            } catch (IOException e) {
                e.getStackTrace();
            }
        }
        Scanner s1 = new Scanner(tilastot);
        int i = 0;
        while (s1.hasNext()) {
            if (i == 0) {
                this.pelatutPelit = s1.nextInt();
            } else {
                this.lapaistytPelit = s1.nextInt();
            }
            i++;
        }
        this.aikatilasto = new File("C:\\Users\\Johanna\\Documents\\GitHub\\pasianssi\\Pasianssi\\ajat.txt");
        if (!aikatilasto.exists()) {
            aikatilasto.createNewFile();
        }
        Scanner s2 = new Scanner(aikatilasto);
        while (s2.hasNext()) {
            this.ajat = s2.nextInt();
        }
        this.korttienmaarat = new File("C:\\Users\\Johanna\\Documents\\GitHub\\pasianssi\\Pasianssi\\korttienmaarat.txt");
        if (!korttienmaarat.exists()) {
            korttienmaarat.createNewFile();
        }
        Scanner s3 = new Scanner(korttienmaarat);
        while (s3.hasNext()) {
            this.korttienMaara = s3.nextInt();
        }
    }
    
    public int getPelatut() {
        return this.pelatutPelit;
    }
    
    public int getLapaistyt() {
        return this.lapaistytPelit;
    }
    /**
    * Metodissa lasketaan kuinka paljon peleissä on keskimäärin jäänyt kortteja jäljelle.
    * @return keskimääräinen korttien määrä
    */
    public int keskimaarainenKorttienMaara() {
        return this.korttienMaara / this.pelatutPelit;
    }
    /**
    * Metodissa lasketaan kuinka paljon peleissä on keskimäärin kulunut aikaa.
    * @return keskimääräinen käytetty aika
    */
    public String keskimaarainenAika() {
        int tulos = this.ajat / this.pelatutPelit;
        int tunnit = tulos / 360;
        int minuutit = tulos / 60;
        if (minuutit > 59) {
            minuutit = minuutit % 60;
        }
        int sekunnit = tulos;
        if (sekunnit > 59) {
            sekunnit = sekunnit % 60;
        }
        String sTeksti = Integer.toString(sekunnit);
        String mTeksti = Integer.toString(minuutit);
        String tTeksti = Integer.toString(tunnit);
        if (sekunnit < 10) {
            sTeksti = "0" + sekunnit;
        }
        if (minuutit < 10) {
            mTeksti = "0" + minuutit;
        }
        if (tunnit < 10) {
            tTeksti = "0" + tunnit;
        }
        String kmAika = tTeksti + ":" + mTeksti + ":" + sTeksti;
        return kmAika;
    }
    /**
    * Metodissa lasketaan prosentteina kuinka paljon pelejä on läpäisty.
    * @return läpäisyprosentti
    */
    public double lapaisyProsentti() {
        double lp = this.lapaistytPelit / this.pelatutPelit * 100;
        DecimalFormat df = new DecimalFormat("0.00"); 
        df.format(lp);
        return lp;
    }
    /**
    * Metodissa päivitetään tilastot tiedostoihin.
    * @param aika käytetty aika
    * @param korttiMaara jäljellle jääneiden korttien määrä
    * @param lapi menikö peli läpi
     * @throws java.io.IOException jos kirjoitus ei onnistu
    */
    public void paivita(int aika, int korttiMaara, boolean lapi) throws IOException {
        this.korttienMaara += korttiMaara;
        try {
            FileWriter fw = new FileWriter(korttienmaarat.getAbsoluteFile());
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write("" + korttiMaara);
                bw.newLine();
                bw.close();
                fw.close();
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        this.ajat += aika;
        try {
            FileWriter fw2 = new FileWriter(aikatilasto.getAbsoluteFile());
            try (BufferedWriter bw2 = new BufferedWriter(fw2)) {
                bw2.write("" + aika);
                bw2.newLine();
                bw2.close();
                fw2.close();
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        this.pelatutPelit++;
        if (lapi) {
            this.lapaistytPelit++;
        }
        try { 
            FileWriter fw3 = new FileWriter(tilastot.getAbsoluteFile());
            try (BufferedWriter bw3 = new BufferedWriter(fw3)) {
                tilastot.delete();
                bw3.write("" + this.pelatutPelit);
                bw3.newLine();
                bw3.write("" + this.lapaistytPelit);
                bw3.close();
                fw3.close();
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}