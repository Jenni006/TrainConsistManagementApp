import java.util.HashSet;
import java.util.Set;

public class UseCase3TrainConsistManagement {

    public static void main(String[] args) {

        // Display banner
        System.out.println("=======================================");
        System.out.println("        UC3: Track Unique Bogie IDs     ");
        System.out.println("=======================================\n");

        Set<String> bogies = new HashSet<>();

        bogies.add("B6101");
        bogies.add("B6102");
        bogies.add("B6103");
        bogies.add("B6104");
        bogies.add("B6101"); // Duplicate entry
        bogies.add("B6102"); // Duplicate entry

        System.out.println("Unique bogie IDs in the train consist:");
        for (String bogieId : bogies) {
            System.out.println("- " + bogieId);
        }

        System.out.println("\nTotal unique bogies: " + bogies.size());
    }
}