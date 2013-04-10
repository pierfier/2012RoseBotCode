/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 *
 * @author Pierre
 */
public class Turret {
    CANJaguar turnTableJag;
    CANJaguar stingerAngleJag;
    CANJaguar bottomShooterJag;
    CANJaguar topShooterJag;
    //this jaguar controls the transition belt from the rollers to the flywheels
    CANJaguar feedJag;
    
    //constructor for turret includes the port ids for the shooter, feed, angle adjustment, and turntable jags
    public Turret(int turnTableID, int stingerAngleID, int bottomShooterID, int topShooterID, int feedID) throws CANTimeoutException{
        turnTableJag = new CANJaguar(turnTableID, CANJaguar.ControlMode.kPosition);
        stingerAngleJag = new CANJaguar(stingerAngleID, CANJaguar.ControlMode.kPosition);
        bottomShooterJag = new CANJaguar(bottomShooterID);
        topShooterJag = new CANJaguar(topShooterID);
        feedJag = new CANJaguar(feedID);
        //setting the control mode to voltage
        turnTableJag.changeControlMode(CANJaguar.ControlMode.kVoltage);
        stingerAngleJag.changeControlMode(CANJaguar.ControlMode.kVoltage);
        bottomShooterJag.changeControlMode(CANJaguar.ControlMode.kSpeed);
        topShooterJag.changeControlMode(CANJaguar.ControlMode.kSpeed);
        feedJag.changeControlMode(CANJaguar.ControlMode.kVoltage);
        bottomShooterJag.setSpeedReference(CANJaguar.SpeedReference.kQuadEncoder);
        topShooterJag.setSpeedReference(CANJaguar.SpeedReference.kQuadEncoder);
    }
    
    //shooter method but it wont be impressive
    public void shoot(double speed){
        try {
            //safety pwm value
            if(speed > 1.0){
                speed = 1.0;
            }
            else if(speed < -1.0){
                speed = -1.0;
            }
            
            //TODO when testing make sure to test which way the motors are placed to see if shooting is negative or positive
            bottomShooterJag.setX(speed);
            //this is done to create backspin
            topShooterJag.setX(speed - .5);/*+ || - */
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    public void noShoot(){
        try {
            bottomShooterJag.setX(0);
            topShooterJag.setX(0);
            feedJag.setX(0);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    public void feedShooter(){
        try {
            feedJag.setX(.3);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    
    //adjusts the shooters pitch angle
    public void adjustShooter(double angle) throws CANTimeoutException{
        if(stingerAngleJag.getForwardLimitOK() || stingerAngleJag.getReverseLimitOK()){
        stingerAngleJag.setX(angle);
        }
    }
    //spins the turn table
    //TODO check if there is a potentiometer or encoder for the bot; figure out the turnTableJag.getForwardLimitOK()
    public void spinTable(double angle) throws CANTimeoutException{
        if(turnTableJag.getForwardLimitOK() || turnTableJag.getReverseLimitOK()){
        turnTableJag.setX(angle);
        }
    }
}
