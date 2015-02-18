
package pasianssi.util;

import java.util.ArrayList;
import java.util.HashSet;
import pasianssi.ui.PaikkaLabel;

public class TilanteenTarkastaja {
    private ArrayList<PaikkaLabel> paikat;
    private HashSet<PaikkaLabel[]> parit;
    
    public TilanteenTarkastaja(ArrayList<PaikkaLabel> paikat) {
        this.paikat = paikat;
    }
    
    public void lisaaParit() {
        this.parit = new HashSet<>();
        for (PaikkaLabel paikka:paikat) {
            for (PaikkaLabel paikka2:paikat) {
                if (!paikka.getPaikka().onkoTyhja() && !paikka2.getPaikka().onkoTyhja()) {
                    if (!(paikka.getPaikka().getPystyrivi()==paikka2.getPaikka().getPystyrivi() && 
                            paikka.getPaikka().getVaakarivi()==paikka2.getPaikka().getVaakarivi())) {
                        if (paikka.getPaikka().getPystyrivi()==paikka2.getPaikka().getPystyrivi() || 
                                paikka.getPaikka().getVaakarivi()==paikka2.getPaikka().getVaakarivi()) {
                            if(paikka.getPaikka().getKortti().getArvo()+paikka2.getPaikka().getKortti().getArvo()==11) {
                                if (paikka.getPaikka().getKortti().getArvo()>paikka2.getPaikka().getKortti().getArvo()) {
                                    PaikkaLabel[] pari = {paikka,paikka2};
                                     parit.add(pari);
                                }
                                else {
                                    PaikkaLabel[] pari = {paikka2,paikka};
                                     parit.add(pari);
                                }
                            }
                        }
                    }
                }
            }
        }
        lisaaKuvat(this.parit);
    }
    
    public void lisaaKuvat(HashSet<PaikkaLabel[]> parit) {
        for (PaikkaLabel paikka:paikat) {
            if (!paikka.getPaikka().onkoTyhja()) {
                if (paikka.getPaikka().getKortti().getArvo()==11) {
                    for (PaikkaLabel paikka2:paikat) {
                        if (!paikka2.getPaikka().onkoTyhja()) {
                            if (paikka2.getPaikka().getKortti().getArvo()==12) {
                                if (paikka2.getPaikka().getPystyrivi()==paikka.getPaikka().getPystyrivi()) {
                                    if (Math.abs(paikka2.getPaikka().getVaakarivi()-paikka.getPaikka().getVaakarivi())==1) {
                                        for (PaikkaLabel paikka3:paikat) {
                                            if (!paikka3.getPaikka().onkoTyhja()) {
                                                if (paikka3.getPaikka().getKortti().getArvo()==13) {
                                                    if (paikka2.getPaikka().getPystyrivi()==paikka3.getPaikka().getPystyrivi()) {
                                                        if (Math.abs(paikka2.getPaikka().getVaakarivi()-paikka3.getPaikka().getVaakarivi())==1) {
                                                            PaikkaLabel[] kuva = {paikka,paikka2,paikka3};
                                                            this.parit.add(kuva);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if (paikka2.getPaikka().getVaakarivi()==paikka.getPaikka().getVaakarivi()) {
                                    if (Math.abs(paikka2.getPaikka().getPystyrivi()-paikka.getPaikka().getPystyrivi())==1) {
                                        for (PaikkaLabel paikka3:paikat) {
                                            if (!paikka3.getPaikka().onkoTyhja()) {
                                                if (paikka3.getPaikka().getKortti().getArvo()==13) {
                                                    if (paikka2.getPaikka().getVaakarivi()==paikka3.getPaikka().getVaakarivi()) {
                                                        if (Math.abs(paikka2.getPaikka().getPystyrivi()-paikka3.getPaikka().getPystyrivi())==1) {
                                                            PaikkaLabel[] kuva = {paikka,paikka2,paikka3};
                                                            this.parit.add(kuva);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public HashSet<PaikkaLabel[]> haeParit() {
        return this.parit;
    }
}
