package model;


/**
 * Class PutusanBanding merupakan turunan
 * dari class Putusan untuk data banding.
 */

public class PutusanBanding extends Putusan {

    private String alasanBanding;

    public PutusanBanding() {

    }

    public PutusanBanding(String alasanBanding) {
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
}