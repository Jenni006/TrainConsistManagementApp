import java.util.ArrayList;
import java.util.List;
public class UseCase1TrainConsistManagement {

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("=======================================");
        System.out.println("      Train Consist Management App     ");
        System.out.println("=======================================\n");

        List<String> trainConsist = new ArrayList<>();

        System.out.println("Train initialized successfully...");
        System.out.println("Initial bogie count: " + trainConsist.size());

        if (trainConsist.isEmpty()) {
            System.out.println("Current train consist is empty.");
        } else {
            System.out.println("Current train consist: " + trainConsist);
        }
    }
}

