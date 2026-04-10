import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase12TrainConsistMgmntTest {

    private List<UseCase12TrainConsistMgmnt.GoodsBogie> bogies;

    @BeforeEach
    void setUp() {
        bogies = new ArrayList<>();
    }

    @Test
    void testSafety_AllBogiesValid() {
        bogies.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Rectangular", "Coal"));

        boolean result = bogies.stream()
                .allMatch(b -> !b.type.equalsIgnoreCase("Cylindrical") || b.cargo.equalsIgnoreCase("Petroleum"));
        assertTrue(result);
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        bogies.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Cylindrical", "Coal")); // VIOLATION

        boolean result = bogies.stream()
                .allMatch(b -> !b.type.equalsIgnoreCase("Cylindrical") || b.cargo.equalsIgnoreCase("Petroleum"));
        assertFalse(result);
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        bogies.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Rectangular", "Coal"));
        bogies.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Open", "Iron Ore"));

        boolean result = bogies.stream()
                .allMatch(b -> !b.type.equalsIgnoreCase("Cylindrical") || b.cargo.equalsIgnoreCase("Petroleum"));
        assertTrue(result);
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        bogies.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Cylindrical", "Water")); // VIOLATION

        boolean result = bogies.stream()
                .allMatch(b -> !b.type.equalsIgnoreCase("Cylindrical") || b.cargo.equalsIgnoreCase("Petroleum"));
        assertFalse(result);
    }

    @Test
    void testSafety_EmptyBogieList() {
        boolean result = bogies.stream()
                .allMatch(b -> !b.type.equalsIgnoreCase("Cylindrical") || b.cargo.equalsIgnoreCase("Petroleum"));
        assertTrue(result, "Empty lists should technically be compliant as no rules are broken.");
    }
}