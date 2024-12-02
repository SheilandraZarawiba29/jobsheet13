import java.util.Scanner;

public class Kelompok_6 {
    static Scanner sc = new Scanner(System.in);
    static String[] nama = new String[1];
    static String[] NIM = new String[1];
    static String[] kodeMatkul = new String[1];
    static String[] SKS = new String[1];
    static String[] namaMatkul = new String[1];
    static String[][] KRSMhs = {
        nama, NIM, kodeMatkul, SKS, namaMatkul
    };

    public static void exit () {
        System.out.println("Terimakasih!");
    }

    public static void analisisData() {
        System.out.println("--- Analisis Data KRS ---");
        int count = 0;
        for (int i = 0; i < KRSMhs[0].length; i++) {
            int totalSKSMahasiswa = 0;
            for (int j = 0; j < KRSMhs[0].length; j++) {
                if (KRSMhs[1][i].equals(KRSMhs[1][j])) {
                    totalSKSMahasiswa += Integer.parseInt(KRSMhs[3][j]);
                }
            }
            if (totalSKSMahasiswa < 20) {
                count++;
            }
        }
        System.out.println("Jumlah mahasiswa dengan total SKS kurang dari 20: " + count);
    }

    public static void tampilkanData() {
        System.out.println("--- Tamilkan Data KRS Mahasiswa ---");
        System.out.print("Masukkan NIM Mahasiswa: ");
        int nim = sc.nextInt();

        System.out.println("\nDaftar KRS:");
        System.out.printf("%-10s", "NIM");
        System.out.printf("%-20s", "Nama");
        System.out.printf("%-12s", "Kode MK");
        System.out.printf("%-25s", "Nama Mata Kuliah");
        System.out.printf("%-3s", "SKS");
        System.out.println();

        int totalSKSMahasiswa = 0;

        for (int i = 0; i < KRSMhs[2].length; i++) {
            if (nim != Integer.parseInt(KRSMhs[1][i])) {
               break; 
            }
            System.out.printf("%-10s", KRSMhs[1][i]);
            System.out.printf("%-20s", KRSMhs[0][i]);
            System.out.printf("%-12s", KRSMhs[2][i]);
            System.out.printf("%-25s", KRSMhs[4][i]);
            System.out.printf("%-3s", KRSMhs[3][i]);
            System.out.println();

            totalSKSMahasiswa += Integer.parseInt(KRSMhs[3][i]);
        }
        System.out.printf("Total SKS: %d%n", totalSKSMahasiswa);
        menu();
    }

    public static void menu() {
        System.out.println("===Sistem Pemantauan KRS mahasiswa===");
        System.out.println("1. Tambah Data KRS");
        System.out.println("2. Tampilkan Daftar KRS Mahasiswa");
        System.out.println("3. Analisis Data KRS");
        System.out.println("4. Keluar");
        System.out.print("Pilih menu: ");
        int opsi = sc.nextInt();
        switch (opsi) {
            case 1:
                
                break;
            case 2:
                tampilkanData();
                break;
            case 3:
                analisisData();
                break;
            case 4:
                exit();
                break;
        
            default:
                System.out.println("Nilai yang dimasukkan tidak valid!");
                menu();
                break;
        }
    }

    public static void main(String[] args) {
       tampilkanData();
    }
}