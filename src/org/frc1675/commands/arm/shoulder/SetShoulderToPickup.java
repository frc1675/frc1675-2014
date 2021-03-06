/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.arm.shoulder;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.frc1675.RobotMap;
import org.frc1675.UPS2014;
import org.frc1675.commands.CommandBase;

/**
 * This will set the shoulder to the pickup angle set in RobotMap. This is a
 * different command because we don't want to hold position at the floor.
 *
 * @author Tony
 */
public class SetShoulderToPickup extends CommandBase {

    private Timer timer;

    public SetShoulderToPickup() {
        requires(shoulder);
        timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shoulder.setPIDSetpoint(RobotMap.FLOOR_ANGLE);
        shoulder.setPower(RobotMap.FLOOR_ANGLE);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("SetShoulderToPickup: " + shoulder.pot.get());
        UPS2014.table.putNumber("ShoulderPotValue", shoulder.pot.get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (shoulder.potIsBad()) {
            return true;
        }
        if ((shoulder.getPIDController().onTarget()) && (timer.get() == 0)) {
            timer.start();
        } else if (timer.get() > 0 && !(shoulder.getPIDController().onTarget())) {
            timer.stop();
            timer.reset();
        } else if (timer.get() > RobotMap.SHOULDER_PID_TARGET_TIME) {
            return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        shoulder.stopAndReset();
        timer.stop();
        timer.reset();

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
