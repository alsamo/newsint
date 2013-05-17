/**
 * This class is responsible for facilitating change of location for a rover while facing South.
 *
 * Created with IntelliJ IDEA.
 * @author Mohamad Alsayedahmad
 * Date: 17/05/2013
 */
public class SouthNavigator implements Navigator {

    private NavigationController navigationController = NavigationController.INSTANCE;

    @Override
    public byte getDirection() {
        return RoverConstants.SOUTH;
    }

    @Override
    public void moveForward(Rover rover) {
        if(rover.getLocation().getYCoordinate() > 0) {
            rover.getLocation().decrementY();
        }
    }

    @Override
    public void turnLeft(Rover rover) {
        rover.getLocation().setNavigator(navigationController.getDirectionByName(RoverConstants.EAST));
    }

    @Override
    public void turnRight(Rover rover) {
        rover.getLocation().setNavigator(navigationController.getDirectionByName(RoverConstants.WEST));
    }
}
