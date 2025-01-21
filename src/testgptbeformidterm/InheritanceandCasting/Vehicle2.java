package testgptbeformidterm.InheritanceandCasting;

public interface Vehicle2 {
    void startEngine();
    void stopEngine();

    public static void main(String[] args){
        Vehicle2 sc = new SportCar();
        sc.startEngine();
        ((SportCar) sc).drive();
        sc.stopEngine();
    }
}
