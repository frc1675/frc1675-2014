/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.autonomous.oneball;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.RobotMap;
import org.frc1675.commands.autonomous.DriveForTime;
import org.frc1675.commands.drive.ShiftLow;
import org.frc1675.commands.Wait;
import org.frc1675.commands.arm.roller.RollForTime;
import org.frc1675.commands.arm.shoulder.SetShoulderAuton;
import org.frc1675.commands.arm.shoulder.StopShoulder;

/**
 * This runs into the low goal and spits a ball in it. Useful for if our
 * shooter breaks.
 *
 * @author Tony
 */
public class LowGoalTime extends CommandGroup {

    public LowGoalTime() {
        addParallel(new ShiftLow());
        addParallel(new SetShoulderAuton((RobotMap.STARTING_ANGLE + RobotMap.STATIC_FORWARD_SHOT_ANGLE) / 2));
        addSequential(new DriveForTime(3, 1));
        addParallel(new StopShoulder());
        addSequential(new Wait(2));
        addSequential(new RollForTime(2, false));
        addSequential(new DriveForTime(3, -1));
    }
}
