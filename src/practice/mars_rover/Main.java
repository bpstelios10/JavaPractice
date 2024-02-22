package practice.mars_rover;

import java.util.Scanner;

public class Main {

    // we assume rover starts at a point (x, y) and all points are positive. could go with negative too with small changes in the code
    // further requirements, went it turns left, the direction changes accordingly
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rover rover = new Rover(0, 0);

        while (true) {
            System.out.println("""
                    Select next move. Options: 
                    0 to exit
                    1. forward
                    2. backwards
                    3. left
                    4. right
                    5. undo last move
                    """);
            int nextMove = scanner.nextInt(); // TODO validations
            if (nextMove == 0) break;
            if (nextMove == 5) rover.undoMove();
            else rover.move(nextMove);

            System.out.println(rover);
        }
    }
}
