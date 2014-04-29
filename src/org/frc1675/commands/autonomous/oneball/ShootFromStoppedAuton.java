/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.autonomous.oneball;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.RobotMap;
import org.frc1675.commands.autonomous.DriveForTime;
import org.frc1675.commands.arm.puncher.shootsequences.PostShoot;
import org.frc1675.commands.drive.ShiftLow;
import org.frc1675.commands.arm.puncher.shootsequences.Shoot;
import org.frc1675.commands.Wait;
import org.frc1675.commands.arm.roller.RollForTime;
import org.frc1675.commands.arm.shoulder.SetShoulder;

/**
 * This is the first half of 2 ball Auton. It also drives forward and back. We
 * used it for testing.
 *
 * @author Tony
 */
public class ShootFromStoppedAuton extends CommandGroup {

    public ShootFromStoppedAuton() {
        addParallel(new ShiftLow());
        addSequential(new PostShoot());
        addSequential(new RollForTime(RobotMap.SUCK_TIME_FOR_BALL_ON_TOP, true));
        addParallel(new SetShoulder(RobotMap.BACKWARD_TWO_BALL_ANGLE));
        addSequential(new Wait(1.0));
        addSequential(new Shoot());
        addParallel(new PostShoot());
        addSequential(new DriveForTime(RobotMap.TIME_TO_REACH_SHOOT, -1.0));
        addSequential(new DriveForTime((RobotMap.TIME_TO_REACH_SHOOT + RobotMap.EXTRA_TIME_TO_DRIVE_BACK), 1.0));
    }
}
