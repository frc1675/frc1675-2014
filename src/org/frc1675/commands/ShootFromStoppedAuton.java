/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.RobotMap;
import org.frc1675.commands.arm.puncher.PuncherGoToLimit;
import org.frc1675.commands.arm.roller.RollForTime;
import org.frc1675.commands.arm.shoulder.SetShoulder;

/**
 *
 * @author Tony
 */
public class ShootFromStoppedAuton extends CommandGroup {

    public ShootFromStoppedAuton() {
        addParallel(new ShiftLow());
        addSequential(new PostShoot());
        addSequential(new RollForTime(RobotMap.SUCK_TIME_FOR_BALL_ON_TOP, true));
        addParallel(new SetShoulder(RobotMap.STATIC_FORWARD_SHOT_ANGLE));
        addSequential(new Wait(1.0));
        addSequential(new Shoot());
        addParallel(new PostShoot());
        addSequential(new DriveForTime(RobotMap.TIME_TO_REACH_SHOOT , 1.0));
        addSequential(new DriveForTime((RobotMap.TIME_TO_REACH_SHOOT + RobotMap.EXTRA_TIME_TO_DRIVE_BACK), -1.0));



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
