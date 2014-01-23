/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

/**
 * Set as initDefaultCommand. Will poll operator left y periodically and set
 * shoulder motor to that value.
 *
 * @author Tony
 */
public class ShoulderMoveWithJoysticks extends CommandBase {

    double speed;

    public ShoulderMoveWithJoysticks() {
        requires(shoulder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        shoulder.rawMoveShoulder(oi.getOperatorLeftY());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        shoulder.rawMoveShoulder(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
