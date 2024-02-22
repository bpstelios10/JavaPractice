package practice.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom benchmark for micro benchmarking. stats for execution time and memory used are printed out.
 * NOTE that memory cant be accurate since garbage collections might happen during the executions.
 * <p>
 * a warmup phase is always added
 * call to gc() after each test, in order to improve the odds for next executions, but
 * user is advised to kill any java processes and run tests one-by-one for best results
 * <p>
 * Can use flags like, -XX:+HeapDumpOnOutOfMemoryError, -Xlog:gc*::time, -XX:+PrintGCDetails, -XX:+PrintCompilation etc for better results
 */
public class Benchmark {

    private Benchmark() {
        throw new UnsupportedOperationException(
                "Suppress default constructor for noninstantiability");
    }

    // This needs more work. objects used should be re-instantiated before each repetition
    public static void benchmark(Runnable command, long iterations, int repetitions) {
        List<Long> allTimings = new ArrayList<>();
        List<Long> allMemories = new ArrayList<>();
        warmUp(command);

//        IntStream.range(0, repetitions).sequential().forEach(j -> { // doesnt work for some reason
        for (short j = 0; j < repetitions; j++) {
            long heapSize = Runtime.getRuntime().totalMemory();
            long startTime = System.currentTimeMillis();

            for (long i = 0; i < iterations; i++)
                command.run();

            long timeElapsed = System.currentTimeMillis() - startTime;
            long memoryUsed = Runtime.getRuntime().totalMemory() - heapSize;
            allTimings.add(timeElapsed);
            if (memoryUsed > 0) allMemories.add(memoryUsed);
            System.out.println("Repetition " + j + ". Total heap size: " + formatSize(memoryUsed));
            System.out.println("Repetition " + j + ". Total execution time: " + timeElapsed + "ms");

            System.gc(); // not guaranteed but let improve our chances before next test
        }

        double averageExecutionTiming = allTimings.stream().mapToLong(Long::longValue).average().orElse(0);
        double averageMemoryConsumption = allMemories.stream().mapToLong(e -> e).average().orElse(0);
        System.out.println("Average heap size consumption: " + formatSize((long) averageMemoryConsumption));
        System.out.println("Average execution time: " + averageExecutionTiming + "ms");
    }

    public static void benchmark(Runnable command, long iterations) {
        warmUp(command);

        long heapSize = Runtime.getRuntime().totalMemory();
        long startTime = System.currentTimeMillis();

        for (long i = 0; i < iterations; i++)
            command.run();

        long endTime = System.currentTimeMillis();
        System.out.println("Total heap size: " + formatSize(Runtime.getRuntime().totalMemory() - heapSize));
        System.out.println("Total execution time: " + (endTime - startTime) + "ms");

        System.gc(); // not guaranteed but let improve our chances before next test
    }

    private static void warmUp(Runnable command) {
        for (short i = 0; i < 5000; i++)
            command.run();
    }

    private static String formatSize(long v) {
        if (v < 1024) return v + " B";
        int z = (63 - Long.numberOfLeadingZeros(v)) / 10;
        return String.format("%.1f %sB", (double) v / (1L << (z * 10)), " KMGTPE".charAt(z));
    }
}
