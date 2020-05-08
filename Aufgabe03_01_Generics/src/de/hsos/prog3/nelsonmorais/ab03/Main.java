package de.hsos.prog3.nelsonmorais.ab03;

import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input;
        do{
        System.out.println("\nWaehlen sie zwischen:\na)Flugschreiber\nb)LIFO\nc)FIFO\n\nexit eingeben zum schliessen.");
         input = scanner.nextLine();

        switch (input){
            case "a":
                try {
                    flugSchreiber();
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case "b":
                try {
                    lifo();
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;

            case "c":
                try {
                    fifo();
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case "exit":
                break;
            default:
                System.out.println("Waehlen sie eine der obere Beispiele oder geben sie 'exit' ein zum verlassen des Programms.");
                break;


        }
    }while(!input.equals("exit"));
    }


    public static void flugSchreiber() {
        int capacity = 60; //minuten, 1 aufnahme für Flughohe jede Minute
        Ringpuffer<Integer> rp = new Ringpuffer<>(60, true, true);
        int range = (12000 - 11000) + 1;
        double simulation = 1.0;
        for (int i = 0; i < capacity; i++) {
            int randy = ((int) (Math.random() * (range * simulation) + 11000));
            if (randy < 0) {
                randy = randy * -1;

            }
            rp.addFirst(randy);

            if (i > 45) {

                simulation = simulation - 1;
            }
        }
        rp.printSchreiber();
        System.out.println("Flight last Saved height before Cutting communications with Tower was: " + rp.peekFirst() + " meters.");
        if (rp.peekFirst() < 10000) {
            System.out.println("Plane experienced severe altitude loss.");
        }

        System.out.println(rp.toString());

    }

    public static void lifo() {
        System.out.println("Beispiel eines Lifos(Stack)");
        int stackData = 1;
        int capacity;
        String input;
        boolean fixed = false;
        boolean discarding = false;


        System.out.println("Fixed Capacity? (y/n)");
        input = scanner.nextLine();

        if (input.equals("y") || input.equals("Y")) {
            fixed = true;
        }

        System.out.println("How many Elements?");
        capacity = scanner.nextInt();


        Ringpuffer<String> rp = new Ringpuffer<>(capacity, fixed, discarding);

        System.out.println("adding elements: ");
        for (int i = 0; i < capacity; i++) {
            try {
                System.out.print("" + stackData + " ");
                rp.push("" + stackData++);

            } catch (Exception e) {
                System.out.println("Is Full");
            }
        }
        System.out.println();
        Iterator<String> it = rp.iterator();
        System.out.println("Stack: ");
        while (it.hasNext()) {

            System.out.print("|" + it.next() + "|\n");

        }
        System.out.println("Popping Element: " + rp.pop());
        System.out.println("Popping Element: " + rp.pop());
        System.out.println("Popping Element: " + rp.pop());


        System.out.println("Stack: ");

        it = rp.iterator();
        while (it.hasNext()) {

            System.out.print("|" + it.next() + "|\n");

        }

        System.out.println("adding elements: ");
        for (int i = 0; i < 5; i++) {
            try {

                rp.push("" + stackData++);
                System.out.println("" + (stackData - 1) + " added.");

            } catch (Exception e) {
                System.out.println("" + (stackData - 1) + " Can't be added, Lifo Is Full. Fixed Capacity: Enabled.");
            }
        }
        System.out.println("Stack: ");

        it = rp.iterator();
        while (it.hasNext()) {

            System.out.print("|" + it.next() + "|\n");

        }


    }

    public static void fifo() {
        System.out.println("Beispiel eines Fifos.");
        int capacity;
        boolean fixed = false;
        String input;
        boolean discarding = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Fixed Capacity? (y/n)");
        input = scanner.nextLine();

        if (input.equals("y") || input.equals("Y")) {
            fixed = true;
        }

        System.out.println("How many Elements?");
        capacity = scanner.nextInt();


        Ringpuffer<String> rp = new Ringpuffer<>(capacity, fixed, discarding);

        System.out.println("Adding elements: ");

        for (int i = 1; i <= capacity; i++) {
            try {
                rp.addFirst("" + i);
            } catch (Exception e) {
                System.out.println("Can't add element " + i);
            }
        }
        Iterator<String> it = rp.descendingIterator();
        System.out.println("Fifo: ");
        while (it.hasNext()) {
            System.out.print(it.next());
            System.out.print("|");
        }

        System.out.println("\nNext element to be removed: " + rp.removeLast());


        it = rp.descendingIterator();
        System.out.println("Fifo: ");
        while (it.hasNext()) {
            System.out.print(it.next());
            System.out.print("|");
        }
        System.out.println();
        try {
            System.out.println("Next element to be removed: " + rp.removeLast());
            System.out.println("Next element to be removed: " + rp.removeLast());
            System.out.println("Next element to be removed: " + rp.removeLast());
            System.out.println("Next element to be removed: " + rp.removeLast());
            System.out.println("Next element to be removed: " + rp.removeLast());
        } catch (Exception e) {
            System.out.println("Fifo is Empty.");
        }


        it = rp.descendingIterator();
        System.out.println("Fifo: ");
        while (it.hasNext()) {
            System.out.print(it.next());
            System.out.print("|");
        }

        System.out.println("Adding 5 elements: ");
        for (int i = 21; i <= 25; i++) {
            try {
                rp.addFirst("" + i);
                System.out.println("added element: " +i);
            } catch (Exception e) {
                System.out.println("Can't add element " + i);
            }
        }

        it = rp.descendingIterator();
        System.out.println("Fifo: ");
        while (it.hasNext()) {
            System.out.print(it.next());
            System.out.print("|");
        }


    }
}
