/**
 * This class is responsible for facilitating change of location for a rover while facing East.
 *
 * Created with IntelliJ IDEA.
 * @author Mohamad Alsayedahmad
 * Date: 17/05/2013
 */
public class EastNavigator implements Navigator {

    private NavigationController navigationController = NavigationController.INSTANCE;

    @Override
    public byte getDirection() {
        return RoverConstants.EAST;
    }

    @Override
    public void moveForward(Rover rover) {
        if(rover.getLocation().getXCoordinate() < Plateau.INSTANCE.getLength()) {
            rover.getLocation().incrementX();
        }
    }

    @Override
    public void turnLeft(Rover rover) {
        rover.getLocation().setNavigator(navigationController.getDirectionByName(RoverConstants.NORTH));
    }

    @Override
    public void turnRight(Rover rover) {
        rover.getLocation().setNavigator(navigationController.getDirectionByName(RoverConstants.SOUTH));
    }
}
