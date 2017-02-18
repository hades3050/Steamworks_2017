package org.usfirst.frc.team1923.robot;

import org.usfirst.frc.team1923.robot.commands.driveCommands.ShiftCommand;
import org.usfirst.frc.team1923.robot.commands.driveCommands.ShiftOmniCommand;
import org.usfirst.frc.team1923.robot.commands.gearCommands.GearCommand;
import org.usfirst.frc.team1923.robot.commands.gearCommands.SlideCommand;
import org.usfirst.frc.team1923.robot.utils.PS4Controller;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	public PS4Controller driver, op;

	public OI() {

		// Creates two ps4 controllers
		driver = new PS4Controller(RobotMap.DRIVER_CONTROLLER_PORT);
		driver.lt.setTriggerSensitivity(0.5);
		driver.rt.setTriggerSensitivity(0.5);

		op = new PS4Controller(RobotMap.OP_CONTROLLER_PORT);

		driver.lb.whenActive(new ShiftCommand(true));
		driver.rb.whenActive(new ShiftCommand(false));

		driver.lt.whenActive(new ShiftOmniCommand(true));
		driver.rt.whenActive(new ShiftOmniCommand(false));

		driver.square.whenActive(new SlideCommand());
		driver.triangle.whenActive(new GearCommand());
	}

}
