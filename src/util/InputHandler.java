package util;

import java.util.Scanner;

/**
 * Utility class untuk validasi semua input dari pengguna.
 * Semua method static — tidak perlu instansiasi.
 * Setiap method menggunakan try-catch agar program tidak crash.
 *
 * @author Adjie Widodo - Backend Developer (Controller)
 * @version 1.0
 */
public class InputHandler {

    /**
     * Validasi input integer. Loop terus sampai user masukkan angka yang valid.
     * @param prompt pesan yang ditampilkan ke user
     * @param sc     Scanner
     * @return nilai integer valid
     */
    public static int validasiInt(String prompt, Scanner sc) {
        while (true) {
            System.out.print(prompt);
            try {
                int nilai = Integer.parseInt(sc.nextLine().trim());
                return nilai;
            } catch (NumberFormatException e) {
                System.out.println("  [ERROR] Harus berupa angka bulat. Coba lagi.");
            }
        }
    }

    /**
     * Validasi input integer dalam rentang tertentu.
     * Overloading dari validasiInt(String, Scanner).
     * @param prompt pesan ke user
     * @param min    nilai minimum
     * @param max    nilai maksimum
     * @param sc     Scanner
     * @return integer valid dalam rentang [min, max]
     */
    public static int validasiInt(String prompt, int min, int max, Scanner sc) {
        while (true) {
            int nilai = validasiInt(prompt, sc);
            if (nilai >= min && nilai <= max) return nilai;
            System.out.println("  [ERROR] Nilai harus antara " + min + " dan " + max + ".");
        }
    }

    /**
     * Validasi input double. Loop terus sampai user masukkan angka yang valid.
     * @param prompt pesan ke user
     * @param sc     Scanner
     * @return nilai double valid
     */
    public static double validasiDouble(String prompt, Scanner sc) {
        while (true) {
            System.out.print(prompt);
            try {
                double nilai = Double.parseDouble(sc.nextLine().trim());
                return nilai;
            } catch (NumberFormatException e) {
                System.out.println("  [ERROR] Harus berupa angka (boleh desimal). Coba lagi.");
            }
        }
    }

    /**
     * Validasi input double yang harus lebih dari 0.
     * Overloading dari validasiDouble(String, Scanner).
     * @param prompt pesan ke user
     * @param sc     Scanner
     * @return double valid dan > 0
     */
    public static double validasiDoublePositif(String prompt, Scanner sc) {
        while (true) {
            double nilai = validasiDouble(prompt, sc);
            if (nilai > 0) return nilai;
            System.out.println("  [ERROR] Nilai harus lebih dari 0.");
        }
    }

    /**
     * Validasi input String yang tidak boleh kosong.
     * @param prompt pesan ke user
     * @param sc     Scanner
     * @return String tidak kosong
     */
    public static String validasiString(String prompt, Scanner sc) {
        while (true) {
            System.out.print(prompt);
            try {
                String input = sc.nextLine().trim();
                if (!input.isEmpty()) return input;
                System.out.println("  [ERROR] Input tidak boleh kosong. Coba lagi.");
            } catch (Exception e) {
                System.out.println("  [ERROR] Input tidak valid: " + e.getMessage());
            }
        }
    }

    /**
     * Validasi pilihan menu dalam rentang tertentu.
     * @param prompt pesan ke user
     * @param min    pilihan minimum
     * @param max    pilihan maksimum
     * @param sc     Scanner
     * @return pilihan valid
     */
    public static int validasiPilihan(String prompt, int min, int max, Scanner sc) {
        return validasiInt(prompt, min, max, sc);
    }
}
