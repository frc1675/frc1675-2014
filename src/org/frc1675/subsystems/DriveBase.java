/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.frc1675.RobotMap;
import org.frc1675.commands.drives.CheesyDriveCommand;
import org.frc1675.commands.drives.TankDriveCommand;

/**
 *
 * @author Daniel & Elise
 */
public class DriveBase extends Subsystem {

    SpeedController leftFrontMotor, rightFrontMotor, leftBackMotor, rightBackMotor;
    Timer leftTimer;
    Timer rightTimer;

    public DriveBase() {
        leftFrontMotor = new Talon(RobotMap.DriveConstants.LEFT_FRONT_MOTOR);
        leftBackMotor = new Talon(RobotMap.DriveConstants.LEFT_BACK_MOTOR);
        rightFrontMotor = new Talon(RobotMap.DriveConstants.RIGHT_FRONT_MOTOR);
        rightBackMotor = new Talon(RobotMap.DriveConstants.RIGHT_BACK_MOTOR);
        leftTimer = new Timer();
        leftTimer.start();
        rightTimer = new Timer();
        rightTimer.start();
        //Change all Victor to Talon on real robot    
    }
    
    public void setTankDrive() {
        setDefaultCommand(new TankDriveCommand());
        System.out.println("Robot Set to Tank Drive");
        SmartDashboard.putString("Drive Command", "Tank Drive");
    }
    
    public void setCheesyDrive() {
        setDefaultCommand(new CheesyDriveCommand());
        System.out.println("Robot Set to Cheesy Drive");
        SmartDashboard.putString("Drive Command", "Cheesy Drive");
    }
    
    public void setArcadeDrive() {
//        setDefaultCommand(new ArcadeDriveCommand());
        System.out.println("ERROR X: Arcade Drive Not Currently Available"); //Robot Set to Arcade Drive");
//        SmartDashboard.putString("Drive Command", "Arcade Drive");
    }

    public void setLeftMotors(double power) {
        power = adjustForDeadZone(power);

        if (power == 0.0) {
            leftTimer.reset();
        } else if (leftTimer.get() < RobotMap.DriveConstants.RAMP_TIME) {
            power = power * (leftTimer.get() / RobotMap.DriveConstants.RAMP_TIME);
        }
        //Acceleration code scales power with timer for left side.
        
            leftFrontMotor.set(-power);
            leftBackMotor.set(-power);
            SmartDashboard.putNumber("Left Motor Power", power);
        }
    

    public void setRightMotors(double power) {
        power = adjustForDeadZone(power);

        if (power == 0.0) {
            rightTimer.reset();
        } else if (rightTimer.get() < RobotMap.DriveConstants.RAMP_TIME) {
            power = power * (rightTimer.get() / RobotMap.DriveConstants.RAMP_TIME);
        }

        rightFrontMotor.set(power);
        rightBackMotor.set(power);
            SmartDashboard.putNumber("Right Motor Power", power);
    }

    public double adjustForDeadZone(double controllerInput) {
        double power;

        if((controllerInput) == 0.0) {
            power = 0.0;
        } else {
            power = (controllerInput / Math.abs(controllerInput)) *
                    //This determines sign. 
                    ((1 - RobotMap.DriveConstants.MOTOR_DEAD_ZONE) * Math.abs(controllerInput)
                    + RobotMap.DriveConstants.MOTOR_DEAD_ZONE);
                    //This scales for the motor dead zone.
        }

        return power;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        //setDefaultCommand(new ArcadeDriveCommand());
        setDefaultCommand(new TankDriveCommand());
        SmartDashboard.putString("Drive Command", "Tank Drive");
    }
}
