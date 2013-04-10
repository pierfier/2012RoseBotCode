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
        stingerOI();
        cowCatcherOI();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        arcadeDriveOI();
        shooterOI();
        collectorOI();
        stingerOI();
        cowCatcherOI();
    }
    
    public void arcadeDriveOI(){
        robot.arcadeDrive(controls.driver.getRawAxis(1), controls.driver.getRawAxis(4));
    }
    public void shooterOI(){
        //only fire when the y button is not pushed, if its do not shoot
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
    public void stingerOI(){
        robot.adjustTurnTable(controls.operatorGetRawAxis(), controls.operatorGetYAxis());
    }
    public void cowCatcherOI(){
        if(controls.driverBButton()){
            robot.cowCatcherUp();
        }else if(!controls.driverBButton()){
            robot.cowCatcherDown();
        }
    }
}
