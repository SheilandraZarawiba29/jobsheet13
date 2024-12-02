import java.util.Scanner;

public class Kelompok_6 {
    static Scanner sc = new Scanner(System.in);
    static String[] nama = new String[1];
    static String[] NIM = new String[1];
    static String[] kodeMatkul = new String[1];
    static String[] SKS = new String[1];
    static String[] namaMatkul = new String[1];
    static String[][] KRSMhs = {
        nama, 
        NIM, 
        kodeMatkul, 
        SKS, 
        namaMatkul
    };

    public static void exit () {
        System.out.println("Terimakasih!");
    }

    public static void analisisData() {
        System.out.println("--- Analisis Data KRS ---");
        int count = 0;
        if (KRSMhs[0][0] != null) {
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
        }
        System.out.println("Jumlah mahasiswa dengan total SKS kurang dari 20: " + count);
        menu();
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

        if (KRSMhs[0][0] != null) {
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
        }
        menu();
    }

    public static void newStringArray(String[][] data) {
        String[][] old = data;
        data = new String[old.length + 1][old[0].length];
        for (int row = 0; row < old.length; row++) {
            for (int col = 0; col < old[row].length; col++) {
                data[row][col] = old[row][col];
            }
        }
    }

    public static String validasiInputSKS() {
        System.out.print("Jumlah SKS (1-3): ");
        String sks = sc.nextLine();
        if (Integer.parseInt(sks) > 3 || Integer.parseInt(sks) < 1) {
            System.out.println("Jumlah SKS tidak valid! SKS harus antara 1 dan 3.");
            return validasiInputSKS();
        }
        return sks;
    }

    public static void tambahkanData() {
        System.out.println("--- Tambah Data KRS ---");
        boolean confirm = true;

        System.out.print("Nama Mahasiswa: ");
        String nama = sc.nextLine();
        sc.nextLine();
        System.out.print("NIM: ");
        String nim = sc.nextLine();

        int totalSKS = 0;

        while (confirm) {
            if (KRSMhs[0][0] != null) {
                newStringArray(KRSMhs);
            }

            KRSMhs[0][KRSMhs[0].length-1] = nama;
            KRSMhs[1][KRSMhs[0].length-1] = nim;

            System.out.print("Kode Mata Kuliah: ");
            KRSMhs[2][KRSMhs[0].length-1] = sc.nextLine();
            
            System.out.print("Nama Mata Kuliah: ");
            KRSMhs[4][KRSMhs[0].length-1] = sc.nextLine();
            
            
            String sks = validasiInputSKS();
            KRSMhs[3][KRSMhs[0].length-1] = sks;
            totalSKS += Integer.parseInt(sks);
            
            System.out.print("Tambah mata kuliah lain? (y/t): ");
            String input = sc.nextLine();
            confirm = input.charAt(0) == 'y';
        }

        System.out.printf("Total SKS yang diambil: %d%n", totalSKS);
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
                tambahkanData();
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
       menu();
    }
}