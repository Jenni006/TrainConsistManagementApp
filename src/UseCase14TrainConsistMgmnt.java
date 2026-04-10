/**
 * ====================================================================
 * MAIN CLASS - UseCase14TrainConsistMgmnt
 * ====================================================================
 */
public class UseCase14TrainConsistMgmnt {

    // ---- CUSTOM EXCEPTION ----
    // Extends Exception to represent a checked domain error
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message); // Passes message to the parent Exception class
        }
    }

    // Passenger Bogie model with validation logic inside the constructor
    static class PassengerBogie {
        String type;
        int capacity;

        // Constructor declares that it may throw the custom exception
        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            // Fail-Fast Validation: Detects errors early
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero"); // Explicitly raises error
            }
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return String.format("Bogie Type: %s, Capacity: %d", type, capacity);
        }
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println(" UC14 - Prevent Invalid Bogies (Custom Exception) ");
        System.out.println("=================================================\n");

        try {
            System.out.println("Attempting to create valid bogie: Sleeper (72 seats)...");
            PassengerBogie validBogie = new PassengerBogie("Sleeper", 72);
            System.out.println("Success: " + validBogie);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("\nAttempting to create invalid bogie: General (0 seats)...");
            PassengerBogie invalidBogie = new PassengerBogie("General", 0);
            System.out.println("Success: " + invalidBogie);
        } catch (InvalidCapacityException e) {
            // System continues execution safely after catching the error
            System.err.println("CAUGHT EXCEPTION: " + e.getMessage());
        }

        try {
            System.out.println("\nAttempting to create invalid bogie: AC Chair (-10 seats)...");
            PassengerBogie negativeBogie = new PassengerBogie("AC Chair", -10);
            System.out.println("Success: " + negativeBogie);
        } catch (InvalidCapacityException e) {
            System.err.println("CAUGHT EXCEPTION: " + e.getMessage());
        }

        System.out.println("\nUC14 execution completed safely.");
    }
}