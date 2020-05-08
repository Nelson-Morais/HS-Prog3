package de.hsos.prog3.nelsonmorais.ab01.orchester;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;

public class Orchester {
    private String bezeichnung;
    private String audioDateiKonzert;
    public DirigentIn dirigentIn;
    public HashSet<MusikerIn> musikerInnen = new HashSet<MusikerIn>();
    public Verhalten verhalten;

    Orchester(String bezeichnung, String audioDateiKonzert) {
        this.bezeichnung = bezeichnung;
        this.audioDateiKonzert = audioDateiKonzert;
        this.dirigentIn = null;
        this.verhalten = null;
    }

    public void addDireigentIn(DirigentIn dirigentIn) {
        this.dirigentIn = dirigentIn;
    }

    public void addMusikerIn(MusikerIn musikerIn) {
        musikerInnen.add(musikerIn);
    }

    public HashSet<MusikerIn> getMusikerInnen() {
        return musikerInnen;
    }

    public URL getAudiodateiKonzert() {
        return Main.class.getResource(audioDateiKonzert);
    }

    public void proben(Orchester orchester) {
        Probe probe = new Probe();
        orchester.verhalten = probe;
    }

    public void auftreten(Orchester orchester) {
        Konzert konzert = new Konzert();
        orchester.verhalten = konzert;
    }

    public void spielen() throws IOException {
        verhalten.spielen(this);
    }
}
