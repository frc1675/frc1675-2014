/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.arm.puncher;

import edu.wpi.first.wpilibj.Timer;
import org.frc1675.RobotMap;
import org.frc1675.commands.CommandBase;

/**
 * Puts pin back in the puncher so you can shoot later.
 *
 * @author Tony
 */
public class PuncherEngage extends CommandBase {

    private Timer timer;

    public PuncherEngage() {
        requires(puncher);
        timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        puncher.putPinIn();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (timer.get() > RobotMap.PNEUMATIC_FIRE_TIME) {
            return true;
        } else {
            return false;
        }

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
