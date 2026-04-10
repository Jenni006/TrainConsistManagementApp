import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UseCase8TrainConsistMgmnt {

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
        System.out.println(" UC8 - Filter Passenger Bogies Using Streams ");
        System.out.println("===============================================\n");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 40));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        System.out.println("Filtered Bogies (Capacity > 60):");
        filteredBogies.forEach(System.out::println);
    }
}