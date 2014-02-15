/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.commands.arm.jaw.JawOpen;
import org.frc1675.commands.arm.puncher.PuncherPutPinIn;
import org.frc1675.commands.arm.puncher.PuncherShoot;
import org.frc1675.commands.arm.roller.RollerStop;

/**
 *
 * @author Tony When the shooter is primed and we want to shoot the ball; use
 * this command group to shoot it
 *
 *
 */
public class Shoot extends CommandGroup {

    private static final double SHOOT_TIME = 10.0;

    public Shoot() {
        addSequential(new JawOpen());
        addParallel(new RollerStop());
        addSequential(new PuncherShoot());
        addSequential(new Wait(SHOOT_TIME));
        addSequential(new PuncherPutPinIn());
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
