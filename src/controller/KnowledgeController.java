package controller;

import model.KnowledgeRepository;
import model.Putusan;
import model.StatistikPutusan;

import java.util.ArrayList;

/**
 * Controller utama — menjembatani Model dan View.
 * Semua logika bisnis ada di sini, BUKAN di View atau Main.
 *
 * @author Adjie Widodo - Backend Developer (Controller)
 * @version 1.0
 */
public class KnowledgeController {

    private KnowledgeRepository repository;

    public KnowledgeController() {
        this.repository = new KnowledgeRepository();
        muatDataSampel();
    }

    // ==================== TAMBAH ====================
    public boolean tambahPutusan(Putusan p) {
        if (repository.cariByNomor(p.getNomorPerkara()) != null) {
            System.out.println("[GAGAL] Nomor perkara sudah ada di sistem.");
            return false;
        }
        repository.simpan(p);
        System.out.println("[SUKSES] Putusan berhasil disimpan. Total data: " + repository.getTotalData());
        return true;
    }

    // ==================== CARI ====================
    public ArrayList<Putusan> cariPutusan(String keyword, String mode) {
        ArrayList<Putusan> hasil = new ArrayList<>();
        if (keyword == null || keyword.isEmpty()) {
            System.out.println("[INFO] Keyword tidak boleh kosong.");
            return hasil;
        }
        switch (mode.toLowerCase()) {
            case "nomor":
                Putusan p = repository.cariByNomor(keyword);
                if (p != null) hasil.add(p);
                else System.out.println("[INFO] Nomor perkara tidak ditemukan.");
                break;
            case "nama":
                hasil = repository.cariByNama(keyword);
                if (hasil.isEmpty())
                    System.out.println("[INFO] Tidak ada terdakwa dengan nama: " + keyword);
                break;
            default:
                System.out.println("[INFO] Mode tidak dikenal. Gunakan 'nomor' atau 'nama'.");
        }
        return hasil;
    }

    // ==================== FILTER ====================
    public ArrayList<Putusan> filterPutusan(String kriteria, String nilai) {
        ArrayList<Putusan> hasil;
        switch (kriteria.toLowerCase()) {
            case "jenis":
                hasil = repository.filterByJenis(nilai);
                break;
            case "pengadilan":
                hasil = repository.filterByPengadilan(nilai);
                break;
            default:
                System.out.println("[INFO] Kriteria tidak dikenal. Gunakan 'jenis' atau 'pengadilan'.");
                return new ArrayList<>();
        }
        if (hasil.isEmpty())
            System.out.println("[INFO] Tidak ada data yang cocok dengan filter: " + nilai);
        return hasil;
    }

    // ==================== HAPUS ====================
    public boolean hapusPutusan(String nomor) {
        if (nomor == null || nomor.isEmpty()) {
            System.out.println("[GAGAL] Nomor perkara tidak boleh kosong.");
            return false;
        }
        boolean hasil = repository.hapus(nomor);
        if (hasil) System.out.println("[SUKSES] Putusan " + nomor + " berhasil dihapus.");
        else       System.out.println("[GAGAL] Nomor perkara '" + nomor + "' tidak ditemukan.");
        return hasil;
    }

    // ==================== STATISTIK ====================
    public StatistikPutusan getStatistik() {
        return new StatistikPutusan(repository.getDaftarSemua());
    }

    // ==================== GETTER ====================
    public ArrayList<Putusan> getDaftarSemua() {
        return repository.getDaftarSemua();
    }

    public int getTotalData() {
        return repository.getTotalData();
    }

