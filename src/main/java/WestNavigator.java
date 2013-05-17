/**
 * This class is responsible for facilitating change of location for a rover while facing West.
 *
 * Created with IntelliJ IDEA.
 * @author Mohamad Alsayedahmad
 * Date: 17/05/2013
 */
public class WestNavigator implements Navigator {

    private NavigationController navigationController = NavigationController.INSTANCE;

    @Override
    public byte getDirection() {
        return RoverConstants.WEST;
    }

    @Override
    public void moveForward(Rover rover) {
        if(rover.getLocation().getXCoordinate() > 0) {
            rover.getLocation().decrementX();
        }
    }

    @Override
    public void turnLeft(Rover rover) {
        rover.getLocation().setNavigator(navigationController.getDirectionByName(RoverConstants.SOUTH));
    }

    @Override
    public void turnRight(Rover rover) {
        rover.getLocation().setNavigator(navigationController.getDirectionByName(RoverConstants.NORTH));
    }
}
