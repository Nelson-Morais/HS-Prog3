package de.hsos.prog3.nelsonmorais.ab01.orchester;

public class MusikerIn extends Mitglied{

   private Instrument instrument;


    MusikerIn(String name) {
        super(name);
    }
    MusikerIn(String name, Instrument instrument){
        super(name);
        this.instrument = instrument;
    }

    public Instrument getInstrument() {
        return instrument;
    }
}
