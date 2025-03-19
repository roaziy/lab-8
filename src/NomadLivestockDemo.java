import java.util.ArrayList;

// B241940029 - Erkhemtur
// Object-oriented programming - Laboratory >> 7 | 3-2th

// Abstract class
abstract class Livestock {
    String name;
    int age;

    public Livestock(String name, int age) {
        this.name = name;
        this.age = age;
    }

    abstract String makeSound();

    void graze() {
        System.out.println(name + " is grazing in the field.");
    }

    void graze(String food) {
        System.out.println(name + " is grazing on " + food + ".");
    }
}

// Interface
interface WorkRole {
    String performTask();
}

// Horse class
class Horse extends Livestock implements WorkRole {
    public Horse(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        return "Neigh!";
    }

    @Override
    public String performTask() {
        return "Horse is used for riding in the field.";
    }
}

// Sheep class
class Sheep extends Livestock {
    public Sheep(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        return "Baa!";
    }
}

// Camel class
class Camel extends Livestock implements WorkRole {
    public Camel(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        return "Grunt!";
    }

    @Override
    public String performTask() {
        return "Camel is used for desert transport.";
    }
}

// Goat class
class Goat extends Livestock implements WorkRole {
    public Goat(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        return "Mee!";
    }

    @Override
    public String performTask() {
        return "Goat carries loads on mountain trails.";
    }

    // Overloaded method: makeSound(int volume)
    String makeSound(int volume) {
        return volume > 5 ? "Loud Mee!" : "Soft Mee!";
    }
}

// Herd class
class Herd {
    ArrayList<Livestock> livestock = new ArrayList<>();

    void addLivestock(Livestock animal) {
        livestock.add(animal);
    }

    void dailyRoutine() {
        for (Livestock animal : livestock) {
            System.out.println(animal.name + ": " + animal.makeSound());
            if (animal instanceof WorkRole) {
                System.out.println(((WorkRole) animal).performTask());
            }
            animal.graze();
        }
    }
}

// Main class
public class NomadLivestockDemo {
    public static void main(String[] args) {
        // Clear the terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Herd herd = new Herd();

        // Add livestock
        herd.addLivestock(new Horse("Bayar", 4));
        herd.addLivestock(new Sheep("Chuluun", 2));
        herd.addLivestock(new Camel("Temur", 6));
        herd.addLivestock(new Goat("Sukhbaatar", 3));

        // Perform daily tasks
        herd.dailyRoutine();

        // Polymorphism test
        Livestock[] animals = {
                new Horse("Bayar", 4),
                new Sheep("Chuluun", 2),
                new Camel("Temur", 6)
        };
        for (Livestock animal : animals) {
            animal.graze();
        }

        // Test Goat's overloaded method
        Goat goat = new Goat("Sukhbaatar", 3);
        System.out.println(goat.makeSound(7)); // Loud Mee!
        System.out.println(goat.makeSound(3)); // Soft Mee!
    }
}
