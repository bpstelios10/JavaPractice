package practice.mars_rover;

import static practice.utils.Assertions.assertThat;

public class RoverTest {

    public static void main(String[] args) {
        RoverTest tests = new RoverTest();

        System.out.println("Starting tests for Rover");

        tests.moves_succeeds();
        tests.undo_succeeds();

        System.out.println("Tests for Rover finished successfully");
    }

    public void moves_succeeds() {
        Rover rover = new Rover();

        rover.move(1);
        assertThat(rover.getXCoordinate() == 0 && rover.getYCoordinate() == 1);
        rover.move(1);
        assertThat(rover.getXCoordinate() == 0 && rover.getYCoordinate() == 2);
        rover.move(4);
        assertThat(rover.getXCoordinate() == 1 && rover.getYCoordinate() == 2);
        rover.move(4);
        assertThat(rover.getXCoordinate() == 2 && rover.getYCoordinate() == 2);
        rover.move(3);
        assertThat(rover.getXCoordinate() == 1 && rover.getYCoordinate() == 2);
        rover.move(2);
        assertThat(rover.getXCoordinate() == 1 && rover.getYCoordinate() == 1);
        assertThat(rover.getSizeOfHistoryPages() == 6);
//        System.out.println(rover);
    }

    public void undo_succeeds() {
        Rover rover = new Rover();

        rover.move(1);
        rover.move(1);
        rover.move(4);
        rover.move(4);
        assertThat(rover.getXCoordinate() == 2 && rover.getYCoordinate() == 2);
        rover.undoMove();
        assertThat(rover.getXCoordinate() == 1 && rover.getYCoordinate() == 2);
        rover.undoMove();
        assertThat(rover.getXCoordinate() == 0 && rover.getYCoordinate() == 2);
        rover.undoMove();
        assertThat(rover.getXCoordinate() == 0 && rover.getYCoordinate() == 1);
        rover.undoMove();
        assertThat(rover.getXCoordinate() == 0 && rover.getYCoordinate() == 0);
        rover.undoMove();
        assertThat(rover.getXCoordinate() == 0 && rover.getYCoordinate() == 0);
        assertThat(rover.getSizeOfHistoryPages() == 0);
//        System.out.println(rover);
    }
}
