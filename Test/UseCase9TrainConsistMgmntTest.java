import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class UseCase9TrainConsistMgmntTest {
    private List<UseCase9TrainConsistMgmnt.Bogie> bogies;

    @BeforeEach
    void setUp() {
        bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("AC Chair", 56));
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 70));
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("AC Chair"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertEquals(2, grouped.get("Sleeper").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertNotEquals(grouped.get("Sleeper"), grouped.get("AC Chair"));
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<UseCase9TrainConsistMgmnt.Bogie> emptyList = new ArrayList<>();
        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> grouped = emptyList.stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertTrue(grouped.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<UseCase9TrainConsistMgmnt.Bogie> singleType = new ArrayList<>();
        singleType.add(new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72));
        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> grouped = singleType.stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertEquals(1, grouped.size());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertTrue(grouped.keySet().containsAll(List.of("Sleeper", "AC Chair")));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(1, grouped.get("AC Chair").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        int originalSize = bogies.size();
        bogies.stream().collect(Collectors.groupingBy(b -> b.name));
        assertEquals(originalSize, bogies.size(), "The original list should remain unmodified.");
    }
}