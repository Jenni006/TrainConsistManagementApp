import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UseCase16TrainConsistMgmntTest {

    @Test
    void testException_ValidCapacityCreation() {
        // Verifies bogie with capacity > 0 is instantiated without exception
        assertDoesNotThrow(() -> {
            new UseCase16TrainConsistMgmnt.PassengerBogie("Sleeper", 72);
        });
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        // Verifies negative value triggers InvalidCapacityException
        assertThrows(UseCase16TrainConsistMgmnt.InvalidCapacityException.class, () -> {
            new UseCase16TrainConsistMgmnt.PassengerBogie("AC Chair", -10);
        });
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        // Verifies zero capacity is treated as invalid
        assertThrows(UseCase16TrainConsistMgmnt.InvalidCapacityException.class, () -> {
            new UseCase16TrainConsistMgmnt.PassengerBogie("General", 0);
        });
    }

    @Test
    void testException_ExceptionMessageValidation() {
        // Verifies the returned message matches business requirements
        Exception exception = assertThrows(UseCase16TrainConsistMgmnt.InvalidCapacityException.class, () -> {
            new UseCase16TrainConsistMgmnt.PassengerBogie("Sleeper", 0);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws UseCase16TrainConsistMgmnt.InvalidCapacityException {
        // Verifies object correctly stores values upon successful creation
        UseCase16TrainConsistMgmnt.PassengerBogie bogie =
                new UseCase16TrainConsistMgmnt.PassengerBogie("First Class", 24);
        assertEquals("First Class", bogie.name);
        assertEquals(24, bogie.capacity);
    }
}