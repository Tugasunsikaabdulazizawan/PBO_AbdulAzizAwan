public class Main {
    public static void main(String[] args) {
        Kubus kubus = new Kubus();
        double sisi = 5;
        System.out.println("Kubus");
        System.out.println("Sisi: " + sisi);
        System.out.println("Volume: " + kubus.hitungVolume(sisi));
        System.out.println("Luas Permukaan: " + kubus.hitungLuasPermukaan(sisi));

        Balok balok = new Balok();
        double panjang = 10, lebar = 4, tinggi = 3;
        System.out.println("Balok");
        System.out.println("Panjang: " + panjang + ", Lebar: " + lebar + ", Tinggi: " + tinggi);
        System.out.println("Volume: " + balok.hitungVolume(panjang, lebar, tinggi));
        System.out.println("Luas Permukaan: " + balok.hitungLuasPermukaan(panjang, lebar, tinggi));
    }
}
