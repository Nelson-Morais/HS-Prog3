package de.hsos.prog3.nelsonmorais.ab02.ui;

import de.hsos.prog3.nelsonmorais.ab02.util.EinUndAusgabe;

public class NutzerEingabe {

    private EinUndAusgabe io;
    private final int constSpieltZellen = 4;
    private final int constSchritte = 10;

    NutzerEingabe(EinUndAusgabe io){
       if(io == null){
           this.io = new EinUndAusgabe();
       }else{
           this.io = io;
       }
    }

    public int anzahlZellenDesSpeilfelds(){
        int zellen;
        System.out.println("Zellen des Spielfelds eingeben:");
        zellen = io.leseInteger();
        if(zellen < constSpieltZellen){
            System.out.println("Zahl ist kleiner als das Minimun, es werden " + constSpieltZellen + " Zellen ausgelegt.");
            zellen = constSpieltZellen;
        }
    return zellen;
   }

   public int wahrscheinlichkeitDerBesiedlung(){
        int wahrscheinlichkeit;
        do{
            System.out.println("Wahrscheinlichkeit der Besiedlung eingeben (zahl zwischen 1 und 100):");
            wahrscheinlichkeit = io.leseInteger();
        }while(wahrscheinlichkeit < 1 || wahrscheinlichkeit > 100);

        return wahrscheinlichkeit;
   }

   public int anzahlDerSimulationsschritte(){
        int schritte;

        do{
            System.out.println("Simulations Schritte eingeben (Zahl Groesser 1):");
            schritte = io.leseInteger();

        }while(schritte < 1);
        if(schritte > constSchritte){
            System.out.println("Zahl ist grosser als die Maximale mögliche Scrhitte, die Maximale Schritte: " +constSchritte +" Schritte, werden ausgeführt");
            schritte = constSchritte;
        }
        return schritte;
   }

}
