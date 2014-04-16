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
 * Pulls pin out of puncher so the ball shoots.
 *
 * @author Tony
 */
public class PuncherDisengage extends CommandBase {

    private static final double START_POWER = .2;
    private static final double TIME_TO_SPIN_MOTORS = .25;
    private static final double PULSE_TIME = .2;
    private static final double PULSE_PERCENTAGE = 1;
    private static final double POWER_TO_RAMP_TO = .3;
    private Timer timer;
    private double rampIncrement;
    private double motorPower = START_POWER;

    public PuncherDisengage() {
        requires(puncher);
        timer = new Timer();

    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.start();
        rampIncrement = (POWER_TO_RAMP_TO - START_POWER) / (50 * TIME_TO_SPIN_MOTORS);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //motorPower += (rampIncrement);  //This makes the power ramp from starting to ending power, if we decide thats necessary.
        if (timer.get() < RobotMap.PNEUMATIC_FIRE_TIME) {
            puncher.shoot();
        } else {
            if ((((timer.get()) % (PULSE_TIME * (1 / PULSE_PERCENTAGE))) <= PULSE_TIME)) {
                puncher.setMotors(motorPower);
            } else {
                puncher.setMotors(0);
            }
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return (puncher.encoder.get() < 100);
        return (timer.get() > (TIME_TO_SPIN_MOTORS + RobotMap.PNEUMATIC_FIRE_TIME));
    }

    // Called once after isFinished returns true
    protected void end() {
        timer.stop();
        timer.reset();
        puncher.setMotors(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
