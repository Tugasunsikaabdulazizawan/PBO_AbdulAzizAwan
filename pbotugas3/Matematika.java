public class Matematika {

    public int pertambahan(int a, int b) {
        return a + b;
    }

    public int pengurangan(int a, int b) {
        return a - b;
    }

    public int perkalian(int a, int b) {
        return a * b;
    }

    public int pembagian(int a, int b) {
        if (b == 0) {
            System.out.println("tidak bisa dibagi 0");
            return 0;
        }
        return a / b;
    }

}
