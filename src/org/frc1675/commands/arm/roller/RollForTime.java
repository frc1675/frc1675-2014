/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.arm.roller;

import edu.wpi.first.wpilibj.Timer;
import org.frc1675.commands.CommandBase;

/**
 * This will eject the ball from the roller claw for the specified amount of
 * time.
 *
 * @author Tony
 */
public class RollForTime extends CommandBase {

    Timer timer;
    double time;
    boolean isIntake = false;

    public RollForTime(double time, boolean isIntake) {
        timer = new Timer();
        requires(rollerClaw);
        this.time = time;
        this.isIntake = isIntake;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.start();
        if(isIntake){
            rollerClaw.intake();
        }else{
            rollerClaw.eject();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() > time;
    }

    // Called once after isFinished returns true
    protected void end() {
        rollerClaw.stop();
        timer.stop();
        timer.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
