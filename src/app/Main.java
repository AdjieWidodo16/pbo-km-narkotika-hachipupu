package app;

import view.ConsoleView;

public class Main {

    public static void main(String[] args) {

        ConsoleView view = new ConsoleView();

        while (true) {

            int pilihan = view.tampilkanMenu();

            switch (pilihan) {

                case 1:
                    view.tampilkanPesan("Menu Tambah Putusan (belum connect Controller)");
                    view.inputFormPutusan();
                    break;

                case 2:
                    view.tampilkanPesan("Menu Lihat Semua Putusan (belum connect Controller)");
                    break;

                case 3:
                    view.tampilkanPesan("Menu Cari Putusan");
                    break;

                case 4:
                    view.tampilkanPesan("Menu Filter Putusan");
                    break;

                case 5:
                    view.tampilkanStatistik(0, 0, 0);
                    break;

                case 6:
                    view.tampilkanPesan("Menu Hapus Putusan");
                    break;

                case 0:
                    view.tampilkanPesan("Keluar dari program...");
                    return;

                default:
                    view.tampilkanPesan("Menu tidak valid!");
            }

            view.pressEnter();
        }
    }
}