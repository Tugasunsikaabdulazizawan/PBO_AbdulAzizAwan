public class Matematika2 extends Matematika {

    public int modulus(int a, int b) {
        if (b == 0) {
            System.out.println("tidak bisa modulus dengan 0");
            return 0;
        }
        return a % b;
    }
}
