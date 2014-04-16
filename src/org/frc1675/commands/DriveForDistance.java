/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

import edu.wpi.first.wpilibj.Timer;
import org.frc1675.RobotMap;

/**
 *
 * Use this to drive straight using PID until you reach a setpoint given in
 * inches.
 *
 * @author Tony
 *
 */
public class DriveForDistance extends CommandBase {

    Timer timer;
    double distance;

    public DriveForDistance(double inches) {
        requires(driveBase);
        distance = inches;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.start();
        driveBase.driveStraightTo(distance);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (driveBase.rightIsOnTarget() && driveBase.leftIsOnTarget() && (timer.get() == 0)) {
            timer.start();
        } else if (timer.get() > 0 && !(driveBase.leftIsOnTarget() && driveBase.rightIsOnTarget())) {
            timer.stop();
            timer.reset();
        } else if (timer.get() > RobotMap.DRIVE_ENCODER_PID_TARGET_TIME) {
            return true;
        }
        return false;
        //All this logic simply returns true when both have been on target for a given time
    }

    // Called once after isFinished returns true
    protected void end() {
        driveBase.disablePid();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        driveBase.disablePid();
    }
}
