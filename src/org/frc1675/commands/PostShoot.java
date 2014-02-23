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
import org.frc1675.commands.arm.puncher.PuncherPutPinIn;
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
        addSequential(new PuncherPutPinIn());
        addSequential(new JawClose());
        addSequential(new PuncherGoToLimit());

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
