package org.usfirst.frc.team1923.robot.commands.driveCommands;

import org.usfirst.frc.team1923.robot.Robot;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class UltrasonicAlignCommand extends Command {

	public UltrasonicAlignCommand() {
		requires(Robot.ultrasonicSubSys);
		requires(Robot.driveSubSys);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putNumber("Left Ultrasonic", Robot.ultrasonicSubSys.getLeft());
		SmartDashboard.putNumber("Right Ultrasonic", Robot.ultrasonicSubSys.getRight());
		if (Robot.ultrasonicSubSys.getLeft() < Robot.ultrasonicSubSys.getRight())
			Robot.driveSubSys.drive(-0.1, 0, TalonControlMode.PercentVbus);
		else if (Robot.ultrasonicSubSys.getRight() < Robot.ultrasonicSubSys.getLeft())
			Robot.driveSubSys.drive(0, -0.1, TalonControlMode.PercentVbus);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Math.abs(Robot.ultrasonicSubSys.getLeft() - Robot.ultrasonicSubSys.getRight()) < 1;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveSubSys.drive(0, 0, TalonControlMode.PercentVbus);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
