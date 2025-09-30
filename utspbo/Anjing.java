public class Anjing extends Hewan {
    public Anjing(String nama, int umur) {
        super(nama, umur);
    }

    public void makan() {
        System.out.println(nama + " sedang makan tulang");
    }

    public void tidur() {
        System.out.println(nama + " tidur di kandang");
    }

    public void bersuara() {
        System.out.println(nama + " menggonggong: Guk Guk");
    }
}
