public class DemoKonversiSuhu {

    public static void main(String[] args) {
        KonversiSuhu2 konversi = new KonversiSuhu2();

        double celcius = 25.0;
        double fahrenheit = 77.0;

        System.out.println("Konversi dari Celcius:");
        System.out.println(celcius + "°C = " + konversi.celciusToFahrenheit(celcius) + "°F");
        System.out.println(celcius + "°C = " + konversi.celciusToReamur(celcius) + "°Re");

        System.out.println("Konversi dari Fahrenheit:");
        System.out.println(fahrenheit + "°F = " + konversi.fahrenheitToReamur(fahrenheit) + "°Re");
    }
}
