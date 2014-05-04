/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.autonomous.oneball;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.RobotMap;
import org.frc1675.commands.autonomous.DriveForDistance;
import org.frc1675.commands.arm.puncher.shootsequences.PostShoot;
import org.frc1675.commands.drive.ShiftLow;
import org.frc1675.commands.arm.puncher.shootsequences.Shoot;
import org.frc1675.commands.arm.roller.RollerIntake;
import org.frc1675.commands.arm.shoulder.SetShoulder;
import org.frc1675.commands.arm.shoulder.SetShoulderToPickup;

/**
 * This autonomous mode uses encoders and PID to shoot one ball and drive back
 * to the middle zone.
 *
 * @author Tony
 */
public class OneBallDistance extends CommandGroup {

    public OneBallDistance() {
        addParallel(new ShiftLow());
        addParallel(new SetShoulder(RobotMap.FORWARD_SHOOT_ANGLE));
        addSequential(new DriveForDistance(RobotMap.DISTANCE_TO_SHOT));
        addSequential(new Shoot());
        addParallel(new PostShoot());
        addParallel(new DriveForDistance(-(RobotMap.DISTANCE_TO_SHOT + RobotMap.DISTANCE_EXTRA_TO_DRIVE_BACK)));
        addParallel(new SetShoulderToPickup());
        addParallel(new RollerIntake());
    }
}
