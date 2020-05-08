package de.hsos.prog3.nelsonmorais.ab02.ui;

import de.hsos.prog3.nelsonmorais.ab02.logik.Simulator;
import de.hsos.prog3.nelsonmorais.ab02.util.Interaktionsbrett;

public class SpielfeldDarstellung {
    private Interaktionsbrett ib;
    private static final int seitenLaenge = 300;
    private static final int margin = 20;



    public SpielfeldDarstellung(Interaktionsbrett ib){
        this.ib = ib;
    }

    public void spielfeldDarstellen(boolean[][] spielfeld) {
        Quadrat q = null;
        abwischen();
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld.length; j++) {
                q = new Quadrat(i * (seitenLaenge / spielfeld.length) + margin, j * (seitenLaenge / spielfeld.length) + margin, (seitenLaenge / spielfeld.length));
                q.darstellenRahmen(ib);
                if (spielfeld[i][j] == Simulator.bewohnt) {
                    q.darstellenFuellung(ib);
                }
            }
        }
    }
    public void abwischen(){

        ib.abwischen();
    }
}
