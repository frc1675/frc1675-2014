/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.arm.shoulder;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.RobotMap;

/**
 *
 * @author Tony
 */
public class ShoulderOnTargetTest extends CommandGroup {
    
    public ShoulderOnTargetTest() {
        addParallel(new SetShoulder(RobotMap.BACKWARD_SHOOT_ANGLE));
        addSequential(new ShoulderOnTarget());
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
