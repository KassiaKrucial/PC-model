package cz.czechitas.pocitac;

import java.sql.*;
import javax.sound.midi.*;

public class SpousteciTrida {
    /*
    * Kacko, bezva! Mas to dovedene temer k dokonalosti ;) Komentare jsou spis info prozatim nad ramec probraneho.
    * Jsi sikovna, ze jsi objevila a zkusila settery a gettery!
    * Asi by bylo fajn byt jazykove konzistentni. Bud vsechny hlasky anglicky nebo vsechny hlasky cesky ;)*/

    public static void main(String[] args) {

        // mas naprogramovane settery, tak je vyuzij ;) Vic k setterum ve tride Disk.

        Procesor mujProcesor = new Procesor();
        mujProcesor.vyrobce = "Intel";
        mujProcesor.rychlost = 4600 * 1000L * 1000L;
        // mujProcesor.setRychlost(4600 * 1000L * 1000L);
        // setter pro vyrobce ti chybi.

        Pamet mojePamet = new Pamet();
        mojePamet.kapacitaPameti = 128 * 1000L * 1000L * 1000L;
        // mojePamet.setKapacitaPameti(128 * 1000L * 1000L * 1000L);
        // atd... :)

        Disk prvniDisk = new Disk();
        prvniDisk.kapacitaDisku = 1000 * 1000L * 1000L * 1000L;
        prvniDisk.vyuziteMisto = 0;


        Disk druhyDisk = new Disk();
        druhyDisk.kapacitaDisku = 8000 * 1000L * 1000L * 1000L;


        Pocitac mujPocitac = new Pocitac();

        //mujPocitac.zapniSe();
        //mujPocitac.vytvorSouborOVelokisti(2000000);
        //mujPocitac.vymazSouborOVelikosti(5000);


        mujPocitac.cpu = mujProcesor;
        mujPocitac.ram = mojePamet;
        mujPocitac.pevnyDisk = prvniDisk;
        mujPocitac.druhyDisk = druhyDisk;

        System.out.println(mujPocitac);
        System.out.println(mujProcesor);

        mujPocitac.zapniSe();
        mujPocitac.vytvorSouborOVelokisti(2000000);
        mujPocitac.vymazSouborOVelikosti(5000);
        mujPocitac.zapniSe();
        mujPocitac.vymazSouborOVelikosti(1000000000000000000L);
        mujPocitac.vypniSe();
        mujPocitac.vypniSe();

    }

}
