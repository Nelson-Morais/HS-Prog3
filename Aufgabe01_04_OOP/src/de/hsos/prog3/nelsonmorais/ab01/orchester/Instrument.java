package de.hsos.prog3.nelsonmorais.ab01.orchester;

public enum Instrument {
    SAXOPHON ("/Baritone.wav"), SCHLAGZEUG ("/Drum.wav"), AKKORDION ("/Accordion.wav");

    private String audiodatei;



    Instrument(String audiodatei) {
        this.audiodatei = audiodatei;
    }

    public String getAudio() {
        return audiodatei;
    }
}


