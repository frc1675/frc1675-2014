/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.RobotMap;
import org.frc1675.commands.arm.roller.RollerIntake;
import org.frc1675.commands.arm.shoulder.SetShoulder;
import org.frc1675.commands.arm.shoulder.SetShoulderToPickup;

/**
 * This autonomous mode uses timers to shoot one ball and drive back to the
 * middle zone.
 *
 * @author Tony
 */
public class OneBallTime extends CommandGroup {

    private static final double TIME_TO_REACH_SHOOT = 1.5;
    private static final double EXTRA_TIME_TO_DRIVE_BACK = .5;

    public OneBallTime() {
        addParallel(new ShiftLow());
        addSequential(new SetShoulder(RobotMap.FORWARD_SHOOT_ANGLE));
        addSequential(new DriveForTime(TIME_TO_REACH_SHOOT, 1.0));
        addSequential(new Shoot());
        addParallel(new SetShoulderToPickup());
        addParallel(new RollerIntake());
        addParallel(new PostShoot());
        addParallel(new DriveForTime((TIME_TO_REACH_SHOOT + EXTRA_TIME_TO_DRIVE_BACK), -1.0));

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
