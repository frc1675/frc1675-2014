/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.drive;
import org.frc1675.commands.CommandBase;

/**
 * This command, when set as default command on DriveBase sets the left motors
 * to the values on the left stick and the right motors to values on the right
 * stick, adjusted for deadzones.
 * 
 * This is designed to be a default subsystem command. It will not stop unless
 * interrupted.
 *
 * @author Elise
 */
public class TankDriveCommand extends CommandBase {

    public TankDriveCommand() {
        requires(driveBase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double leftTankY = oi.getDriverLeftY();
        double rightTankY = oi.getDriverRightY();
        
        driveBase.setLeftMotors(leftTankY);
        driveBase.setRightMotors(rightTankY);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
