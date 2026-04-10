import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UseCase7TrainConsistManagement {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return String.format("Bogie{name='%s', capacity=%d}", name, capacity);
        }
    }

    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println(" UC7 - Sort Bogies by Capacity (Comparator) ");
        System.out.println("===============================================\n");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 40));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("Before Sorting:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting by Capacity (Ascending):");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
    }
}