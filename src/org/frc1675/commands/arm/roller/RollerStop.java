/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.arm.roller;

import org.frc1675.commands.CommandBase;

/**
 *
 * @author Tony
 * Stops the roller claw
 */
public class RollerStop extends CommandBase {

    public RollerStop() {
        requires(rollerClaw);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        rollerClaw.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        rollerClaw.stop();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}