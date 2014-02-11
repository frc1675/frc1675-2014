/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.arm.shoulder;

import org.frc1675.commands.CommandBase;

/**
 * Use this to set the shoulder to any angle other than the floor. It will
 * maintain this angle.
 *
 * @author Tony
 */
public class SetShoulder extends CommandBase {
    private int setpoint;
    
    public SetShoulder(int angle) {
        requires(shoulder);
        setpoint = angle;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shoulder.setPIDSetpoint(setpoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("SetShoulder: " + shoulder.getPot());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        shoulder.stopAndReset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
