/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.arm.roller;

import org.frc1675.commands.CommandBase;

/**
 * Sets the roller claw to eject.  Set as a WhileHeld.
 *
 * @author Tony
 */
public class RollerEject extends CommandBase {

    public RollerEject() {
        requires(rollerClaw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        rollerClaw.eject();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        rollerClaw.eject();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        rollerClaw.stop();
    }

    protected void interrupted() {
        end();
    }
}
