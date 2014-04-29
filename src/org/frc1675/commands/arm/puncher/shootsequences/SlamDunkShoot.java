/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.arm.puncher.shootsequences;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.RobotMap;
import org.frc1675.commands.arm.roller.RollForTime;

/**
 * This shot can be used when we're pushed up against the low goal. It spits the
 * ball out a bit before shooting for less power.
 *
 * @author Tony
 */
public class SlamDunkShoot extends CommandGroup {

    public SlamDunkShoot() {
        addSequential(new RollForTime(RobotMap.SPIT_TIME_FOR_SLAM_DUNK, false));
        addSequential(new JawClosedTeleopShoot());
    }
}
