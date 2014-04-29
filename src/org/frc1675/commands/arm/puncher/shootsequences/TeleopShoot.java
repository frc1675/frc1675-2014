/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.arm.puncher.shootsequences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * This command group combines the Shoot and PostShoot commands for teleop
 * control.
 *
 * @author Tony
 */
public class TeleopShoot extends CommandGroup {

    public TeleopShoot() {
        addSequential(new Shoot());
        addSequential(new PostShoot());
    }
}
