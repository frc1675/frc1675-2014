/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.RobotMap;

/**
 * Shoulder represents the system used for changing the angle of the entire claw
 * and shooter assembly.
 *
 * @author josh
 */
public class Shoulder extends PIDSubsystem {

    private final int potScale = 50;
    AnalogPotentiometer pot;
    SpeedController motor;

    public Shoulder(double p, double i, double d) {
        super(p, i, d);
        this.pot = new AnalogPotentiometer(RobotMap.SHOULDER_POT, potScale);
        this.motor = new Talon(RobotMap.SHOULDER_MOTOR);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void rawMoveShoulder(double joystickValue) {
        motor.set(joystickValue);
    }

    protected double returnPIDInput() {
        return pot.get();
    }

    protected void usePIDOutput(double d) {
        motor.set(d);
    }

}
