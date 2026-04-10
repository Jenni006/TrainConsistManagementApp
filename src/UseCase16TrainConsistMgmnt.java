/**
 * UC16 - Manual Sorting using Bubble Sort
 * Description: Sorts bogie capacities in ascending order without using library methods.
 */
public class UseCase16TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println(" UC16 - Manual Sorting using Bubble Sort ");
        System.out.println("===============================================\n");

        // 1. Create array of passenger bogie capacities
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.print("Original Capacities: ");
        displayArray(capacities);

        // ---- BUBBLE SORT LOGIC ----
        // 2. Outer loop controls number of passes
        for (int i = 0; i < capacities.length - 1; i++) {
            // 3. Inner loop compares adjacent values
            for (int j = 0; j < capacities.length - 1 - i; j++) {
                // 4. Swap values if they are out of order
                if (capacities[j] > capacities[j + 1]) {
                    // Swapping Logic using a temporary variable
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        // 5. Display the sorted result
        System.out.print("\nSorted Capacities (Ascending): ");
        displayArray(capacities);

        System.out.println("\nSorting completed successfully.");
    }

    private static void displayArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}