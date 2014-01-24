/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Relay;
import org.frc1675.RobotMap;

/**
 * Does all things relating to compressor
 *
 * @author Tony
 */
public class CompressorSystem extends Subsystem {

    Compressor compressor;

    public CompressorSystem() {
        compressor = new Compressor(RobotMap.PRESSURE_SWITCH, RobotMap.COMPRESSOR_SPIKE);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void enable() {
        compressor.start();
    }

    public void disable() {
        compressor.setRelayValue(Relay.Value.kOff);
        compressor.stop();
    }
}
