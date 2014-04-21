/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.arm.puncher;

import org.frc1675.RobotMap;
import org.frc1675.commands.CommandBase;

/**
 * This will wind the winch back until the limit switch is pressed.
 *
 * @author Tony
 */
public class PuncherGoToLimit extends CommandBase {

    private boolean isAtSetpoint;

    public PuncherGoToLimit() {

        requires(puncher);
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
