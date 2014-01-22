/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

/**
 *
 * @author Tony
 */
public class RollerIntake extends CommandBase {

    public RollerIntake() {
        requires(rollerClaw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        rollerClaw.intake();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        rollerClaw.intake();
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
