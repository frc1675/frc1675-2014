/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.RobotMap;
import org.frc1675.UPS2014;
import org.frc1675.commands.arm.jaw.JawClose;
import org.frc1675.commands.arm.jaw.JawOpen;
import org.frc1675.commands.arm.puncher.PuncherEngage;
import org.frc1675.commands.arm.puncher.PuncherDisengage;
import org.frc1675.commands.arm.puncher.SetWinch;
import org.frc1675.commands.arm.roller.RollerStop;

/**
 * This command group combines the Shoot and PostShoot commands for teleop
 * control.
 *
 * @author Tony
 */
public class TeleopShoot extends CommandGroup {

    public TeleopShoot() {
        addSequential(new Shoot());
        addSequential(new PostShoot());
    }
}
