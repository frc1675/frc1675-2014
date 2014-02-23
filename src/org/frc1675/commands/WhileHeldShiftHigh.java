/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

/**
 *
 * Use a whileHeld command to trigger this so the robot is seldom in
 * battery-eating high gear.
 *
 * @author Tony
 */
public class WhileHeldShiftHigh extends CommandBase {

    public WhileHeldShiftHigh() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shifter.shiftToHighGear();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        shifter.shiftToHighGear();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        new ShiftLow();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
