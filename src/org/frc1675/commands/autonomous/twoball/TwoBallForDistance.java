/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.autonomous.twoball;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.RobotMap;
import org.frc1675.commands.DriveForDistance;
import org.frc1675.commands.PostShoot;
import org.frc1675.commands.ShiftLow;
import org.frc1675.commands.Shoot;
import org.frc1675.commands.Wait;
import org.frc1675.commands.arm.roller.RollerIntake;
import org.frc1675.commands.arm.roller.RollerStop;
import org.frc1675.commands.arm.shoulder.SetShoulder;
import org.frc1675.commands.arm.shoulder.SetShoulderToPickup;

/**
 *
 * Use this for a two ball autonomous. This was the first one we wrote, and it
 * requires encoders that we don't have.
 *
 * @author Tony
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
    }
}
