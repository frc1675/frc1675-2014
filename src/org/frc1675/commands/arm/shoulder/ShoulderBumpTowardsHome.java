/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.arm.shoulder;

import org.frc1675.commands.CommandBase;

/**
 * This was designed to move the shoulder down a few degrees.
 *
 * @author Tony
 */
public class ShoulderBumpTowardsHome extends CommandBase {

    public ShoulderBumpTowardsHome() {
        requires(shoulder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shoulder.bumpTowardsHome();
        System.out.println("ShoulderBumpTowardsHome started");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
