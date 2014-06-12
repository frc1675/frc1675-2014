/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.frc1675.RobotMap;

/**
 *
 * @author Tony
 */
public class ResetPid extends CommandBase {
    double p, i, d;
    public ResetPid() {
        requires(shoulder);
                // Use requires() here to declare subsystem dependencies
                // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        p = SmartDashboard.getNumber("ShoulderP", RobotMap.SHOULDER_P);
        i = SmartDashboard.getNumber("ShoulderI", RobotMap.SHOULDER_I);
        d = SmartDashboard.getNumber("ShoulderD", RobotMap.SHOULDER_D);
        System.out.println("pTheoretical = " + p);
        shoulder.stopAndReset();
        shoulder.getPIDController().setPID(p, i, d);
        System.out.println("pActual = " + shoulder.getPIDController().getP());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
