import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UseCase2TrainConsistManagement {

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println("        UC2: Add Passenger Bogies       ");
        System.out.println("=======================================\n");

        List<String> passengerBogies = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("\nSelect an action:");
            System.out.println("1. Add a bogie");
            System.out.println("2. Remove a bogie");
            System.out.println("3. Display current bogies");
            System.out.println("4. Check bogie availability");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Enter bogie name to add: ");
                    String newBogie = scanner.nextLine();
                    passengerBogies.add(newBogie);
                    System.out.println("Bogie '" + newBogie + "' added.");
                    break;

                case "2":
                    System.out.print("Enter bogie name to remove: ");
                    String removeBogie = scanner.nextLine();
                    if (passengerBogies.remove(removeBogie)) {
                        System.out.println("Bogie '" + removeBogie + "' removed.");
                    } else {
                        System.out.println("Bogie '" + removeBogie + "' not found.");
                    }
                    break;

                case "3":
                    System.out.println("Current train consist: " + passengerBogies);
                    System.out.println("Total bogies: " + passengerBogies.size());
                    break;

                case "4":
                    System.out.print("Enter bogie name to check: ");
                    String checkBogie = scanner.nextLine();
                    if (passengerBogies.contains(checkBogie)) {
                        System.out.println("Bogie '" + checkBogie + "' is available.");
                    } else {
                        System.out.println("Bogie '" + checkBogie + "' is NOT available.");
                    }
                    break;

                case "0":
                    System.out.println("Exiting UC2: Train Consist Management.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (!input.equals("0"));

        scanner.close();

        // Final consist display
        System.out.println("\nFinal train consist: " + passengerBogies);
        System.out.println("Total bogies: " + passengerBogies.size());
    }
}
