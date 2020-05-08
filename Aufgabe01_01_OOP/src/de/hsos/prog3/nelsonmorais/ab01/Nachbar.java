package de.hsos.prog3.nelsonmorais.ab01;

public class Nachbar {
    String vorname;
    String nachname;

    public Nachbar(String vorname, String nachname) {
        setVorname(vorname);
        setNachname(nachname);
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return this.vorname;
    }

    public String getNachname() {
        return this.nachname;
    }
}
