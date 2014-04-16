/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.arm.shoulder;

import org.frc1675.commands.CommandBase;

/**
 * This sets the shoulder the old way(without doing the weight shift
 * calculation) so that it would still work after that was implemented.
 *
 * @author Tony
 */
public class SetShoulderAuton extends CommandBase {

    double setpoint;

    public SetShoulderAuton(double angle) {
        requires(shoulder);
        setpoint = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shoulder.setPIDSetpoint(setpoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("Auton angle " + shoulder.pot.get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return shoulder.potIsBad();
    }

    // Called once after isFinished returns true
    protected void end() {
        shoulder.stopAndReset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
