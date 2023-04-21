package cz.czechitas.pocitac;

import java.security.*;
import javax.sound.midi.*;

public class Pocitac {

    boolean jeZapnuty = false;
    Procesor cpu;
    Pamet ram;
    Disk pevnyDisk;
    Disk druhyDisk;

    public String toString() {
        return "PROCESOR POCITACE: " + "\n" + cpu + "\n" + "PAMET POCITACE: " + "\n" + ram + "\n" +
                "PEVNY DISK POCITACE: " + "\n" + pevnyDisk + "\n" + "DRUHY DISK POCITACE: " + "\n" + druhyDisk;
        // Moc hezky odradkovane :)
    }

    public void zapniSe() {
        if (cpu == null) {
            jeZapnuty = false;
            System.out.println("Error: Processor not found");
        }
        if (ram == null) {
            jeZapnuty = false;
            System.out.println("Error: Memory not found");
        }
        if (pevnyDisk == null) {
            jeZapnuty = false;
            System.out.println("Error: Storage not found");
        }
        if (jeZapnuty) {
            System.out.println("Error: PC is already on");
            return;
            // Tohle by asi mela byt uplne prvni podminka. Jestli je pocitac uz zapnuty,
            // neni potreba kontrolovat soucasti.
        }
        if (cpu != null && ram != null && pevnyDisk != null) {
                jeZapnuty = true;
                System.out.println("PC IS ON!");
        }
        /*
         * Pokud bys chtela dodrzet single-responsibility princip (viz. wikipedia), tak bys tuhle metodu mela rozbit jeste do dalsich.
         * V podstate pro kazdy if spesl metoda, checkRam, checkDisk, checkCPU,... A v teto souhrnne metode pak jen vsechny dilci zavolas
         * a vratis nejaky vysledek. Tzn. zbavila by ses vsech tech return, jen bys jednim ifem overila, ze ma pocitac vsechny komponenty
         * pro zapnuti, a pak ho bud zapla nebo vypsala chybovou hlasku.
         * Vyhodu by to zacalo predstavovat v pripade, ze bys do teto tridy pridavala dalsi funkcionalitu, ktera by taky potrebovala checkovat,
         * jestli existuje treba procesor, pamet atd. Nebo kdybys naopak potrebovala overit jeste nejake dalsi veci proto, aby se pocitac uspesne
         * zapnul.
         * Jednoduse, cim min kodu musis upravovat, kdyz chces v programu neco menit, tim lepe - jednak z ohledu na casovou narocnost, druhak
         * je mensi sance, ze si vyrobis chyby :) */
        
    }

    public void vypniSe() {
        if (jeZapnuty == true) {
            jeZapnuty = false;
            System.out.println("PC IS OFF!");
        }
        // Mohl by tu opet byt i else pro pripadny opakovany pokus o vypnuti.
    }

    public void vytvorSouborOVelokisti(long velikost) {
        if (jeZapnuty == true) {
            long volneMistoNaDiskuPrvnimDisku = pevnyDisk.getKapacita() - pevnyDisk.getVyuziteMisto();
            // Za me fajn, ze jsi to ulozila do promenne. Nemusim u kazdeho ifu premyslet, jestli to mas napsane spravne :) - to je ta prehlednost
            // Akorat mas v nazvu dvakrat slovo disk. Pokud budes chtit prejmenovat, nedelej to po jednom, pouzij refactoring, ktery ti
            // prejmenuje vsechna pouziti te promenne naraz. Shift + F6 nebo pravy klik mysi -> refactor -> rename.

            if (velikost <= 0) {
                System.out.println("Error: Does not compute");  // Hezky, na to zatim nikdo jiny nemyslel :)
            } else if (velikost <= volneMistoNaDiskuPrvnimDisku) {
                pevnyDisk.setVyuziteMisto(pevnyDisk.getVyuziteMisto() + velikost);
                System.out.println("Na prvnim disku je volnych: " +
                        (pevnyDisk.getKapacita() - pevnyDisk.getVyuziteMisto()) + " bytes");
            } else if (velikost > volneMistoNaDiskuPrvnimDisku &&
                    velikost <= (druhyDisk.getKapacita() - druhyDisk.getVyuziteMisto())) {
                // Tuhle podminku by slo zjednodusit. Prvni cast smazat (ta se kontroluje uz tim, ze se preskocilo predchozi else-if),
                // pro druhou cas by sis mohla taky vytvorit promennou, aby byl kod jednotny. Hned pod tou pro prvni disk.

                    druhyDisk.setVyuziteMisto(druhyDisk.getVyuziteMisto() + velikost);
                    System.out.println("Na druhem disku je volnych: " +
                        (druhyDisk.getKapacita() - druhyDisk.getVyuziteMisto()) + " bytes");
            }
            else {
                System.out.println("Error: Disk is full");
            }
        } else {
            System.out.println("...");
        }
    }

    public void vymazSouborOVelikosti(long velikost) {
        if (jeZapnuty == false) {
            System.out.println("...");
        } else {
            if (velikost <= 0) {
                System.out.println("Error: Does not compute");
            } else if (velikost <= druhyDisk.getVyuziteMisto()) {
                druhyDisk.setVyuziteMisto(druhyDisk.getVyuziteMisto() - velikost);
                System.out.println("Na druhem disku je volnych: " +
                        (druhyDisk.getKapacita() - druhyDisk.getVyuziteMisto() + " bytes"));
            } else if (velikost <= pevnyDisk.getVyuziteMisto()) {
                pevnyDisk.setVyuziteMisto(pevnyDisk.getVyuziteMisto() - velikost);
                System.out.println("Na prvnim disku je volnych: " +
                        (pevnyDisk.getKapacita() - pevnyDisk.getVyuziteMisto()) + " bytes");
            } else {
                System.out.println("Error: Not enough bytes to be erased");
                // Tohle me rozesmalo :)
                // Mozna bys mohla vymazat na nulu a napsat hlasku ve smyslu, ze disk je kompletne prazdny.
            }
        }
    }

}
