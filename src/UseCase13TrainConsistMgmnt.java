import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UseCase13TrainConsistMgmnt {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println(" UC13 - Performance Comparison (Loops vs Streams) ");
        System.out.println("===============================================\n");

        // Create a large dataset to make the benchmark meaningful
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Sleeper", (int) (Math.random() * 100)));
        }

        // --- 1. BENCHMARK TRADITIONAL LOOP ---
        long startLoop = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                loopFiltered.add(b);
            }
        }
        long endLoop = System.nanoTime();
        long loopDuration = endLoop - startLoop;

        // --- 2. BENCHMARK STREAM API ---
        long startStream = System.nanoTime();
        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();
        long streamDuration = endStream - startStream;

        // Display results
        System.out.println("Dataset Size: " + bogies.size() + " bogies");
        System.out.println("Filtered Count: " + loopFiltered.size());
        System.out.println("\nExecution Time (Nanoseconds):");
        System.out.println("Traditional Loop : " + loopDuration + " ns");
        System.out.println("Stream API       : " + streamDuration + " ns");

        if (loopDuration < streamDuration) {
            System.out.println("\nResult: Traditional Loop was faster in this run.");
        } else {
            System.out.println("\nResult: Stream API was faster in this run.");
        }
    }
}