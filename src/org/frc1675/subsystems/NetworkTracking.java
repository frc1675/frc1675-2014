/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.RobotMap;
import org.frc1675.UPS2014;

/**
 * We thought about doing vision tracking on the driver station through network
 * tables. We would take a picture with the lights on and with the lights off
 * and compare. The lights will also be controlled through the network table.
 *
 * @author Tony
 */
public class NetworkTracking extends Subsystem {
    //Solenoid lights = new Solenoid(RobotMap.LIGHTS);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public boolean isHot() {
        return UPS2014.table.getBoolean("isHot");
    }

    public void setLights(boolean on) {
        //lights.set(on);
    }
}
