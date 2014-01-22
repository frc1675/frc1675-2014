package org.frc1675;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    //relays
    public static final int ROLLER_CLAW_SPIKE = 1;
    public static final int COMPRESSOR_SPIKE = 2;

    //motors
    public static final int WINCH_MOTOR = 1;
    public static final int SHOULDER_MOTOR = 2;

    //pneumatics
    public static final int SHOOTER_EXTEND = 1;  //put pin in
    public static final int SHOOTER_RETRACT = 2;  //shoot
    public static final int JAW_EXTEND = 3;
    public static final int JAW_RETRACT = 4;

    //digital sensors
    public static final int WINCH_ENCODER_CHANNEL_A = 1;
    public static final int WINCH_ENCODER_CHANNEL_B = 2;
    public static final int PRESSURE_SWITCH = 3;

    //analog sensors
    public static final int SHOULDER_POT = 3;

    //controller stuff
    public static final int DRIVER_CONTROLLER = 1;
    public static final int OPERATOR_CONTROLLER = 2;
    public static final double CONTROLLER_DEAD_ZONE = .2;

    //PID
    public static final double PUNCHER_P = 1;
    public static final double PUNCHER_I = 0;
    public static final double PUNCHER_D = 0;

    public static final double SHOULDER_P = 1;
    public static final double SHOULDER_I = 0;
    public static final double SHOULDER_D = 0;

}
