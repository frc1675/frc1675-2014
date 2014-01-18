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
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 * Shoulder represents the system used for changing the angle of the entire claw
 * and shooter assembly.
 * @author josh
 */
public class Shoulder extends PIDSubsystem {
    private final int shoulderMotorPort = 1;
    private final int potPort = 2;
    private final int potLowAngle = 60;
    private final int potMedAngle = 70;
    private final int potHighAngle = 80;
    private final int potScale = 50;
    //private static final double p = 10;
    AnalogPotentiometer pot;
    SpeedController motor;

   public Shoulder(double p, double i,double d) {
     
       super(p,i,d);
        this.pot = new AnalogPotentiometer(potPort,potScale);
        this.motor = new Talon(shoulderMotorPort);
    }
    
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void rawMoveShoulder(double joystickValue){
        motor.set(joystickValue);
    }

    protected double returnPIDInput() {
        return pot.get();
    }

    protected void usePIDOutput(double d) {
        motor.set(d);
    }
   
    
            }
