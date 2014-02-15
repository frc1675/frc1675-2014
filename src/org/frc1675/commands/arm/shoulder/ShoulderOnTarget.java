/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.arm.shoulder;

import edu.wpi.first.wpilibj.Timer;
import org.frc1675.RobotMap;
import org.frc1675.commands.CommandBase;

/**
 * Checks if the shoulder has reached its target. May be necessary for auton.
 *
 * @author Tony
 */
public class ShoulderOnTarget extends CommandBase {

    Timer timer;

    public ShoulderOnTarget() {
        timer = new Timer();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if ((shoulder.getPIDController().onTarget()) && (timer.get() == 0)) {
            timer.start();
        } else if (timer.get() > 0 && !(shoulder.getPIDController().onTarget())) {
            timer.stop();
            timer.reset();
        } else if (timer.get() > RobotMap.SHOULDER_PID_TARGET_TIME) {
            return true;
        }
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
