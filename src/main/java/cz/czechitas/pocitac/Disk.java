package cz.czechitas.pocitac;

public class Disk {

    long kapacitaDisku;
    long vyuziteMisto;

    public String toString() {
        return "Kapaciata disku: " + kapacitaDisku + " bytes"+ "\n" + "Vyuzete misto na disku: " +
                vyuziteMisto + " bytes";
    }

    public long getVyuziteMisto() {
        return vyuziteMisto;
    }

    public void setVyuziteMisto(long newValue) {
        vyuziteMisto = newValue;
    }

    public long getKapacita() {
        return kapacitaDisku;
    }

    public void setKapacita(long newValue) {
        kapacitaDisku = newValue;
    }

    /*Bezva, ze jsi objevila settery a gettery! :)
    * Abys plne vyuzila jejich potencial, tak by chtelo nastavit atributy (vlastnosti) tridy na 'private'.
    *
    * private long kapacitaDisku;
    * private long vyuziteMisto;
    *
    * Tim padem k nim nebude mozne odjinud (mimo tuto tridu) pristoupit pres teckovou notaci. Tzn. konkretni hodnoty
    * bude mozne vzdy nastavovat jedine pres setter a ziskavat jedine pres getter.
    * Je to mnohem bezpecnejsi zpusob pristupu k atributum, protoze do setteru si muzes, pokud je to potreba, naprogramovat
    * nejakou vnitrni logiku, ktera ti treba zkontroluje, jestli je zadavana hodnota validni ap.*/

}
