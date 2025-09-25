import java.util.Scanner;

public class NilaiMahasiswa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("NPM : ");
        String npm = input.nextLine();

        System.out.print("Nama Mahasiswa : ");
        String nama = input.nextLine();

        System.out.print("Nilai Kehadiran : ");
        double kehadiran = input.nextDouble();

        System.out.print("Nilai Tugas : ");
        double tugas = input.nextDouble();

        System.out.print("Nilai UTS : ");
        double uts = input.nextDouble();

        System.out.print("Nilai UAS : ");
        double uas = input.nextDouble();

        double nilaiAkhir = (0.10 * kehadiran) + (0.20 * tugas) + (0.30 * uts) + (0.40 * uas);

        String grade, keterangan;

        if (nilaiAkhir >= 76 && nilaiAkhir <= 100) {
            grade = "A";
            keterangan = "ISTIMEWA";
        } else if (nilaiAkhir >= 66) {
            grade = "B";
            keterangan = "BAIK";
        } else if (nilaiAkhir >= 56) {
            grade = "C";
            keterangan = "CUKUP";
        } else if (nilaiAkhir >= 46) {
            grade = "D";
            keterangan = "KURANG";
        } else {
            grade = "E";
            keterangan = "KURANG SEKALI";
        }

        System.out.println("hasil");
        System.out.println("NPM Mahasiswa   : " + npm);
        System.out.println("Nama Mahasiswa  : " + nama);
        System.out.printf("Nilai Rata-rata : %.2f\n", nilaiAkhir);
        System.out.println("Grade           : " + grade);
        System.out.println("Keterangan      : " + keterangan);

        input.close();
    }
}
