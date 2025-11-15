import java.util.Scanner;

class Pet {
    String name;
    int age;
    Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void greet() {
        System.out.println("Hola, soy " + name + " y tengo " + age + " años.");
    }
}

public class Main {
    public static void greetUser() {
        System.out.println("Bienvenida al programa de mascotas");
    }

    public static void main(String[] args) {
        greetUser();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre de tu mascota: ");

        String name = scanner.nextLine();

        System.out.print("Ingrese la edad de tu mascota: ");

        int age = scanner.nextInt();

        Pet myPet = new Pet(name, age);

        myPet.greet();
    }
}