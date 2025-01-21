package testgptbeformidterm.InheritanceandCasting;

public class Shape {
    public void draw(){
        System.out.println("Drawing Shape");
    }
    public static void main (String[] agrs){
        Shape c = new Circle();
        c.draw();
        Shape r = new Rectangle();
        r.draw();
    }
}
