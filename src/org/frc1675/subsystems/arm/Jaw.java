/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems.arm;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.RobotMap;

/**
 * Jaw represents the top arm of the roller claw. The Jaw can be articulated
 * small amounts, either out of the way of a shot (open), or down for touching
 * the ball for collection (closed).
 *
 * @author josh
 */
public class Jaw extends Subsystem {

    Solenoid extend;
    Solenoid retract;

    public Jaw() {
        extend = new Solenoid(RobotMap.JAW_EXTEND);
        retract = new Solenoid(RobotMap.JAW_RETRACT);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void close() {
        extend.set(true);
        retract.set(false);
    }

    public void open() {
        retract.set(true);
        extend.set(false);
    }
}
