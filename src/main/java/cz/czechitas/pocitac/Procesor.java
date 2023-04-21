package cz.czechitas.pocitac;

public class Procesor {

    String vyrobce;
    long rychlost;

    public String toString() {
        return "Vyrobce procesoru: " + vyrobce + "\n" + "Rychlost procesoru: " + rychlost + " Hz";
    }

    public long getRychlost() {
        return rychlost;
    }

    public void setRychlost(long newValue) {
        rychlost = newValue;
    }

    // Proc mas setter jen pro rychlost a ne pro vyrobce?
}
