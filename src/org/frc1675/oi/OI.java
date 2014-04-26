package org.frc1675.oi;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.frc1675.oi.buttons.DPadButton;
import org.frc1675.oi.buttons.EscapeJoystickButton;
import org.frc1675.RobotMap;
import org.frc1675.XBoxControllerMap;
import org.frc1675.commands.autonomous.noball.BabbysFirstAuton;
import org.frc1675.commands.JawClosedTeleopShoot;
import org.frc1675.commands.ShiftHigh;
import org.frc1675.commands.ShiftLow;
import org.frc1675.commands.Shoot;
import org.frc1675.commands.SlamDunkShoot;
import org.frc1675.commands.TeleopShoot;
import org.frc1675.commands.arm.jaw.JawClose;
import org.frc1675.commands.arm.jaw.JawOpen;
import org.frc1675.commands.arm.puncher.PuncherGoToLimit;
import org.frc1675.commands.arm.puncher.PuncherEngage;
import org.frc1675.commands.arm.puncher.PuncherDisengage;
import org.frc1675.commands.arm.roller.RollForTime;
import org.frc1675.commands.arm.roller.RollerEject;
import org.frc1675.commands.arm.roller.RollerIntake;
import org.frc1675.commands.arm.roller.RollerStop;
import org.frc1675.commands.arm.shoulder.SetShoulder;
import org.frc1675.commands.arm.shoulder.SetShoulderToCurrentPosition;
import org.frc1675.commands.arm.shoulder.SetShoulderToPickup;
import org.frc1675.commands.arm.shoulder.ShoulderBumpTowardsHome;
import org.frc1675.commands.arm.shoulder.ShoulderBumpTowardsBack;
import org.frc1675.commands.arm.shoulder.ShoulderOnTargetTest;
import org.frc1675.commands.arm.shoulder.StopShoulder;
import org.frc1675.commands.autonomous.noball.ZeroBallAuton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    EscapeJoystickButton operatorLeftTriggerAndX;
    EscapeJoystickButton operatorRightTriggerAndX;

    EscapeJoystickButton operatorLeftTriggerAndY;
    EscapeJoystickButton operatorRightTriggerAndY;

    EscapeJoystickButton operatorLeftTriggerAndB;
    EscapeJoystickButton operatorRightTriggerAndB;

    EscapeJoystickButton operatorLeftTriggerAndA;
    EscapeJoystickButton operatorRightTriggerAndA;

    EscapeJoystickButton operatorLeftTriggerAndRightBumper;
    EscapeJoystickButton operatorRightTriggerAndRightBumper;

    EscapeJoystickButton operatorLeftTriggerAndLeftBumper;
    EscapeJoystickButton operatorRightTriggerAndLeftBumper;

    EscapeJoystickButton operatorLeftTriggerAndRightDPad;
    EscapeJoystickButton operatorRightTriggerAndRightDPad;
    
    EscapeJoystickButton operatorLeftTriggerAndLeftDPad;
    EscapeJoystickButton operatorRightTriggerAndLeftDPad;

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

        operatorLeftTriggerAndX = new EscapeJoystickButton(XBoxControllerButtons.operatorLeftTrigger, XBoxControllerButtons.operatorX);
        operatorRightTriggerAndX = new EscapeJoystickButton(XBoxControllerButtons.operatorRightTrigger, XBoxControllerButtons.operatorX);

        operatorLeftTriggerAndY = new EscapeJoystickButton(XBoxControllerButtons.operatorLeftTrigger, XBoxControllerButtons.operatorY);
        operatorRightTriggerAndY = new EscapeJoystickButton(XBoxControllerButtons.operatorRightTrigger, XBoxControllerButtons.operatorY);

        operatorLeftTriggerAndB = new EscapeJoystickButton(XBoxControllerButtons.operatorLeftTrigger, XBoxControllerButtons.operatorB);
        operatorRightTriggerAndB = new EscapeJoystickButton(XBoxControllerButtons.operatorRightTrigger, XBoxControllerButtons.operatorB);

        operatorLeftTriggerAndA = new EscapeJoystickButton(XBoxControllerButtons.operatorLeftTrigger, XBoxControllerButtons.operatorA);
        operatorRightTriggerAndA = new EscapeJoystickButton(XBoxControllerButtons.operatorRightTrigger, XBoxControllerButtons.operatorA);

        operatorLeftTriggerAndLeftBumper = new EscapeJoystickButton(XBoxControllerButtons.operatorLeftTrigger, XBoxControllerButtons.operatorLeftBumper);
        operatorRightTriggerAndLeftBumper = new EscapeJoystickButton(XBoxControllerButtons.operatorRightTrigger, XBoxControllerButtons.operatorLeftBumper);

        operatorLeftTriggerAndRightBumper = new EscapeJoystickButton(XBoxControllerButtons.operatorLeftTrigger, XBoxControllerButtons.operatorRightBumper);
        operatorRightTriggerAndRightBumper = new EscapeJoystickButton(XBoxControllerButtons.operatorRightTrigger, XBoxControllerButtons.operatorRightBumper);

        operatorLeftTriggerAndLeftDPad = new EscapeJoystickButton(XBoxControllerButtons.operatorLeftTrigger, XBoxControllerButtons.operatorDPadLeft);
        operatorRightTriggerAndLeftDPad = new EscapeJoystickButton(XBoxControllerButtons.operatorRightTrigger, XBoxControllerButtons.operatorDPadLeft);

        operatorLeftTriggerAndRightDPad = new EscapeJoystickButton(XBoxControllerButtons.operatorLeftTrigger, XBoxControllerButtons.operatorDPadRight);
        operatorRightTriggerAndRightDPad = new EscapeJoystickButton(XBoxControllerButtons.operatorRightTrigger, XBoxControllerButtons.operatorDPadRight);

        
        XBoxControllerButtons.driverRightBumper.whenPressed(new ShiftHigh());
        XBoxControllerButtons.driverRightBumper.whenReleased(new ShiftLow());
        XBoxControllerButtons.driverY.whenPressed(new PuncherDisengage());
        XBoxControllerButtons.driverB.whenPressed(new PuncherEngage());
        XBoxControllerButtons.driverX.whenPressed(new ZeroBallAuton());

        XBoxControllerButtons.operatorDPadLeft.whileHeld(new RollerIntake());
        XBoxControllerButtons.operatorDPadRight.whileHeld(new RollerEject());
        XBoxControllerButtons.operatorStart.whenPressed(new SetShoulder(RobotMap.BACKWARD_SHOOT_ANGLE));
        XBoxControllerButtons.operatorBack.whenPressed(new StopShoulder());

        operatorLeftTriggerAndX.setDefaultButtonBindings(new JawOpen(), null, null);
        operatorLeftTriggerAndX.setEscapeButtonBindings(new PuncherDisengage(), null, null);
        operatorRightTriggerAndX.setDefaultButtonBindings(new JawOpen(), null, null);
        operatorRightTriggerAndX.setEscapeButtonBindings(null, null, null);

        operatorLeftTriggerAndY.setDefaultButtonBindings(new TeleopShoot(), null, null);
        operatorLeftTriggerAndY.setEscapeButtonBindings(new SlamDunkShoot(), null, null);
        operatorRightTriggerAndY.setDefaultButtonBindings(new TeleopShoot(), null, null);
        operatorRightTriggerAndY.setEscapeButtonBindings(new JawClosedTeleopShoot(), null, null);

        operatorLeftTriggerAndB.setDefaultButtonBindings(new SetShoulderToCurrentPosition(), null, null);
        operatorLeftTriggerAndB.setEscapeButtonBindings(new StopShoulder(), null, null);
        operatorRightTriggerAndB.setDefaultButtonBindings(new SetShoulderToCurrentPosition(), null, null);
        operatorRightTriggerAndB.setEscapeButtonBindings(new SetShoulderToCurrentPosition(), null, null);

        operatorLeftTriggerAndA.setDefaultButtonBindings(new JawClose(), null, null);
        operatorLeftTriggerAndA.setEscapeButtonBindings(new PuncherEngage(), null, null);
        operatorRightTriggerAndA.setDefaultButtonBindings(new JawClose(), null, null);
        operatorRightTriggerAndA.setEscapeButtonBindings(new JawClose(), null, null);

        operatorLeftTriggerAndLeftBumper.setDefaultButtonBindings(new SetShoulderToPickup(), null, null);
        operatorLeftTriggerAndLeftBumper.setEscapeButtonBindings(new SetShoulder(RobotMap.BACKWARD_TRUSS_ANGLE), null, null);
        operatorRightTriggerAndLeftBumper.setDefaultButtonBindings(new SetShoulderToPickup(), null, null);
        operatorRightTriggerAndLeftBumper.setEscapeButtonBindings(new SetShoulder(RobotMap.BACKWARD_SHOOT_ANGLE), null, null);

        operatorLeftTriggerAndRightBumper.setDefaultButtonBindings(new SetShoulder(RobotMap.STATIC_FORWARD_SHOT_ANGLE), null, null);
        operatorLeftTriggerAndRightBumper.setEscapeButtonBindings(new SetShoulder(RobotMap.STARTING_ANGLE), null, null);
        operatorRightTriggerAndRightBumper.setDefaultButtonBindings(new SetShoulder(RobotMap.STATIC_FORWARD_SHOT_ANGLE), null, null);
        operatorRightTriggerAndRightBumper.setEscapeButtonBindings(new SetShoulder(RobotMap.TRUSS_ANGLE), null, null);

        operatorLeftTriggerAndRightDPad.setDefaultButtonBindings(null, new RollerEject(), null);
        operatorLeftTriggerAndRightDPad.setEscapeButtonBindings(new ShoulderBumpTowardsBack(), null, null);
        operatorRightTriggerAndRightDPad.setDefaultButtonBindings(null, new RollerEject(), null);
        operatorRightTriggerAndRightDPad.setEscapeButtonBindings(null, null, null);
        
        operatorLeftTriggerAndLeftDPad.setDefaultButtonBindings(null, new RollerIntake(), null);
        operatorLeftTriggerAndLeftDPad.setEscapeButtonBindings(new ShoulderBumpTowardsHome(), null, null);
        operatorRightTriggerAndLeftDPad.setDefaultButtonBindings(null, new RollerIntake(), null);
        operatorRightTriggerAndLeftDPad.setEscapeButtonBindings(null, null, null);

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
