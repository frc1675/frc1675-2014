/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.arm.puncher;

import edu.wpi.first.wpilibj.Timer;
import org.frc1675.commands.CommandBase;

/**
 * Give this a setpoint in encoder ticks and the winch will wind to it
 *
 * @author Tony
 */
public class SetWinch extends CommandBase {

    private Timer timer;
    private int setpoint;
    private boolean isAtSetpoint;

    public SetWinch(int ticks) {
        timer = new Timer();
        setpoint = ticks;
        requires(puncher);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        puncher.resetAndRestartEncoder();
        isAtSetpoint = puncher.goToSetpoint(setpoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        isAtSetpoint = puncher.goToSetpoint(setpoint);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isAtSetpoint;
    }

    // Called once after isFinished returns true
    protected void end() {
        puncher.stop();
        timer.stop();
        timer.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
