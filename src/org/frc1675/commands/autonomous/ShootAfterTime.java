/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.RobotMap;
import org.frc1675.commands.PostShoot;
import org.frc1675.commands.Shoot;
import org.frc1675.commands.TeleopShoot;
import org.frc1675.commands.Wait;
import org.frc1675.commands.arm.roller.RollerStop;
import org.frc1675.commands.arm.shoulder.SetShoulderToPickup;

/**
 * This command group takes in a time, and waits until that time in autonomous
 * to shoot, disregarding anything else. Useful for a 2 ball when theres a bunch
 * of stuff going on at once and we want to be sure our ball gets off.
 *
 * @author Tony
 */
public class ShootAfterTime extends CommandGroup {

    private static final double WAIT_AFTER_ROLL = .2;

    public ShootAfterTime(double time) {
        addSequential(new Wait(time - WAIT_AFTER_ROLL - 2 * RobotMap.PNEUMATIC_FIRE_TIME));
        addParallel(new RollerStop());
        addSequential(new Wait(WAIT_AFTER_ROLL));
        addSequential(new Shoot());
        addParallel(new SetShoulderToPickup());
        addSequential(new PostShoot());
    }
}
