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
    
    DriveTrain driveTrain;
    Turret turret;
    Rollers rollers;
    CowCatcher cowCatcher;
    
    double shooterSpeed = .75;
    
    public Robot(){
        robotInit();
    }
    
    public void robotInit(){
        driveTrain = new DriveTrain(1,2,3,4);
        rollers = new Rollers(1);
        cowCatcher = new CowCatcher(1);
        
        try {
            turret = new Turret(1,2,3,4,5);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void arcadeDrive(double leftSpeed, double rightSpeed){
        
    }
    
    public void collecterOI(){
        if(controls.operatorLeftBumbper()){
            rollers.pickUp();
        }
        if(!controls.operatorLeftBumbper() || !controls.operatorRightBumbper()){
            rollers.stop();
        }
        if(controls.operatorRightBumbper()){
            rollers.feed();
        }
    }
    
    public void shooter(){
        turret.shoot(shooterSpeed);
    }
    
    public void turretAdjustOI(){
        
    }
    public void cowCatcherOI(){
        
    }
}
