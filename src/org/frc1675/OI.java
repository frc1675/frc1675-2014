package org.frc1675;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.frc1675.commands.ShiftHigh;
import org.frc1675.commands.ShiftLow;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    private Joystick driverController = new Joystick(RobotMap.DRIVER_CONTROLLER);
    private Joystick operatorController = new Joystick(RobotMap.OPERATOR_CONTROLLER);
    private JoystickButton driverRightBumper = new JoystickButton(driverController, XBoxControllerMap.RIGHT_BUMPER_BUTTON);
    private JoystickButton driverLeftBumper = new JoystickButton(driverController, XBoxControllerMap.LEFT_BUMPER_BUTTON);
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
    public OI() {
        driverRightBumper.whenPressed(new ShiftHigh());
        driverLeftBumper.whenPressed(new ShiftLow());
    }
    
    public double getOperatorLeftY() {
        double analogStick = operatorController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
        
        double deadzoneAnalogStick = adjustForDeadZone(analogStick);
        
        return deadzoneAnalogStick;
    }

    public double getOperatorRightY() {
        double analogStick = operatorController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);
        
        double deadzoneAnalogStick = adjustForDeadZone(analogStick);
        
        return deadzoneAnalogStick;
    }

    public double getDriverLeftY() {
        double analogStick = driverController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
        
        double deadzoneAnalogStick = adjustForDeadZone(analogStick);
        
        return deadzoneAnalogStick;
    }

    public double getDriverRightY() {
        double analogStick = driverController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);
        
        double deadzoneAnalogStick = adjustForDeadZone(analogStick);
        
        return deadzoneAnalogStick;
    }

    public double getOperatorLeftX() {
        double analogStick = operatorController.getRawAxis(XBoxControllerMap.LEFT_X_AXIS);
        
        double deadzoneAnalogStick = adjustForDeadZone(analogStick);
        
        return deadzoneAnalogStick;
    }

    public double getOperatorRightX() {
        double analogStick = operatorController.getRawAxis(XBoxControllerMap.RIGHT_X_AXIS);
        
        double deadzoneAnalogStick = adjustForDeadZone(analogStick);
        
        return deadzoneAnalogStick;
    }

    public double getDriverLeftX() {
        double analogStick = driverController.getRawAxis(XBoxControllerMap.LEFT_X_AXIS);
        
        double deadzoneAnalogStick = adjustForDeadZone(analogStick);
        
        return deadzoneAnalogStick;
    }

    public double getDriverRightX() {
        double analogStick = driverController.getRawAxis(XBoxControllerMap.RIGHT_X_AXIS);
        
        double deadzoneAnalogStick = adjustForDeadZone(analogStick);
        
        return deadzoneAnalogStick;
    }
    
    public double adjustForDeadZone(double axisInput) {
        if (Math.abs(axisInput) <= RobotMap.CONTROLLER_DEAD_ZONE) {
            axisInput = 0;
        } else {
            axisInput = (axisInput / Math.abs(axisInput))
                    * // This determines sign. 
                    (Math.abs(axisInput) - RobotMap.CONTROLLER_DEAD_ZONE)
                    / (1 - RobotMap.CONTROLLER_DEAD_ZONE);
            // This scales for controller dead zone. 
        }

        return axisInput;
    }
    
}
