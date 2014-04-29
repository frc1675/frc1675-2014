/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.oi.buttons;

import edu.wpi.first.wpilibj.GenericHID;
import org.frc1675.RobotMap;
import org.frc1675.XBoxControllerMap;

/**
 * This turns the DPad axis into a left button or a right button.
 *
 * @author pordonj
 */
public class DPadButton extends RebindableJoystickButton {

    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    private GenericHID joystick;
    private int leftOrRight;

    public DPadButton(GenericHID joystick, int leftOrRight) {
        super(joystick, -1); //Since an implementation of the get method is in this class, the -1 doesn't cause harm.
        this.joystick = joystick;
        this.leftOrRight = leftOrRight;
    }

    public boolean get() {
        boolean returnVal;
        switch (leftOrRight) {
            case LEFT:
                returnVal = joystick.getRawAxis(XBoxControllerMap.DPAD_AXIS) < -RobotMap.CONTROLLER_DEAD_ZONE;
                break;
            case RIGHT:
                returnVal = joystick.getRawAxis(XBoxControllerMap.DPAD_AXIS) > RobotMap.CONTROLLER_DEAD_ZONE;
                break;
            default:
                returnVal = false;
                break;
        }
        return returnVal;
    }

}
