package org.usfirst.frc.team1923.robot.subsystems;

import org.usfirst.frc.team1923.robot.RobotMap;
import org.usfirst.frc.team1923.robot.commands.driveCommands.UltrasonicAlignCommand;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Ultrasonic.Unit;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class UltrasonicSubsystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	Ultrasonic left, right;
	
	public UltrasonicSubsystem() {
		left = new Ultrasonic(RobotMap.LEFT_ULTRASONIC_OUT, RobotMap.LEFT_ULTRASONIC_IN, Unit.kInches);
		right = new Ultrasonic(RobotMap.RIGHT_ULTRASONIC_OUT, RobotMap.RIGHT_ULTRASONIC_IN, Unit.kInches);
		left.setEnabled(true);
		left.setAutomaticMode(true);
		right.setEnabled(true);
		right.setAutomaticMode(true);
	}
	
	public double getLeft() {
		//left.ping();
		System.out.println(left.getRangeInches());
		return left.getRangeInches();
	}

	public double getRight() {
		//right.ping();
		System.out.println(right.getRangeInches());
		return right.getRangeInches();
	}

	public void initDefaultCommand() {
		//setDefaultCommand(new UltrasonicAlignCommand());
	}
}
