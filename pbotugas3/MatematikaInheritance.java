public class MatematikaInheritance {

    public static void main(String[] args) {
        Matematika2 mtk = new Matematika2();

        int a = 10;
        int b = 3;

        System.out.println("Pertambahan: " + mtk.pertambahan(a, b));
        System.out.println("Pengurangan: " + mtk.pengurangan(a, b));
        System.out.println("Perkalian: " + mtk.perkalian(a, b));
        System.out.println("Pembagian: " + mtk.pembagian(a, b));
        System.out.println("Modulus: " + mtk.modulus(a, b));
    }
}
