/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 *
 * @author josh
 */
public class DPadButton extends Button {

    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    private GenericHID joystick;
    private int leftOrRight;

    public DPadButton(GenericHID joystick, int leftOrRight) {
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
