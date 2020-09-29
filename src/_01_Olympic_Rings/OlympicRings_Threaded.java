package _01_Olympic_Rings;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.

	public static void main(String[] args) {
		Robot r1 = new Robot(20, 700);
		Robot r2 = new Robot(400, 700);
		Robot r3 = new Robot(800, 700);
		Robot r4 = new Robot(190, 900);
		Robot r5 = new Robot(600, 900);

		r1.setSpeed(10);
		r2.setSpeed(10);
		r3.setSpeed(10);
		r4.setSpeed(10);
		r5.setSpeed(10);

		r1.penDown();
		r2.penDown();
		r3.penDown();
		r4.penDown();
		r5.penDown();
		
		Thread t1 = new Thread(() -> drawCircle(r1, 359));
		Thread t2 = new Thread(() -> drawCircle(r2, 359));
		Thread t3 = new Thread(() -> drawCircle(r3, 359));
		Thread t4 = new Thread(() -> drawCircle(r4, 359));
		Thread t5 = new Thread(() -> drawCircle(r5, 359));

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

	}

	static void drawCircle(Robot r, int sides) {
		for (int i = 0; i < 360; i++) {
			r.move(3);
			r.turn(360 / 360);
		}
	}

}
