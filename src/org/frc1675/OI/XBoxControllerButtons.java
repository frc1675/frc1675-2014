/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.OI;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.frc1675.DPadButton;
import org.frc1675.OI.buttons.RebindableJoystickButton;
import org.frc1675.OI.buttons.TriggerButton;
import org.frc1675.RobotMap;
import org.frc1675.XBoxControllerMap;

/**
 *
 * @author Elise
 */
public class XBoxControllerButtons {

    public static final Joystick driverController = new Joystick(RobotMap.DRIVER_CONTROLLER);
    public static final RebindableJoystickButton driverA = new RebindableJoystickButton(driverController, XBoxControllerMap.A_BUTTON);
    public static final RebindableJoystickButton driverB = new RebindableJoystickButton(driverController, XBoxControllerMap.B_BUTTON);
    public static final RebindableJoystickButton driverX = new RebindableJoystickButton(driverController, XBoxControllerMap.X_BUTTON);
    public static final RebindableJoystickButton driverY = new RebindableJoystickButton(driverController, XBoxControllerMap.Y_BUTTON);
    public static final RebindableJoystickButton driverRightBumper = new RebindableJoystickButton(driverController, XBoxControllerMap.RIGHT_BUMPER_BUTTON);
    public static final RebindableJoystickButton driverLeftBumper = new RebindableJoystickButton(driverController, XBoxControllerMap.LEFT_BUMPER_BUTTON);
    public static final RebindableJoystickButton driverLeftJoystickButton = new RebindableJoystickButton(driverController, XBoxControllerMap.RIGHT_JOYSTICK_BUTTON);
    public static final RebindableJoystickButton driverRightJoystickButton = new RebindableJoystickButton(driverController, XBoxControllerMap.LEFT_JOYSTICK_BUTTON);
    public static final DPadButton driverDPadRight = new DPadButton(driverController, DPadButton.RIGHT);
    public static final DPadButton driverDPadLeft = new DPadButton(driverController, DPadButton.LEFT);
    public static final TriggerButton driverLeftTrigger = new TriggerButton(driverController, TriggerButton.LEFT);
    public static final TriggerButton driverRightTrigger = new TriggerButton(driverController, TriggerButton.RIGHT);

    
    public static final Joystick operatorController = new Joystick(RobotMap.OPERATOR_CONTROLLER);
    public static final RebindableJoystickButton operatorA = new RebindableJoystickButton(operatorController, XBoxControllerMap.A_BUTTON);
    public static final RebindableJoystickButton operatorB = new RebindableJoystickButton(operatorController, XBoxControllerMap.B_BUTTON);
    public static final RebindableJoystickButton operatorX = new RebindableJoystickButton(operatorController, XBoxControllerMap.X_BUTTON);
    public static final RebindableJoystickButton operatorY = new RebindableJoystickButton(operatorController, XBoxControllerMap.Y_BUTTON);
    public static final RebindableJoystickButton operatorRightBumper = new RebindableJoystickButton(operatorController, XBoxControllerMap.RIGHT_BUMPER_BUTTON);
    public static final RebindableJoystickButton operatorLeftBumper = new RebindableJoystickButton(operatorController, XBoxControllerMap.LEFT_BUMPER_BUTTON);
    public static final RebindableJoystickButton operatorLeftJoystickButton = new RebindableJoystickButton(operatorController, XBoxControllerMap.RIGHT_JOYSTICK_BUTTON);
    public static final RebindableJoystickButton operatorRightJoystickButton = new RebindableJoystickButton(operatorController, XBoxControllerMap.LEFT_JOYSTICK_BUTTON);
    public static final RebindableJoystickButton operatorBack = new RebindableJoystickButton(operatorController, XBoxControllerMap.BACK_BUTTON);
    public static final RebindableJoystickButton operatorStart = new RebindableJoystickButton(operatorController, XBoxControllerMap.START_BUTTON);
    public static final DPadButton operatorDPadRight = new DPadButton(operatorController, DPadButton.RIGHT);
    public static final DPadButton operatorDPadLeft = new DPadButton(operatorController, DPadButton.LEFT);
    public static final TriggerButton operatorLeftTrigger = new TriggerButton(operatorController, TriggerButton.LEFT);
    public static final TriggerButton operatorRightTrigger = new TriggerButton(operatorController, TriggerButton.RIGHT);
    
    public static void init() {
    }
}
