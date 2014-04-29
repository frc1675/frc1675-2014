/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.arm.puncher.shootsequences;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.RobotMap;
import org.frc1675.commands.Wait;
import org.frc1675.commands.arm.jaw.JawOpen;
import org.frc1675.commands.arm.puncher.PuncherDisengage;


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
