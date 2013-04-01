/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 *
 * @author Pierre
 */
public class Robot {
    //robot subsystems
    Controller controls;
    DriveTrain driveTrain;
    Turret turret;
    Rollers rollers;
    CowCatcher cowCatcher;
    
    public Robot(){
        robotInit();
    }
    
    public void robotInit(){
        controls = new Controller();
        driveTrain = new DriveTrain(1,2,3,4);
        rollers = new Rollers(1);
        cowCatcher = new CowCatcher(1);
        
        try {
            turret = new Turret(1,2,3,4,5);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        
    }
    public void arcadeDrive(){
        //left x axis value
        double leftSpeed = controls.driver.getRawAxis(1);
        //right x axis value
        double rightSpeed = controls.driver.getRawAxis(4);
    }
    public void collect(){
        if(controls.operatorLeftBumbper()){
            rollers.pickUp();
        }
        if(!controls.operatorLeftBumbper()){
            rollers.stop();
        }
    }
}
