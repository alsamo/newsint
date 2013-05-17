/**
 * This class contains the main method and is written for testing purposes only.
 *
 * Created with IntelliJ IDEA.
 * @author Mohamad Alsayedahmad
 * Date: 17/05/2013
 */
public class Main {

    public static void main(String args[]) {

        String inputPlateauSize = "5 5";

        String inputRoverALocation = "1 2 N";
        String inputRoverACommand = "LMLMLMLMM";

        Rover rover = null;

        try {
            MarsController.INSTANCE.setPlateau(inputPlateauSize);
            rover = MarsController.INSTANCE.initiateRover(inputRoverALocation);

            MarsController.INSTANCE.validateCommand(inputRoverACommand);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }

        System.out.println("Output: ");
        if(rover != null) {
            rover.execute(inputRoverACommand);
            System.out.println(rover.getLocation().getXCoordinate() + " " + rover.getLocation().getYCoordinate() + " "
                    + new String(new byte[]{rover.getLocation().getNavigator().getDirection()}));
        }

    }
}
