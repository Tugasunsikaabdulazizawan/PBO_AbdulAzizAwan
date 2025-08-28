public class Nilai {
    String nim;
    String nama;
    double absen;
    double tugas;
    double uts;
    double uas;

    public void Nilai(String nim, String nama, double absen, double tugas, double uts, double uas) {
        this.nim = nim;
        this.nama = nama;
        this.absen = absen;
        this.tugas = tugas;
        this.uts = uts;
        this.uas = uas;
    }

    public void CetakNilai() {
        double nilaiAkhir = (absen * 0.10) + (tugas * 0.20) + (uts * 0.30) + (uas * 0.40);
        System.out.println("NIM : " + nim);
        System.out.println("Nama : " + nama);
        System.out.println("Nilai Absen [10%] : " + absen);
        System.out.println("Nilai Tugas [20%] : " + tugas);
        System.out.println("Nilai UTS [30%] : " + uts);
        System.out.println("Nilai UAS [40%] : " + uas);
        System.out.println("Nilai Akhir : " + nilaiAkhir);
    }
}
