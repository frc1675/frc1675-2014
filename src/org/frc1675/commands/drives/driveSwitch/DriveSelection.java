/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.drives.driveSwitch;

import org.frc1675.commands.CommandBase;


/**
 *
 * @author Quangdao
 */
public class DriveSelection extends CommandBase {
        private boolean selectionIsActive;
    
    public DriveSelection() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveBase);
    }
    
    public DriveSelection(boolean selection) {
        selectionIsActive = selection;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //Select With Button
        if(selectionIsActive){
            oi.setSwitchDriveCommands();
        }else{
            oi.setDefaultCommands();
        }
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