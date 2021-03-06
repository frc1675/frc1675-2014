/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import org.frc1675.commands.CommandBase;

/**
 * Tells drive motors to move for a given time and power (scaled for 
 * acceleration). Use for autonomous control.
 * 
 * @author Tony
 */
public class DriveForTime extends CommandBase {

    Timer timer;
    double time;
    double power;

    public DriveForTime(double time, double power) {
        requires(driveBase);
        timer = new Timer();
        this.time = time;
        this.power = power;
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
