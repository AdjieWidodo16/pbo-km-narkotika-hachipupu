package app;

import controller.KnowledgeController;
import model.Putusan;
import model.StatistikPutusan;
import view.ConsoleView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        KnowledgeController controller = new KnowledgeController();
        ConsoleView view = new ConsoleView();

        boolean running = true;
        while (running) {
            int pilihan = view.tampilkanMenu();

            switch (pilihan) {
                case 1 -> {
                    Putusan p = view.inputFormPutusan();
                    boolean ok = controller.tambahPutusan(p);
                    view.tampilkanPesan(ok ? "[SUKSES] Data berhasil ditambahkan!"
                                           : "[GAGAL] Nomor perkara sudah ada.");
                    view.pressEnter();
                }
                case 2 -> {
                    ArrayList<Putusan> semua = controller.getDaftarSemua();
                    view.tampilkanDaftarPutusan(semua);
                    view.pressEnter();
                }
                case 3 -> {
                    String mode    = view.bacaInput("Mode cari (nomor/nama): ");
                    String keyword = view.bacaInput("Keyword: ");
                    ArrayList<Putusan> hasil = controller.cariPutusan(keyword, mode);
                    view.tampilkanDaftarPutusan(hasil);
                    view.pressEnter();
                }
                case 4 -> {
                    String kriteria = view.bacaInput("Kriteria filter (jenis/pengadilan): ");
                    String nilai    = view.bacaInput("Nilai: ");
                    ArrayList<Putusan> filtered = controller.filterPutusan(kriteria, nilai);
                    view.tampilkanDaftarPutusan(filtered);
                    view.pressEnter();
                }
                case 5 -> {
                    StatistikPutusan stat = controller.getStatistik();
                    stat.tampilkanLaporan();
                    int ringan = 0, sedang = 0, berat = 0;
                    for (Putusan p : controller.getDaftarSemua()) {
                        switch (p.getKategoriHukuman()) {
                            case "Ringan" -> ringan++;
                            case "Sedang" -> sedang++;
                            case "Berat"  -> berat++;
                        }
                    }
                    view.tampilkanStatistik(ringan, sedang, berat);
                    view.pressEnter();
                }
                case 6 -> {
                    String nomor = view.bacaInput("Nomor perkara yang dihapus: ");
                    boolean ok = controller.hapusPutusan(nomor);
                    view.tampilkanPesan(ok ? "[SUKSES] Data dihapus."
                                           : "[GAGAL] Data tidak ditemukan.");
                    view.pressEnter();
                }
                case 0 -> {
                    view.tampilkanPesan("Terima kasih. Program selesai.");
                    running = false;
                }
                default -> {
                    view.tampilkanPesan("[ERROR] Pilihan tidak valid.");
                    view.pressEnter();
                }
            }
        }
    }
}
