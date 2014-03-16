/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.RobotMap;
import org.frc1675.commands.DriveForTime;
import org.frc1675.commands.PostShoot;
import org.frc1675.commands.ShiftLow;
import org.frc1675.commands.Shoot;
import org.frc1675.commands.Wait;
import org.frc1675.commands.arm.roller.RollerIntake;
import org.frc1675.commands.arm.roller.RollerStop;
import org.frc1675.commands.arm.shoulder.SetShoulder;
import org.frc1675.commands.arm.shoulder.SetShoulderToPickup;

/**
 * This auton mode should be used for shooting two balls into a goal when we
 * don't have encoders. We need encoders. This ain't gonna work.
 *
 * @author Tony
 */
public class TwoBallForTime extends CommandGroup {

    TwoBallForTime() {
        addParallel(new ShiftLow());
        addParallel(new SetShoulder(RobotMap.BACKWARD_SHOOT_ANGLE));
        addParallel(new DriveForTime(RobotMap.TIME_TO_REACH_SHOOT + RobotMap.EXTRA_TIME_TO_DRIVE_FORWARD, -1.0));
        addSequential(new Wait(RobotMap.TIME_TO_REACH_SHOOT));
        addSequential(new Shoot());
        addParallel(new PostShoot());
        addParallel(new RollerIntake());
        addParallel(new SetShoulderToPickup());
        addSequential(new DriveForTime(RobotMap.TIME_TO_REACH_SHOOT + RobotMap.EXTRA_TIME_TO_DRIVE_FORWARD, 1.0));
        addSequential(new Wait(RobotMap.TIME_TO_PICK_UP_BALL));
        addParallel(new RollerStop());
        addParallel(new SetShoulder(RobotMap.BACKWARD_SHOOT_ANGLE));
        addParallel(new DriveForTime(RobotMap.TIME_TO_REACH_SHOOT + RobotMap.EXTRA_TIME_TO_DRIVE_FORWARD, -1.0));
        addSequential(new Wait(RobotMap.TIME_TO_REACH_SHOOT));
        addSequential(new Shoot());
        addParallel(new PostShoot());
        addParallel(new SetShoulderToPickup());
        addParallel(new RollerIntake());
        addSequential(new DriveForTime(RobotMap.TIME_TO_REACH_SHOOT + RobotMap.EXTRA_TIME_TO_DRIVE_BACK, 1.0));
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
