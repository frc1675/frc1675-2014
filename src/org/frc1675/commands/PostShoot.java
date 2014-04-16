/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.RobotMap;
import org.frc1675.commands.arm.jaw.JawClose;
import org.frc1675.commands.arm.puncher.PuncherGoToLimit;
import org.frc1675.commands.arm.puncher.PuncherEngage;
import org.frc1675.commands.arm.puncher.SetWinch;

/**
 * This CommandGroup returns the shooter to its original state so it is ready to
 * shoot again.
 *
 *
 * @author Tony
 */
public class PostShoot extends CommandGroup {

    public PostShoot() {
        addSequential(new PuncherEngage());
        addSequential(new JawClose());
        addSequential(new PuncherGoToLimit());
    }
}
