/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems.arm;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.RobotMap;
import org.frc1675.commands.arm.roller.RollerStop;

/**
 * Roller represents the powered roller at the end of the top arm of the claw.
 * It has 3 states: Intake (pulling a ball in), Eject (send a ball out), and at
 * all other times, the wheels are not powered.
 *
 * @author Tony
 */
public class Roller extends Subsystem {

    private Talon talon;

    public Roller() {
        talon = new Talon(RobotMap.ROLLER_CLAW_MOTOR);
    }

    public void intake() {
        talon.set(-1);
    }

    public void eject() {
        talon.set(1);
    }

    public void stop() {
        talon.set(0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new RollerStop());
    }
}
