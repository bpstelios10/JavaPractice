package practice.mars_rover;

public class RoverPaginatedStack {

    private static final int SIZE_OF_HISTORY_PAGES = 1000; // Switch to 3 for testing purposes

    private long xCoordinate;
    private long yCoordinate;

    // To keep full history, created a data structure that keeps paginated data. it is a deque of byte arrays, of fixed size
    // arrays are of byte type so that we minimize memory footprint
    // alternative is a stack of bytes or integers of fixed, small size. if we only need the last 1000 moves for example
    private final PaginatedStack movesHistory;

    public RoverPaginatedStack() {
        this(0, 0);
    }

    // provide constructor that changes the starting point
    public RoverPaginatedStack(long xCoordinate, long yCoordinate) {
        // validate > 0
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        movesHistory = new PaginatedStack(SIZE_OF_HISTORY_PAGES);
    }

    public long getXCoordinate() {
        return xCoordinate;
    }

    public long getYCoordinate() {
        return yCoordinate;
    }

    int getSizeOfHistoryPages() {
        return movesHistory.size();
    }

    //  1. forward | 2. backwards | 3. left | 4. right
    public void move(int nextMove) {
        long currentXCoordinate = xCoordinate;
        long currentYCoordinate = yCoordinate;

        doStep(nextMove);

        if (currentXCoordinate != xCoordinate || currentYCoordinate != yCoordinate)
            movesHistory.push((byte) nextMove);
    }

    public void undoMove() {
        if (movesHistory.empty()) return; // TODO throw error?

        int lastMove = movesHistory.pop();
        switch (lastMove) {
            case 1 -> doStep(2);
            case 2 -> doStep(1);
            case 3 -> doStep(4);
            case 4 -> doStep(3);
        }
    }

    public String toString() {
        return String.format("Rover is on position x: [%d], y: [%d]", xCoordinate, yCoordinate);
    }

    private void doStep(int nextMove) {
        switch (nextMove) {
            // no need to check limits cause its infinite (but will risk overflow)
            case 1 -> yCoordinate++;
            case 2 -> {
                if (yCoordinate > 0) yCoordinate--;
                // else throw some exception
            }
            case 3 -> {
                if (xCoordinate > 0) xCoordinate--;
                // else exception
            }
            //similar here, no need at the moment to check next right move
            case 4 -> xCoordinate++;
        }
    }
}
