/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.frc1675;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.frc1675.oi.XBoxControllerButtons;
import org.frc1675.commands.autonomous.noball.BabbysFirstAuton;
import org.frc1675.commands.CommandBase;
import org.frc1675.commands.autonomous.oneball.GoalColdAtFirstAuton;
import org.frc1675.commands.autonomous.oneball.NetworkHotAuton;
import org.frc1675.commands.MakeCompressorWork;
import org.frc1675.commands.autonomous.oneball.LowGoalTime;
import org.frc1675.commands.autonomous.oneball.OneBallDistance;
import org.frc1675.commands.autonomous.oneball.OneBallTime;
import org.frc1675.commands.autonomous.oneball.ShootFromStoppedAuton;
import org.frc1675.commands.autonomous.twoball.TwoBallHighTensionAuton;
import org.frc1675.commands.autonomous.noball.ZeroBallAuton;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 *
 * @author SmartPersonAtWPI
 */
public class UPS2014 extends IterativeRobot {

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    Command autonomousCommand;
    public static NetworkTable table;
    Solenoid lights = new Solenoid(RobotMap.LIGHTS);

    public void robotInit() {
        lights.set(true);
        table = NetworkTable.getTable("dataTable");

        //autonomousCommand = new BabbysFirstAuton();
        //autonomousCommand = new ZeroBallAuton();
        //autonomousCommand = new ShootFromStoppedAuton();
        autonomousCommand = new OneBallTime();
        //autonomousCommand = new LowGoalTime();
        //autonomousCommand = new TwoBall();
        //autonomousCommand = new TwoBallHighTensionAuton();

        XBoxControllerButtons.init();
        CommandBase.init();

    }

    public void autonomousInit() {
        //For hot
//        if (CommandBase.vision.isHorizontalTarget()) {
//            System.out.println("HOT");
//        } else {
//            autonomousCommand = new GoalColdAtFirstAuton();
//            System.out.println("COLD");
//        }

        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    public void testInit() {
        CommandBase.createTestOI();
        
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
