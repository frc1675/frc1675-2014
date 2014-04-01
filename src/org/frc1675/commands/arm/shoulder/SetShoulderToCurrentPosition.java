/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.arm.shoulder;

import org.frc1675.UPS2014;
import org.frc1675.commands.CommandBase;

/**
 * When this is called, the shoulder will hold position.
 *
 * @author Tony
 */
public class SetShoulderToCurrentPosition extends CommandBase {

    private int setpoint;

    public SetShoulderToCurrentPosition() {
        requires(shoulder);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shoulder.setPower(setpoint);
        shoulder.setPIDSetpoint(shoulder.pot.get());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("SetShoulder: " + shoulder.pot.get());
        UPS2014.table.putNumber("ShoulderPotValue", shoulder.pot.get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return shoulder.potIsBad();
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
