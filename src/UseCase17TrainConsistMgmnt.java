import java.util.Arrays;

public class UseCase17TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println(" UC17 - Sort Bogie Names Using Arrays.sort() ");
        System.out.println("===============================================\n");

        String[] bogieTypes = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Original Bogie Names: " + Arrays.toString(bogieTypes));

        Arrays.sort(bogieTypes);

        System.out.println("Sorted Bogie Names (Alphabetical): " + Arrays.toString(bogieTypes));

        System.out.println("\nSorting completed using optimized library method.");
    }
}