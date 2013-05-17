The project was managed and built using Maven. To see it working, run the Main class or the unit tests.

Assumptions:

1. The application is based on an integer coordinate system.
2. No two rovers are allowed on the plateau at the same time.
3. Rovers are bound by the plateau coordinates.

The solution was devised using the State design pattern.

The context is handled by the following classes:

1. Rover
2. Location
3. NavigationController
4. MarsController

The state is handled by the following classes:

1. Navigator
2. NorthNavigator
3. SouthNavigator
4. WestNavigator
5. EastNavigator
6. Plateau

There are two main tests for this program:

1. MarsControllerTest
2. RoverTest

