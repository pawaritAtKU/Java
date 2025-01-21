package testgptbeformidterm.InheritanceandCasting;

public class Employee extends Person {
    String title;

    public Employee(String name, int age, String title){
        super(name, age);
        this.title = title;
    }
    @Override
    public void displayInfo(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Title: "+title);
    }
}
