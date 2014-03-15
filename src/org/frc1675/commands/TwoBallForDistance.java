/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.RobotMap;
import org.frc1675.commands.arm.roller.RollerIntake;
import org.frc1675.commands.arm.roller.RollerStop;
import org.frc1675.commands.arm.shoulder.SetShoulder;
import org.frc1675.commands.arm.shoulder.SetShoulderToPickup;

/**
 *
 * @author Use this for a two ball autonomous.  No guarantees!
 */
public class TwoBallForDistance extends CommandGroup {

    public TwoBallForDistance() {
        addParallel(new ShiftLow());
        addParallel(new SetShoulder(RobotMap.BACKWARD_SHOOT_ANGLE));
        addSequential(new DriveForDistance(-RobotMap.DISTANCE_TO_SHOT));
        addSequential(new Shoot());
        addParallel(new PostShoot());
        addParallel(new RollerIntake());
        addParallel(new SetShoulderToPickup());
        addSequential(new DriveForDistance((RobotMap.DISTANCE_EXTRA_TO_DRIVE_BACK + RobotMap.DISTANCE_TO_SHOT)));
        addSequential(new Wait(RobotMap.TIME_TO_PICK_UP_BALL));
        addParallel(new RollerStop());
        addSequential(new DriveForDistance(-(RobotMap.DISTANCE_EXTRA_TO_DRIVE_BACK + RobotMap.DISTANCE_TO_SHOT)));
        addSequential(new Shoot());
        addParallel(new PostShoot());
        addParallel(new SetShoulderToPickup());
        addSequential(new DriveForDistance(RobotMap.DISTANCE_TO_SHOT + RobotMap.DISTANCE_EXTRA_TO_DRIVE_BACK));
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
