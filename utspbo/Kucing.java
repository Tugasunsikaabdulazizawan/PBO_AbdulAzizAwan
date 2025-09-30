public class Kucing extends Hewan {
    public Kucing(String nama, int umur) {
        super(nama, umur);
    }

    public void makan() {
        System.out.println(nama + " sedang makan ikan");
    }

    public void tidur() {
        System.out.println(nama + " tidur di sofa");
    }

    public void bersuara() {
        System.out.println(nama + " mengeong: Meow");
    }
}
