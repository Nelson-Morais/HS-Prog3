package de.hsos.prog3.nelsonmorais.ab02.logik;

import java.util.Random;

public class Simulator implements Simulation {

    private boolean[][] spielfeld;
    private BeiAenderung beiAenderung;
    private Random rnd = new Random();
    public final static boolean bewohnt = true;
    public final static boolean unbewohnt = false;

    @Override
    public void berechneAnfanbgsGeneration(int anzahlDerZellen, int wahrscheinlichkeitDerBesiedlung) {
        spielfeld = new boolean[anzahlDerZellen][anzahlDerZellen];
        if (beiAenderung != null) {
            for (int i = 0; i < spielfeld.length; i++) {
                for (int j = 0; j < spielfeld[i].length; j++) {
                    int randy = rnd.nextInt();
                    if (randy < wahrscheinlichkeitDerBesiedlung) {
                        spielfeld[i][j] = bewohnt;
                    } else {
                        spielfeld[i][j] = unbewohnt;
                    }
                }

            }
            beiAenderung.aktualisiere(spielfeld);
        }
    }

    @Override
    public void berechneFolgeGeneration(int berechnungsschritte) throws InterruptedException {
        if (beiAenderung != null) {
            for (int i = 0; i < berechnungsschritte; i++) {
                for (int j = 0; j < spielfeld.length; j++) {
                    for (int k = 0; k < spielfeld[j].length; k++) {
                        checkZellen(spielfeld, j, k);
                    }
                }
                Thread.sleep(2000);
                beiAenderung.aktualisiere(spielfeld);
            }
        }

    }

    @Override
    public void anmeldenFuerAktualisierungsBeiAenderung(BeiAenderung beiAenderung) {
        this.beiAenderung = beiAenderung;

    }

    private static void checkZellen(boolean[][] spielfeld, int i, int j) {
        int counter = 0;

        if (i == 0 && j == 0) {
            if (spielfeld[i][j + 1] == bewohnt) {
                counter++;
            }
            if (spielfeld[i + 1][j] == bewohnt) {
                counter++;
            }
            if (spielfeld[i + 1][j + 1] == bewohnt) {
                counter++;
            }
        } else if (i == 0 && j == spielfeld[i].length - 1) {
            if (spielfeld[i][j - 1] == bewohnt) {
                counter++;
            }
            if (spielfeld[i + 1][j] == bewohnt) {
                counter++;
            }
            if (spielfeld[i + 1][j - 1] == bewohnt) {
                counter++;
            }
        } else if (i == spielfeld.length - 1 && j == 0) {
            if (spielfeld[i - 1][j] == bewohnt) {
                counter++;
            }
            if (spielfeld[i - 1][j + 1] == bewohnt) {
                counter++;
            }
            if (spielfeld[i][j + 1]) {
                counter++;
            }
        } else if (i == spielfeld.length - 1 && j == spielfeld[i].length - 1) {
            if (spielfeld[i][j - 1] == bewohnt) {
                counter++;
            }
            if (spielfeld[i - 1][j - 1] == bewohnt) {
                counter++;
            }
            if (spielfeld[i - 1][j] == bewohnt) {
                counter++;
            }
        } else if (j == 0) {
            if (spielfeld[i - 1][j] == bewohnt) {
                counter++;
            }
            if (spielfeld[i - 1][j + 1] == bewohnt) {
                counter++;
            }
            if (spielfeld[i][j + 1] == bewohnt) {
                counter++;
            }
            if (spielfeld[i + 1][j + 1] == bewohnt) {
                counter++;
            }
            if (spielfeld[i + 1][j] == bewohnt) {
                counter++;
            }
        } else if (i == 0) {
            if (spielfeld[i][j - 1] == bewohnt) {
                counter++;
            }
            if (spielfeld[i + 1][j - 1] == bewohnt) {
                counter++;
            }
            if (spielfeld[i + 1][j] == bewohnt) {
                counter++;
            }
            if (spielfeld[i + 1][j + 1] == bewohnt) {
                counter++;

            }
            if (spielfeld[i][j + 1] == bewohnt) {
                counter++;
            }
        } else if (j == spielfeld[i].length - 1) {
            if (spielfeld[i - 1][j] == bewohnt) {
                counter++;
            }
            if (spielfeld[i - 1][j - 1] == bewohnt) {
                counter++;
            }
            if (spielfeld[i][j - 1] == bewohnt) {
                counter++;
            }
            if (spielfeld[i + 1][j - 1] == bewohnt) {
                counter++;
            }
            if (spielfeld[i + 1][j] == bewohnt) {
                counter++;
            }
        } else if (i == spielfeld.length - 1) {
            if (spielfeld[i][j - 1] == bewohnt) {
                counter++;
            }
            if (spielfeld[i - 1][j - 1] == bewohnt) {
                counter++;
            }
            if (spielfeld[i - 1][j] == bewohnt) {
                counter++;
            }
            if (spielfeld[i - 1][j + 1] == bewohnt) {
                counter++;
            }
            if (spielfeld[i][j + 1] == bewohnt) {
                counter++;
            }
        } else {
            if (spielfeld[i - 1][j - 1] == bewohnt) {
                counter++;
            }
            if (spielfeld[i - 1][j] == bewohnt) {
                counter++;
            }
            if (spielfeld[i - 1][j + 1] == bewohnt) {
                counter++;
            }
            if (spielfeld[i][j + 1] == bewohnt) {
                counter++;
            }
            if (spielfeld[i + 1][j + 1] == bewohnt) {
                counter++;
            }
            if (spielfeld[i + 1][j] == bewohnt) {
                counter++;
            }
            if (spielfeld[i + 1][j - 1] == bewohnt) {
                counter++;
            }
            if (spielfeld[i][j - 1] == bewohnt) {
                counter++;
            }
        }
        if ((spielfeld[i][j] == bewohnt && counter == 2)) {
            spielfeld[i][j] = bewohnt;
        } else if (spielfeld[i][j] == bewohnt && counter == 3) {
            spielfeld[i][j] = bewohnt;
        } else if (spielfeld[i][j] == unbewohnt && counter == 3) {
            spielfeld[i][j] = bewohnt;
        } else {
            spielfeld[i][j] = unbewohnt;
        }


    }


}
