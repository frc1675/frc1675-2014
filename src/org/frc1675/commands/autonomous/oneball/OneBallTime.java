/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.autonomous.oneball;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.RobotMap;
import org.frc1675.commands.DriveForTime;
import org.frc1675.commands.PostShoot;
import org.frc1675.commands.ShiftLow;
import org.frc1675.commands.Shoot;
import org.frc1675.commands.Wait;
import org.frc1675.commands.arm.roller.RollForTime;
import org.frc1675.commands.arm.roller.RollerIntake;
import org.frc1675.commands.arm.roller.RollerStop;
import org.frc1675.commands.arm.shoulder.SetShoulder;
import org.frc1675.commands.arm.shoulder.SetShoulderAuton;
import org.frc1675.commands.arm.shoulder.SetShoulderToPickup;

/**
 * This autonomous mode uses timers to shoot one ball and drive back to the
 * middle zone.
 *
 * @author Tony
 */
public class OneBallTime extends CommandGroup {
    private double TIME_BEFORE_SHOULDER = .4;
    public OneBallTime() {
        addParallel(new DriveForTime(10000, 0));  //This is so it cancels any weird drift from previous controller values.  It gets cancelled, so I just made it really long time
        addParallel(new PostShoot());
        addParallel(new RollerIntake());
        addSequential(new Wait(1.2));
        addParallel(new ShiftLow());
        addParallel(new DriveForTime(RobotMap.TIME_TO_REACH_SHOOT + RobotMap.EXTRA_TIME_TO_DRIVE_FORWARD, 1.0));
        addParallel(new Wait(TIME_BEFORE_SHOULDER));
        addParallel(new SetShoulderAuton(RobotMap.STATIC_FORWARD_SHOT_ANGLE));
        addSequential(new Wait(RobotMap.TIME_TO_REACH_SHOOT-TIME_BEFORE_SHOULDER));
        addParallel(new RollerStop());
        addSequential(new Shoot());
        addParallel(new SetShoulderToPickup());
        addParallel(new RollerIntake());
        addParallel(new PostShoot());
        addParallel(new DriveForTime((RobotMap.TIME_TO_REACH_SHOOT + RobotMap.EXTRA_TIME_TO_DRIVE_BACK), -1.0));
    }
}
