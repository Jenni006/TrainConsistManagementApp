import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class UseCase8TrainConsistMgmntTest {
    private List<UseCase8TrainConsistMgmnt.Bogie> bogies;

    @BeforeEach
    void setUp() {
        bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("AC Chair", 40));
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("First Class", 24));
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("General", 90));
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<UseCase8TrainConsistMgmnt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());
        assertEquals(2, result.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<UseCase8TrainConsistMgmnt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 72)
                .collect(Collectors.toList());
        assertFalse(result.stream().anyMatch(b -> b.capacity == 72));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<UseCase8TrainConsistMgmnt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 100)
                .collect(Collectors.toList());
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<UseCase8TrainConsistMgmnt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 30)
                .collect(Collectors.toList());
        assertEquals(3, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<UseCase8TrainConsistMgmnt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 500)
                .collect(Collectors.toList());
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<UseCase8TrainConsistMgmnt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 10)
                .collect(Collectors.toList());
        assertEquals(bogies.size(), result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<UseCase8TrainConsistMgmnt.Bogie> emptyList = new ArrayList<>();
        List<UseCase8TrainConsistMgmnt.Bogie> result = emptyList.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        int originalSize = bogies.size();
        bogies.stream().filter(b -> b.capacity > 60).collect(Collectors.toList());
        assertEquals(originalSize, bogies.size());
        assertEquals("Sleeper", bogies.get(0).name);
    }
}