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
 *
 * When the shooter is primed and we want to shoot the ball; use this command
 * group to shoot it.
 *
 * @author Tony
 *
 */
public class Shoot extends CommandGroup {

    public Shoot() {
        addSequential(new JawOpen());
        addSequential(new PuncherDisengage());
        addSequential(new Wait(RobotMap.SHOOT_TIME));
    }
}
