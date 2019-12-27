package _02_Advanced_Robot_Race;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	int temp = 30;
	Random rand = new Random();
	ArrayList<Robot> racers = new ArrayList<Robot>();
	Thread r1 = new Thread(() -> race(racers.get(0)));
	Thread r2 = new Thread(() -> race(racers.get(1)));
	Thread r3 = new Thread(() -> race(racers.get(2)));
	Thread r4 = new Thread(() -> race(racers.get(3)));
	Thread r5 = new Thread(() -> race(racers.get(4)));

	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.
	/** i never did this version of module 3 ^ :( **/
	public static void main(String[] args) {
		AdvancedRobotRace main = new AdvancedRobotRace();
	}

	public AdvancedRobotRace() {
		for (int i = 0; i < 5; i++) {
			racers.add(new Robot(temp, 600));
			temp += 70;
		}
		for (Robot robot : racers) {
			robot.setSpeed(10);
			// robot.turn(180);
		}
		// Thread r1 = new Thread(() -> race(racers.get(0)));
		// Thread r2 = new Thread(() -> race(racers.get(1)));
		// Thread r3 = new Thread(() -> race(racers.get(2)));
		// Thread r4 = new Thread(() -> race(racers.get(3)));
		// Thread r5 = new Thread(() -> race(racers.get(4)));

		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();

		/*
		 * if (racers.get(0).getY() <= 0) { JOptionPane.showMessageDialog(null,
		 * "Robot 1 is the winner!"); } else if (racers.get(1).getY() <= 0) {
		 * JOptionPane.showMessageDialog(null, "Robot 2 is the winner!"); } else if
		 * (racers.get(2).getY() <= 0) { JOptionPane.showMessageDialog(null,
		 * "Robot 3 is the winner!"); } else if (racers.get(3).getY() <= 0) {
		 * JOptionPane.showMessageDialog(null, "Robot 4 is the winner!"); } else if
		 * (racers.get(4).getY() <= 0) { JOptionPane.showMessageDialog(null,
		 * "Robot 5 is the winner!"); } else { JOptionPane.showMessageDialog(null,
		 * "Huh. No one finishes!"); }
		 */
		while (racers.get(0).getY() > 0 && racers.get(1).getY() > 0 && racers.get(2).getY() > 0
				&& racers.get(3).getY() > 0 && racers.get(4).getY() > 0) {
			System.out.println("nope");
		}
		
		if (racers.get(0).getY() <= 0 && racers.get(1).getY() > 0 && racers.get(2).getY() > 0
				&& racers.get(3).getY() > 0 && racers.get(4).getY() > 0) {
			JOptionPane.showMessageDialog(null, "Robot 1 is the winner!");
		} else if (racers.get(1).getY() <= 0 && racers.get(0).getY() > 0 && racers.get(2).getY() > 0
				&& racers.get(3).getY() > 0 && racers.get(4).getY() > 0) {
			JOptionPane.showMessageDialog(null, "Robot 2 is the winner!");
		} else if (racers.get(2).getY() <= 0 && racers.get(0).getY() > 0 && racers.get(1).getY() > 0
				&& racers.get(3).getY() > 0 && racers.get(4).getY() > 0) {
			JOptionPane.showMessageDialog(null, "Robot 3 is the winner!");
		} else if (racers.get(3).getY() <= 0 && racers.get(0).getY() > 0 && racers.get(1).getY() > 0
				&& racers.get(2).getY() > 0 && racers.get(4).getY() > 0) {
			JOptionPane.showMessageDialog(null, "Robot 4 is the winner!");
		} else if (racers.get(4).getY() <= 0 && racers.get(0).getY() > 0 && racers.get(1).getY() > 0
				&& racers.get(2).getY() > 0 && racers.get(3).getY() > 0) {
			JOptionPane.showMessageDialog(null, "Robot 5 is the winner!");
		} else if (racers.get(0).getY() > 0 && racers.get(1).getY() > 0 && racers.get(2).getY() > 0
				&& racers.get(3).getY() > 0 && racers.get(4).getY() > 0) {
			JOptionPane.showMessageDialog(null, "Huh. No one finishes!");
		} else {
			JOptionPane.showMessageDialog(null, "Huh. It was a tie!");
		}

	}

	void race(Robot robadob) {

		while (robadob.getY() > 0) {
			if (racers.get(0).getY() > 0 && racers.get(1).getY() > 0 && racers.get(2).getY() > 0
					&& racers.get(3).getY() > 0 && racers.get(4).getY() > 0) {
				robadob.move(rand.nextInt(25));
			} else if (racers.get(0).getY() <= 0 || racers.get(1).getY() <= 0 || racers.get(2).getY() <= 0
					|| racers.get(3).getY() <= 0 || racers.get(4).getY() <= 0) {
				// robadob.setY(100);
			}
		}

		if (robadob.getY() <= 0) {
			System.out.println("Robot has finished!");
			// robadob.setY(-10);
		}

	}

}
