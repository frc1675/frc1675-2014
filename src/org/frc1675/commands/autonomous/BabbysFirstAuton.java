/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.commands.DriveForTime;
import org.frc1675.commands.Wait;

/**
 *
 * @author Tony
 *
 * This auton drives forward and backwards. It works!
 */
public class BabbysFirstAuton extends CommandGroup {

    public BabbysFirstAuton() {
        addSequential(new DriveForTime(2, 1.0));
        addSequential(new Wait(2));
        addSequential(new DriveForTime(2, -1.0));
    }
}
