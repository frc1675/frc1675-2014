/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.autonomous.oneball;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.RobotMap;
import org.frc1675.commands.PostShoot;
import org.frc1675.commands.ShiftLow;
import org.frc1675.commands.arm.puncher.PuncherGoToLimit;
import org.frc1675.commands.arm.roller.RollForTime;

/**
 * This auton does not move.  Ever.  Especially not before shooting.
 * @author Tony
 */
public class BallOnTopAuton extends CommandGroup {

    public BallOnTopAuton() {
        addSequential(new ShiftLow());
        addSequential(new PostShoot());
        addSequential(new RollForTime(RobotMap.SUCK_TIME_FOR_BALL_ON_TOP, true));
        addSequential(new OneBallTime());
    }
}
