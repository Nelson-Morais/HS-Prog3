package de.hsos.prog3.nelsonmorais.ab01;
import java.util.HashSet;
import java.util.Scanner;

public class App {
    static HashSet<Nachbar> nachbarList = new HashSet<>();
    public static void main(String[] args) {

        String nachbarVorname, nachbarNachname;

        int navi = 1;
        Scanner ioInput = new Scanner(System.in);

        do {

            System.out.println("Input Vorname");
            nachbarVorname = ioInput.next();

            System.out.println("Input Nachname");
            nachbarNachname = ioInput.next();

            Nachbar nachbar = new Nachbar(nachbarVorname,nachbarNachname);
            nachbarList.add(nachbar);


            System.out.println("To add more Objects press (1) to finish and say Hello press (0).");
            navi = ioInput.nextInt();

        }while(navi != 0);
        System.out.print("Hello");
        for( Nachbar o : nachbarList){
            System.out.print(", " + o.getVorname()+ " " + o.getNachname());
        }

    }


}
