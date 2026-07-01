package model;

import java.util.ArrayList;

/**
 * Class StatistikPutusan digunakan
 * untuk menghitung statistik putusan.
 */

public class StatistikPutusan {

    private ArrayList<Putusan> daftarPutusan;

    // Constructor
    public StatistikPutusan(ArrayList<Putusan> daftarPutusan) {
        this.daftarPutusan = daftarPutusan;
    }

    // Hitung rata-rata vonis
    public double rataRataVonis() {

        if (daftarPutusan.isEmpty()) {
            return 0;
        }

        int total = 0;

        for (Putusan p : daftarPutusan) {
            total += p.getVonisHukuman();
        }

        return (double) total / daftarPutusan.size();
    }

    // Hitung rata-rata denda
    public double rataRataDenda() {

        if (daftarPutusan.isEmpty()) {
            return 0;
        }

        double total = 0;

        for (Putusan p : daftarPutusan) {
            total += p.getVonisDenda();
        }

        return total / daftarPutusan.size();
    }

    // Hitung jumlah data
    public int totalPutusan() {
        return daftarPutusan.size();
    }

    // Tampilkan laporan
    public void tampilkanLaporan() {
        System.out.println("===== Statistik Putusan =====");
        System.out.println("Total Putusan    : " + totalPutusan());
        System.out.printf("Rata-rata Vonis  : %.1f bulan%n", rataRataVonis());
        System.out.printf("Rata-rata Denda  : Rp %,.0f%n", rataRataDenda());
    }

}
