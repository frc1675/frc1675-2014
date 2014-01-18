/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
/**
 *
 * @author John
 */
public class TheCompressor extends Subsystem {
    public static final int COMPRESSOR_SPIKE = 2;
    public static final int PRESSURE_SWITCH = 7;
    Compressor compressor;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public TheCompressor(){
        compressor = new Compressor(PRESSURE_SWITCH, COMPRESSOR_SPIKE);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void enable(){
        compressor.start();
    }
    public void disable(){
        compressor.stop();
    }
}
