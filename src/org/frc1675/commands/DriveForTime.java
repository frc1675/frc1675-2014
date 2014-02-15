/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *Tells drive motors to move for a given time.  Use for autonomous
 * 
 * @author Tony
 */
public class DriveForTime extends CommandBase {
    Timer timer;
    double time;
    private static final double KIND_OF_LIKE_POWER = .6;
    public DriveForTime(double seconds) {
        requires(driveBase);
        timer = new Timer();
        time = seconds;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        driveBase.setLeftMotors(KIND_OF_LIKE_POWER);
        driveBase.setRightMotors(KIND_OF_LIKE_POWER);
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return(timer.get()>time);
    }

    // Called once after isFinished returns true
    protected void end() {
        driveBase.setLeftMotors(0);
        driveBase.setRightMotors(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
