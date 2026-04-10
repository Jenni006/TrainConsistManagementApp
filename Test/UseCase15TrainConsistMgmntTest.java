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
        // Verifies negative value triggers InvalidCapacityException
        assertThrows(UseCase14TrainConsistMgmnt.InvalidCapacityException.class, () -> {
            new UseCase14TrainConsistMgmnt.PassengerBogie("AC Chair", -10);
        });
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        // Verifies zero capacity is treated as invalid
        assertThrows(UseCase14TrainConsistMgmnt.InvalidCapacityException.class, () -> {
            new UseCase14TrainConsistMgmnt.PassengerBogie("General", 0);
        });
    }

    @Test
    void testException_ExceptionMessageValidation() {
        // Verifies the returned message matches business requirements
        Exception exception = assertThrows(UseCase14TrainConsistMgmnt.InvalidCapacityException.class, () -> {
            new UseCase14TrainConsistMgmnt.PassengerBogie("Sleeper", 0);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws UseCase14TrainConsistMgmnt.InvalidCapacityException {
        // Verifies object correctly stores values upon successful creation
        UseCase14TrainConsistMgmnt.PassengerBogie bogie =
                new UseCase14TrainConsistMgmnt.PassengerBogie("First Class", 24);
        assertEquals("First Class", bogie.name);
        assertEquals(24, bogie.capacity);
    }
}