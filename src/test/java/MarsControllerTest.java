import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 *  This class is responsible for testing the MarsController class.
 *
 * Created with IntelliJ IDEA.
 * @author Mohamad Alsayedahmad
 * Date: 17/05/2013
 */
public class MarsControllerTest {

    @Test
    public void valid_input_sets_plateau_correctly() throws Exception {
        MarsController.INSTANCE.setPlateau("5 10");

        assertEquals(Plateau.INSTANCE.getLength(), 5);
        assertEquals(Plateau.INSTANCE.getWidth(), 10);

    }

    @Test (expectedExceptions = InvalidInputException.class)
    public void invalid_plateau_coordinates_throw_exception() throws InvalidInputException {
        MarsController.INSTANCE.setPlateau("0 1");
    }

    @Test
    public void valid_rover_location_initiates_rover() throws Exception {
        String roverLocation = "2 3 N";
        Rover rover = MarsController.INSTANCE.initiateRover(roverLocation);

        assertEquals(rover.getLocation().getXCoordinate(), 2);
        assertEquals(rover.getLocation().getYCoordinate(), 3);
        assertEquals(rover.getLocation().getNavigator().getDirection(), RoverConstants.NORTH);
    }

    @Test (expectedExceptions = InvalidInputException.class)
    public void invalid_rover_location_throws_exception () throws InvalidInputException {
        String roverLocation = "-1 0 L";
        MarsController.INSTANCE.initiateRover(roverLocation);
    }

    @Test (expectedExceptions = InvalidInputException.class)
    public void invalid_command_throws_exception() throws Exception {
        String command = "LLLLK";
        MarsController.INSTANCE.validateCommand(command);
    }
}
