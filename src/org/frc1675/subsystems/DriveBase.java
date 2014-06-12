/* Drivebase
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.RobotMap;
import org.frc1675.commands.drive.CheesyDriveCommand;
import org.frc1675.utils.AccelerationSpeedController;

/**
 *
 * @author Daniel &    Elise    Tony
 */
public class DriveBase extends Subsystem {

    AccelerationSpeedController leftFrontMotor, rightFrontMotor, leftBackMotor, rightBackMotor;
    SideEncoder rightEncoder;
    SideEncoder leftEncoder;

    public DriveBase(double driveEncoderP, double driveEncoderI, double driveEncoderD) {
        leftEncoder = new SideEncoder(driveEncoderP, driveEncoderI, driveEncoderD, RobotMap.DRIVE_LEFT_ENCODER_CHANNEL_A, RobotMap.DRIVE_LEFT_ENCODER_CHANNEL_B, SideEncoder.LEFT);
        rightEncoder = new SideEncoder(driveEncoderP, driveEncoderI, driveEncoderD, RobotMap.DRIVE_RIGHT_ENCODER_CHANNEL_A, RobotMap.DRIVE_RIGHT_ENCODER_CHANNEL_B, SideEncoder.RIGHT);
        leftFrontMotor = new AccelerationSpeedController(new Talon(RobotMap.DriveConstants.LEFT_FRONT_MOTOR));
        leftBackMotor = new AccelerationSpeedController(new Talon(RobotMap.DriveConstants.LEFT_BACK_MOTOR));
        rightFrontMotor = new AccelerationSpeedController(new Talon(RobotMap.DriveConstants.RIGHT_FRONT_MOTOR));
        rightBackMotor = new AccelerationSpeedController(new Talon(RobotMap.DriveConstants.RIGHT_BACK_MOTOR));
    }

    public void setLeftMotors(double powerFromController) {
        leftFrontMotor.set(-powerFromController);
        leftBackMotor.set(-powerFromController);
    }

    public void setRightMotors(double powerFromController) {
        rightFrontMotor.set(powerFromController);
        rightBackMotor.set(powerFromController);
    }

    public double adjustForDeadZone(double controllerInput) {
        double power;

        if ((controllerInput) == 0.0) {
            power = 0.0;
        } else {
            power = (controllerInput / Math.abs(controllerInput))
                    * //This determines sign. 
                    ((1 - RobotMap.DriveConstants.MOTOR_DEAD_ZONE) * Math.abs(controllerInput)
                    + RobotMap.DriveConstants.MOTOR_DEAD_ZONE);
            //This scales for the motor dead zone.
        }

        return power;
    }

    public void driveStraightTo(double inches) {
        leftEncoder.goToSetpoint(inches);
        rightEncoder.goToSetpoint(inches);
    }

    public boolean rightIsOnTarget() {
        return rightEncoder.onTarget();
    }

    public boolean leftIsOnTarget() {
        return leftEncoder.onTarget();
    }

    public void disablePid() {
        leftEncoder.disablePid();
        rightEncoder.disablePid();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        //setDefaultCommand(new ArcadeDriveCommand());
//        setDefaultCommand(new TankDriveCommand());
//        setDefaultCommand(CommandBase.thresholdFinder);
        setDefaultCommand(new CheesyDriveCommand());
        //setDefaultCommand(new UltimateCheezyDriveCommand(.5, 4));
    }
    
    public class SideEncoder extends PIDSubsystem {

        public static final boolean LEFT = true;
        public static final boolean RIGHT = false;

        private static final double ABSOLUTE_TOLERANCE = 2; //inches

        Encoder encoder;
        boolean isLeft;

        public SideEncoder(double p, double i, double d, int encoderChannelA, int encoderChannelB, boolean LEFT_OR_RIGHT) {
            super(p, i, d);
            isLeft = LEFT_OR_RIGHT;
            encoder = new Encoder(encoderChannelA, encoderChannelB);
            encoder.setDistancePerPulse(4 * Math.PI / RobotMap.DRIVE_ENCODER_TICKS);//This math converts the encoder pulses to inches (?d)
            this.setAbsoluteTolerance(ABSOLUTE_TOLERANCE);
        }

        protected double returnPIDInput() {
            return encoder.get();
        }

        private void goToSetpoint(double setpoint) {
            this.setSetpoint(setpoint);
            this.enable();
        }

        private void disablePid() { //This disables the PID so it fails safely. 
            this.disable();
            this.getPIDController().reset();
            if (isLeft) {
                setLeftMotors(0);
            } else {
                setRightMotors(0);
            }
        }

        protected void usePIDOutput(double d) { //This method is called by the PID controller
            if (isLeft) {
                setLeftMotors(d);
            } else {
                setRightMotors(d);
            }
        }

        protected void initDefaultCommand() {

        }
    }
}
