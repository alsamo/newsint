/**
 * This class is responsible for representing a rover object, which holds the rover's location and facilitates for
 * command execution.
 *
 * Created with IntelliJ IDEA.
 * @author Mohamad Alsayedahmad
 * Date: 17/05/2013
 */
public class Rover {

    private Location location;

    public Rover(int x, int y, byte direction) {
        this.location = new Location(x, y, NavigationController.INSTANCE.getDirectionByName(direction));
    }

    public void execute(String command) {
        for(int i=0; i<command.length(); i++){
            switch (command.charAt(i)){
                case RoverConstants.MOVE:
                    this.moveForward();
                    break;
                case RoverConstants.LEFT:
                    this.turnLeft();
                    break;
                case RoverConstants.RIGHT:
                    this.turnRight();
                    break;
            }
        }
    }

    private void moveForward() {
        location.getNavigator().moveForward(this);
    }

    private void turnLeft() {
        location.getNavigator().turnLeft(this);
    }

    private void turnRight() {
        location.getNavigator().turnRight(this);
    }

    public Location getLocation() {
        return location;
    }


}
