package permidtearm.GetterSetter;

public class ElectricCar extends Car {
    public ElectricCar(String brand, String model, int year){
        super(brand, model, year);
    }
    String batteryCapacity;

    public void getBatteryCapacity(){
        System.out.println("Battery Capacity: " + batteryCapacity);
    }
    public void displayCarInfo(){
        super.displayCarInfo();
        getBatteryCapacity();
    }
}