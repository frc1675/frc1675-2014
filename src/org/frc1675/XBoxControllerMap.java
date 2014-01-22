/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675;

/**
 * A map of values used by the WPILib Joystick class to interface with an XBox
 * Controller
 *
 * @author josh
 */
public class XBoxControllerMap {

    /* CURRENTLY NOT MAPPED:
     * D-Pad vertical axis
     * Start, Back, and XBox buttons
     */
    //AXES
    //Left analog stick
    public static final int LEFT_X_AXIS = 1;
    public static final int LEFT_Y_AXIS = 2;

    //Right analog stick
    public static final int RIGHT_X_AXIS = 4;
    public static final int RIGHT_Y_AXIS = 5;

    //Trigger axis.
    //Starts at 0. Left trigger increases value, right trigger decreases value.
    //NOTE that this means you cannot "detect" both triggers being pulled at 
    //  any degree.
    public static final int TRIGGER_AXIS = 3;

    //Directional Pad horizontal axis.
    //Starts at 0, goes down when left is preseed, up when right is pressed.
    public static final int DPAD_AXIS = 6;

    //BUTTONS
    //Face buttons
    public static final int A_BUTTON = 1;
    public static final int B_BUTTON = 2;
    public static final int X_BUTTON = 3;
    public static final int Y_BUTTON = 4;

    //Bumpers (shoulders)
    public static final int LEFT_BUMPER_BUTTON = 5;
    public static final int RIGHT_BUMPER_BUTTON = 6;

    //Joystick buttons (clicking in stick)
    public static final int LEFT_JOYSTICK_BUTTON = 9;
    public static final int RIGHT_JOYSTICK_BUTTON = 10;

}
