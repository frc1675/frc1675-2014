/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.oi;

import org.frc1675.oi.OI;

/**
 * This is suppoesd to make it so buttons do different things in test mode on
 * driver station. For debugging. Is unimplemented.
 *
 * @author Elise
 */
public class TestOI extends OI {

    public TestOI() {
        XBoxControllerButtons.driverB.whenPressed(null);
    }


    
    
    
    
}
