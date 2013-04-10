/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 *
 * @author Pierre
 */
public class DriveTrain {
    CANJaguar topLeftJag;
    CANJaguar bottomLeftJag;
    CANJaguar topRightJag;
    CANJaguar bottomRightJag;
    
    //constructor paramters are to set the jaguar IDs
    public DriveTrain(int topLeftID, int bottomLeftID, int topRightID, int bottomRightID){
        try {
            topLeftJag = new CANJaguar(topLeftID);
            bottomLeftJag= new CANJaguar(bottomLeftID);
            topRightJag= new CANJaguar(topRightID);
            bottomRightJag = new CANJaguar(bottomRightID);
            
            //setting the CANJaguar control mode
            topLeftJag.changeControlMode(CANJaguar.ControlMode.kVoltage);
            bottomLeftJag.changeControlMode(CANJaguar.ControlMode.kVoltage);
            topRightJag.changeControlMode(CANJaguar.ControlMode.kVoltage);
            bottomRightJag.changeControlMode(CANJaguar.ControlMode.kVoltage);
            
            
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    public void leftDive(double leftSpeed){
        try {
            //safety with the pwm value
            if(leftSpeed > 1.0){
                leftSpeed = 1.0;
            }
            else if(leftSpeed < -1.0){
                leftSpeed = -1.0;
            }
            topLeftJag.setX(leftSpeed);
            bottomLeftJag.setX(leftSpeed);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    public void rightDive(double rightSpeed){
        try {
            //safety with the pwm value
            if(rightSpeed > 1.0){
                rightSpeed = 1.0;
            }
            else if(rightSpeed < -1.0){
                rightSpeed = -1.0;
            }
            topRightJag.setX(rightSpeed);
            bottomRightJag.setX(rightSpeed);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }    
}
