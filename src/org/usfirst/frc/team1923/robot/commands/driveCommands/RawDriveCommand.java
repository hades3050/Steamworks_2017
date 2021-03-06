<<<<<<< HEAD:src/org/usfirst/frc/team1923/robot/commands/RawDriveCommand.java
package org.usfirst.frc.team1923.robot.commands;

import org.usfirst.frc.team1923.robot.Robot;
import org.usfirst.frc.team1923.robot.utils.DriveProfile.ProfileCurve;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This command directly feeds the raw values on the joysticks to the motor
 * without PID
 */
public class RawDriveCommand extends Command {

	public RawDriveCommand() {
		requires(Robot.driveSubSystem);
	}

	public RawDriveCommand(ProfileCurve p) {
		requires(Robot.driveSubSystem);
		Robot.driveSubSystem.dprofile.setProfile(p);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.driveSubSystem.disable();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.driveSubSystem.set(Robot.driveSubSystem.dprofile.scale(Robot.oi.driver.getLeftY()),
				Robot.driveSubSystem.dprofile.scale(Robot.oi.driver.getRightY()));
		SmartDashboard.putNumber("Left Encoder Pos: ", Robot.driveSubSystem.leftTalons[0].getEncPosition());
    	SmartDashboard.putNumber("Right Encoder Pos: ", Robot.driveSubSystem.rightTalons[0].getEncPosition());
    	SmartDashboard.putNumber("Left Encoder Speed: ", Robot.driveSubSystem.leftTalons[0].getEncVelocity());
    	SmartDashboard.putNumber("Right Encoder Speed: ", Robot.driveSubSystem.rightTalons[0].getEncVelocity());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveSubSystem.set(0, 0); // Stops the robot
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
=======
package org.usfirst.frc.team1923.robot.commands.driveCommands;

import org.usfirst.frc.team1923.robot.Robot;
import org.usfirst.frc.team1923.robot.utils.DriveProfile.ProfileCurve;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command directly feeds the raw values on the joysticks to the motor
 * without PID
 */
public class RawDriveCommand extends Command {

	public RawDriveCommand() {
		requires(Robot.driveSubSys);
	}

	public RawDriveCommand(ProfileCurve p) {
		requires(Robot.driveSubSys);
		Robot.driveSubSys.dprofile.setProfile(p);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.driveSubSys.drive(Robot.driveSubSys.dprofile.scale(Robot.oi.driver.getLeftY()),
				Robot.driveSubSys.dprofile.scale(Robot.oi.driver.getRightY()), TalonControlMode.PercentVbus);
		// SmartDashboard.putNumber("L Enc pos",
		// Robot.driveSubSys.getLeftPosition());
		// SmartDashboard.putNumber("R Enc pos",
		// Robot.driveSubSys.getRightPosition());
		// SmartDashboard.putNumber("Distance (in): ",
		// Robot.driveSubSys.frontSonar.getRangeInches());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveSubSys.stop(); // Stops the robot
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
>>>>>>> refs/remotes/Team1923/master:src/org/usfirst/frc/team1923/robot/commands/driveCommands/RawDriveCommand.java
