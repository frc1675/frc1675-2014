package org.frc1675;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    private Joystick driverController = new Joystick(RobotMap.DRIVER_CONTROLLER);
    private Joystick operatorController = new Joystick(RobotMap.OPERATOR_CONTROLLER);
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
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
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    public double getOperatorLeftY() {
        return operatorController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
    }

    public double getOperatorRightY() {
        return operatorController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);
    }

    public double getDriverLeftY() {
        return driverController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
    }

    public double getDriverRightY() {
        return driverController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);
    }

    public double getOperatorLeftX() {
        return operatorController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
    }

    public double getOperatorRightX() {
        return operatorController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);
    }

    public double getDriverLeftX() {
        return driverController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
    }

    public double getDriverRightX() {
        return driverController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);
    }
}
