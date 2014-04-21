/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.autonomous;

import org.frc1675.commands.CommandBase;

/**
 * This can be used for vision diagnostics. It is commented out because the
 * camera was unplugged, and it causes errors.
 */
public class VisionTest extends CommandBase {

    public VisionTest() {
        //requires(vision);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //System.out.println("The target has been found is a " + vision.isHorizontalTarget() + " statement");
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
