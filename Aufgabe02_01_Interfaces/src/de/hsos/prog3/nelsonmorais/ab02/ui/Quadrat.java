package de.hsos.prog3.nelsonmorais.ab02.ui;

import de.hsos.prog3.nelsonmorais.ab02.util.Interaktionsbrett;

public class Quadrat {

   private int x;
   private int y;
   private int seitenlaenge;



    Quadrat(int x, int y, int seitenlaenge){
        setX(x);
        setY(y);
        setSeitenlaenge(seitenlaenge);

    }

    public void darstellenRahmen(Interaktionsbrett ib){
        ib.neuesRechteck(getX(), getY(), getSeitenlaenge(), getSeitenlaenge());
    }
    public void darstellenFuellung(Interaktionsbrett ib){
        for(int i = 0; i < seitenlaenge; i++)
        ib.neueLinie(getX(),getY()+i,getX()+getSeitenlaenge(),getY()+i);
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setSeitenlaenge(int seitenlaenge){
        this.seitenlaenge = seitenlaenge;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSeitenlaenge() {
        return seitenlaenge;
    }


}
