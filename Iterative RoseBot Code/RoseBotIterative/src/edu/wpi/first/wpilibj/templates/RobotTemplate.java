/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {
    Robot robot;
    Controller controls;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        robot = new Robot();
        controls = new Controller();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    //
    public void teleopPeriodic() {
        arcadeDriveOI();
        shooterOI();
        collectorOI();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
    public void arcadeDriveOI(){
        //left x axis value
        double leftSpeed = controls.driver.getRawAxis(1);
        //right x axis value
        double rightSpeed = controls.driver.getRawAxis(4);
        
        robot.arcadeDrive(leftSpeed, rightSpeed);
    }
    public void shooterOI(){
        if(controls.operatorYButton()){
            robot.turret.noShoot();
        }else{
            if(controls.operatorBButton()){
            robot.shooterSpeed += .1;
        }else if(controls.operatorAButton()){
            robot.shooterSpeed += .1;
        }
            robot.shoot();
    }
    }
    public void collectorOI(){
    if(controls.operatorLeftBumbper()){
            robot.rollers.pickUp();
        }
        if(!controls.operatorLeftBumbper() || !controls.operatorRightBumbper()){
            robot.rollers.stop();
        }
        if(controls.operatorRightBumbper()){
            robot.rollers.feed();
        }
    }
}
