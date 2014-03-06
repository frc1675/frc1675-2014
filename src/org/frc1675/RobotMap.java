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
    public static final int COMPRESSOR_SPIKE = 1;

    //motors
    public static final int WINCH_MOTOR = 5;
    public static final int WINCH_MOTOR_TWO = 6;
    public static final int SHOULDER_MOTOR = 1;
    public static final int ROLLER_CLAW_MOTOR = 2;

    //pneumatics
    public static final int SHOOTER_EXTEND = 6;  //put pin in
    public static final int SHOOTER_RETRACT = 5;  //shoot
    public static final int JAW_EXTEND = 7;
    public static final int JAW_RETRACT = 8;
    public static final int SHIFTER_HIGH = 4;
    public static final int SHIFTER_LOW = 3;
    public static final double PNEUMATIC_FIRE_TIME = .1;

    //digital sensors
    public static final int PRESSURE_SWITCH = 1;
    public static final int WINCH_ENCODER_CHANNEL_A = 2;
    public static final int WINCH_ENCODER_CHANNEL_B = 8;
    public static final int DRIVE_LEFT_ENCODER_CHANNEL_A = 4;
    public static final int DRIVE_LEFT_ENCODER_CHANNEL_B = 5;
    public static final int DRIVE_RIGHT_ENCODER_CHANNEL_A = 6;
    public static final int DRIVE_RIGHT_ENCODER_CHANNEL_B = 7;
    public static final int WINCH_LIMIT = 3;
    public static final double DRIVE_ENCODER_TICKS = 360;

    //analog sensors
    public static final int SHOULDER_POT = 2;

    //controller stuff
    public static final double CONTROLLER_DEAD_ZONE = .15;
    public static final int DRIVER_CONTROLLER = 1;
    public static final int OPERATOR_CONTROLLER = 2;

    //drive stuff
    public static class DriveConstants {

        public static final double MOTOR_DEAD_ZONE = 0.268;
        public static final int LEFT_FRONT_MOTOR = 3;
        public static final int LEFT_BACK_MOTOR = 4;
        public static final int RIGHT_FRONT_MOTOR = 7;
        public static final int RIGHT_BACK_MOTOR = 8;
        public static final double RAMP_TIME = 0.25;
    }
    
    //drive command ID
    public static final int TANK_DRIVE = 1;
    public static final int ARCADE_DRIVE = 2;
    public static final int CHEESY_DRIVE = 3;
    
    
    //PID
    public static final double SHOULDER_P = .02;
    public static final double SHOULDER_I = 0;
    public static final double SHOULDER_D = 0;
    public static final double SHOULDER_PID_TARGET_TIME = .5;

    public static final double DRIVE_ENCODER_P = 1;
    public static final double DRIVE_ENCODER_I = 0;
    public static final double DRIVE_ENCODER_D = 0;
    public static final double DRIVE_ENCODER_PID_TARGET_TIME = .25;

//setpoints
    public static final int FLOOR_ANGLE = 252;  //degrees
    public static final int RUNNING_FORWARD_SHOOT_ANGLE = 183;
    public static final int STATIC_FORWARD_SHOT_ANGLE = 165;
    public static final int BACKWARD_SHOOT_ANGLE = 120;
    public static final int STARTING_ANGLE = 144;

    public static final int WINCH_ENERGY = 750;  //encoder ticks

//auton stuff
    public static final double DISTANCE_TO_SHOT = 48; //inches
    public static final double DISTANCE_EXTRA_TO_DRIVE_BACK = 15; //inches
    public static final double EXTRA_DISTANCE_BACK_TO_BALL = 5; //inches
    public static final double TIME_TO_PICK_UP_BALL = .7; //seconds

    public static final double TIME_TO_REACH_SHOOT = 2;
    public static final double EXTRA_TIME_TO_DRIVE_FORWARD = .25;
    public static final double EXTRA_TIME_TO_DRIVE_BACK = -.5;
}
