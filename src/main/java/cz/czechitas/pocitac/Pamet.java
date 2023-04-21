package cz.czechitas.pocitac;

public class Pamet {
    
    long kapacitaPameti;
    
    public String toString() {
        return "Kapacita pameti: " + kapacitaPameti + " bytes";
    }

    public long getKapacitaPameti() {
        return kapacitaPameti;
    }

    public void setKapacitaPameti(long newValue) {
        kapacitaPameti = newValue;
    }
}
