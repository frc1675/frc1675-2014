/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.autonomous.oneball;

import org.frc1675.commands.autonomous.NetworkCheckForTarget;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.RobotMap;
import org.frc1675.commands.DriveForDistance;
import org.frc1675.commands.PostShoot;
import org.frc1675.commands.ShiftLow;
import org.frc1675.commands.Shoot;
import org.frc1675.commands.Wait;
import org.frc1675.commands.arm.roller.RollerIntake;
import org.frc1675.commands.arm.shoulder.SetShoulder;
import org.frc1675.commands.arm.shoulder.SetShoulderToPickup;

/**
 * The shooter will wait for the target to be seen by the network table to shoot.  
 *
 * @author Tony
 */
public class NetworkHotAuton extends CommandGroup {

    public NetworkHotAuton() {
        addSequential(new ShiftLow());
        addSequential(new Wait(.25));
        addParallel(new SetShoulder(RobotMap.STATIC_FORWARD_SHOT_ANGLE));
        addParallel(new DriveForDistance(RobotMap.DISTANCE_TO_SHOT));
        addSequential(new NetworkCheckForTarget());
        addSequential(new Shoot());
        addParallel(new PostShoot());
        addParallel(new DriveForDistance(-(RobotMap.DISTANCE_TO_SHOT + RobotMap.DISTANCE_EXTRA_TO_DRIVE_BACK)));
        addParallel(new SetShoulderToPickup());
        addParallel(new RollerIntake());
    }
}
