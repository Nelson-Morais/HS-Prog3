package de.hsos.prog3.nelsonmorais.ab01.orchester;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusikerIn musikerIn = (MusikerIn) o;
        return instrument == musikerIn.instrument;
    }

    @Override
    public int hashCode() {
        return Objects.hash(instrument);
    }
}
