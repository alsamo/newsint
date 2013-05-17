/**
 * This is a singleton class which is responsible for initiating rover objects, setting the plateau and validating the
 * input command.
 *
 * Created with IntelliJ IDEA.
 * @author Mohamad Alsayedahamd
 * Date: 17/05/2013
 */
public enum MarsController {
    INSTANCE;

    public void setPlateau(String plateauCoordinates) throws InvalidInputException {
        try {
            String[] coordinates = plateauCoordinates.split(" ");
            int length = Integer.parseInt(coordinates[0]);
            int width = Integer.parseInt(coordinates[1]);
            Plateau.INSTANCE.setLength(length);
            Plateau.INSTANCE.setWidth(width);
            if(length<1 || width<1) {
                throw new InvalidInputException("Plateau coordinates must be greater than 1");
            }
        } catch (NumberFormatException ne) {
            throw new InvalidInputException("Invalid Plateau coordinates: " + plateauCoordinates);
        }
    }

    public Rover initiateRover(String initialLocation) throws InvalidInputException {
        Rover rover;
        try {
            String[] location = initialLocation.split(" ");
            int roverCoordinateX = Integer.parseInt(location[0]);
            int roverCoordinateY = Integer.parseInt(location[1]);
            byte roverDirection = location[2].getBytes()[0];
            if(!validDirection(roverDirection) || !Plateau.INSTANCE.contains(roverCoordinateX, roverCoordinateY)) {
                throw new InvalidInputException("Invalid Rover direction!");
            }
            rover = new Rover(roverCoordinateX, roverCoordinateY, roverDirection);
        } catch (Exception e) {
            throw new InvalidInputException("Invalid Rover location: " + initialLocation);
        }
        return rover;
    }

    public void validateCommand(String command) throws InvalidInputException {
        for(int i=0; i<command.length(); i++) {
            switch(command.charAt(i)) {
                case RoverConstants.LEFT:
                    break;
                case RoverConstants.RIGHT:
                    break;
                case RoverConstants.MOVE:
                    break;
                default:
                    throw new InvalidInputException("Invalid Command: " + command);
            }
        }
    }

    private boolean validDirection(byte roverDirection) {
        return roverDirection == RoverConstants.NORTH
                || roverDirection == RoverConstants.SOUTH
                || roverDirection == RoverConstants.WEST
                || roverDirection == RoverConstants.EAST;
    }

}
