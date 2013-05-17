/**
 * This is a singleton class which is responsible for providing the correct navigator associated with a given direction.
 *
 * Created with IntelliJ IDEA.
 * @author Mohamad Alsayedahmad
 * Date: 17/05/2013
 */
public enum NavigationController {
    INSTANCE;

    private static Navigator north;
    private static Navigator south;
    private static Navigator west;
    private static Navigator east;

    public Navigator getDirectionByName(byte direction) {
        Navigator tempNavigator = null;

        if(direction == RoverConstants.NORTH) {
            if(north == null) {
                north = new NorthNavigator();
            }
            tempNavigator = north;
        } else if(direction == RoverConstants.SOUTH) {
            if(south == null) {
                south = new SouthNavigator();
            }
            tempNavigator = south;
        } else if(direction == RoverConstants.WEST) {
            if(west == null) {
                west = new WestNavigator();
            }
            tempNavigator = west;
        } else if(direction == RoverConstants.EAST) {
            if(east == null) {
                east = new EastNavigator();
            }
            tempNavigator = east;
        }
        return tempNavigator;
    }

}
