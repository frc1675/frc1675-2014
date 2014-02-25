package org.frc1675.OI;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.frc1675.DPadButton;
import org.frc1675.RobotMap;
import org.frc1675.XBoxControllerMap;
import org.frc1675.commands.BabbysFirstAuton;
import org.frc1675.commands.ShiftHigh;
import org.frc1675.commands.ShiftLow;
import org.frc1675.commands.Shoot;
import org.frc1675.commands.TeleopShoot;
import org.frc1675.commands.arm.jaw.JawClose;
import org.frc1675.commands.arm.jaw.JawOpen;
import org.frc1675.commands.arm.puncher.PuncherGoToLimit;
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
        XBoxControllerButtons.driverRightBumper.whenPressed(new ShiftHigh());
        XBoxControllerButtons.driverLeftBumper.whenPressed(new ShiftLow());
        XBoxControllerButtons.driverY.whenPressed(new PuncherShoot());
        XBoxControllerButtons.driverB.whenPressed(new PuncherPutPinIn());


        XBoxControllerButtons.operatorDPadLeft.whileHeld(new RollerIntake());
        XBoxControllerButtons.operatorDPadRight.whileHeld(new RollerEject());
        XBoxControllerButtons.operatorX.whenPressed(new JawOpen());
        XBoxControllerButtons.operatorY.whenPressed(new TeleopShoot());
        XBoxControllerButtons.operatorA.whenPressed(new JawClose());
        XBoxControllerButtons.operatorRightBumper.whenPressed(new SetShoulder(RobotMap.STATIC_FORWARD_SHOT_ANGLE));
        XBoxControllerButtons.operatorLeftBumper.whenPressed(new SetShoulderToPickup());
    }

    public double getOperatorLeftY() {
        double analogStick = XBoxControllerButtons.operatorController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);

        double deadzoneAnalogStick = adjustForAxisDeadzone(analogStick);

        return deadzoneAnalogStick;
    }

    public double getOperatorRightY() {
        double analogStick = XBoxControllerButtons.operatorController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);

        double deadzoneAnalogStick = adjustForAxisDeadzone(analogStick);

        return deadzoneAnalogStick;
    }

    public double getDriverLeftY() {
        double analogStick = XBoxControllerButtons.driverController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);

        double deadzoneAnalogStick = adjustForAxisDeadzone(analogStick);

        return deadzoneAnalogStick;
    }

    public double getDriverRightY() {
        double analogStick = XBoxControllerButtons.driverController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);

        double deadzoneAnalogStick = adjustForAxisDeadzone(analogStick);

        return deadzoneAnalogStick;
    }

    public double getOperatorLeftX() {
        double analogStick = XBoxControllerButtons.operatorController.getRawAxis(XBoxControllerMap.LEFT_X_AXIS);

        double deadzoneAnalogStick = adjustForAxisDeadzone(analogStick);

        return deadzoneAnalogStick;
    }

    public double getOperatorRightX() {
        double analogStick = XBoxControllerButtons.operatorController.getRawAxis(XBoxControllerMap.RIGHT_X_AXIS);

        double deadzoneAnalogStick = adjustForAxisDeadzone(analogStick);

        return deadzoneAnalogStick;
    }

    public double getDriverLeftX() {
        double analogStick = XBoxControllerButtons.driverController.getRawAxis(XBoxControllerMap.LEFT_X_AXIS);

        double deadzoneAnalogStick = adjustForAxisDeadzone(analogStick);

        return deadzoneAnalogStick;
    }

    public double getDriverRightX() {
        double analogStick = XBoxControllerButtons.driverController.getRawAxis(XBoxControllerMap.RIGHT_X_AXIS);

        double deadzoneAnalogStick = adjustForAxisDeadzone(analogStick);

        return deadzoneAnalogStick;
    }

    public double getScaledLeftAnalogVector() {

        double leftAxisX = XBoxControllerButtons.driverController.getRawAxis(XBoxControllerMap.LEFT_X_AXIS);
        double leftAxisY = XBoxControllerButtons.driverController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);

        double scaledLeftAnalogVector = adjustForVectorDeadZone(leftAxisX, leftAxisY);

        return scaledLeftAnalogVector;

    }

    public double getScaledRightAnalogVector() {

        double rightAxisX = XBoxControllerButtons.driverController.getRawAxis(XBoxControllerMap.RIGHT_X_AXIS);
        double rightAxisY = XBoxControllerButtons.driverController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);

        double scaledRightAnalogVector = adjustForVectorDeadZone(rightAxisX, rightAxisY);

        return scaledRightAnalogVector;

    }

    public boolean getDriverTrigger() {
        double trigger = XBoxControllerButtons.driverController.getRawAxis(XBoxControllerMap.TRIGGER_AXIS);
        boolean triggerBoolean = false;
        if (trigger < -0.25) {
            triggerBoolean = true;
        }
        return triggerBoolean;
    }

    public double getOperaterTrigger() {
        double trigger = XBoxControllerButtons.operatorController.getRawAxis(XBoxControllerMap.TRIGGER_AXIS);

        return trigger;
    }

    /**
     * Sorry, this axis will treat both axes as the y axis when it passes them
     * into adjustForVectorDeadzone.
     */
    private double adjustForAxisDeadzone(double axisInput) {
        double axisOutput;

        if (Math.abs(axisInput) <= RobotMap.CONTROLLER_DEAD_ZONE) {
            axisOutput = 0;
        } else {
            axisOutput = calculateScaledVector(axisInput, axisInput);
        }

        return axisOutput;
    }

    private double adjustForVectorDeadZone(double xAxis, double yAxis) {
        double magnitude = Math.sqrt(xAxis * xAxis + yAxis * yAxis);
        double scaledVector;

        if (Math.abs(magnitude) <= RobotMap.CONTROLLER_DEAD_ZONE) {
            scaledVector = 0;
        } else {
            scaledVector = calculateScaledVector(yAxis, magnitude);
        }
        return scaledVector;
    }

    private double calculateScaledVector(double signDeterminingAxis, double magnitude) {
        double scaledVector;
        double sign = (signDeterminingAxis / Math.abs(signDeterminingAxis));
        scaledVector = sign * (Math.abs(magnitude) - RobotMap.CONTROLLER_DEAD_ZONE)
                / (1 - RobotMap.CONTROLLER_DEAD_ZONE);
        // This scales for controller dead zone.
        return scaledVector;
    }
}
