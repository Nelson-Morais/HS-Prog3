package de.hsos.prog3.nelsonmorais.ab01.orchester;



import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        String audioDatei = "/All_Together.wav";
        Orchester orchester = new Orchester ("HSOS Titty Twiester Orchestra", audioDatei);

        DirigentIn karajan = new DirigentIn("Karjan");
        orchester.addDireigentIn(karajan);

        MusikerIn trompete = new MusikerIn( "Dirk Die Lunge Mueller", Instrument.SAXOPHON);
        MusikerIn akkordion = new MusikerIn("Akki Taste", Instrument.AKKORDION);
        MusikerIn drum = new MusikerIn("Das Biest", Instrument.SCHLAGZEUG);
        orchester.addMusikerIn(trompete);
        orchester.addMusikerIn(akkordion);
        orchester.addMusikerIn(drum);

        orchester.proben(orchester);
      //  orchester.auftreten(orchester);



        try{
            orchester.spielen();
        }catch (Exception e){
            System.out.println("Wird abgebrochen");
        }
    }
}
