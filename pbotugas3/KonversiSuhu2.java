public class KonversiSuhu2 extends KonversiSuhu {

    public double fahrenheitToReamur(double f) {
        double c = (f - 32) * 5 / 9;
        return c * 4 / 5;
    }
}
