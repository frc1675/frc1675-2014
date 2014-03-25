/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.oi.buttons;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;
import org.frc1675.RobotMap;
import org.frc1675.XBoxControllerMap;

/**
 * This class turns a trigger into a normal button.
 *
 * @author Tony
 */
public class TriggerButton extends Button {

    public static final boolean RIGHT = true;
    public static final boolean LEFT = false;
    private GenericHID joystick;
    private boolean isRight;

    public TriggerButton(GenericHID joystick, boolean isRight) {
        this.joystick = joystick;
        this.isRight = isRight;
    }

    public boolean get() {
        if (isRight) {
            return (joystick.getRawAxis(XBoxControllerMap.TRIGGER_AXIS) < -RobotMap.CONTROLLER_DEAD_ZONE);
        } else {
            return (joystick.getRawAxis(XBoxControllerMap.TRIGGER_AXIS) > RobotMap.CONTROLLER_DEAD_ZONE);
        }
    }
}
