/**
 * This class is responsible for facilitating change of location for a rover while facing North.
 *
 * Created with IntelliJ IDEA.
 * @author Mohamad Alsayedahmad
 * Date: 17/05/2013
 */
public class NorthNavigator implements Navigator {

    private NavigationController navigationController = NavigationController.INSTANCE;

    @Override
    public byte getDirection() {
        return RoverConstants.NORTH;
    }

    @Override
    public void moveForward(Rover rover) {
        if(rover.getLocation().getYCoordinate() < Plateau.INSTANCE.getWidth()) {
            rover.getLocation().incrementY();
        }
    }

    @Override
    public void turnLeft(Rover rover) {
        rover.getLocation().setNavigator(navigationController.getDirectionByName(RoverConstants.WEST));
    }

    @Override
    public void turnRight(Rover rover) {
        rover.getLocation().setNavigator(navigationController.getDirectionByName(RoverConstants.EAST));
    }
}
