/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems.arm;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.RobotMap;
import org.frc1675.commands.arm.puncher.WindWinchWithJoysticks;

/**
 * Puncher represents the ball punching mechanism. We control a winch, pull it
 * back to a specific point, and shift the gearbox into neutral to release the
 * puncher to hit the ball.
 *
 * @author josh
 */
public class Puncher extends Subsystem {

    private Solenoid extend;
    private Solenoid retract;
    private SpeedController winchMotor;
    private SpeedController winchMotorTwo;
    private Encoder encoder;

    public Puncher() {
        extend = new Solenoid(RobotMap.SHOOTER_EXTEND);
        retract = new Solenoid(RobotMap.SHOOTER_RETRACT);
        winchMotor = new Talon(RobotMap.WINCH_MOTOR);
        winchMotorTwo = new Talon(RobotMap.WINCH_MOTOR_TWO);
        encoder = new Encoder(RobotMap.WINCH_ENCODER_CHANNEL_A, RobotMap.WINCH_ENCODER_CHANNEL_B);

    }

    public void initDefaultCommand() {
        //setDefaultCommand(new WindWinchWithJoysticks());
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
        if (joystickValue > RobotMap.CONTROLLER_DEAD_ZONE) {
            winchMotor.set(joystickValue);
            winchMotorTwo.set(joystickValue);
        } else {
            winchMotor.set(0);
            winchMotorTwo.set(0);
        }
    }

    public boolean goToSetpoint(int setpoint) {    //returns if its at setpoint
        if (encoder.get() < setpoint) {
            winchMotor.set(1);
            winchMotorTwo.set(1);
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
