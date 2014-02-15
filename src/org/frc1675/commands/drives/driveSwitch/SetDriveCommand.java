/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.drives.driveSwitch;

import edu.wpi.first.wpilibj.command.Command;
import org.frc1675.RobotMap;
import org.frc1675.commands.CommandBase;

/**
 *
 * @author Quangdao
 */
public class SetDriveCommand extends CommandBase {

    int driveID;
    private Command switchDrive;

    public SetDriveCommand() {
        requires(driveBase);
    }
    
    public SetDriveCommand(int id) {
        this();
        driveID = id;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if (driveID == RobotMap.ARCADE_DRIVE) {
            driveBase.setArcadeDrive();
        } else if (driveID == RobotMap.CHEESY_DRIVE) {
            driveBase.setCheesyDrive();
        } else {
            driveBase.setTankDrive();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    //robotDriveBase.switchDefaultCommand();
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