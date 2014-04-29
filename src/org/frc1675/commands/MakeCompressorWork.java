/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

/**
 * Starts the compressor. The code behind the scenes periodically polls
 * pressure switch and sets relay accordingly
 *
 * @author Tony
 */
public class MakeCompressorWork extends CommandBase {

    public MakeCompressorWork() {
        requires(compressor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        compressor.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        compressor.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
