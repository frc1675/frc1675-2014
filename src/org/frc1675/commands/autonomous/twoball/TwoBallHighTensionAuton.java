/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.autonomous.twoball;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.frc1675.RobotMap;
import org.frc1675.commands.autonomous.DriveForTime;
import org.frc1675.commands.arm.puncher.shootsequences.PostShoot;
import org.frc1675.commands.drive.ShiftLow;
import org.frc1675.commands.arm.puncher.shootsequences.Shoot;
import org.frc1675.commands.Wait;
import org.frc1675.commands.arm.roller.RollerIntake;
import org.frc1675.commands.arm.roller.RollerStop;
import org.frc1675.commands.arm.shoulder.SetShoulderAuton;
import org.frc1675.commands.arm.shoulder.SetShoulderToPickup;
import org.frc1675.commands.arm.shoulder.ShoulderOnTarget;

/**
 * This is the two ball for when we have enough tension to shoot from the middle
 * zone. 
 *
 * @author Tony
 */
public class TwoBallHighTensionAuton extends CommandGroup {

    private static final double TIME_TO_SUCK_BALL_FROM_TOP = 1.0;
    private static final double TIME_FROM_START_TO_SHOOTING_ANGLE = 1.0;
    private static final double TIME_TO_DRIVE_TO_PICKUP = .9;    
    private static final double PICKUP_DRIVE_POWER = .5;
    private static final double TIME_BEFORE_SHOOT = 1.5;
    
    private static final double TIME_FROM_HOME_TO_SHOOTING_ANGLE =  2.0;
    private static final double SECOND_SHOT_DRIVE_POWER = -.7;
    private static final int FIRST_BALL_ANGLE = 70;
    private static final int SECOND_BALL_ANGLE = 72;
      
    
    public TwoBallHighTensionAuton() {
        addParallel(new ShiftLow());
        addParallel(new RollerIntake());
        addParallel(new PostShoot());
        addSequential(new Wait(TIME_TO_SUCK_BALL_FROM_TOP));
        addParallel(new SetShoulderAuton(FIRST_BALL_ANGLE));
        addSequential(new ShoulderOnTarget());
        addParallel(new RollerStop());
        addSequential(new Shoot());
        addParallel(new PostShoot());
        addParallel(new RollerIntake());
        addParallel(new SetShoulderToPickup());
        addSequential(new Wait(1.9));
        addSequential(new DriveForTime(TIME_TO_DRIVE_TO_PICKUP, PICKUP_DRIVE_POWER));
        addSequential(new Wait(RobotMap.TIME_TO_PICK_UP_BALL));
        addParallel(new DriveForTime(RobotMap.TIME_TO_REACH_SHOOT + RobotMap.EXTRA_TIME_TO_DRIVE_FORWARD + .2, SECOND_SHOT_DRIVE_POWER));
        addParallel(new SetShoulderAuton(SECOND_BALL_ANGLE));
        addSequential(new Wait(TIME_FROM_HOME_TO_SHOOTING_ANGLE));
        addParallel(new RollerStop());
        addSequential(new Shoot());
        addParallel(new PostShoot());
        addParallel(new SetShoulderToPickup());
        addParallel(new RollerIntake());
    }
}
