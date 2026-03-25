import java.util.LinkedList;
import java.util.List;

public class UseCase4TrainConsistManagement {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println(" UC4 Maintain Ordered Bogie Consist ");
        System.out.println("==================================");

        List<String> trainConsist = new LinkedList<>();

        // Adding bogies in sequence
        trainConsist.add("Engine");
        trainConsist.add("Bogie1");
        trainConsist.add("Bogie2");
        trainConsist.add("Bogie3");

        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist);

        // Insert bogie at specific position
        trainConsist.add(2, "PantryCar");

        System.out.println("\nAfter inserting PantryCar at position 2:");
        System.out.println(trainConsist);

        // Remove bogie from front
        if (!trainConsist.isEmpty()) {
            trainConsist.remove(0);
        }

        System.out.println("\nAfter removing front bogie:");
        System.out.println(trainConsist);

        // Remove bogie from rear
        if (!trainConsist.isEmpty()) {
            trainConsist.remove(trainConsist.size() - 1);
        }

        System.out.println("\nAfter removing rear bogie:");
        System.out.println(trainConsist);

        System.out.println("\nFinal Train Structure:");
        System.out.println(trainConsist);
    }
}