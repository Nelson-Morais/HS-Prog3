package de.hsos.prog3.nelsonmorais.ab01.orchester;

import de.hsos.prog3.nelsonmorais.ab01.audio.StdAudioPlayer;
import de.hsos.prog3.nelsonmorais.ab01.audio.adapter.SimpleAudioPlayerAdapter;

import java.io.IOException;
import java.net.URL;

public class Konzert implements Verhalten {




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
