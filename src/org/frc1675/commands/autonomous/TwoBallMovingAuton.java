
 /*/ To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.autonomous;

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
import org.frc1675.commands.arm.shoulder.ShoulderOnTarget;

/**
 *
 * @author Tony
 */
public class TwoBallMovingAuton extends CommandGroup {
    private static final double TIME_TO_SUCK_BALL_FROM_TOP = 1; //+.7
    private static final double TIME_FROM_START_TO_SHOOTING_ANGLE = 1.0;
    private static final double TIME_FROM_HOME_TO_SHOOTING_ANGLE = 2.0;
    private static final double TIME_TO_DRIVE_TO_PICKUP = 1.2; //+.6
    private static final double PICKUP_DRIVE_POWER = .5;
    public TwoBallMovingAuton() {
        addParallel(new ShootAfterTime(9.5));
        addParallel(new ShiftLow());
        addParallel(new RollerIntake());
        addParallel(new PostShoot());
        addSequential(new Wait(TIME_TO_SUCK_BALL_FROM_TOP));
        addParallel(new SetShoulderAuton(RobotMap.BACKWARD_TWO_BALL_ANGLE +3));
        addSequential(new Wait(TIME_FROM_START_TO_SHOOTING_ANGLE/2));
        addParallel(new DriveForTime(TIME_FROM_START_TO_SHOOTING_ANGLE/2+.4, -1));     
        addSequential(new Wait(TIME_FROM_START_TO_SHOOTING_ANGLE/2));
        addParallel(new RollerStop());
        addSequential(new Shoot());
        addParallel(new PostShoot());
        addParallel(new RollerIntake());
        addParallel(new SetShoulderToPickup());
        addSequential(new Wait(.5));
        addSequential(new DriveForTime(TIME_TO_DRIVE_TO_PICKUP , .75));
        addSequential(new Wait(RobotMap.TIME_TO_PICK_UP_BALL));
        addParallel(new DriveForTime(RobotMap.TIME_TO_REACH_SHOOT + RobotMap.EXTRA_TIME_TO_DRIVE_FORWARD + 1, -.6));
        addParallel(new SetShoulderAuton(RobotMap.BACKWARD_TWO_BALL_ANGLE+4));

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

