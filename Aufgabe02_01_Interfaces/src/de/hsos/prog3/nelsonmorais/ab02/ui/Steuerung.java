package de.hsos.prog3.nelsonmorais.ab02.ui;

import de.hsos.prog3.nelsonmorais.ab02.logik.BeiAenderung;
import de.hsos.prog3.nelsonmorais.ab02.logik.Simulation;
import de.hsos.prog3.nelsonmorais.ab02.logik.Simulator;
import de.hsos.prog3.nelsonmorais.ab02.util.EinUndAusgabe;
import de.hsos.prog3.nelsonmorais.ab02.util.Interaktionsbrett;

public class Steuerung implements BeiAenderung {

    NutzerEingabe nutzerIo;
    Simulation sim = new Simulator();
    SpielfeldDarstellung sfd;

    public Steuerung(){

    }

    public void startDesSpiels() throws InterruptedException {
        initialisierung();
        int zellen = nutzerIo.anzahlZellenDesSpeilfelds();
        int wahrscheinlichkeit = nutzerIo.wahrscheinlichkeitDerBesiedlung();
        sim.berechneAnfanbgsGeneration(zellen,wahrscheinlichkeit);
        int anzahl = nutzerIo.anzahlDerSimulationsschritte();
        sim.berechneFolgeGeneration(anzahl);



    }

    private void initialisierung(){
        Interaktionsbrett ib = new Interaktionsbrett();
        EinUndAusgabe io = new EinUndAusgabe();
        nutzerIo = new NutzerEingabe(io);
        sfd = new SpielfeldDarstellung(ib);
        sim.anmeldenFuerAktualisierungsBeiAenderung(this);
    }



    @Override
    public void aktualisiere(boolean[][] neueGeneration) {
    sfd.spielfeldDarstellen(neueGeneration);
    }
}
