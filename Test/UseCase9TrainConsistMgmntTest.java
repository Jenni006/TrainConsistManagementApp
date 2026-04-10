import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UseCase10TrainConsistMgmntTest {

    private List<UseCase10TrainConsistMgmnt.Bogie> bogies;

    @BeforeEach
    void setUp() {
        bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("AC Chair", 56));
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("First Class", 24));
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("Sleeper", 70));
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        int total = bogies.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        assertEquals(222, total); // 72 + 56 + 24 + 70
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        int total = bogies.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        assertTrue(total > 0);
        assertEquals(4, bogies.size());
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<UseCase10TrainConsistMgmnt.Bogie> singleList = List.of(new UseCase10TrainConsistMgmnt.Bogie("Sleeper", 72));
        int total = singleList.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        assertEquals(72, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<UseCase10TrainConsistMgmnt.Bogie> emptyList = new ArrayList<>();
        int total = emptyList.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        assertEquals(0, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        int originalSize = bogies.size();
        bogies.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        assertEquals(originalSize, bogies.size());
    }
}