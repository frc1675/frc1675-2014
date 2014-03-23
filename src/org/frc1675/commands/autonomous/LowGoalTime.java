/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.RobotMap;
import org.frc1675.commands.DriveForTime;
import org.frc1675.commands.ShiftLow;
import org.frc1675.commands.Wait;
import org.frc1675.commands.arm.roller.RollForTime;
import org.frc1675.commands.arm.shoulder.SetShoulder;
import org.frc1675.commands.arm.shoulder.StopShoulder;

/**
 *
 * @author Tony
 */
public class LowGoalTime extends CommandGroup {
    
    public LowGoalTime() {
        addParallel(new ShiftLow());
        addParallel(new SetShoulder((RobotMap.STARTING_ANGLE + RobotMap.STATIC_FORWARD_SHOT_ANGLE)/2));
        addSequential(new DriveForTime(4,1));
        addParallel(new StopShoulder());
        addSequential(new Wait(2));
        addSequential(new RollForTime(2, false));
        addSequential(new DriveForTime(4, -1));
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
