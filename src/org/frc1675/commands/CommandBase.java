package org.frc1675.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.frc1675.oi.OI;
import org.frc1675.oi.TestOI;
import org.frc1675.RobotMap;
import org.frc1675.subsystems.arm.Jaw;
import org.frc1675.subsystems.arm.Puncher;
import org.frc1675.subsystems.arm.Roller;
import org.frc1675.subsystems.arm.Shoulder;
import org.frc1675.subsystems.CompressorSystem;
import org.frc1675.subsystems.DriveBase;
import org.frc1675.subsystems.NetworkTracking;
import org.frc1675.subsystems.Shifter;
import org.frc1675.subsystems.VisionTracking;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use
 * CommandBase.exampleSubsystem
 */
public abstract class CommandBase extends Command {

    public static OI oi;

    // Create a single static instance of all of the subsystems
    public static Jaw jaw = new Jaw();
    public static Puncher puncher = new Puncher();
    public static Roller rollerClaw = new Roller();
    public static Shoulder shoulder = new Shoulder(RobotMap.SHOULDER_P, RobotMap.SHOULDER_I, RobotMap.SHOULDER_D);
    public static CompressorSystem compressor = new CompressorSystem();
    public static DriveBase driveBase = new DriveBase(RobotMap.DRIVE_ENCODER_P, RobotMap.DRIVE_ENCODER_I, RobotMap.DRIVE_ENCODER_D); 
    public static Shifter shifter = new Shifter();

    public static NetworkTracking network = new NetworkTracking();
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        createCompetitionOI(); 
    }
    
    public static void createCompetitionOI() {
        oi = new OI();
    }
    
    public static void createTestOI() {
        oi = new TestOI(); 
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
    
}
