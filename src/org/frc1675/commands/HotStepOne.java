/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.RobotMap;
import org.frc1675.commands.arm.shoulder.SetShoulder;

/**
 * The shooter won't shoot if there is no target. It will shoot if there is one.
 * Run it for the first five seconds of auton.
 *
 * @author Tony
 */
public class HotStepOne extends CommandGroup {

    public HotStepOne() {
        addSequential(new ShiftLow());
        addSequential(new Wait(.25));
        addParallel(new SetShoulder(RobotMap.FORWARD_SHOOT_ANGLE));
        addParallel(new DriveForDistance(RobotMap.DISTANCE_TO_SHOT));
        addSequential(new CheckForTarget());
        addSequential(new Shoot());

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
