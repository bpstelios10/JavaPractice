package practice.mars_rover;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;

public class PaginatedStack {

    public static int ARRAY_SIZE;
    private final Deque<byte[]> stack;
    private int size = 0;

    public PaginatedStack() {
        this(1000);
    }

    public PaginatedStack(int arraySize) {
        ARRAY_SIZE = arraySize;
        this.stack = new ArrayDeque<>();
    }

    public void push(byte nextMove) {
        if (nextMoveIndex() == 0)
            stack.push(new byte[ARRAY_SIZE]);

        if (stack.size() < 1) throw new RuntimeException("stack cant be empty at this point");
        byte[] latestMovesArray = stack.peek();

        latestMovesArray[nextMoveIndex()] = nextMove;
        size++;
    }

    public byte pop() {
        if (stack.size() == 0) throw new EmptyStackException();
        int nextMoveIndex = nextMoveIndex();
        int lastMoveIndex = nextMoveIndex == 0 ? ARRAY_SIZE - 1 : nextMoveIndex - 1;
        byte[] latestMovesArray = nextMoveIndex == 1 ? stack.pop() : stack.peek();
        size--;

        return latestMovesArray[lastMoveIndex];
    }

    public byte peek() {
        if (stack.size() == 0) throw new EmptyStackException();
        int nextMoveIndex = nextMoveIndex();

        return stack.peek()[nextMoveIndex == 0 ? ARRAY_SIZE - 1 : nextMoveIndex - 1];
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size() == 0;
    }

    private short nextMoveIndex() {
        return (short) (size % ARRAY_SIZE);
    }
}
