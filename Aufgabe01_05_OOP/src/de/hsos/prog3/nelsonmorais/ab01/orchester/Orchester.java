package de.hsos.prog3.nelsonmorais.ab01.orchester;

import de.hsos.prog3.nelsonmorais.ab01.audio.StdAudioPlayer;
import de.hsos.prog3.nelsonmorais.ab01.audio.adapter.SimpleAudioPlayerAdapter;

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

    private class Konzert implements Verhalten {

        @Override
        public void spielen(Orchester orchester) throws IOException {

            URL datei = orchester.getAudiodateiKonzert();
            StdAudioPlayer audioPlayer = new SimpleAudioPlayerAdapter();
            try{
                audioPlayer.einmaligAbspielen(datei);
            }catch(Exception e){
                System.out.println("Auftritt wird abgebrochen KONZERT");
            }
        }
    }
    private class Probe implements Verhalten{

        @Override
        public void spielen(Orchester orchester) throws IOException {
            for (MusikerIn o : orchester.getMusikerInnen()){

                URL instrument = Main.class.getResource(o.getInstrument().getAudio());
                StdAudioPlayer audioPlayer = new SimpleAudioPlayerAdapter();

                try{
                    audioPlayer.einmaligAbspielen(instrument);

                }catch(Exception e) {
                    System.out.println("Probe wird abgebrochen PROBE");
                }
            }
        }
    }
}

/* AB01_1.5:
* Durch Innereklassen ist ein zugriff auf Instanzvariablen und Methoden (Auch private) der Klasse Orchester und deren spezialisierungen falls benötigt möglich.
* Durch Innereklassen können wir diese als Privat oder Public setzen je nach sichbarkeitsbedarf, Private Innereklassen sind nur sichtbar für die Klasse wo diese sich befinden.
* Innereklassen sind sehr hilfreich für Objektklassen die komplexer sind und viele Konstruktoren enthalten, durch diese können sogenante Builder-Patterns vorgesehen werden, um ein Objekt erzeugung mit geringer anfälligkeit für fehlern zu ermöglichen ( z.B. NullpointerExceptions ).
* Wenn es klassen gibt die nur von Eine klasse wie in diesem beispiel benutzt werden ist es meistens sinvoll diese klassen als Innereklassen zu implementieren.
* Innerklassen sind dennoch nicht perfekt und können zu sehr unübersichtlichen code der Umhüllendeklasse führen, dies ist hier nicht der fall da es sich um 2 ziemlich kleine klassen handelt.
*/