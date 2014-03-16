/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems.arm;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.PIDController;
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
    private static final double BUMP = 10;
    private static final int ABSOLUTE_TOLERANCE = 10;  //degrees
    private static final int POT_SCALE = 50;
    public AnalogPotentiometer pot;
    private SpeedController motor;
    double setpoint = 250;
    boolean potWasBad = false;
    boolean potWasWasBad = false;

    public Shoulder(double p, double i, double d) {
        super(p, i, d);
        this.pot = new AnalogPotentiometer(RobotMap.SHOULDER_POT, POT_SCALE);
        this.motor = new Talon(RobotMap.SHOULDER_MOTOR);
        this.setInputRange(-1, 256);
        this.setAbsoluteTolerance(ABSOLUTE_TOLERANCE);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ShoulderMoveWithJoysticks());
        //setDefaultCommand(new IncreaseShoulderSetpoint());
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
        motor.set((d) * .75);
    }

    public void setPIDSetpoint(double angle) {
        this.setSetpoint(angle);
        this.enable();
    }
    public void bumpUp(){
        this.setSetpoint((this.getSetpoint())-BUMP);
    }
    public void bumpDown(){
        this.setSetpoint((this.getSetpoint())+BUMP);
    }
    
    public void stopAndReset() {
        this.disable();
        this.getPIDController().reset();
        motor.set(0);
    }
    public boolean potIsBad(){
        boolean potIsBad = pot.get()<5;
        if(potIsBad && potWasBad && potWasWasBad){
            return true;
        }
        potWasWasBad = potWasBad;
        potWasBad = potIsBad;
        return false;        
    }
  

}

