package de.hsos.prog3.nelsonmorais.ab01.audio.adapter;

import de.hsos.prog3.audio.SimpleAudioPlayer;
import de.hsos.prog3.nelsonmorais.ab01.audio.StdAudioPlayer;
import sun.java2d.pipe.SpanShapeRenderer;

import java.io.IOException;
import java.net.URL;

public class SimpleAudioPlayerAdapter implements StdAudioPlayer {

    SimpleAudioPlayer player;

    @Override
    public void einmaligAbspielen(URL url) throws IOException {
        player = createPlayer(url);
        tonAn();
        player.play(0);

    }

    @Override
    public void wiederholtAbspielen(URL url, int wiederholungen) throws IOException {
        player = createPlayer(url);
        tonAn();
        player.play(wiederholungen);
    }

    @Override
    public void tonAus() {
        player.setDebug(true);
        player.verboseLogging(true);

    }

    @Override
    public void tonAn() {
        player.setDebug(false);
        player.verboseLogging(true);
    }

    private SimpleAudioPlayer createPlayer(URL url) throws IOException {
        player = new SimpleAudioPlayer(url);
        return player;
    }
}
