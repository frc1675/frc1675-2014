/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author John
 */
public class SetShoulderWithPID extends CommandBase {
    double angle;
    Timer timer;
    public SetShoulderWithPID(double degrees) {
        requires(shoulder);
        timer = new Timer();
        angle = degrees;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shoulder.setPIDSetpoint(angle);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if ((shoulder.getPIDController().onTarget()) && (timer.get()!=0)){
            timer.start();
        }else if(timer.get() > 0 && !(shoulder.getPIDController().onTarget())){
            timer.stop();
            timer.reset();
            timer.stop();           
        }else if (timer.get()>.5){
            return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        shoulder.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
