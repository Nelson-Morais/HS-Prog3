package de.hsos.prog3.nelsonmorais.ab01.orchester;

public abstract class Mitglied {
    private String name;

    Mitglied(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
