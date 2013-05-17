import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * This class is responsible for testing the Rover class.
 *
 * Created with IntelliJ IDEA.
 * @author Mohamad Alsayedahmad
 * Date: 17/05/2013
 */
public class RoverTest {



    @BeforeMethod
    public void setUp() throws Exception {
        Plateau.INSTANCE.setLength(5);
        Plateau.INSTANCE.setWidth(5);
    }


    @Test
    public void north_facing_move_increments_y() {
        Rover rover = new Rover(0,0, RoverConstants.NORTH);
        rover.execute("M");

        int expectedY = 1;
        int actualY = rover.getLocation().getYCoordinate();

        assertEquals(expectedY, actualY);
    }

    @Test
    public void north_facing_right_is_east() {
        Rover rover = new Rover(0,0, RoverConstants.NORTH);
        rover.execute("R");

        byte expectedDirection = RoverConstants.EAST;
        byte actualDirection = rover.getLocation().getNavigator().getDirection();

        assertEquals(expectedDirection, actualDirection);
    }

    @Test
    public void north_facing_left_is_west() {
        Rover rover = new Rover(0,0, RoverConstants.NORTH);
        rover.execute("L");

        byte expectedDirection = RoverConstants.WEST;
        byte actualDirection = rover.getLocation().getNavigator().getDirection();

        assertEquals(expectedDirection, actualDirection);
    }

    @Test
    public void north_facing_increment_will_not_overflow() {
        Rover rover = new Rover(0,0, RoverConstants.NORTH);
        rover.execute("MMMMMM");

        int expectedY = Plateau.INSTANCE.getWidth();
        int actualY = rover.getLocation().getYCoordinate();

        assertEquals(expectedY, actualY);
    }

    @Test
    public void south_facing_move_decrements_y() {
        Rover rover = new Rover(0,1, RoverConstants.SOUTH);
        rover.execute("M");

        int expectedY = 0;
        int actualY = rover.getLocation().getYCoordinate();

        assertEquals(expectedY, actualY);
    }

    @Test
    public void south_facing_right_is_west() {
        Rover rover = new Rover(0,0, RoverConstants.SOUTH);
        rover.execute("R");

        byte expectedDirection = RoverConstants.WEST;
        byte actualDirection = rover.getLocation().getNavigator().getDirection();

        assertEquals(expectedDirection, actualDirection);
    }

    @Test
    public void south_facing_left_is_east() {
        Rover rover = new Rover(0,0, RoverConstants.SOUTH);
        rover.execute("L");

        byte expectedDirection = RoverConstants.EAST;
        byte actualDirection = rover.getLocation().getNavigator().getDirection();

        assertEquals(expectedDirection, actualDirection);
    }

    @Test
    public void south_facing_decrement_will_not_overflow() {
        Rover rover = new Rover(0,2, RoverConstants.SOUTH);
        rover.execute("MMMMMM");

        int expectedY = 0;
        int actualY = rover.getLocation().getYCoordinate();

        assertEquals(expectedY, actualY);
    }

    @Test
    public void west_facing_move_decrements_x() {
        Rover rover = new Rover(1,0, RoverConstants.WEST);
        rover.execute("M");

        int expectedX = 0;
        int actualX = rover.getLocation().getXCoordinate();

        assertEquals(expectedX, actualX);
    }

    @Test
    public void west_facing_right_is_north() {
        Rover rover = new Rover(0,0, RoverConstants.WEST);
        rover.execute("R");

        byte expectedDirection = RoverConstants.NORTH;
        byte actualDirection = rover.getLocation().getNavigator().getDirection();

        assertEquals(expectedDirection, actualDirection);
    }

    @Test
    public void west_facing_left_is_south() {
        Rover rover = new Rover(0,0, RoverConstants.WEST);
        rover.execute("L");

        byte expectedDirection = RoverConstants.SOUTH;
        byte actualDirection = rover.getLocation().getNavigator().getDirection();

        assertEquals(expectedDirection, actualDirection);
    }

    @Test
    public void west_facing_decrement_will_not_overflow() {
        Rover rover = new Rover(2,0, RoverConstants.WEST);
        rover.execute("MMMMMM");

        int expectedX = 0;
        int actualX = rover.getLocation().getXCoordinate();

        assertEquals(expectedX, actualX);
    }

    @Test
    public void east_facing_move_increments_x() {
        Rover rover = new Rover(0,0, RoverConstants.EAST);
        rover.execute("M");

        int expectedX = 1;
        int actualX = rover.getLocation().getXCoordinate();

        assertEquals(expectedX, actualX);
    }

    @Test
    public void east_facing_right_is_south() {
        Rover rover = new Rover(0,0, RoverConstants.EAST);
        rover.execute("R");

        byte expectedDirection = RoverConstants.SOUTH;
        byte actualDirection = rover.getLocation().getNavigator().getDirection();

        assertEquals(expectedDirection, actualDirection);
    }

    @Test
    public void east_facing_left_is_north() {
        Rover rover = new Rover(0,0, RoverConstants.EAST);
        rover.execute("L");

        byte expectedDirection = RoverConstants.NORTH;
        byte actualDirection = rover.getLocation().getNavigator().getDirection();

        assertEquals(expectedDirection, actualDirection);
    }

    @Test
    public void east_facing_increment_will_not_overflow() {
        Rover rover = new Rover(2,0, RoverConstants.EAST);
        rover.execute("MMMMMM");

        int expectedX = Plateau.INSTANCE.getLength();
        int actualX = rover.getLocation().getXCoordinate();

        assertEquals(expectedX, actualX);
    }

    @Test
    public void rover_executes_sample1_command_correctly() {
        Rover rover = new Rover(1,2, RoverConstants.NORTH);
        rover.execute("LMLMLMLMM");

        byte expectedDirection = RoverConstants.NORTH;
        byte actualDirection = rover.getLocation().getNavigator().getDirection();

        int expectedY = 3;
        int actualY = rover.getLocation().getYCoordinate();

        int expectedX = 1;
        int actualX = rover.getLocation().getXCoordinate();

        assertEquals(expectedDirection, actualDirection);
        assertEquals(expectedX, actualX);
        assertEquals(expectedY, actualY);
    }

}
