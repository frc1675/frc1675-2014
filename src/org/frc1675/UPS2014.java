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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
 */
public class UPS2014 extends IterativeRobot {

    public static int twoBallFirstAngle = RobotMap.DashboardDefaults.TWO_BALL_FIRST_ANGLE;
    public static int twoBallSecondAngle = RobotMap.DashboardDefaults.TWO_BALL_SECOND_ANGLE;
    public static double twoBallDrivePower = RobotMap.DashboardDefaults.TWO_BALL_DRIVE_POWER;
    public static double twoBallDriveTimeBeforeShooting = RobotMap.DashboardDefaults.TWO_BALL_DRIVE_TIME_BEFORE_SHOOTING;
    public static int oneBallAngle = RobotMap.DashboardDefaults.ONE_BALL_ANGLE;
    public static double oneBallPower = RobotMap.DashboardDefaults.ONE_BALL_DRIVE_POWER;
    public static int forwardAngle = RobotMap.DashboardDefaults.FORWARD_SHOOT_ANGLE;
    public static int backwardAngle = RobotMap.DashboardDefaults.BACKWARD_SHOOT_ANGLE;

    Command autonomousCommand;
    public static NetworkTable table;
    Solenoid lights = new Solenoid(RobotMap.LIGHTS);

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        lights.set(true);
        table = NetworkTable.getTable("dataTable");
        SmartDashboard.putBoolean("Shoulder Is on target", false);
        SmartDashboard.putNumber("ShoulderP", RobotMap.SHOULDER_P);
        SmartDashboard.putNumber("ShoulderI", RobotMap.SHOULDER_I);
        SmartDashboard.putNumber("ShoulderD", RobotMap.SHOULDER_D);
        SmartDashboard.putNumber("First Ball Angle", RobotMap.DashboardDefaults.TWO_BALL_FIRST_ANGLE);
        SmartDashboard.putNumber("Second Ball Angle", RobotMap.DashboardDefaults.TWO_BALL_SECOND_ANGLE);
        SmartDashboard.putNumber("Two Ball Drive Power", RobotMap.DashboardDefaults.TWO_BALL_DRIVE_POWER);
        SmartDashboard.putNumber("Two Ball Drive Time Before Shooting", RobotMap.DashboardDefaults.TWO_BALL_DRIVE_TIME_BEFORE_SHOOTING);
        SmartDashboard.putNumber("One Ball Angle", RobotMap.DashboardDefaults.ONE_BALL_ANGLE);
        SmartDashboard.putNumber("Forward Shoot Angle", RobotMap.DashboardDefaults.FORWARD_SHOOT_ANGLE);
        SmartDashboard.putNumber("Backward Shoot Angle", RobotMap.DashboardDefaults.BACKWARD_SHOOT_ANGLE);
        SmartDashboard.putNumber("One Ball Drive Power", RobotMap.DashboardDefaults.ONE_BALL_DRIVE_POWER);
        SmartDashboard.putBoolean("Two Ball?", false);
        //autonomousCommand = new BabbysFirstAuton();
        autonomousCommand = new ZeroBallAuton();
        //autonomousCommand = new ShootFromStoppedAuton();
        //autonomousCommand = new OneBallTime();
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
        System.out.println(SmartDashboard.getBoolean("Two Ball?"));
        if (SmartDashboard.getBoolean("Two Ball?")) {
            twoBallFirstAngle = (int) SmartDashboard.getNumber("First Ball Angle", RobotMap.DashboardDefaults.TWO_BALL_FIRST_ANGLE);
            twoBallSecondAngle = (int) SmartDashboard.getNumber("Second Ball Angle", RobotMap.DashboardDefaults.TWO_BALL_SECOND_ANGLE);
            twoBallDrivePower = SmartDashboard.getNumber("Two Ball Drive Power", RobotMap.DashboardDefaults.TWO_BALL_DRIVE_POWER);
            twoBallDriveTimeBeforeShooting = SmartDashboard.getNumber("Two Ball Drive Time Before Shooting", RobotMap.DashboardDefaults.TWO_BALL_DRIVE_TIME_BEFORE_SHOOTING);
            autonomousCommand = new TwoBallHighTensionAuton();
        } else {
            oneBallAngle = (int) SmartDashboard.getNumber("One Ball Angle", RobotMap.DashboardDefaults.ONE_BALL_ANGLE);
            oneBallPower = SmartDashboard.getNumber("One Ball Drive Power", RobotMap.DashboardDefaults.ONE_BALL_DRIVE_POWER);
            autonomousCommand = new OneBallTime();
        }
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
        CommandBase.setShoulderAngleFromDashboard((int) SmartDashboard.getNumber("Forward Shoot Angle", RobotMap.DashboardDefaults.FORWARD_SHOOT_ANGLE),
                (int) SmartDashboard.getNumber("Backward Shoot Angle", RobotMap.DashboardDefaults.BACKWARD_SHOOT_ANGLE));
        Scheduler.getInstance().removeAll();
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
