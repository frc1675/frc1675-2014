/* AccelerationSpeedController
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.frc1675.utils;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author michael
 */
public class AccelerationSpeedController{
    
    private final SpeedController speedController;
    
    private static double msPerLoop = 20.0;       

    double threshold;
    double deadzone;
    double rampTime;
    
    double previousPower;
    double accelerationDebt;
    
    double initialPower;
    double difference;
    
    boolean inAccelerationSession;    
    boolean endOfAccelerationSession;
    
    public AccelerationSpeedController(SpeedController speedController){ 
        this.speedController = speedController;
                
        threshold = 0.10; //got this from xbox controller
        deadzone = 0.27;
        
        rampTime = 160;
        //rampTime affects the amount of time it takes to ramp, but does not directly correlate.
    }
    
    public void set(double speed) {
        difference = speed - previousPower;
        accelerationDebt = accelerationDebt + difference; //AccelerationDebts has a maximum size?
        
        double motorPower;        
        if (Math.abs(accelerationDebt) < threshold) {                        
            initialPower = 0;
            accelerationDebt = 0;
            inAccelerationSession = false;
            endOfAccelerationSession = false;
            motorPower = speed;            
            SmartDashboard.putBoolean("Accelerating?", inAccelerationSession);
        }else {
            SmartDashboard.putBoolean("Accelerating?", inAccelerationSession);            
            if(!inAccelerationSession){
                inAccelerationSession=true;
                initialPower = previousPower;                            
            }            
            double loopsToRamp = Math.ceil(rampTime * (1/msPerLoop));            
            double increment = 1/loopsToRamp * accelerationDebt;
            motorPower = initialPower + increment;
            initialPower = motorPower;
            accelerationDebt = accelerationDebt - increment;
            
            SmartDashboard.putNumber("Increment", increment);                                    
        }
        previousPower = speed;        
        SmartDashboard.putNumber("AccelerationDebt", accelerationDebt);
        SmartDashboard.putNumber("MotorPower", motorPower);
        speedController.set(motorPower);
    }
    
    
    
}
