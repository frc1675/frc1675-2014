/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.arm.shoulder;

import org.frc1675.commands.CommandBase;

/**
 * Set as initDefaultCommand. Will poll operator left y periodically and set
 * shoulder motor to that value.  Used for manual override.
 *
 * @author Tony
 */
public class ShoulderMoveWithJoysticks extends CommandBase {

    private double speed;
    private double potval;

    public ShoulderMoveWithJoysticks() {
        requires(shoulder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        potval = shoulder.pot.get();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (!shoulder.getPIDController().isEnable()){
            if ((shoulder.pot.get()>249.2)&&oi.getOperatorLeftY()>0){ //so it doesn't run into the ground
                shoulder.rawMoveShoulder(0);
            }else{
            shoulder.rawMoveShoulder(oi.getOperatorLeftY());
            }
            //System.out.println("ShoulderPotValue" +  shoulder.pot.get());
        }
        System.out.println("ShoulderWithJoysticks " + shoulder.pot.get());

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        shoulder.rawMoveShoulder(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
