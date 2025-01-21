package testgptbeformidterm.InheritanceandCasting;

public class Vehicle {
    public void drive(){
        System.out.println("Vehicle is driving");
    }
    public static void main(String[] args) {
        Car2 car = new Car2();
        car.drive();

        Truck turck = new Truck();
        turck.drive();
    }
}
