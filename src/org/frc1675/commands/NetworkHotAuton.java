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
 * The shooter will wait for the target to be seen to shoot.  
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
