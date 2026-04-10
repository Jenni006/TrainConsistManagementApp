import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UseCase11TrainConsistMgmnt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===============================================");
        System.out.println(" UC11 - Validate Train ID & Cargo Codes (Regex) ");
        System.out.println("===============================================\n");

        // Accept input
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // ---- DEFINE REGEX RULES ----
        // TRN- followed by exactly 4 digits
        String trainIdRegex = "TRN-\\d{4}";
        // PET- followed by exactly 2 uppercase letters
        String cargoCodeRegex = "PET-[A-Z]{2}";

        // Validate Train ID
        boolean isTrainIdValid = validate(trainId, trainIdRegex);
        // Validate Cargo Code
        boolean isCargoCodeValid = validate(cargoCode, cargoCodeRegex);

        System.out.println("\nValidation Results:");
        System.out.println("Train ID [" + trainId + "]: " + (isTrainIdValid ? "VALID" : "INVALID"));
        System.out.println("Cargo Code [" + cargoCode + "]: " + (isCargoCodeValid ? "VALID" : "INVALID"));

        if (isTrainIdValid && isCargoCodeValid) {
            System.out.println("\nSuccess: All formats are correct. Proceeding to consist management.");
        } else {
            System.err.println("\nError: Validation failed. Please check the input formats.");
        }
    }

    public static boolean validate(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}