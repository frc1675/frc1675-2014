/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.arm.puncher;

import org.frc1675.RobotMap;
import org.frc1675.commands.CommandBase;

/**
 * This will wind the winch until the Vex button is pressed. The encoder didn't
 * work too well.
 *
 * @author Tony
 */
public class PuncherGoToLimit extends CommandBase {

    private boolean isAtSetpoint;

    public PuncherGoToLimit() {

        requires(puncher);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        isAtSetpoint = puncher.goToLimit();
        puncher.limitTimer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        isAtSetpoint = puncher.goToLimit();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isAtSetpoint;
    }

    // Called once after isFinished returns true
    protected void end() {
        puncher.stop();
        puncher.limitTimer.stop();
        puncher.limitTimer.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
