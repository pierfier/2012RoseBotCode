/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Jaguar;

/**
 *
 * @author Pierre
 */
public class DriveTrain {
    Jaguar topLeftJag;
    Jaguar bottomLeftJag;
    Jaguar topRightJag;
    Jaguar bottomRightJag;
    
    //constructor paramters are to set the jaguar IDs
    public DriveTrain(int topLeftID, int bottomLeftID, int topRightID, int bottomRightID){
        topLeftJag = new Jaguar(topLeftID);
        bottomLeftJag= new Jaguar(bottomLeftID);
        topRightJag= new Jaguar(topRightID);
        bottomRightJag = new Jaguar(bottomRightID);
    }
    public void leftDive(double leftSpeed){
        //safety with the pwm value
        if(leftSpeed > 1.0){
            leftSpeed = 1.0;
        }
        else if(leftSpeed < -1.0){
            leftSpeed = -1.0;
        }
        topLeftJag.set(leftSpeed);
        bottomLeftJag.set(leftSpeed);
    
    }
    public void rightDive(double rightSpeed){
        //safety with the pwm value
        if(rightSpeed > 1.0){
            rightSpeed = 1.0;
        }
        else if(rightSpeed < -1.0){
            rightSpeed = -1.0;
        }
        topRightJag.set(rightSpeed);
        bottomRightJag.set(rightSpeed);
    
    }
    
}
