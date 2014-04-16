/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.RobotMap;

/**
 * This contains the pneumatic solenoids associated with shifting. It allows our
 * drive to go fast or torquey.
 *
 * @author josh
 */
public class Shifter extends Subsystem {

    Solenoid high;
    Solenoid low;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Shifter() {
        high = new Solenoid(RobotMap.SHIFTER_HIGH);
        low = new Solenoid(RobotMap.SHIFTER_LOW);
    }

    public void shiftToHighGear() {
        high.set(true);
        low.set(false);
    }

    public void shiftToLowGear() {
        high.set(false);
        low.set(true);
    }

    public void initDefaultCommand() {

    }
}
