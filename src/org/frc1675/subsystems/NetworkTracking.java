/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.UPS2014;

/**
 *
 * @author Tony
 */
public class NetworkTracking extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public boolean isHot() {
        return UPS2014.table.getBoolean("isHot");
    }
}
