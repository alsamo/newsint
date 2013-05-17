/**
 * This class is responsible for defining the interface of a particular state in a rover's context.
 *
 * Created with IntelliJ IDEA.
 * @author Mohamad Alsayedahmad
 * Date: 17/05/2013
 */
public interface Navigator {
    public byte getDirection();
    public void moveForward(Rover rover);
    public void turnLeft(Rover rover);
    public void turnRight(Rover rover);
}
