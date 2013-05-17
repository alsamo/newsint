/**
 * This class represents the location of a particular rover. It holds information about x,y coordinates and the
 * associated navigator which in turn holds the direction of a rover.
 *
 * Created with IntelliJ IDEA.
 * @author Mohamad Alsayedahmad
 * Date: 17/05/2013
 */
public class Location {

    private int x;
    private int y;
    private Navigator navigator = null;

    public Location(int x, int y, Navigator navigator) {
        this.x = x;
        this.y = y;
        this.navigator = navigator;
    }

    public int getXCoordinate() {
        return this.x;
    }

    public int getYCoordinate() {
        return this.y;
    }

    public Navigator getNavigator() {
        return this.navigator;
    }

    public void incrementX() {
        x++;
    }

    public void decrementX() {
        x--;
    }

    public void incrementY() {
        y++;
    }

    public void decrementY() {
        y--;
    }

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

}

