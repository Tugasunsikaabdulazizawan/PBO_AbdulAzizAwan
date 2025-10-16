import java.util.Scanner;

public class Pertemuan_8Array {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Data Buku
        Book[] koleksi = new Book[5];
        koleksi[0] = new Book("Cara memasak", "Raihan", "1930", false);
        koleksi[1] = new Book("Bumi Manusia", "Pramoedya Ananta Toer", "1980", false);
        koleksi[2] = new Book("Laskar Pelangi", "Andrea Hiratai", "2005", false);
        koleksi[3] = new Book("Filosofi Teras", "Henry Manamping", "2018", false);
        koleksi[4] = new Book("Madilo", "Tan Malaka", "1943", false);
        
        int pilihan;
        
        do {
            System.out.println("\n===== SISTEM PERPUSTAKAAN =====");
            System.out.println("1. Lihat semua Book");
            System.out.println("2. Cari Book berdasarkan judul");
            System.out.println("3. Pinjam Book");
            System.out.println("4. Kembalikan Book");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- Daftar Book ---");
                    // Lakukan perulangan untuk tampilkan info buku disini
                    for(Book b : koleksi) {
                        b.tampilkanDataBuku();
                    }
                    System.out.println("\n Tekan enter untuk melanjutkan...");
                    input.nextLine();
                    break;

                case 2:
                    System.out.print("Masukkan judul Book yang dicari: ");
                    String cari = input.nextLine();
                    boolean ditemukan = false;
                    
                    // Lakukan logika untuk mencari buku disini
                    for(Book b : koleksi){
                        if(b.judul.equalsIgnoreCase(cari)){
                            b.tampilkanDataBuku();
                            ditemukan = true;
                            break;
                        }
                    }
                    if(!ditemukan) {
                        System.out.println("Buku tidak ditemukan");
                    }

		    break;
                    
                case 3:
                    System.out.print("Masukkan judul Book yang ingin dipinjam: ");
                    String pinjam = input.nextLine();
                    boolean ada = false;
                    
                    // Lakukan logika untuk meminjam buku disini
                    for (Book b : koleksi) {
                        if (b.judul.equalsIgnoreCase(pinjam)) {
                            if (!b.isBooked) {
                                b.isBooked = true;
                                System.out.println("Buku \"" + b.judul + "\" berhasil dipinjam.");
                            } else {
                                System.out.println("Buku \"" + b.judul + "\" sedang dipinjam.");
                            }
                            ada = true;
                            break;
                        }
                    }
                    if (!ada) {
                        System.out.println("Buku tidak ditemukan.");
                    }
                    break;
                case 4:
                    System.out.print("Masukkan judul Book yang dikembalikan: ");
                    String kembali = input.nextLine();
                    boolean ditemukanKembali = false;
                    
                    // Silakan masukan logika untuk mengembalikan buku disini
                    for (Book b : koleksi) {
                        if (b.judul.equalsIgnoreCase(kembali)) {
                            if (b.isBooked) {
                                b.isBooked = false;
                                System.out.println("Buku \"" + b.judul + "\" berhasil dikembalikan.");
                            } else {
                                System.out.println("Buku \"" + b.judul + "\" belum dipinjam.");
                            }
                            ditemukanKembali = true;
                            break;
                        }
                    }
                
                    if (!ditemukanKembali) {
                        System.out.println("Buku tidak ditemukan.");
                    }
                    break;

                case 0:
                    System.out.println("Keluar dari sistem...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 0);
        
        input.close();
    }
    
}