import java.util.Scanner;

public class Kelompok_6 {
    static Scanner sc = new Scanner(System.in);
    static String[] nama = new String[10];
    static String[] NIM = new String[10];
    static String[] kodeMatkul = new String[10];
    static String[] SKS = new String[10];
    static String[] namaMatkul = new String[10];
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
                if (NIM[i].equals(NIM[j])) {
                    totalSKSMahasiswa += Integer.parseInt(SKS[j]);
                }
            }
            if (totalSKSMahasiswa < 20) {
                count++;
            }
        }
        System.out.println("Jumlah mahasiswa dengan total SKS kurang dari 20: " + count);
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
       menu();
    }
}