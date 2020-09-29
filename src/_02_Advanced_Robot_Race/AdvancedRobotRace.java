package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.

	// 1. make a main method
	public static void main(String[] args) {
		// 2. create an array of 5 robots.
		Robot[] robots = new Robot[7];
		Thread[] threads = new Thread[robots.length];
		// 3. use a for loop to initialize the robots.
		for (int i = 0; i < robots.length; i++) {
			final int index = i;
			robots[i] = new Robot();
			threads[i] = new Thread(() -> robots[index].move(999));
		}
		// 4. make each robot start at the bottom of the screen, side by side, facing up
		for (int i = 0; i < robots.length; i++) {
			robots[i].setX(100 * (i + 1));
			robots[i].setY(500);
		}
		// 5. use another for loop to iterate through the array and make each robot move
		// a random amount less than 50.

		// 6. use a while loop to repeat step 5
		// until a robot has reached the top of the screen.
		Random r = new Random();
		/*
		 * while (robots[0].getY() < 0 && robots[1].getY() < 0 && robots[2].getY() < 0
		 * && robots[3].getY() < 0 || robots[4].getY() < 0) { for (int i = 0; i < 5;
		 * i++) { } }
		 */
		for (int i = 0; i < robots.length; i++) {
			robots[i].setSpeed(r.nextInt(11));
			threads[i].start();
		}
		
		boolean isRobotsFinished = false;
		while (!isRobotsFinished) {
			for (int i = 0; i < robots.length; i++) {
				if (robots[i].getY() < 0) {
					isRobotsFinished = true;
					break;
				}
			}
		}
		// 7. declare that robot the winner and throw it a party!
		for (int l = 0; l < robots.length - 1; l++) {
			threads[l].stop();
			if (robots[l].getY() < 0) {
				robots[l].setY(500);
				robots[l].setX(500);
				robots[l].sparkle();
			}
		}
		// 8. try different races with different amounts of robots.

		// 9. make the robots race around a circular track.
	}
}
