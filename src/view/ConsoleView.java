package view;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {

    private final Scanner input;

    public ConsoleView() {
        input = InputHelper.getScanner();
    }

    // =========================
    // TITLE
    // =========================
    public void showTitle() {
        System.out.println("====================================================");
        System.out.println("     KNOWLEDGE MANAGEMENT SYSTEM");
        System.out.println("   PUTUSAN PENGADILAN NARKOTIKA");
        System.out.println("====================================================");
    }

    // =========================
    // MENU
    // =========================
    public int tampilkanMenu() {
        showTitle();

        System.out.println("1. Tambah Putusan");
        System.out.println("2. Lihat Semua Putusan");
        System.out.println("3. Cari Putusan");
        System.out.println("4. Filter Putusan");
        System.out.println("5. Statistik");
        System.out.println("6. Hapus Putusan");
        System.out.println("0. Keluar");

        System.out.print("\nPilih menu : ");
        return readInt();
    }

    // =========================
    // INPUT FORM PUTUSAN
    // return String[] (DTO sederhana)
    // =========================
    public String[] inputFormPutusan() {

        showTitle();
        System.out.println("========== TAMBAH DATA PUTUSAN ==========\n");

        String[] data = new String[12];

        System.out.print("Nomor Perkara        : ");
        data[0] = input.nextLine();

        System.out.print("Pengadilan           : ");
        data[1] = input.nextLine();

        System.out.print("Tanggal Putusan      : ");
        data[2] = input.nextLine();

        System.out.print("Nama Terdakwa        : ");
        data[3] = input.nextLine();

        System.out.print("Umur Terdakwa        : ");
        data[4] = input.nextLine();

        System.out.print("Jenis Narkotika      : ");
        data[5] = input.nextLine();

        System.out.print("Berat Barang Bukti   : ");
        data[6] = input.nextLine();

        System.out.print("Pasal Dilanggar      : ");
        data[7] = input.nextLine();

        System.out.print("Peran Terdakwa       : ");
        data[8] = input.nextLine();

        System.out.print("Vonis Hukuman        : ");
        data[9] = input.nextLine();

        System.out.print("Vonis Denda          : ");
        data[10] = input.nextLine();

        System.out.print("Nama Hakim           : ");
        data[11] = input.nextLine();

        return data;
    }

    // =========================
    // TAMPILKAN DAFTAR PUTUSAN (TABEL)
    // =========================
    public void tampilkanDaftarPutusan(List<String[]> data) {

        showTitle();
        System.out.println("==============================================================");
        System.out.printf("%-12s %-20s %-18s %-10s%n",
                "No", "Terdakwa", "Narkotika", "Vonis");
        System.out.println("==============================================================");

        for (String[] p : data) {
            System.out.printf("%-12s %-20s %-18s %-10s%n",
                    p[0], p[3], p[5], p[9]);
        }

        System.out.println("==============================================================");
    }

    // =========================
    // DETAIL PUTUSAN
    // =========================
    public void tampilkanDetail(String[] p) {

        showTitle();
        System.out.println("========== DETAIL PUTUSAN ==========\n");

        System.out.println("Nomor Perkara     : " + p[0]);
        System.out.println("Pengadilan        : " + p[1]);
        System.out.println("Tanggal Putusan   : " + p[2]);
        System.out.println("Nama Terdakwa     : " + p[3]);
        System.out.println("Umur Terdakwa     : " + p[4]);
        System.out.println("Jenis Narkotika   : " + p[5]);
        System.out.println("Berat Barang Bukti: " + p[6]);
        System.out.println("Pasal Dilanggar   : " + p[7]);
        System.out.println("Peran Terdakwa    : " + p[8]);
        System.out.println("Vonis Hukuman     : " + p[9]);
        System.out.println("Vonis Denda       : " + p[10]);
        System.out.println("Nama Hakim        : " + p[11]);
    }

    // =========================
    // STATISTIK
    // =========================
    public void tampilkanStatistik(int ringan, int sedang, int berat) {

        showTitle();
        System.out.println("========== STATISTIK PUTUSAN ==========\n");

        System.out.println("Ringan : " + ringan);
        System.out.println("Sedang : " + sedang);
        System.out.println("Berat  : " + berat);
    }

    // =========================
    // PESAN
    // =========================
    public void tampilkanPesan(String pesan) {
        System.out.println("\n" + pesan);
    }

    // =========================
    // HELPER INPUT AMAN
    // =========================
    private int readInt() {
        while (!input.hasNextInt()) {
            System.out.print("Input harus angka! Ulangi: ");
            input.next();
        }
        int value = input.nextInt();
        input.nextLine(); // clear buffer
        return value;
    }

    public void pressEnter() {
        System.out.println("\nTekan ENTER untuk lanjut...");
        input.nextLine();
    }
}