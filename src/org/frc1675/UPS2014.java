/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.frc1675;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.frc1675.commands.BabbysFirstAuton;
import org.frc1675.commands.CommandBase;
import org.frc1675.commands.GoalColdAtFirstAuton;
import org.frc1675.commands.NetworkHotAuton;
import org.frc1675.commands.MakeCompressorWork;
import org.frc1675.commands.OneBallDistance;
import org.frc1675.commands.OneBallTime;
import org.frc1675.commands.TwoBallForTime;
import org.frc1675.commands.arm.puncher.PuncherGoToLimit;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class UPS2014 extends IterativeRobot {

//    Command autonomousCommand;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    Command autonomousCommand;
    public static NetworkTable table;

    public void robotInit() {
        table = NetworkTable.getTable("dataTable");

        //autonomousCommand = new BabbysFirstAuton();
        //autonomousCommand = new OneBallTime();
        //autonomousCommand = new OneBallDistance();
        //autonomousCommand = new TwoBallForTime();
        //autonomousCommand = new NetworkHotAuton();
        autonomousCommand = new BabbysFirstAuton();
        //For Hot
        CommandBase.init();

    }

    public void autonomousInit() {
        //For hot
        if (CommandBase.vision.isHorizontalTarget()) {
            System.out.println("HOT");
            autonomousCommand = new OneBallTime();
        } else {
            autonomousCommand = new GoalColdAtFirstAuton();
            System.out.println("COLD");
        }

        autonomousCommand.start();
//        autonomousCommand.start();
        // schedule the autonomous command (example)
//        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomousCommand.cancel();

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }

    public void disabledInit() {
        Scheduler.getInstance().removeAll();
    }
}
