public class Kubus extends BangunRuang {
    @Override
    double hitungVolume(double sisi) {
        return sisi * sisi * sisi;
    }

    @Override
    double hitungLuasPermukaan(double sisi) {
        return 6 * sisi * sisi;
    }
}
