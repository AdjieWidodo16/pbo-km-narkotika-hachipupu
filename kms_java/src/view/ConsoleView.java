package view;

import model.Putusan;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {

    private final Scanner input;

    public ConsoleView() {
        this.input = new Scanner(System.in);
    }

    public void showTitle() {
        System.out.println("====================================================");
        System.out.println("     KNOWLEDGE MANAGEMENT SYSTEM");
        System.out.println("   PUTUSAN PENGADILAN NARKOTIKA");
        System.out.println("====================================================");
    }

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

    // Return Putusan langsung, bukan String[]
    public Putusan inputFormPutusan() {
        showTitle();
        System.out.println("========== TAMBAH DATA PUTUSAN ==========\n");

        System.out.print("Nomor Perkara        : "); String nomor      = input.nextLine();
        System.out.print("Pengadilan           : "); String pengadilan = input.nextLine();
        System.out.print("Tanggal Putusan      : "); String tanggal    = input.nextLine();
        System.out.print("Nama Terdakwa        : "); String nama       = input.nextLine();
        System.out.print("Umur Terdakwa        : "); int umur          = readInt();
        System.out.print("Jenis Narkotika      : "); String jenis      = input.nextLine();
        System.out.print("Berat Barang Bukti   : "); double berat      = readDouble();
        System.out.print("Pasal Dilanggar      : "); String pasal      = input.nextLine();
        System.out.print("Peran Terdakwa       : "); String peran      = input.nextLine();
        System.out.print("Vonis Hukuman (bln)  : "); int vonis         = readInt();
        System.out.print("Vonis Denda          : "); double denda      = readDouble();
        System.out.print("Nama Hakim           : "); String hakim      = input.nextLine();

        return new Putusan(nomor, pengadilan, tanggal, nama, umur,
                           jenis, berat, pasal, peran, vonis, denda, hakim);
    }

    // Terima List<Putusan>, bukan List<String[]>
    public void tampilkanDaftarPutusan(List<Putusan> data) {
        showTitle();
        if (data.isEmpty()) {
            System.out.println("[INFO] Tidak ada data untuk ditampilkan.");
            return;
        }
        System.out.println("==============================================================");
        System.out.printf("%-30s %-20s %-15s %-8s%n",
                "Nomor Perkara", "Terdakwa", "Narkotika", "Vonis");
        System.out.println("==============================================================");
        for (Putusan p : data) {
            System.out.printf("%-30s %-20s %-15s %-8s%n",
                    p.getNomorPerkara(),
                    p.getNamaTerdakwa(),
                    p.getJenisNarkotika(),
                    p.getVonisHukuman() + " bln");
        }
        System.out.println("==============================================================");
        System.out.println("Total: " + data.size() + " data");
    }

    // Terima Putusan langsung
    public void tampilkanDetail(Putusan p) {
        showTitle();
        System.out.println("========== DETAIL PUTUSAN ==========\n");
        System.out.println("Nomor Perkara     : " + p.getNomorPerkara());
        System.out.println("Pengadilan        : " + p.getPengadilan());
        System.out.println("Tanggal Putusan   : " + p.getTanggalPutusan());
        System.out.println("Nama Terdakwa     : " + p.getNamaTerdakwa());
        System.out.println("Umur Terdakwa     : " + p.getUmurTerdakwa());
        System.out.println("Jenis Narkotika   : " + p.getJenisNarkotika());
        System.out.println("Berat Barang Bukti: " + p.getBeratBarangBukti() + " gram");
        System.out.println("Pasal Dilanggar   : " + p.getPasalDilanggar());
        System.out.println("Peran Terdakwa    : " + p.getPeranTerdakwa());
        System.out.println("Vonis Hukuman     : " + p.getVonisHukuman() + " bulan");
        System.out.println("Vonis Denda       : Rp " + p.getVonisDenda());
        System.out.println("Nama Hakim        : " + p.getNamaHakim());
        System.out.println("Kategori Hukuman  : " + p.getKategoriHukuman());
    }

    public void tampilkanStatistik(int ringan, int sedang, int berat) {
        showTitle();
        System.out.println("========== STATISTIK PUTUSAN ==========\n");
        System.out.println("Ringan (≤12 bln) : " + ringan);
        System.out.println("Sedang (≤60 bln) : " + sedang);
        System.out.println("Berat  (>60 bln) : " + berat);
    }

    public void tampilkanPesan(String pesan) {
        System.out.println("\n" + pesan);
    }

    public void pressEnter() {
        System.out.println("\nTekan ENTER untuk lanjut...");
        input.nextLine();
    }

    private int readInt() {
        while (true) {
            try {
                int val = Integer.parseInt(input.nextLine().trim());
                return val;
            } catch (NumberFormatException e) {
                System.out.print("  [ERROR] Harus angka. Ulangi: ");
            }
        }
    }

    private double readDouble() {
        while (true) {
            try {
                double val = Double.parseDouble(input.nextLine().trim());
                return val;
            } catch (NumberFormatException e) {
                System.out.print("  [ERROR] Harus angka. Ulangi: ");
            }
        }
    }
}
