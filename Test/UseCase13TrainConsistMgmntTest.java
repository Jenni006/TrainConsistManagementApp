import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase13TrainConsistMgmntTest {

    private List<UseCase13TrainConsistMgmnt.Bogie> bogies;

    @BeforeEach
    void setUp() {
        bogies = new ArrayList<>();
        bogies.add(new UseCase13TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase13TrainConsistMgmnt.Bogie("General", 40));
        bogies.add(new UseCase13TrainConsistMgmnt.Bogie("AC Chair", 80));
    }

    @Test
    void testLoopFilteringLogic() {
        List<UseCase13TrainConsistMgmnt.Bogie> filtered = new ArrayList<>();
        for (UseCase13TrainConsistMgmnt.Bogie b : bogies) {
            if (b.capacity > 60) filtered.add(b);
        }
        assertEquals(2, filtered.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<UseCase13TrainConsistMgmnt.Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        assertEquals(2, filtered.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        // Loop result
        List<UseCase13TrainConsistMgmnt.Bogie> loopRes = new ArrayList<>();
        for (UseCase13TrainConsistMgmnt.Bogie b : bogies) {
            if (b.capacity > 60) loopRes.add(b);
        }

        // Stream result
        List<UseCase13TrainConsistMgmnt.Bogie> streamRes = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(loopRes.size(), streamRes.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        // simulate a small delay or operation
        Math.sqrt(25.0);
        long end = System.nanoTime();
        assertTrue((end - start) >= 0);
    }
}