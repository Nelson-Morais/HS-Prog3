package de.hsos.prog3.nelsonmorais.ab01;

import de.hsos.prog3.audio.SimpleAudioPlayer;
import de.hsos.prog3.nelsonmorais.ab01.audio.adapter.SimpleAudioPlayerAdapter;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        SimpleAudioPlayerAdapter playerAdapter;
        Scanner IOscanner = new Scanner(System.in);

        int navi = 0;
        String waveDatei = null;
        int loop = 0;



        do {
            System.out.println("Instrument zum abspielen auswaehlen: \n1) Accordion \n2) Baritone \n3) Drum\n4)Alle zusammen\n9)Programm beenden");
            navi = IOscanner.nextInt();
            switch (navi) {
                case 1:
                    waveDatei = "Accordion";
                    break;
                case 2:
                    waveDatei = "Baritone";
                    break;
                case 3:
                    waveDatei = "Drum";
                    break;
                case 4:
                    waveDatei = "All_Together";
                    break;
                default:
                    break;
            }
            URL url = Main.class.getResource("/"+waveDatei+".wav");
            playerAdapter = new SimpleAudioPlayerAdapter();


            System.out.println("1) Einmalig abspielen\n2) In loop abspielen");
            navi = IOscanner.nextInt();
            switch(navi){
                case 1:
                    playerAdapter.einmaligAbspielen(url);
                    break;
                case 2:
                    System.out.println("Wie oft?");
                    loop = IOscanner.nextInt();
                    playerAdapter.wiederholtAbspielen(url, loop-1);
                    break;
                default:
                    break;
            }
        }while(navi!=9);



    }
}
