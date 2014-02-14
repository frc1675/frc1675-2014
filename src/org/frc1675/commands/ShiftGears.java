/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

import edu.wpi.first.wpilibj.Timer;
import org.frc1675.RobotMap;
import org.frc1675.commands.CommandBase;
import org.frc1675.subsystems.Shifter;


/**
 *
 * @author Tony
 * This shifts to the high gear, solenoid specified in robotMap
 */
public class ShiftGears extends CommandBase {
    
    private Timer timer;

    public ShiftGears() {
        requires(shifter);
        timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(shifter.isInHighGear()){
            shifter.shiftToLowGear();
        }else{
            shifter.shiftToHighGear();
        }
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
