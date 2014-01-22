/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 * Opens Jaw
 *
 * @author Tony
 */
public class JawOpen extends CommandBase {

    Timer timer;

    public JawOpen() {
        requires(jaw);
        timer = new Timer();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        jaw.open();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (timer.get() > .25) {
            return true;
        } else {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        timer.reset();
        timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
