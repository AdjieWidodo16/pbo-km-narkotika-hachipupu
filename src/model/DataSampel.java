package model;

/**
 * Class DataSampel digunakan
 * untuk mengisi data contoh putusan.
 */

public class DataSampel {

    public static void isiData(KnowledgeRepository repo){

        repo.simpan(new Putusan(
                "001/Pid.Sus/2026",
                "PN Jakarta Selatan",
                "12-01-2026",
                "Budi",
                25,
                "Sabu",
                2.5,
                "Pasal 112",
                "Pengedar",
                48,
                50000000,
                "Hakim Andi"
        ));

        repo.simpan(new Putusan(
                "002/Pid.Sus/2026",
                "PN Bandung",
                "15-01-2026",
                "Rizky",
                30,
                "Ganja",
                1.2,
                "Pasal 111",
                "Pemakai",
                12,
                10000000,
                "Hakim Dedi"
        ));

        String[] jenis = {"Sabu", "Ganja", "Ekstasi"};
        String[] peran = {"Pengedar", "Pemakai", "Kurir"};
        String[] hakim = {"Hakim Budi", "Hakim Dedi", "Hakim Sari"};

        for (int i = 3; i <= 50; i++) {

            repo.simpan(new Putusan(
                    String.format("%03d/Pid.Sus/2026", i),
                    "PN Surabaya",
                    "20-01-2026",
                    "Terdakwa" + i,
                    20 + i,
                    jenis[i % jenis.length],
                    1.5 + i,
                    "Pasal 112",
                    peran[i % peran.length],
                    24 + i,
                    25000000,
                    hakim[i % hakim.length]
            ));

        }
    }
}
