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

        for (int i = 3; i <= 50; i++) {

            repo.simpan(new Putusan(
                    i + "/Pid.Sus/2026",
                    "PN Surabaya",
                    "20-01-2026",
                    "Terdakwa" + i,
                    20 + i,
                    "Sabu",
                    1.5,
                    "Pasal 112",
                    "Pengedar",
                    24,
                    25000000,
                    "Hakim Budi"
            ));

        }
    }
}