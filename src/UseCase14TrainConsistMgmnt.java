
public class UseCase14TrainConsistMgmnt {
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message); // Passes message to Exception parent class
        }
    }

    // Passenger Bogie model with internal validation
    static class PassengerBogie {
        String name;
        int capacity;

        // Constructor uses 'throws' to declare checked exception
        PassengerBogie(String name, int capacity) throws InvalidCapacityException {
            // Fail-Fast Validation rule: Capacity must be > 0
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return "Bogie: " + name + " | Capacity: " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println(" UC14 - Handle Invalid Bogie Capacity (Custom Exception) ");
        System.out.println("===============================================\n");

        // CASE 1: Valid Capacity creation
        try {
            PassengerBogie validBogie = new PassengerBogie("Sleeper", 72);
            System.out.println("CREATED: " + validBogie);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // CASE 2: Invalid Capacity (Zero) creation
        try {
            System.out.println("\nAttempting to create bogie with 0 capacity...");
            PassengerBogie invalidBogie = new PassengerBogie("General", 0);
        } catch (InvalidCapacityException e) {
            System.err.println("CAUGHT EXCEPTION: " + e.getMessage());
        }

        // CASE 3: Invalid Capacity (Negative) creation
        try {
            System.out.println("\nAttempting to create bogie with -10 capacity...");
            PassengerBogie negativeBogie = new PassengerBogie("AC Chair", -10);
        } catch (InvalidCapacityException e) {
            System.err.println("CAUGHT EXCEPTION: " + e.getMessage());
        }

        System.out.println("\nSystem continues execution safely...");
    }
}