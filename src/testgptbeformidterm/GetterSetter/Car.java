package testgptbeformidterm.GetterSetter;

public class Car {
    String brand;
    String model;
    int year;

    public Car(String brand, String model, int year){
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand(){
        return brand;
    }
    public String getModel(){
        return model;
    }
    public int getYear(){
        return year;
    }
    public void displayCarInfo(){
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("---------------------------------");
    }
}
