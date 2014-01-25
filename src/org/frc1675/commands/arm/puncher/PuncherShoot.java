/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.arm.puncher;

import edu.wpi.first.wpilibj.Timer;
import org.frc1675.commands.CommandBase;

/**
 * Pulls pin out of puncher so the ball shoots. Should be called in a whileHeld
 * command
 *
 * @author Tony
 */
public class PuncherShoot extends CommandBase {

    private Timer timer;

    public PuncherShoot() {
        requires(puncher);
        timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        puncher.shoot();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        timer.stop();
        timer.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
