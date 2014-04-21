package org.frc1675;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    //relays
    public static final int COMPRESSOR_SPIKE = 1;

    //motors
    public static final int WINCH_MOTOR = 5;
    public static final int WINCH_MOTOR_TWO = 6;
    public static final int SHOULDER_MOTOR = 1;
    public static final int ROLLER_CLAW_MOTOR = 2;

    //pneumatics
    public static final int SHOOTER_EXTEND = 5;  //put pin in
    public static final int SHOOTER_RETRACT = 6;  //shoot
    public static final int JAW_EXTEND = 7;
    public static final int JAW_RETRACT = 8;
    public static final int SHIFTER_HIGH = 3;
    public static final int SHIFTER_LOW = 4;
    public static final int LIGHTS = 1;
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

    //PID
    public static final double SHOULDER_P = .035;
    public static final double SHOULDER_I = .0001;
    public static final double SHOULDER_D = .038;
    public static final double SHOULDER_PID_TARGET_TIME = .3;


    public static final double DRIVE_ENCODER_P = 1;
    public static final double DRIVE_ENCODER_I = 0;
    public static final double DRIVE_ENCODER_D = 0;
    public static final double DRIVE_ENCODER_PID_TARGET_TIME = .25;

//setpoints
    public static final int FLOOR_ANGLE = 252;  //degrees
    public static final int RUNNING_FORWARD_SHOOT_ANGLE = 179;
    public static final int STATIC_FORWARD_SHOT_ANGLE = 181; //High Tension
    //public static final int STATIC_FORWARD_SHOT_ANGLE = 184; Practice Bot High Tension
    public static final int BACKWARD_SHOOT_ANGLE = 69;
    public static final int BACKWARD_TWO_BALL_ANGLE = 68;
    public static final int STARTING_ANGLE = 137;
    public static double STRAIGHT_UP_ANGLE = 125;
    public static final int TRUSS_ANGLE = ((STARTING_ANGLE+STATIC_FORWARD_SHOT_ANGLE)/2) -2;
    public static final int BACKWARD_TRUSS_ANGLE = ((BACKWARD_SHOOT_ANGLE + STARTING_ANGLE)/2) - 6;
    public static final double SHOOT_TIME = .5;
    public static final double SPIT_TIME_FOR_SLAM_DUNK = .1;


//auton stuff
    public static final double DISTANCE_TO_SHOT = 48; //inches
    public static final double DISTANCE_EXTRA_TO_DRIVE_BACK = 15; //inches
    public static final double EXTRA_DISTANCE_BACK_TO_BALL = 5; //inches
    
    public static final double TIME_TO_PICK_UP_BALL = .7; //seconds
    public static final double SUCK_TIME_FOR_BALL_ON_TOP = .7;

    public static final double TIME_TO_REACH_SHOOT = 1.70;   //2
    public static final double EXTRA_TIME_TO_DRIVE_FORWARD = .5;
    public static final double EXTRA_TIME_TO_DRIVE_BACK = 0;
    
    public static final double TIME_TO_REACH_COLORED_ZONE = 1.3;
}
