package model;

import java.util.ArrayList;

/**
 * Class KnowledgeRepository digunakan
 * untuk menyimpan data Putusan.
 */

public class KnowledgeRepository {

    private ArrayList<Putusan> daftarPutusan;

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

    // Ambil semua data
    public ArrayList<Putusan> getDaftarSemua() {
        return daftarPutusan;
    }

    // Total data
    public int getTotalData() {
        return daftarPutusan.size();
    }
}