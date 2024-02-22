package practice.mars_rover;

import static practice.utils.Assertions.assertThat;

public class PaginatedStackTest {
    private final byte b1 = 1;
    private final byte b2 = 2;
    private final byte b3 = 3;
    private final byte b4 = 4;

    public static void main(String[] args) {
        PaginatedStackTest tests = new PaginatedStackTest();
        System.out.println("Starting tests for PaginatedStack");

        tests.push_tests();
        tests.push_tests_nextPage();
        tests.pop_tests();
        tests.pop_tests_nextAndPreviousPages();
        tests.peek_tests();
        tests.peek_tests_nextAndPreviousPages();
        tests.size_tests();
        tests.empty_tests();

        System.out.println("Tests for PaginatedStack finished successfully");
    }

    private void push_tests() {
        PaginatedStack paginatedStack = new PaginatedStack();

        assertThat(paginatedStack.size() == 0);
        paginatedStack.push(b1);
        paginatedStack.push(b3);
        assertThat(paginatedStack.size() == 2);
        assertThat(paginatedStack.peek() == b3);
    }

    private void push_tests_nextPage() {
        PaginatedStack paginatedStack = new PaginatedStack(3);

        assertThat(paginatedStack.size() == 0);
        paginatedStack.push(b1);
        paginatedStack.push(b2);
        paginatedStack.push(b3);
        assertThat(paginatedStack.size() == 3);
        assertThat(paginatedStack.peek() == b3);
        paginatedStack.push(b2);
        assertThat(paginatedStack.size() == 4);
        assertThat(paginatedStack.peek() == b2);
    }

    private void pop_tests() {
        PaginatedStack paginatedStack = new PaginatedStack();

        assertThat(paginatedStack.size() == 0);
        paginatedStack.push(b1);
        assertThat(paginatedStack.pop() == b1);
        assertThat(paginatedStack.size() == 0);
        paginatedStack.push(b1);
        paginatedStack.push(b2);
        paginatedStack.push(b3);
        paginatedStack.push(b4);
        assertThat(paginatedStack.size() == 4);
        assertThat(paginatedStack.pop() == b4);
        assertThat(paginatedStack.pop() == b3);
        assertThat(paginatedStack.pop() == b2);
        assertThat(paginatedStack.pop() == b1);
        assertThat(paginatedStack.size() == 0);
    }

    private void pop_tests_nextAndPreviousPages() {
        PaginatedStack paginatedStack = new PaginatedStack(3);
        paginatedStack.push(b1);
        paginatedStack.push(b2);
        paginatedStack.push(b3);
        assertThat(paginatedStack.size() == 3);
        assertThat(paginatedStack.pop() == b3);
        assertThat(paginatedStack.pop() == b2);
        assertThat(paginatedStack.pop() == b1);
        assertThat(paginatedStack.size() == 0);

        paginatedStack.push(b1);
        paginatedStack.push(b2);
        paginatedStack.push(b3);
        paginatedStack.push(b4);
        assertThat(paginatedStack.size() == 4);
        assertThat(paginatedStack.pop() == b4);
        assertThat(paginatedStack.pop() == b3);
        assertThat(paginatedStack.pop() == b2);
        assertThat(paginatedStack.pop() == b1);
        assertThat(paginatedStack.size() == 0);
    }

    private void peek_tests() {
        PaginatedStack paginatedStack = new PaginatedStack();

        assertThat(paginatedStack.size() == 0);
        paginatedStack.push(b1);
        assertThat(paginatedStack.peek() == b1);
        assertThat(paginatedStack.peek() == b1);
        paginatedStack.push(b3);
        assertThat(paginatedStack.size() == 2);
        assertThat(paginatedStack.peek() == b3);
        assertThat(paginatedStack.peek() == b3);
        assertThat(paginatedStack.peek() == b3);
    }

    private void peek_tests_nextAndPreviousPages() {
        PaginatedStack paginatedStack = new PaginatedStack(3);

        assertThat(paginatedStack.size() == 0);
        paginatedStack.push(b1);
        assertThat(paginatedStack.peek() == b1);
        assertThat(paginatedStack.peek() == b1);
        paginatedStack.push(b2);
        paginatedStack.push(b3);
        assertThat(paginatedStack.size() == 3);
        assertThat(paginatedStack.peek() == b3);
        assertThat(paginatedStack.peek() == b3);
        assertThat(paginatedStack.peek() == b3);
        paginatedStack.push(b4);
        assertThat(paginatedStack.size() == 4);
        assertThat(paginatedStack.peek() == b4);
        assertThat(paginatedStack.peek() == b4);
        assertThat(paginatedStack.peek() == b4);
    }

    private void size_tests() {
        PaginatedStack paginatedStack = new PaginatedStack();

        assertThat(paginatedStack.size() == 0);
        paginatedStack.push(b1);
        assertThat(paginatedStack.size() == 1);
        paginatedStack.push(b1);
        assertThat(paginatedStack.size() == 2);
    }

    private void empty_tests() {
        PaginatedStack paginatedStack = new PaginatedStack();

        assertThat(paginatedStack.empty());
        paginatedStack.push(b1);
        assertThat(!paginatedStack.empty());
    }
}
