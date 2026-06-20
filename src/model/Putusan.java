package model;

// Class Putusan digunakan untuk menyimpan
// data Putusan pengadilan narkotika

public class Putusan implements Displayable {

    private String nomorPerkara;
    private String pengadilan;
    private String tanggalPutusan;
    private String namaTerdakwa;
    private int umurTerdakwa;
    private String jenisNarkotika;
    private double beratBarangBukti;
    private String pasalDilanggar;
    private String peranTerdakwa;
    private int vonisHukuman;
    private double vonisDenda;
    private String namaHakim;

    private static int jumlahDibuat = 0;

    // Constructor kosong
    public Putusan() {
        jumlahDibuat++;
    }

    // Constructor parameter
    public Putusan(String nomorPerkara, String pengadilan, String tanggalPutusan,
                   String namaTerdakwa, int umurTerdakwa, String jenisNarkotika,
                   double beratBarangBukti, String pasalDilanggar,
                   String peranTerdakwa, int vonisHukuman,
                   double vonisDenda, String namaHakim) {

        this.nomorPerkara = nomorPerkara;
        this.pengadilan = pengadilan;
        this.tanggalPutusan = tanggalPutusan;
        this.namaTerdakwa = namaTerdakwa;
        this.umurTerdakwa = umurTerdakwa;
        this.jenisNarkotika = jenisNarkotika;
        this.beratBarangBukti = beratBarangBukti;
        this.pasalDilanggar = pasalDilanggar;
        this.peranTerdakwa = peranTerdakwa;
        this.vonisHukuman = vonisHukuman;
        this.vonisDenda = vonisDenda;
        this.namaHakim = namaHakim;

        jumlahDibuat++;
    }

    // Getter & Setter
    public String getNomorPerkara() {
        return nomorPerkara;
    }

    public void setNomorPerkara(String nomorPerkara) {
        this.nomorPerkara = nomorPerkara;
    }

    public String getNamaTerdakwa() {
        return namaTerdakwa;
    }

    public void setNamaTerdakwa(String namaTerdakwa) {
        this.namaTerdakwa = namaTerdakwa;
    }

    public int getVonisHukuman() {
        return vonisHukuman;
    }

    public void setVonisHukuman(int vonisHukuman) {
        if (vonisHukuman > 0) {
            this.vonisHukuman = vonisHukuman;
        }
    }

    public double getBeratBarangBukti() {
        return beratBarangBukti;
    }

    public void setBeratBarangBukti(double beratBarangBukti) {
        if (beratBarangBukti > 0) {
            this.beratBarangBukti = beratBarangBukti;
        }
    }

    // Override dari interface
    @Override
    public void tampilkan() {
        System.out.println(nomorPerkara + " - " + namaTerdakwa);
    }

    // Static method
    public static int getJumlahDibuat() {
        return jumlahDibuat;
    }

    // Method overloading
    public void tampilkan(boolean detail) {
        if (detail) {
            System.out.println("Nomor Perkara : " + nomorPerkara);
            System.out.println("Terdakwa : " + namaTerdakwa);
            System.out.println("Jenis Narkotika : " + jenisNarkotika);
            System.out.println("Vonis : " + vonisHukuman + " bulan");
        } else {
            tampilkan();
        }
    }

    public String getKategoriHukuman() {

        if (vonisHukuman <= 12) {
            return "Ringan";
        } else if (vonisHukuman <= 60) {
            return "Sedang";
        } else {
            return "Berat";
        }
    }

    @Override
    public String toString() {
        return nomorPerkara + " | "
                + namaTerdakwa + " | "
                + jenisNarkotika + " | "
                + vonisHukuman + " bulan";
    }
}