    // ==================== DATA SAMPEL 50 PUTUSAN ====================
    private void muatDataSampel() {
        repository.simpan(new Putusan("1/Pid.Sus/2024/PN Sby","PN Surabaya","10-01-2024","Budi Santoso",28,"Sabu-sabu",10.5,"Pasal 112 ayat 1","Pengguna",24,800000000,"H. Bambang"));
        repository.simpan(new Putusan("2/Pid.Sus/2024/PN Sby","PN Surabaya","11-01-2024","Siti Rahayu",35,"Ganja",250.0,"Pasal 111 ayat 1","Bandar",60,1000000000,"H. Slamet"));
        repository.simpan(new Putusan("3/Pid.Sus/2024/PN Sby","PN Surabaya","12-01-2024","Ahmad Fauzi",22,"Sabu-sabu",5.2,"Pasal 112 ayat 1","Kurir",36,800000000,"H. Bambang"));
        repository.simpan(new Putusan("4/Pid.Sus/2024/PN Sby","PN Surabaya","15-01-2024","Dewi Lestari",30,"Ekstasi",50.0,"Pasal 114 ayat 1","Bandar",48,1000000000,"H. Wahyudi"));
        repository.simpan(new Putusan("5/Pid.Sus/2024/PN Sby","PN Surabaya","16-01-2024","Eko Prasetyo",25,"Sabu-sabu",3.1,"Pasal 112 ayat 1","Pengguna",18,800000000,"H. Slamet"));
        repository.simpan(new Putusan("6/Pid.Sus/2024/PN Sby","PN Surabaya","17-01-2024","Fajar Nugroho",40,"Heroin",2.5,"Pasal 112 ayat 2","Penyimpan",72,1000000000,"H. Bambang"));
        repository.simpan(new Putusan("7/Pid.Sus/2024/PN Sby","PN Surabaya","18-01-2024","Gita Pertiwi",27,"Ganja",500.0,"Pasal 111 ayat 2","Bandar",84,1000000000,"H. Wahyudi"));
        repository.simpan(new Putusan("8/Pid.Sus/2024/PN Sby","PN Surabaya","19-01-2024","Hendra Wijaya",33,"Sabu-sabu",15.0,"Pasal 112 ayat 2","Kurir",48,1000000000,"H. Slamet"));
        repository.simpan(new Putusan("9/Pid.Sus/2024/PN Sby","PN Surabaya","22-01-2024","Indah Sari",29,"Ekstasi",20.0,"Pasal 114 ayat 1","Pengedar",36,800000000,"H. Bambang"));
        repository.simpan(new Putusan("10/Pid.Sus/2024/PN Sby","PN Surabaya","23-01-2024","Joko Susilo",45,"Sabu-sabu",7.8,"Pasal 112 ayat 1","Penyimpan",30,800000000,"H. Wahyudi"));
        repository.simpan(new Putusan("11/Pid.Sus/2024/PN Sby","PN Surabaya","24-01-2024","Kartika Dewi",32,"Sabu-sabu",12.0,"Pasal 112 ayat 2","Bandar",60,1000000000,"H. Slamet"));
        repository.simpan(new Putusan("12/Pid.Sus/2024/PN Sby","PN Surabaya","25-01-2024","Lukman Hakim",38,"Ganja",150.0,"Pasal 111 ayat 1","Kurir",42,800000000,"H. Bambang"));
        repository.simpan(new Putusan("13/Pid.Sus/2024/PN Sby","PN Surabaya","26-01-2024","Maya Indah",24,"Sabu-sabu",4.5,"Pasal 112 ayat 1","Pengguna",12,800000000,"H. Wahyudi"));
        repository.simpan(new Putusan("14/Pid.Sus/2024/PN Sby","PN Surabaya","29-01-2024","Nanda Putra",31,"Ekstasi",100.0,"Pasal 114 ayat 2","Bandar",72,1000000000,"H. Slamet"));
        repository.simpan(new Putusan("15/Pid.Sus/2024/PN Sby","PN Surabaya","30-01-2024","Oki Setiawan",26,"Sabu-sabu",6.3,"Pasal 112 ayat 1","Kurir",24,800000000,"H. Bambang"));
        repository.simpan(new Putusan("16/Pid.Sus/2024/PN Sby","PN Surabaya","31-01-2024","Putri Amalia",23,"Ganja",80.0,"Pasal 111 ayat 1","Pengedar",30,800000000,"H. Wahyudi"));
        repository.simpan(new Putusan("17/Pid.Sus/2024/PN Sby","PN Surabaya","01-02-2024","Rizky Maulana",34,"Sabu-sabu",20.0,"Pasal 112 ayat 2","Bandar",84,1000000000,"H. Slamet"));
        repository.simpan(new Putusan("18/Pid.Sus/2024/PN Sby","PN Surabaya","02-02-2024","Sari Wulandari",28,"Heroin",1.8,"Pasal 112 ayat 1","Penyimpan",36,800000000,"H. Bambang"));
        repository.simpan(new Putusan("19/Pid.Sus/2024/PN Sby","PN Surabaya","05-02-2024","Toni Kurniawan",42,"Sabu-sabu",9.0,"Pasal 112 ayat 1","Pengguna",18,800000000,"H. Wahyudi"));
        repository.simpan(new Putusan("20/Pid.Sus/2024/PN Sby","PN Surabaya","06-02-2024","Umar Farhan",37,"Ekstasi",75.0,"Pasal 114 ayat 1","Bandar",60,1000000000,"H. Slamet"));
        repository.simpan(new Putusan("21/Pid.Sus/2024/PN Sby","PN Surabaya","07-02-2024","Vina Oktavia",25,"Sabu-sabu",2.8,"Pasal 112 ayat 1","Kurir",24,800000000,"H. Bambang"));
        repository.simpan(new Putusan("22/Pid.Sus/2024/PN Sby","PN Surabaya","08-02-2024","Wahyu Hidayat",30,"Ganja",300.0,"Pasal 111 ayat 2","Bandar",96,1000000000,"H. Wahyudi"));
        repository.simpan(new Putusan("23/Pid.Sus/2024/PN Sby","PN Surabaya","09-02-2024","Xena Fitriani",22,"Sabu-sabu",1.5,"Pasal 112 ayat 1","Pengguna",9,800000000,"H. Slamet"));
        repository.simpan(new Putusan("24/Pid.Sus/2024/PN Sby","PN Surabaya","12-02-2024","Yusuf Pratama",36,"Ekstasi",40.0,"Pasal 114 ayat 1","Pengedar",48,800000000,"H. Bambang"));
        repository.simpan(new Putusan("25/Pid.Sus/2024/PN Sby","PN Surabaya","13-02-2024","Zahra Nabila",27,"Sabu-sabu",8.5,"Pasal 112 ayat 1","Penyimpan",30,800000000,"H. Wahyudi"));
        repository.simpan(new Putusan("26/Pid.Sus/2024/PN Sby","PN Surabaya","14-02-2024","Agus Salim",44,"Ganja",200.0,"Pasal 111 ayat 2","Bandar",72,1000000000,"H. Slamet"));
        repository.simpan(new Putusan("27/Pid.Sus/2024/PN Sby","PN Surabaya","15-02-2024","Bayu Anggara",29,"Sabu-sabu",11.2,"Pasal 112 ayat 2","Kurir",42,1000000000,"H. Bambang"));
        repository.simpan(new Putusan("28/Pid.Sus/2024/PN Sby","PN Surabaya","16-02-2024","Citra Aulia",24,"Heroin",3.2,"Pasal 112 ayat 1","Penyimpan",48,800000000,"H. Wahyudi"));
        repository.simpan(new Putusan("29/Pid.Sus/2024/PN Sby","PN Surabaya","19-02-2024","Dimas Prayoga",31,"Sabu-sabu",5.7,"Pasal 112 ayat 1","Pengguna",15,800000000,"H. Slamet"));
        repository.simpan(new Putusan("30/Pid.Sus/2024/PN Sby","PN Surabaya","20-02-2024","Elsa Permata",26,"Ekstasi",60.0,"Pasal 114 ayat 1","Bandar",60,1000000000,"H. Bambang"));
        repository.simpan(new Putusan("31/Pid.Sus/2024/PN Sby","PN Surabaya","21-02-2024","Fandi Ahmad",39,"Sabu-sabu",18.0,"Pasal 112 ayat 2","Bandar",78,1000000000,"H. Wahyudi"));
        repository.simpan(new Putusan("32/Pid.Sus/2024/PN Sby","PN Surabaya","22-02-2024","Galuh Puspita",33,"Ganja",120.0,"Pasal 111 ayat 1","Kurir",36,800000000,"H. Slamet"));
        repository.simpan(new Putusan("33/Pid.Sus/2024/PN Sby","PN Surabaya","23-02-2024","Haris Fauzan",28,"Sabu-sabu",3.9,"Pasal 112 ayat 1","Pengguna",12,800000000,"H. Bambang"));
        repository.simpan(new Putusan("34/Pid.Sus/2024/PN Sby","PN Surabaya","26-02-2024","Irma Yanti",35,"Ekstasi",90.0,"Pasal 114 ayat 2","Bandar",84,1000000000,"H. Wahyudi"));
        repository.simpan(new Putusan("35/Pid.Sus/2024/PN Sby","PN Surabaya","27-02-2024","Jihan Safira",23,"Sabu-sabu",2.1,"Pasal 112 ayat 1","Kurir",18,800000000,"H. Slamet"));
        repository.simpan(new Putusan("36/Pid.Sus/2024/PN Sby","PN Surabaya","28-02-2024","Kiki Amalia",41,"Ganja",400.0,"Pasal 111 ayat 2","Bandar",108,1000000000,"H. Bambang"));
        repository.simpan(new Putusan("37/Pid.Sus/2024/PN Sby","PN Surabaya","01-03-2024","Lutfi Harun",27,"Sabu-sabu",7.3,"Pasal 112 ayat 1","Penyimpan",24,800000000,"H. Wahyudi"));
        repository.simpan(new Putusan("38/Pid.Sus/2024/PN Sby","PN Surabaya","04-03-2024","Melani Putri",32,"Heroin",4.1,"Pasal 112 ayat 2","Pengedar",60,1000000000,"H. Slamet"));
        repository.simpan(new Putusan("39/Pid.Sus/2024/PN Sby","PN Surabaya","05-03-2024","Niko Setiawan",38,"Sabu-sabu",13.5,"Pasal 112 ayat 2","Bandar",72,1000000000,"H. Bambang"));
        repository.simpan(new Putusan("40/Pid.Sus/2024/PN Sby","PN Surabaya","06-03-2024","Olin Rahayu",25,"Ekstasi",30.0,"Pasal 114 ayat 1","Kurir",30,800000000,"H. Wahyudi"));
        repository.simpan(new Putusan("41/Pid.Sus/2024/PN Sby","PN Surabaya","07-03-2024","Pandu Kusuma",34,"Sabu-sabu",6.8,"Pasal 112 ayat 1","Pengguna",21,800000000,"H. Slamet"));
        repository.simpan(new Putusan("42/Pid.Sus/2024/PN Sby","PN Surabaya","08-03-2024","Qori Handayani",29,"Ganja",180.0,"Pasal 111 ayat 1","Bandar",60,1000000000,"H. Bambang"));
        repository.simpan(new Putusan("43/Pid.Sus/2024/PN Sby","PN Surabaya","11-03-2024","Rafi Iskandar",43,"Sabu-sabu",16.0,"Pasal 112 ayat 2","Kurir",54,1000000000,"H. Wahyudi"));
        repository.simpan(new Putusan("44/Pid.Sus/2024/PN Sby","PN Surabaya","12-03-2024","Sella Meisya",26,"Ekstasi",55.0,"Pasal 114 ayat 1","Penyimpan",36,800000000,"H. Slamet"));
        repository.simpan(new Putusan("45/Pid.Sus/2024/PN Sby","PN Surabaya","13-03-2024","Teguh Prabowo",37,"Sabu-sabu",9.9,"Pasal 112 ayat 1","Pengedar",42,800000000,"H. Bambang"));
        repository.simpan(new Putusan("46/Pid.Sus/2024/PN Sby","PN Surabaya","14-03-2024","Uma Kalsum",30,"Heroin",2.0,"Pasal 112 ayat 1","Pengguna",24,800000000,"H. Wahyudi"));
        repository.simpan(new Putusan("47/Pid.Sus/2024/PN Sby","PN Surabaya","15-03-2024","Vicky Renaldy",22,"Sabu-sabu",4.2,"Pasal 112 ayat 1","Kurir",18,800000000,"H. Slamet"));
        repository.simpan(new Putusan("48/Pid.Sus/2024/PN Sby","PN Surabaya","18-03-2024","Widi Astuti",36,"Ganja",350.0,"Pasal 111 ayat 2","Bandar",96,1000000000,"H. Bambang"));
        repository.simpan(new Putusan("49/Pid.Sus/2024/PN Sby","PN Surabaya","19-03-2024","Xander Halim",28,"Ekstasi",45.0,"Pasal 114 ayat 1","Pengedar",48,800000000,"H. Wahyudi"));
        repository.simpan(new Putusan("50/Pid.Sus/2024/PN Sby","PN Surabaya","20-03-2024","Yanti Safitri",33,"Sabu-sabu",11.0,"Pasal 112 ayat 2","Bandar",66,1000000000,"H. Slamet"));
    }
}