/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class uses the left stick to control both throttle and turning. Its
 * arcade drive. However, it does some really cool math so that you can be at
 * full power and full turning at the same time.
 *
 * @author Elise
 */
public class VectorArcadeDriveCommand extends CommandBase {

    public VectorArcadeDriveCommand() {
        requires(driveBase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double leftX = oi.getDriverLeftX();

        double magnitude = oi.getScaledLeftAnalogVector();
        boolean driverTrigger = oi.getDriverTrigger();

        double turn = leftX;
        double forward = magnitude;
        
        double leftPower = forward + turn;
        double rightPower = forward - turn;

        if (driverTrigger) {
            leftPower = ultimateLeft(leftPower, rightPower);
            rightPower = ultimateRight(leftPower, rightPower);
        }
        //Enables ultimate turn when driverTrigger is pressed.

        driveBase.setLeftMotors(leftPower);

        driveBase.setRightMotors(rightPower);


        
    }

    public double ultimateRight(double leftPower, double rightPower) {

        if (leftPower > 1.0) {
            rightPower -= (leftPower - 1.0);
            //right = right - (left - 1.0); 
        } else if (leftPower < -1.0) {
            rightPower += (-1.0 - leftPower);
        }

        return rightPower;
    }

    public double ultimateLeft(double leftPower, double rightPower) {

        if (rightPower > 1.0) {
            leftPower -= (rightPower - 1.0);
        } else if (rightPower < -1.0) {
            leftPower += (-1.0 - rightPower);
        }

        return leftPower;
//        (where leftPower - 1.0 etc is surplus)
    
    }

// Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
