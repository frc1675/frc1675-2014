/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems.arm;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.frc1675.RobotMap;
import org.frc1675.commands.arm.shoulder.ShoulderMoveWithJoysticks;

/**
 * Shoulder represents the system used for changing the angle of the entire claw
 * and shooter assembly.
 *
 * @author josh
 */
public class Shoulder extends PIDSubsystem {

    private static final int ABSOLUTE_TOLERANCE = 5;  //degrees
    private static final int POT_SCALE = 50;
    private AnalogPotentiometer pot;
    private SpeedController motor;

    public Shoulder(double p, double i, double d) {
        super(p, i, d);
        this.pot = new AnalogPotentiometer(RobotMap.SHOULDER_POT, POT_SCALE);
        this.motor = new Talon(RobotMap.SHOULDER_MOTOR);
        this.setInputRange(-1, 251);
        this.setAbsoluteTolerance(ABSOLUTE_TOLERANCE);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ShoulderMoveWithJoysticks());
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
        motor.set((-d)/2);
        //System.out.println("Sent Value" + d);
    }

    public void setPIDSetpoint(double angle) {
        this.setSetpoint(angle);
        this.enable();
    }
    public void rawSetAngle(double angle){
        if (pot.get()>angle){
            motor.set(0);
        }
        else{
            motor.set(.5);
        }
    }

    public void stopAndReset() {
        this.disable();
        this.getPIDController().reset();
        motor.set(0);
    }
    public double getPot(){
        return pot.get();
    }

}
