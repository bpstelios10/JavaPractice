package practice.tictactoe;

import java.util.Arrays;

import static practice.utils.Assertions.assertThat;

class TicTacToeTest {

    public static void main(String[] args) {
        System.out.println("Tests for TicTacToe start");
        TicTacToeTest tests = new TicTacToeTest();

        tests.addToBoard_succeeds();
        tests.printBoard_succeeds();
        tests.winningPlayer_succeeds();

        System.out.println("Tests for TicTacToe ended");
    }

    private void addToBoard_succeeds() {
        TicTacToe underTest = new TicTacToe();

        assertThat(underTest.board[0][0] == 0);
        assertThat(underTest.moves == 0);
        underTest.addToBoard(1, 1);
        assertThat(underTest.board[0][0] == 1);
        assertThat(underTest.moves == 1);
        assertThat(underTest.board[1][0] == 0);
        underTest.addToBoard(2, 4);
        assertThat(underTest.board[1][0] == 2);
        assertThat(underTest.moves == 2);
        assertThat(underTest.board[2][2] == 0);
        underTest.addToBoard(1, 9);
        assertThat(underTest.board[2][2] == 1);
        assertThat(underTest.moves == 3);
        assertThat(Arrays.deepEquals(underTest.board, new int[][]{{1, 0, 0}, {2, 0, 0}, {0, 0, 1}}));
    }

    private void printBoard_succeeds() {
        TicTacToe underTest = new TicTacToe();
//        System.out.println(underTest.printBoard());

        String expectedBoard = """
                 0 | 0 | 0\s
                -----------
                 0 | 0 | 0\s
                -----------
                 0 | 0 | 0\s""";
        assertThat(underTest.printBoard().equals(expectedBoard));

        underTest.addToBoard(1, 1);
        underTest.addToBoard(2, 4);
        underTest.addToBoard(1, 9);
//        System.out.println(underTest.printBoard());
        expectedBoard = """
                 1 | 0 | 0\s
                -----------
                 2 | 0 | 0\s
                -----------
                 0 | 0 | 1\s""";
        assertThat(underTest.printBoard().equals(expectedBoard));
    }

    private void winningPlayer_succeeds() {
        TicTacToe winningRow = new TicTacToe();
        assertThat(winningRow.winningPlayer().isEmpty());
        winningRow.addToBoard(1, 1);
        assertThat(winningRow.winningPlayer().isEmpty());
        winningRow.addToBoard(2, 4);
        assertThat(winningRow.winningPlayer().isEmpty());
        winningRow.addToBoard(1, 2);
        assertThat(winningRow.winningPlayer().isEmpty());
        winningRow.addToBoard(2, 5);
        assertThat(winningRow.winningPlayer().isEmpty());
        winningRow.addToBoard(1, 3);
        assertThat(winningRow.winningPlayer().orElse(0) == 1);

        TicTacToe winningColumn = new TicTacToe();
        assertThat(winningColumn.winningPlayer().isEmpty());
        winningColumn.addToBoard(1, 1);
        assertThat(winningColumn.winningPlayer().isEmpty());
        winningColumn.addToBoard(2, 3);
        assertThat(winningColumn.winningPlayer().isEmpty());
        winningColumn.addToBoard(1, 4);
        assertThat(winningColumn.winningPlayer().isEmpty());
        winningColumn.addToBoard(2, 6);
        assertThat(winningColumn.winningPlayer().isEmpty());
        winningColumn.addToBoard(1, 8);
        winningColumn.addToBoard(2, 9);
        assertThat(winningColumn.winningPlayer().orElse(0) == 2);

        TicTacToe noWinner = new TicTacToe();
        assertThat(noWinner.winningPlayer().isEmpty());
        noWinner.addToBoard(1, 1);
        assertThat(noWinner.winningPlayer().isEmpty());
        noWinner.addToBoard(2, 5);
        assertThat(noWinner.winningPlayer().isEmpty());
        noWinner.addToBoard(1, 2);
        assertThat(noWinner.winningPlayer().isEmpty());
        noWinner.addToBoard(2, 3);
        assertThat(noWinner.winningPlayer().isEmpty());
        noWinner.addToBoard(1, 7);
        assertThat(noWinner.winningPlayer().isEmpty());
        noWinner.addToBoard(2, 4);
        assertThat(noWinner.winningPlayer().isEmpty());
        noWinner.addToBoard(1, 6);
        assertThat(noWinner.winningPlayer().isEmpty());
        noWinner.addToBoard(2, 8);
        assertThat(noWinner.winningPlayer().isEmpty());
        noWinner.addToBoard(1, 9);
//        System.out.println(noWinner.printBoard());
        assertThat(noWinner.winningPlayer().isEmpty());

        TicTacToe winningAngle = new TicTacToe();
        assertThat(winningAngle.winningPlayer().isEmpty());
        winningAngle.addToBoard(1, 1);
        assertThat(winningAngle.winningPlayer().isEmpty());
        winningAngle.addToBoard(2, 5);
        assertThat(winningAngle.winningPlayer().isEmpty());
        winningAngle.addToBoard(1, 2);
        assertThat(winningAngle.winningPlayer().isEmpty());
        winningAngle.addToBoard(2, 3);
        assertThat(winningAngle.winningPlayer().isEmpty());
        winningAngle.addToBoard(1, 4);
        assertThat(winningAngle.winningPlayer().isEmpty());
        winningAngle.addToBoard(2, 7);
//        System.out.println(winningAngle.printBoard());
        assertThat(winningColumn.winningPlayer().orElse(0) == 2);
    }
}
