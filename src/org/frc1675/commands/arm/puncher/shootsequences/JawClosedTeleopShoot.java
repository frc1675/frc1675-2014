/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.arm.puncher.shootsequences;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.commands.Wait;
import org.frc1675.RobotMap;
import org.frc1675.commands.arm.puncher.PuncherDisengage;

/**
 * In teleop, this command shoots with the jaw closed and then pulls back the
 * puncher.
 *
 * @author Tony
 */
public class JawClosedTeleopShoot extends CommandGroup {

    public JawClosedTeleopShoot() {
        addSequential(new PuncherDisengage());
        addSequential(new Wait(RobotMap.SHOOT_TIME));
        addSequential(new PostShoot());
    }
}
