/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.frc1675.RobotMap;

/**
 *
 * @author josh
 */
public class Shifter extends Subsystem {
    Solenoid high;
    Solenoid low;
    private static boolean onHighGear;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Shifter(){
        high = new Solenoid(RobotMap.SHIFTER_HIGH);
        low = new Solenoid(RobotMap.SHIFTER_LOW);
    }
    public void shiftToHighGear(){
        high.set(true);
        low.set(false);
        onHighGear = true;
        SmartDashboard.putString("Current Gear", "High");
    }
    public void shiftToLowGear(){
        high.set(false);
        low.set(true);
        onHighGear = false;
        SmartDashboard.putString("Current Gear", "Low");
    }
    
    public boolean isInHighGear(){
        return onHighGear;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
