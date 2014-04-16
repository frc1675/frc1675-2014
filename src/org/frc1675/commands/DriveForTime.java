/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 * Tells drive motors to move for a given time and power(kind of, because it
 * gets scaled for acceleration and stuff). Use for autonomous
 *
 * @author Tony
 */
public class DriveForTime extends CommandBase {

    Timer timer;
    double time;
    double power;

    public DriveForTime(double seconds, double kindOfLikePower) {
        requires(driveBase);
        timer = new Timer();
        time = seconds;
        power = kindOfLikePower;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        driveBase.setLeftMotors(0);
        driveBase.setRightMotors(0);
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        driveBase.setLeftMotors(-power);
        driveBase.setRightMotors(-power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (timer.get() > time);
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
