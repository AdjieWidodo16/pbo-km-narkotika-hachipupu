package model;

import java.util.ArrayList;

/**
 * Class KnowledgeRepository digunakan
 * untuk menyimpan data Putusan.
 */

public class KnowledgeRepository {

    private ArrayList<Putusan> daftarPutusan;

    // Constructor
    public KnowledgeRepository() {
        daftarPutusan = new ArrayList<>();
    }

    // Simpan data
    public void simpan(Putusan p) {
        daftarPutusan.add(p);
    }

    // Cari berdasarkan nomor perkara
    public Putusan cariByNomor(String nomor) {

        for (Putusan p : daftarPutusan) {

            if (p.getNomorPerkara().equalsIgnoreCase(nomor)) {
                return p;
            }

        }

        return null;
    }

    // Cari berdasarkan nama terdakwa
    public ArrayList<Putusan> cariByNama(String nama) {

        ArrayList<Putusan> hasil = new ArrayList<>();

        for (Putusan p : daftarPutusan) {

            if (p.getNamaTerdakwa()
                    .toLowerCase()
                    .contains(nama.toLowerCase())) {

                hasil.add(p);
            }

        }

        return hasil;
    }

    // Filter berdasarkan jenis narkotika
    public ArrayList<Putusan> filterByJenis(String jenis) {

        ArrayList<Putusan> hasil = new ArrayList<>();

        for (Putusan p : daftarPutusan) {

            if (p.getJenisNarkotika()
                    .equalsIgnoreCase(jenis)) {

                hasil.add(p);
            }

        }

        return hasil;
    }

    // Filter berdasarkan pengadilan
    public ArrayList<Putusan> filterByPengadilan(String pengadilan) {

        ArrayList<Putusan> hasil = new ArrayList<>();

        for (Putusan p : daftarPutusan) {

            if (p.getPengadilan()
                    .equalsIgnoreCase(pengadilan)) {

                hasil.add(p);
            }

        }

        return hasil;
    }

    // Hapus data berdasarkan nomor perkara
    public boolean hapus(String nomor) {

        Putusan p = cariByNomor(nomor);

        if (p != null) {

            daftarPutusan.remove(p);
            return true;

        }

        return false;
    }

    // Ambil semua data
    public ArrayList<Putusan> getDaftarSemua() {
        return daftarPutusan;
    }

    // Total data
    public int getTotalData() {
        return daftarPutusan.size();
    }
}
