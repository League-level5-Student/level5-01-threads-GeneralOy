package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	Robot blueRing;
	Robot yellowRing;
	Robot blackRing;
	Robot greenRing;
	Robot redRing;
	public static void main(String[] args) {
		OlympicRings_Threaded main = new OlympicRings_Threaded();
		
	}
	public OlympicRings_Threaded() {
		blueRing = new Robot(100,200);
		yellowRing = new Robot(220,300);
		blackRing = new Robot(340,200);
		greenRing = new Robot(460,300);
		redRing = new Robot(580,200);
		
		Thread r1 = new Thread(()->drawCircles(Color.blue, blueRing));
		Thread r2 = new Thread(()->drawCircles(Color.yellow, yellowRing));
		Thread r3 = new Thread(()->drawCircles(Color.black, blackRing));
		Thread r4 = new Thread(()->drawCircles(Color.green, greenRing));
		Thread r5 = new Thread(()->drawCircles(Color.red, redRing));

		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
	}
	
	void drawCircles(Color color, Robot r) {
		r.setPenWidth(15);
		r.setSpeed(20);
		r.penDown();
		r.setPenColor(color);
		for(int i = 0; i < 360; i++) {
			r.move(2);
			r.turn(1);
		}
		r.penUp();
		r.hide();
	}
}

