/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.autonomous;

import org.frc1675.UPS2014;
import org.frc1675.commands.CommandBase;

/**
 * This command ends when the network table says the target is seen.
 *
 * @author Tony
 */
public class NetworkCheckForTarget extends CommandBase {

    public NetworkCheckForTarget() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(network);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return UPS2014.table.getBoolean("isHot");
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
