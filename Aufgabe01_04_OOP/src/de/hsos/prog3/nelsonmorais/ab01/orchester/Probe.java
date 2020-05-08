package de.hsos.prog3.nelsonmorais.ab01.orchester;

import de.hsos.prog3.nelsonmorais.ab01.audio.StdAudioPlayer;
import de.hsos.prog3.nelsonmorais.ab01.audio.adapter.SimpleAudioPlayerAdapter;

import java.io.IOException;
import java.net.URL;

public class Probe implements Verhalten{




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
