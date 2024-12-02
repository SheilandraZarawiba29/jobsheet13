import java.util.Scanner;

public class Kelompok_6 {
    static Scanner sc = new Scanner(System.in);
    String[] nama = new String[3];
    String[] NIM = new String[3];
    String[] kodeMatkul = new String[3];
    String[] SKS = new String[3];
    String[] namaMatkul = new String[3];
    String[][] KRSMhs = {
        nama, NIM, kodeMatkul, SKS, namaMatkul
    };

    public static void exit () {
        
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
       
    }
}