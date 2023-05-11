# AmazingRace

AmazingRace is a simple race game implemented in Java using the Swing library. The game allows two cars, Delorean and Ectomobile, to race towards a goal. Users can control the race using buttons in the graphical interface, including starting, stopping, restarting, and pausing the race.

## Getting Started

To run the game, you need to have Java installed on your system. Follow these steps:

1. Clone the repository or download the source code files.
2. Compile the Java source files using the following command:


## Game Controls

The game provides the following buttons to control the race:

1. **Iniciar**: Click this button to start the race.
2. **Destruir**: Click this button to stop the race.
3. **Reiniciar**: Click this button to restart the race, resetting the car positions.
4. **Suspender**: Click this button to pause the race for 5 seconds.

## Game Logic

1. The game window consists of a graphical interface with two cars (Delorean and Ectomobile) and a goal.
2. Each car moves randomly with varying speeds towards the goal.
3. The cars' positions are updated at regular intervals.
4. The race continues until one of the cars reaches the goal.
5. When a car reaches the goal, the race is stopped, and the winner is displayed in the console.
6. Users can control the race using the provided buttons.
7. The **Iniciar** button starts the race by creating threads for each car's motion.
8. The **Destruir** button stops the race by stopping the car motion threads.
9. The **Reiniciar** button resets the race by stopping the threads, resetting the car positions, and updating the panel.
10. The **Suspender** button pauses the race for 5 seconds by pausing the car motion threads.

## Code Explanation

1. The code starts with importing the necessary packages: javax.swing for creating the GUI components and java.awt.event for handling events.
2. The AmazingRace class contains the main method, which serves as the entry point for the program. It creates an instance of the Graphics class, initializes the graphical components, and displays the window.
3. The Graphics class handles the creation of the game window and defines the GUI components and their functionalities.
4. Inside the Graphics class, several instance variables are declared to represent the various components of the game, such as the frame, panel, labels for cars and goal, and buttons for controlling the race.
5. The createWindow method is responsible for setting up the window and adding the components to it. It configures the frame, creates buttons with their respective event listeners, loads images for the cars and goal, and sets their positions.
6. The Motion class implements the Runnable interface and represents the motion of a car. It has a run method that executes the car's movement by calling the move method.
7. The move method defines the car's movement logic. It calculates the car's current position, the goal's position, and a random speed. The car is then moved incrementally by updating its location. The panel is revalidated and repainted to show the updated position. If the car reaches the goal, the race is stopped, and the winning car is displayed in the console. The method uses recursion to continuously move the car at regular intervals until it reaches the goal.
8. Several inner classes are defined to handle button events:
+The JButtonListener class implements the ActionListener interface and handles the start button's action. It creates instances of the Motion class for both cars, creates and starts the corresponding threads for each car.
+The StopListener class implements the ActionListener interface and handles the stop button's action. It stops the threads responsible for car motion.
+The RestartListener class implements the ActionListener interface and handles the restart button's action. It stops the threads, resets the car positions, and updates the panel to reflect the changes.
+The SleepListener class implements the ActionListener interface and handles the sleep button's action. It pauses the threads for 5000 milliseconds (5 seconds).

## License

AmazingRace is released under the [MIT License](LICENSE).

