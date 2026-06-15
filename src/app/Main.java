package app;

import controller.KnowledgeController;
import view.ConsoleView;

import java.util.Scanner;

/**
 * Entry point aplikasi KMS Putusan Pengadilan Narkotika.
 * Main HANYA berisi inisialisasi komponen MVC dan menjalankan loop menu.
 * TIDAK ada logika bisnis di sini.
 *
 * @author Adjie Widodo - Backend Developer (Controller)
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inisialisasi komponen MVC
        KnowledgeController controller = new KnowledgeController();
        ConsoleView view = new ConsoleView();

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   KMS PUTUSAN PENGADILAN NARKOTIKA       ║");
        System.out.println("║   Kelompok hachipupu — PBO 2025/2026     ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println("Data berhasil dimuat: " +
                           controller.getTotalData() + " putusan tersedia.\n");

        // Loop menu utama
        boolean running = true;
        while (running) {
            int pilihan = view.tampilkanMenu(sc);

            switch (pilihan) {
                case 1:
                    // Tambah putusan
                    controller.tambahPutusan(sc);
                    break;
                case 2:
                    // Tampilkan semua putusan
                    view.tampilkanDaftarPutusan(controller.getDaftarSemua());
                    break;
                case 3:
                    // Cari putusan
                    System.out.print("Cari berdasarkan (nomor/nama): ");
                    String mode = sc.nextLine().trim();
                    System.out.print("Masukkan keyword: ");
                    String keyword = sc.nextLine().trim();
                    view.tampilkanDaftarPutusan(controller.cariPutusan(keyword, mode));
                    break;
                case 4:
                    // Filter putusan
                    System.out.print("Filter berdasarkan (jenis/pengadilan): ");
                    String kriteria = sc.nextLine().trim();
                    System.out.print("Masukkan nilai filter: ");
                    String nilai = sc.nextLine().trim();
                    view.tampilkanDaftarPutusan(controller.filterPutusan(kriteria, nilai));
                    break;
                case 5:
                    // Statistik
                    view.tampilkanStatistik(controller.getStatistik());
                    break;
                case 6:
                    // Hapus putusan
                    System.out.print("Masukkan nomor perkara yang dihapus: ");
                    String nomor = sc.nextLine().trim();
                    controller.hapusPutusan(nomor);
                    break;
                case 0:
                    // Keluar
                    System.out.println("\nTerima kasih. Sampai jumpa!");
                    running = false;
                    break;
                default:
                    view.tampilkanPesan("[ERROR] Pilihan tidak valid.");
            }
        }
        sc.close();
    }
}
