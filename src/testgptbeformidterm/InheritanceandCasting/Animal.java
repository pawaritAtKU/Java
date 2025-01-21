package testgptbeformidterm.InheritanceandCasting;

public class Animal {
    public void makeSound() {
        System.out.println("Animal is making a sound");
    }

    public static void main(String[] agrs) {
        Dog dog = new Dog();
        dog.makeSound();
    }
}
