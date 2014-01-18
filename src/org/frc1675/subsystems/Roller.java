/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Roller represents the powered roller at the end of the top arm of the claw.
 * It has 3 states: Intake (pulling a ball in), Eject (send a ball out), and at
 * all other times, the wheels are not powered.
 * @author josh
 */
public class Roller extends Subsystem {
    public static final int ROLLER_CLAW_SPIKE = 1;
    Relay relay;
    
    
    public Roller(){
        relay = new Relay(ROLLER_CLAW_SPIKE);       
    }
    
    public void intake(){
        relay.set(Relay.Value.kForward);
    }
    
    public void eject(){
        relay.set(Relay.Value.kReverse);
    }
    
    public void turnOff(){
        relay.set(Relay.Value.kOff);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}