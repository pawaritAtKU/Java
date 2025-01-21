package testgptbeformidterm.InheritanceandCasting;

public abstract class Car3 implements Vehicle2 {
    public void drive(){
        System.out.println("Driving the car");
    }
    @Override
    public void startEngine(){
        System.out.println("Starting the engine");
    }
    @Override
    public void stopEngine(){
        System.out.println("Stopping the engine");
    }
}
