/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems.arm;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.RobotMap;
import org.frc1675.UPS2014;
import org.frc1675.commands.arm.puncher.WindWinchWithJoysticks;

/**
 * Puncher represents the ball punching mechanism. We control a winch, pull it
 * back to a specific point, and shift the gearbox into neutral to release the
 * puncher to hit the ball. We will reel the thing back until a limit switch it
 * hit. Sometimes it fails, so there's also a timeout on it.
 *
 * @author josh
 */
public class Puncher extends Subsystem {

    private static final double WINCH_HIGH_POWER = 1;
    private static final double WINCH_LOW_POWER = .3;
    private static final double LOW_TIME = .5;
    private static final double STOP_TIME = 0;
    private static final double TIME_OUT_TIME = 5;
    private Solenoid extend;
    public Timer limitTimer;
    private Solenoid retract;
    private DigitalInput limitSwitch;
    private SpeedController winchMotor;
    private SpeedController winchMotorTwo;
    public Encoder encoder;

    public Puncher() {
        extend = new Solenoid(RobotMap.SHOOTER_EXTEND);
        retract = new Solenoid(RobotMap.SHOOTER_RETRACT);
        winchMotor = new Talon(RobotMap.WINCH_MOTOR);
        winchMotorTwo = new Talon(RobotMap.WINCH_MOTOR_TWO);
        limitSwitch = new DigitalInput(RobotMap.WINCH_LIMIT);
        encoder = new Encoder(RobotMap.WINCH_ENCODER_CHANNEL_A, RobotMap.WINCH_ENCODER_CHANNEL_B);
        encoder.start();
        limitTimer = new Timer();
    }

    public void initDefaultCommand() {
        setDefaultCommand(new WindWinchWithJoysticks());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void shoot() {
        extend.set(false);
        retract.set(true);
    }

    public void putPinIn() {
        retract.set(false);
        extend.set(true);
    }

    public void rawRunWinch(double joystickValue) {
        UPS2014.table.putBoolean("ShooterSwitch", limitSwitch.get());
        if ((joystickValue > (RobotMap.CONTROLLER_DEAD_ZONE)) && limitSwitch.get()) {
            winchMotor.set(joystickValue);
            winchMotorTwo.set(joystickValue);
        } else {
            winchMotor.set(0);
            winchMotorTwo.set(0);
        }
        //System.out.println("WINCH " + encoder.get());
    }

    public boolean goToLimit() {
        boolean limit = limitSwitch.get();
        UPS2014.table.putBoolean("ShooterSwitch", limit);
        double time = limitTimer.get();
        if (limit && (time < TIME_OUT_TIME)) {
            if (time <= LOW_TIME) {
                winchMotor.set(WINCH_LOW_POWER);
                winchMotorTwo.set(WINCH_LOW_POWER);
            } else if (time < (LOW_TIME + STOP_TIME)) {
                winchMotor.set(0);
                winchMotorTwo.set(0);
            } else {
                winchMotor.set(WINCH_HIGH_POWER);
                winchMotorTwo.set(WINCH_HIGH_POWER);
            }
            return false;
        } else {
            winchMotor.set(0);
            winchMotorTwo.set(0);
            return true;
        }
    }

    public void setMotors(double power) {
        winchMotor.set(power);
        winchMotorTwo.set(power);
    }

    public void resetAndRestartEncoder() {
        encoder.reset();
        encoder.start();
    }

    public boolean goToSetpoint(int setpoint) {    //returns true if its at setpoint
        //System.out.println("WINCH " + encoder.get());
        if (encoder.get() < setpoint) {
            winchMotor.set(WINCH_HIGH_POWER);
            winchMotorTwo.set(WINCH_HIGH_POWER);
            return false;
        } else {
            winchMotor.set(0);
            winchMotorTwo.set(0);
            return true;
        }
    }

    public void stop() {
        winchMotor.set(0);
        winchMotorTwo.set(0);
    }
}
