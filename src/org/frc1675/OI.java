package org.frc1675;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.frc1675.commands.BabbysFirstAuton;
import org.frc1675.commands.ShiftHigh;
import org.frc1675.commands.ShiftLow;
import org.frc1675.commands.Shoot;
import org.frc1675.commands.TeleopShoot;
import org.frc1675.commands.arm.jaw.JawClose;
import org.frc1675.commands.arm.jaw.JawOpen;
import org.frc1675.commands.arm.puncher.GoToLimit;
import org.frc1675.commands.arm.puncher.PuncherPutPinIn;
import org.frc1675.commands.arm.puncher.PuncherShoot;
import org.frc1675.commands.arm.roller.RollerEject;
import org.frc1675.commands.arm.roller.RollerIntake;
import org.frc1675.commands.arm.roller.RollerStop;
import org.frc1675.commands.arm.shoulder.SetShoulder;
import org.frc1675.commands.arm.shoulder.SetShoulderToPickup;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    public Joystick driverController = new Joystick(RobotMap.DRIVER_CONTROLLER);
    private Button driverB = new JoystickButton(driverController, XBoxControllerMap.B_BUTTON);
    private Button driverX = new JoystickButton(driverController, XBoxControllerMap.X_BUTTON);
    private Button driverY = new JoystickButton(driverController, XBoxControllerMap.Y_BUTTON);
    private Button driverA = new JoystickButton(driverController, XBoxControllerMap.A_BUTTON);
    private Button driverRightBumper = new JoystickButton(driverController, XBoxControllerMap.RIGHT_BUMPER_BUTTON);
    private Button driverLeftBumper = new JoystickButton(driverController, XBoxControllerMap.LEFT_BUMPER_BUTTON);
    private Button driverLeftJoystickButton = new JoystickButton(driverController, XBoxControllerMap.RIGHT_JOYSTICK_BUTTON);
    private Button driverRightJoystickButton = new JoystickButton(driverController, XBoxControllerMap.LEFT_JOYSTICK_BUTTON);
    private Button driverDPadRight = new DPadButton(driverController, DPadButton.RIGHT);
    private Button driverDPadLeft = new DPadButton(driverController, DPadButton.LEFT);

    public Joystick operatorController = new Joystick(RobotMap.OPERATOR_CONTROLLER);
    private Button operatorB = new JoystickButton(operatorController, XBoxControllerMap.B_BUTTON);
    private Button operatorX = new JoystickButton(operatorController, XBoxControllerMap.X_BUTTON);
    private Button operatorY = new JoystickButton(operatorController, XBoxControllerMap.Y_BUTTON);
    private Button operatorA = new JoystickButton(operatorController, XBoxControllerMap.A_BUTTON);
    private Button operatorRightBumper = new JoystickButton(operatorController, XBoxControllerMap.RIGHT_BUMPER_BUTTON);
    private Button operatorLeftBumper = new JoystickButton(operatorController, XBoxControllerMap.LEFT_BUMPER_BUTTON);
    private Button operatorLeftJoystickButton = new JoystickButton(operatorController, XBoxControllerMap.RIGHT_JOYSTICK_BUTTON);
    private Button operatorRightJoystickButton = new JoystickButton(operatorController, XBoxControllerMap.LEFT_JOYSTICK_BUTTON);
    private Button operatorDPadRight = new DPadButton(operatorController, DPadButton.RIGHT);
    private Button operatorDPadLeft = new DPadButton(operatorController, DPadButton.LEFT);
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
        driverA.whenPressed(new TeleopShoot());

        operatorDPadLeft.whileHeld(new RollerIntake());
        operatorDPadRight.whileHeld(new RollerEject());
        operatorX.whenPressed(new JawOpen());
        operatorY.whenPressed(new PuncherShoot());
        operatorB.whenPressed(new PuncherPutPinIn());
        operatorA.whenPressed(new JawClose());
        //operatorRightBumper.whenPressed(new GoToLimit());
        //operatorLeftBumper.whenPressed(new SetShoulderToPickup());
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

    public boolean getDriverTrigger() {
        double trigger = driverController.getRawAxis(XBoxControllerMap.TRIGGER_AXIS);
        boolean triggerBoolean = false;
        if (trigger < -0.25) {
            triggerBoolean = true;
        }
        return triggerBoolean;
    }

    public double getOperaterTrigger() {
        double trigger = operatorController.getRawAxis(XBoxControllerMap.TRIGGER_AXIS);

        return trigger;
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
