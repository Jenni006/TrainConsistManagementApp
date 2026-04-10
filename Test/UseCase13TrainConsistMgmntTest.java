import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UseCase14TrainConsistMgmntTest {

    @Test
    void testException_ValidCapacityCreation() {
        // Verifies bogie with capacity > 0 is instantiated without exception
        assertDoesNotThrow(() -> {
            new UseCase14TrainConsistMgmnt.PassengerBogie("Sleeper", 72);
        });
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        // Verifies capacity value -10 triggers the custom exception
        Exception exception = assertThrows(UseCase14TrainConsistMgmnt.InvalidCapacityException.class, () -> {
            new UseCase14TrainConsistMgmnt.PassengerBogie("AC Chair", -10);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        // Verifies zero capacity is treated as invalid input
        assertThrows(UseCase14TrainConsistMgmnt.InvalidCapacityException.class, () -> {
            new UseCase14TrainConsistMgmnt.PassengerBogie("General", 0);
        });
    }

    @Test
    void testException_ExceptionMessageValidation() {
        // Verifies the correct error message is returned
        try {
            new UseCase14TrainConsistMgmnt.PassengerBogie("First Class", -5);
        } catch (UseCase14TrainConsistMgmnt.InvalidCapacityException e) {
            assertEquals("Capacity must be greater than zero", e.getMessage());
        }
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws UseCase14TrainConsistMgmnt.InvalidCapacityException {
        // Verifies properties match constructor parameters after successful creation
        UseCase14TrainConsistMgmnt.PassengerBogie bogie = new UseCase14TrainConsistMgmnt.PassengerBogie("Sleeper", 72);
        assertEquals("Sleeper", bogie.type);
        assertEquals(72, bogie.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() {
        // Verifies multiple valid bogies can be created without triggering exceptions
        assertDoesNotThrow(() -> {
            new UseCase14TrainConsistMgmnt.PassengerBogie("Sleeper", 72);
            new UseCase14TrainConsistMgmnt.PassengerBogie("AC Chair", 40);
            new UseCase14TrainConsistMgmnt.PassengerBogie("First Class", 24);
        });
    }
}