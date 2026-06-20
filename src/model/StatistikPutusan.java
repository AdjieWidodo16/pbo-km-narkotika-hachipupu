package model;

/**
 * Class StatistikPutusan digunakan
 * untuk menghitung statistik putusan.
 */

import java.util.ArrayList;

public class StatistikPutusan {

    // Hitung rata-rata vonis
    public double rataRataVonis(ArrayList<Putusan> daftar) {

        if (daftar.isEmpty()) {
            return 0;
        }

        int total = 0;

        for (Putusan p : daftar) {
            total += p.getVonisHukuman();
        }

        return (double) total / daftar.size();
    }

    // Hitung jumlah data
    public int totalPutusan(ArrayList<Putusan> daftar) {
        return daftar.size();
    }

}