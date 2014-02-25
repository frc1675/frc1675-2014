/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.OI;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.frc1675.DPadButton;
import org.frc1675.RobotMap;
import org.frc1675.XBoxControllerMap;

/**
 *
 * @author Elise
 */
public class XBoxControllerButtons {
    
    public static Joystick driverController = new Joystick(RobotMap.DRIVER_CONTROLLER);
    public static Button driverB = new JoystickButton(driverController, XBoxControllerMap.B_BUTTON);
    public static Button driverX = new JoystickButton(driverController, XBoxControllerMap.X_BUTTON);
    public static Button driverY = new JoystickButton(driverController, XBoxControllerMap.Y_BUTTON);
    public static Button driverA = new JoystickButton(driverController, XBoxControllerMap.A_BUTTON);
    public static Button driverRightBumper = new JoystickButton(driverController, XBoxControllerMap.RIGHT_BUMPER_BUTTON);
    public static Button driverLeftBumper = new JoystickButton(driverController, XBoxControllerMap.LEFT_BUMPER_BUTTON);
    public static Button driverLeftJoystickButton = new JoystickButton(driverController, XBoxControllerMap.RIGHT_JOYSTICK_BUTTON);
    public static Button driverRightJoystickButton = new JoystickButton(driverController, XBoxControllerMap.LEFT_JOYSTICK_BUTTON);
    public static Button driverDPadRight = new DPadButton(driverController, DPadButton.RIGHT);
    public static Button driverDPadLeft = new DPadButton(driverController, DPadButton.LEFT);

    public static Joystick operatorController = new Joystick(RobotMap.OPERATOR_CONTROLLER);
    public static Button operatorB = new JoystickButton(operatorController, XBoxControllerMap.B_BUTTON);
    public static Button operatorX = new JoystickButton(operatorController, XBoxControllerMap.X_BUTTON);
    public static Button operatorY = new JoystickButton(operatorController, XBoxControllerMap.Y_BUTTON);
    public static Button operatorA = new JoystickButton(operatorController, XBoxControllerMap.A_BUTTON);
    public static Button operatorRightBumper = new JoystickButton(operatorController, XBoxControllerMap.RIGHT_BUMPER_BUTTON);
    public static Button operatorLeftBumper = new JoystickButton(operatorController, XBoxControllerMap.LEFT_BUMPER_BUTTON);
    public static Button operatorLeftJoystickButton = new JoystickButton(operatorController, XBoxControllerMap.RIGHT_JOYSTICK_BUTTON);
    public static Button operatorRightJoystickButton = new JoystickButton(operatorController, XBoxControllerMap.LEFT_JOYSTICK_BUTTON);
    public static Button operatorDPadRight = new DPadButton(operatorController, DPadButton.RIGHT);
    public static Button operatorDPadLeft = new DPadButton(operatorController, DPadButton.LEFT);
    
}
