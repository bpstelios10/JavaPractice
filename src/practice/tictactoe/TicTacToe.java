package practice.tictactoe;

import java.util.Optional;
import java.util.Scanner;

public class TicTacToe {

    final int[][] board = new int[3][3];
    int moves = 0;

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner in = new Scanner(System.in);
        int nextPlayer = 1;

        while (game.moves < 9 && game.winningPlayer().isEmpty()) {
            char nextPlayerChar = nextPlayer == 1 ? 'A' : 'B';
            System.out.println("Current board is:");
            System.out.println(game.printBoard());
            System.out.println("Player " + nextPlayerChar + " please select move, from 1 to 9");
            game.addToBoard(nextPlayer, in.nextInt());

            nextPlayer = nextPlayer == 1 ? 2 : 1;
        }

        if (game.winningPlayer().isEmpty()) System.out.println("Unlucky. No winners on this round");
        else System.out.printf("Player %c is the winner!! Congrats!\n", game.winningPlayer().get() == 1 ? 'A' : 'B');
    }

    void addToBoard(int player, int cell) {
        // TODO add validations + tests
        // cell and player numbers should be valid
        // cell should have value 0
        // could check if there is already a winner?
        int row = (cell - 1) / 3;
        int column = (cell - 1) % 3;

        board[row][column] = player;
        moves++;
    }

    String printBoard() {
        StringBuilder printout = new StringBuilder();
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                printout.append(" ").append(board[x][y]).append(" ");
                if (y < 2) printout.append("|");
            }
            if (x < 2) printout.append("\n-----------\n");
        }

        return printout.toString();
    }

    Optional<Integer> winningPlayer() {
        // TODO checks + optimizations
        // could check if there is already a winner? store it in class field
        // could keep a count of moves and if < 5 or 9 and not a winner, false
        // could use something like graph and if set of 3 then winner ? not exactly
        // could add the complexity to add. check if any neighbour is also same and if yes, then check the next in line
        int winner = 0;

        for (int x = 0; x < 3; x++) {
            if (board[0][x] == board[1][x] && board[1][x] == board[2][x]) {
                winner = board[0][x];
                break;
            } else if (board[x][0] == board[x][1] && board[x][1] == board[x][2]) {
                winner = board[x][0];
                break;
            }
        }
        if (winner == 0) {
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2] || board[2][0] == board[1][1] && board[1][1] == board[0][2])
                winner = board[2][2];
        }

        return winner == 0 ? Optional.empty() : Optional.of(winner);
    }
}
