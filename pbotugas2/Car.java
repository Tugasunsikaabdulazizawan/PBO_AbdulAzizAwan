public class Car implements Vehicle {
    String color;
    String noPlate;
    double width;
    double height;
    String brand;
    boolean headLampOn;

    public Car() {
        this.color = "Hitam";
        this.noPlate = "T 3412 XYZ";
        this.width = 3.8;
        this.height = 2.6;
        this.brand = "Avanza";
        this.headLampOn = false;
    }

    public void startEngine() {
        System.out.println("Menyalakan mesin");
    }

    public void throttle() {
        System.out.println("Menambah kecepatan");
    }

    public void brake() {
        System.out.println("Mengurangi kecepatan");
    }

    public void turnOnHeadLamp() {
        headLampOn = true;
        System.out.println("Menyalakan lampu depan");
    }

    public void turnOfHeadLamp() {
        headLampOn = false;
        System.out.println("Mematikan lampu depan");
    }

    public void displayInfo() {
        System.out.println("Info Mobil:");
        System.out.println("Brand: " + brand);
        System.out.println("Warna: " + color);
        System.out.println("No Plat: " + noPlate);
        System.out.println("Ukuran: " + width + "m x " + height + "m");
        System.out.println("Lampu Depan: " + (headLampOn ? "ON" : "OFF"));
    }

    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.displayInfo();
        myCar.startEngine();
        myCar.throttle();
        myCar.brake();
        myCar.turnOnHeadLamp();
        myCar.turnOfHeadLamp();
    }
}
