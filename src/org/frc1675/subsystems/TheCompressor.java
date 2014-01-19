/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
import org.frc1675.RobotMap;
/**
 *
 * @author John
 */
public class TheCompressor extends Subsystem {

    Compressor compressor;

    public TheCompressor() {
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
        compressor.stop();
    }
}
