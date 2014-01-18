/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Puncher represents the ball punching mechanism. We control a winch, pull it
 * back to a specific point, and shift the gearbox into neutral to release the
 * puncher to hit the ball.
 * @author josh
 */
public class Puncher extends PIDSubsystem {
    public static final int WINCH_MOTOR = 5;
    
    public static final int SHOOTER_EXTEND = 1;
    public static final int SHOOTER_RETRACT = 2;
    
    public static final int WINCH_ENCODER_CHANNEL_A = 1;
    public static final int WINCH_ENCODER_CHANNEL_B = 2;
    
    public static final double CONTROLLER_DEAD_ZONE = .2; 

   
    
    private Solenoid extend;
    private Solenoid retract;
    private SpeedController winchMotor;
    private Encoder encoder;
    
    public Puncher(double p,double i,double d){
        super(p,i,d);
        extend = new Solenoid(SHOOTER_EXTEND);
        retract = new Solenoid(SHOOTER_RETRACT);
        winchMotor = new Talon(WINCH_MOTOR);
        encoder = new Encoder(WINCH_ENCODER_CHANNEL_A, WINCH_ENCODER_CHANNEL_B);
        
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void shoot(){
       extend.set(false);
       retract.set(true);
    }
    public void putPinIn(){
        retract.set(false);
        extend.set(true);
    }
    public void rawRunWinch(double joystickValue){
        if (joystickValue>CONTROLLER_DEAD_ZONE){
            winchMotor.set(joystickValue);
        }
        else{
            winchMotor.set(0);
        }
    }

    protected double returnPIDInput() {
        return encoder.get();
    }

    protected void usePIDOutput(double d) {
        winchMotor.set(d);
    }
}
