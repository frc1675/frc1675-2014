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
 *
 * @author John
 */
public class ShootAfterTime extends CommandGroup {
    private static final double WAIT_AFTER_ROLL = .2;
    public ShootAfterTime(double time) {
        addSequential(new Wait(time -WAIT_AFTER_ROLL - 2*RobotMap.PNEUMATIC_FIRE_TIME));
        addParallel(new RollerStop());
        addSequential(new Wait(WAIT_AFTER_ROLL));
        addSequential(new Shoot());
        addParallel(new SetShoulderToPickup());
        addSequential(new PostShoot());
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
