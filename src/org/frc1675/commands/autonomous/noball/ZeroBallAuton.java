/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.autonomous.noball;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.commands.DriveForTime;
import org.frc1675.commands.PostShoot;

/**
 * Our shooter was working very poorly at Milwaukee. We wrote this so our
 * partner could do a two ball and we could get out of the way and mobility.
 *
 * @author Tony
 */
public class ZeroBallAuton extends CommandGroup {

    public ZeroBallAuton() {
        addSequential(new DriveForTime(2, 1));
        addSequential(new PostShoot());
    }
}
