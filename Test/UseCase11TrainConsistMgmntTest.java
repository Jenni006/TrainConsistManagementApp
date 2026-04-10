import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase11TrainConsistMgmntTest {

    private final String TRAIN_ID_REGEX = "TRN-\\d{4}";
    private final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(UseCase11TrainConsistMgmnt.validate("TRN-1234", TRAIN_ID_REGEX));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(UseCase11TrainConsistMgmnt.validate("TRAIN12", TRAIN_ID_REGEX));
        assertFalse(UseCase11TrainConsistMgmnt.validate("TRN12A", TRAIN_ID_REGEX));
        assertFalse(UseCase11TrainConsistMgmnt.validate("1234-TRN", TRAIN_ID_REGEX));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(UseCase11TrainConsistMgmnt.validate("PET-AB", CARGO_CODE_REGEX));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(UseCase11TrainConsistMgmnt.validate("PET-ab", CARGO_CODE_REGEX)); // Lowercase
        assertFalse(UseCase11TrainConsistMgmnt.validate("PET123", CARGO_CODE_REGEX)); // Digits
        assertFalse(UseCase11TrainConsistMgmnt.validate("AB-PET", CARGO_CODE_REGEX)); // Wrong order
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(UseCase11TrainConsistMgmnt.validate("TRN-123", TRAIN_ID_REGEX));   // 3 digits
        assertFalse(UseCase11TrainConsistMgmnt.validate("TRN-12345", TRAIN_ID_REGEX)); // 5 digits
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(UseCase11TrainConsistMgmnt.validate("PET-aB", CARGO_CODE_REGEX));
        assertFalse(UseCase11TrainConsistMgmnt.validate("PET-Ab", CARGO_CODE_REGEX));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(UseCase11TrainConsistMgmnt.validate("", TRAIN_ID_REGEX));
        assertFalse(UseCase11TrainConsistMgmnt.validate("", CARGO_CODE_REGEX));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        // Checking that it doesn't just match a portion
        assertFalse(UseCase11TrainConsistMgmnt.validate("TRN-1234Extra", TRAIN_ID_REGEX));
        assertFalse(UseCase11TrainConsistMgmnt.validate("PET-ABC", CARGO_CODE_REGEX));
    }
}