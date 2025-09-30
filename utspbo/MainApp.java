import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    static ArrayList<Hewan> daftarHewan = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("Aplikasi Manajemen Hewan Peliharaan");
            System.out.println("1. Tambah Hewan");
            System.out.println("2. Lihat Daftar Hewan");
            System.out.println("3. Interaksi dengan Hewan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tambahHewan();
                    break;
                case 2:
                    tampilkanDaftar();
                    break;
                case 3:
                    interaksiHewan();
                    break;
                case 0:
                    System.out.println("Terima kasih");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (pilihan != 0);
    }

    public static void tambahHewan() {
        System.out.println("Jenis Hewan:");
        System.out.println("1. Anjing");
        System.out.println("2. Kucing");
        System.out.println("3. Burung");
        System.out.print("Pilih jenis: ");
        int jenis = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nama Hewan: ");
        String nama = scanner.nextLine();
        System.out.print("Umur Hewan: ");
        int umur = scanner.nextInt();

        Hewan hewan = null;
        switch (jenis) {
            case 1:
                hewan = new Anjing(nama, umur);
                break;
            case 2:
                hewan = new Kucing(nama, umur);
                break;
            case 3:
                hewan = new Burung(nama, umur);
                break;
            default:
                System.out.println("Jenis tidak valid");
                return;
        }

        daftarHewan.add(hewan);
        System.out.println("Hewan berhasil ditambahkan");
    }

    public static void tampilkanDaftar() {
        System.out.println("Daftar Hewan");
        if (daftarHewan.isEmpty()) {
            System.out.println("Belum ada data hewan");
            return;
        }

        for (int i = 0; i < daftarHewan.size(); i++) {
            Hewan h = daftarHewan.get(i);
            System.out.println((i + 1) + ". " + h.getNama() + " (Umur: " + h.getUmur() + ")");
        }
    }

    public static void interaksiHewan() {
        tampilkanDaftar();
        if (daftarHewan.isEmpty()) return;

        System.out.print("Pilih nomor hewan: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > daftarHewan.size()) {
            System.out.println("Nomor tidak valid");
            return;
        }

        Hewan h = daftarHewan.get(index - 1);
        System.out.println("\nPilih aksi:");
        System.out.println("1. Makan");
        System.out.println("2. Tidur");
        System.out.println("3. Bersuara");
        System.out.print("Aksi: ");
        int aksi = scanner.nextInt();

        switch (aksi) {
            case 1:
                h.makan();
                break;
            case 2:
                h.tidur();
                break;
            case 3:
                h.bersuara();
                break;
            default:
                System.out.println("Aksi tidak dikenal");
        }
    }
}
