package practice.mars_rover;

import practice.utils.Benchmark;

public class RoverBenchmark {

    private final long ITERATIONS = 800_000_000L;

    // to check memory better, kill all java tasks before running each test separately
    // to test rover or rover-paginated, for now, just switch the rover instantiation in each method
    public static void main(String[] args) {
        System.out.println("Starting tests for Rover");
        RoverBenchmark tests = new RoverBenchmark();
//        tests.benchmark_invalidMoves_multipleTimes();
        tests.benchmark_invalidMoves();
        tests.benchmark_straightMove();
        tests.benchmark_movesForthAndBack();
        tests.benchmark_movesDiagonal();
        tests.benchmark_moveAndUndoMove();
        tests.benchmark_moveManyAndUndoAllMultipleTimes();
        System.out.println("Tests for Rover finished successfully");
    }

    public void benchmark_invalidMoves() {
//        Rover rover = new Rover();
        RoverPaginatedStack rover = new RoverPaginatedStack();

        Benchmark.benchmark(() -> rover.move(2), ITERATIONS);
    }

    public void benchmark_invalidMoves_multipleTimes() {
//        Rover rover = new Rover();
        RoverPaginatedStack rover = new RoverPaginatedStack();

        Benchmark.benchmark(() -> rover.move(2), ITERATIONS, 10);
    }

    public void benchmark_straightMove() {
//        Rover rover = new Rover();
        RoverPaginatedStack rover = new RoverPaginatedStack();

        Benchmark.benchmark(() -> rover.move(1), ITERATIONS);
    }

    public void benchmark_movesForthAndBack() {
//        Rover rover = new Rover();
        RoverPaginatedStack rover = new RoverPaginatedStack();

        Benchmark.benchmark(() -> {
            rover.move(1);
            rover.move(2);
        }, ITERATIONS);
    }

    public void benchmark_movesDiagonal() {
//        Rover rover = new Rover();
        RoverPaginatedStack rover = new RoverPaginatedStack();

        Benchmark.benchmark(() -> {
            rover.move(1);
            rover.move(4);
        }, ITERATIONS);
    }

    public void benchmark_moveAndUndoMove() {
//        Rover rover = new Rover();
        RoverPaginatedStack rover = new RoverPaginatedStack();

        Benchmark.benchmark(() -> {
            rover.move(1);
            rover.undoMove();
        }, ITERATIONS);
    }

    public void benchmark_moveManyAndUndoAllMultipleTimes() {
//        Rover rover = new Rover();
        RoverPaginatedStack rover = new RoverPaginatedStack();

        Benchmark.benchmark(() -> {
            for (short j = 0; j < 1001; j++) {
                rover.move(1);
            }
            for (short j = 0; j < 1001; j++) {
                rover.undoMove();
            }
        }, ITERATIONS / 1000);
    }
}
