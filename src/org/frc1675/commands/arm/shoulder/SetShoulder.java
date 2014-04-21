/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.arm.shoulder;

import edu.wpi.first.wpilibj.Timer;
import org.frc1675.RobotMap;
import org.frc1675.UPS2014;
import org.frc1675.commands.CommandBase;

/**
 * Use this to set the shoulder to any angle other than the floor. It will
 * maintain this angle. It does some logic to try to slow the arm down if its
 * going over the top. This causes some weird inertia that the PID doesn't like,
 * so this tries to remedy that.
 *
 * @author Tony
 */
public class SetShoulder extends CommandBase {

    private int setpoint;
    private int isGoingOverWeightShift;
    Timer timer;
    private static final double STOP_TIME = .01;
    private static final double FORWARD_STOP_ANGLE = 145;
    private static final double BACKWARD_STOP_ANGLE = 105;
    private static final double STOP_TOLERANCE = 5;
    private static final double NEW_POWER = .5;

    public SetShoulder(int angle) {
        requires(shoulder);
        setpoint = angle;
        timer = new Timer();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shoulder.setPIDSetpoint(setpoint);
        isGoingOverWeightShift = shoulder.isGoingOverWeightShift();
        System.out.println("IsGoingOverWeightShift: " + isGoingOverWeightShift);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("SetShoulder: " + shoulder.pot.get());
        if (isGoingOverWeightShift == 0) {

        } else if (isGoingOverWeightShift == 1) {
            if (Math.abs(shoulder.pot.get() - FORWARD_STOP_ANGLE) < STOP_TOLERANCE) {
                if (timer.get() == 0.0) {
                    timer.start();
                    shoulder.power = NEW_POWER;
                    System.out.println("CHANGED POWER");
                }
            }
        } else {     //isGoingOverWeightShift is equal to -1
            if (Math.abs(shoulder.pot.get() - BACKWARD_STOP_ANGLE) < STOP_TOLERANCE) {
                if (timer.get() == 0.0) {
                    timer.start();
                    shoulder.power = NEW_POWER;
                    System.out.println("CHANGED POWER");
                }
            }
        }
        if (timer.get() >= STOP_TIME) {
            isGoingOverWeightShift = 0;
            shoulder.setPIDSetpoint(setpoint);
            System.out.println("resetting!");
            timer.reset();
        }
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
