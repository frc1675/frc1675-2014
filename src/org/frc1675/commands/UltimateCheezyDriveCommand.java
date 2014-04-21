/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

/**
 * This class does a whole lot of complex math to make driving feel smoother.
 * Set it as default command, and its control should be the same as CheesyDrive,
 * just better. Based off of 254's implementation.
 * 
 * This is designed to be a default subsystem command. It will not stop unless
 * interrupted.
 *
 * @author Tony
 */
public class UltimateCheezyDriveCommand extends CommandBase {

    private double steeringNonLinearity;
    private int numberOfCurveOperations;
    private double previousSteeringPosition;
    private double counterSteerAccumulator;

    public UltimateCheezyDriveCommand(double steeringNonLinearity, int numOfCurveOperations) {
        requires(driveBase);
        this.steeringNonLinearity = steeringNonLinearity;
        this.numberOfCurveOperations = numOfCurveOperations;
        this.previousSteeringPosition = 0.0;
        this.counterSteerAccumulator = 0.0;
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double throttlePosition = oi.getDriverLeftY();
        double steeringPosition = oi.getDriverRightX();
        boolean doesDriverWantQuickTurn = oi.getDriverTrigger();

        double curvySteeringPosition = makeCurvy(steeringPosition);
        double scaledDisplacement = calculateDisplacementConstantUsedForGraphShifting(steeringPosition);
        previousSteeringPosition = steeringPosition;
        double shiftedCurvySteeringPosition = curvySteeringPosition + scaledDisplacement;

        double angularPower;
        if (doesDriverWantQuickTurn) {
            calculateCounterSteerAccumulator(throttlePosition, shiftedCurvySteeringPosition);
            angularPower = shiftedCurvySteeringPosition;
        } else {
            angularPower = calculateAngularPower(throttlePosition, shiftedCurvySteeringPosition);
        }
        double linearPower = throttlePosition;
        double leftPower = linearPower - angularPower;
        double rightPower = linearPower + angularPower;
        if (doesDriverWantQuickTurn) {
            double surplus;
            if (leftPower > 1) {
                surplus = leftPower - 1;
                rightPower = rightPower - surplus;
            } else if (rightPower > 1) {
                surplus = rightPower - 1;
                leftPower = leftPower - surplus;
            } else if (leftPower < -1) {
                surplus = -1 - leftPower;
                rightPower = rightPower + surplus;
            } else if (rightPower < -1) {
                surplus = -1 - rightPower;
                leftPower = leftPower + surplus;
            }
        }
        driveBase.setLeftMotors(leftPower);
        driveBase.setRightMotors(rightPower);

    }

    private double makeCurvy(double steering) {
        for (int i = 0; i < numberOfCurveOperations; i++) {
            steering = Math.sin((getRadians(steering) * steeringNonLinearity) / (Math.sin(getRadians(1.0) * steeringNonLinearity)));
        }
        return steering;
    }

    private double getRadians(double radianRatio) {
        return ((Math.PI / 2.0) * radianRatio);
    }

    private double calculateDisplacementConstantUsedForGraphShifting(double steeringPosition) {
        double displacement = steeringPosition - previousSteeringPosition;
        double displacementSteeringScalar = determineDisplacementScalingScalar(steeringPosition, displacement);
        return (displacement * displacementSteeringScalar);
    }

    private void calculateCounterSteerAccumulator(double throttlePosition, double shiftedCurvySteeringPosition) {
        if (Math.abs(throttlePosition) < .2) {
            double alpha = .1;
            counterSteerAccumulator = (1 - alpha) * counterSteerAccumulator + (alpha * 5) * shiftedCurvySteeringPosition;
        }
    }

    private double calculateAngularPower(double throttlePosition, double shiftedCurvySteeringPosition) {
        double angularPower = Math.abs(throttlePosition) * shiftedCurvySteeringPosition * 0.75;
        angularPower = angularPower - counterSteerAccumulator;
        if (counterSteerAccumulator > 1) {
            counterSteerAccumulator -= 1;
        } else if (counterSteerAccumulator < -1) {
            counterSteerAccumulator += 1;
        } else {
            counterSteerAccumulator = 0;
        }
        return angularPower;
    }

    private double determineDisplacementScalingScalar(double steering, double displacement) {
        double displacementScalingScalar;
        if (steering * displacement > 0) {
            displacementScalingScalar = 2.5;
        } else {
            displacementScalingScalar = 4;
        }
        return displacementScalingScalar;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {

    }
}
