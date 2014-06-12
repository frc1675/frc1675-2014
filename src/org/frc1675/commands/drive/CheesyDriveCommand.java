 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.drive;
import org.frc1675.commands.CommandBase;


/**
 * This command drives the robot using one stick (left) for throttle and the 
 * other (right) for turning.
 *
 * This is designed to be a default subsystem command. It will not stop unless
 * interrupted.
 * 
 * @author hemilia_bedilia
 */
public class CheesyDriveCommand extends CommandBase {

    public CheesyDriveCommand() {
        requires(driveBase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double forward = oi.getDriverLeftY();
        double turn = oi.getDriverRightX();
        boolean quickTurn = oi.getDriverTrigger();
        double left;
        double right;

        left = forward - turn;
        right = forward + turn;
        double surplus = 0;

        if (quickTurn == true) {
            if (left > 1) {
                surplus = left - 1;
                right = right - surplus;
            } else if (right > 1) {
                surplus = right - 1;
                left = left - surplus;
            } else if (left < -1) {
                surplus = -1 - left;
                right = right + surplus;
            } else if (right < -1) {
                surplus = -1 - right;
                left = left + surplus;
            }
        }

        driveBase.setLeftMotorsWithAcceleration(left);
        driveBase.setRightMotorsWithAcceleration(right);        
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
