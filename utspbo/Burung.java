public class Burung extends Hewan {
    public Burung(String nama, int umur) {
        super(nama, umur);
    }

    public void makan() {
        System.out.println(nama + " sedang makan biji-bijian");
    }

    public void tidur() {
        System.out.println(nama + " tidur di sangkar");
    }

    public void bersuara() {
        System.out.println(nama + " berkicau: Cuit Cuit");
    }
}
