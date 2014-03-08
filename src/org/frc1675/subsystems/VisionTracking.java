/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVision.MeasurementType;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import edu.wpi.first.wpilibj.image.RGBImage;
import org.frc1675.UPS2014;

/**
 *
 * @author Alex
 */
public class VisionTracking extends Subsystem {

    private final int RED_LOW = 225;            // Should not have to change but if you do need to change follow steps below
    private final int RED_HIGH = 257;           // 1) Run code.
    private final int GREEN_LOW = 209;          // 2) Use FTP to get picture called ("Vtracking1.jpg)
    private final int GREEN_HIGH = 256;         // 3) Open picture with Paint and select color of rectangle
    private final int BLUE_LOW = 128;            // 4) Go to "More colors" in paint and click on selected colors
    private final int BLUE_HIGH = 178;           // 5) Change these values to match values in Paint
    private final int AREA_MINIMUM = 100;          // Filters out rectangles with smaller area
    private final int MAX_PARTICLES = 8;         // Dont change this!! (if you do, make it smaller).
    private final double VISION_TOLERANCE = .5;  //Change this to allow different shapes (ie. Not Perfect Rectanges)
    private CriteriaCollection cc;

    private final double VIEW_ANGLE = 49;		//Axis M1013  // Dont change
    private final int RECTANGULARITY_CONSTANT = 50;  // this is the percentage of how close to a rectange.
    private final double IDEAL_HORIZONTAL_RATIO = (4.0 / 23.5);// DONT change this.
    private final double IDEAL_VERTICAL_RATIO = (32.0 / 4.0);

    AxisCamera camera;

    public VisionTracking() {
        camera = AxisCamera.getInstance();  // get an instance of the camera
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public boolean isHorizontalTarget() {
        boolean targetFound = false;
        cc = new CriteriaCollection();      // create the criteria for the particle filter
        cc.addCriteria(MeasurementType.IMAQ_MT_AREA, AREA_MINIMUM, 65535, false);
        try {
            UPS2014.table.putString("Picture Analysis", "We tried!");
            System.out.println("Picture Analasys");
            targetFound = pictureAnalysis();
        } catch (AxisCameraException ex) {
            ex.printStackTrace();
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }
        return targetFound;

    }

    private boolean isVerticalTarget() { // dont use this calss
        boolean targetFound = false;
        cc = new CriteriaCollection();      // create the criteria for the particle filter
        cc.addCriteria(MeasurementType.IMAQ_MT_AREA, AREA_MINIMUM, 65535, false);
        try {
            targetFound = pictureAnalysis();
        } catch (AxisCameraException ex) {
            ex.printStackTrace();
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }
        return targetFound;
    }

    private boolean pictureAnalysis() throws AxisCameraException, NIVisionException {

        try {
            ColorImage image;                           // next 2 lines read image from flash on cRIO
            image = camera.getImage();
            image.write("/vTracking1.jpg");
            System.out.println("Image Got");
            image = new RGBImage("/vTracking1.jpg");		// get the sample image from the cRIO flash
            BinaryImage thresholdImage = image.thresholdRGB(RED_LOW, RED_HIGH, GREEN_LOW, GREEN_HIGH, BLUE_LOW, BLUE_HIGH); //change to Orange
            BinaryImage filteredImage = thresholdImage.particleFilter(cc);
            thresholdImage.write("/threshold.bmp");
            filteredImage.write("/filterImage.bmp");
            int numberOfParticles;
            numberOfParticles = filteredImage.getNumberParticles();
            filteredImage.getNumberParticles();
            System.out.println("Particles Numbers" + numberOfParticles);
            UPS2014.table.putNumber("Number of Particles", numberOfParticles);
            double rectangularity[] = new double[numberOfParticles];

            if (filteredImage.getNumberParticles() > 0) {

                for (int i = 0; i < MAX_PARTICLES && i < filteredImage.getNumberParticles(); i++) {
                    ParticleAnalysisReport report = filteredImage.getParticleAnalysisReport(i);
                    rectangularity[i] = scoreRectangularity(report);
                    System.out.println("rectangularity " + i + " : " + rectangularity[i]);
                    UPS2014.table.putString("Rectangularity: ", "rectangularity " + i + " : " + rectangularity[i]);
                }
                for (int i = 0; i < MAX_PARTICLES && i < filteredImage.getNumberParticles(); i++) {
                    if (rectangularity[i] > RECTANGULARITY_CONSTANT) {
                        ParticleAnalysisReport report = filteredImage.getParticleAnalysisReport(i);
                        int height = report.boundingRectHeight;
                        int width = report.boundingRectWidth;
                        double ratio = (double) height / width;
                        System.out.println(ratio);
                        if (Math.abs(ratio - IDEAL_HORIZONTAL_RATIO) < VISION_TOLERANCE) {
                            return true;
                        }
                    }
                }

            }
            return false;

        } catch (NIVisionException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    double scoreRectangularity(ParticleAnalysisReport report) {
        if (report.boundingRectWidth * report.boundingRectHeight != 0) {
            return 100.0 * report.particleArea / (double) (report.boundingRectWidth * report.boundingRectHeight);
        } else {
            return 0;
        }
    }

}
