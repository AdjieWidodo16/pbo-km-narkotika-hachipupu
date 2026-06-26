package model;

/**
 * Class PutusanBanding merupakan turunan
 * dari class Putusan
 */

public class PutusanBanding extends Putusan {

    private String alasanBanding;

    // Constructor kosong
    public PutusanBanding() {
        super();
    }

    // Constructor lengkap
    public PutusanBanding(
            String nomorPerkara,
            String pengadilan,
            String tanggalPutusan,
            String namaTerdakwa,
            int umurTerdakwa,
            String jenisNarkotika,
            double beratBarangBukti,
            String pasalDilanggar,
            String peranTerdakwa,
            int vonisHukuman,
            double vonisDenda,
            String namaHakim,
            String alasanBanding
    ) {

        super(
                nomorPerkara,
                pengadilan,
                tanggalPutusan,
                namaTerdakwa,
                umurTerdakwa,
                jenisNarkotika,
                beratBarangBukti,
                pasalDilanggar,
                peranTerdakwa,
                vonisHukuman,
                vonisDenda,
                namaHakim
        );

        this.alasanBanding = alasanBanding;
    }

    public String getAlasanBanding() {
        return alasanBanding;
    }

    public void setAlasanBanding(String alasanBanding) {
        this.alasanBanding = alasanBanding;
    }

    @Override
    public void tampilkan() {
        super.tampilkan();
        System.out.println("Alasan Banding : " + alasanBanding);
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Alasan Banding : " + alasanBanding;
    }

}
