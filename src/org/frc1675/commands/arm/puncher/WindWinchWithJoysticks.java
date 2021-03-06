/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.arm.puncher;

import org.frc1675.commands.CommandBase;

/**
 * Set as initDefaultCommand. Will poll operator right y periodically and set
 * winch motor to that value. The subsystem will protect from backdriving the
 * winch.
 *
 * @author Tony
 */
public class WindWinchWithJoysticks extends CommandBase {

    public WindWinchWithJoysticks() {
        requires(puncher);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        puncher.rawRunWinch(oi.getOperatorRightY());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        puncher.rawRunWinch(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
