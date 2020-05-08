package de.hsos.prog3.nelsonmorais.ab02.logik;

public interface Simulation {

    void berechneAnfanbgsGeneration(int anzahlDerZellen, int wahrscheinlichkeitDerBesiedlung);
    void berechneFolgeGeneration(int berechnungsschritte) throws InterruptedException;
    void anmeldenFuerAktualisierungsBeiAenderung(BeiAenderung beiAenderung);
}
