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
public class Turret {
    CANJaguar turnTableJag;
    CANJaguar stingerAngleJag;
    Jaguar bottomShooterJag;
    Jaguar topShooterJag;
    //this jaguar controls the transition belt from the rollers to the flywheels
    Jaguar feedJag;
    
    //constructor for turret includes the port ids for the shooter, feed, angle adjustment, and turntable jags
    public Turret(int turnTableID, int stingerAngleID, int bottomShooterID, int topShooterID, int feedID) throws CANTimeoutException{
        turnTableJag = new CANJaguar(turnTableID, CANJaguar.ControlMode.kPosition);
        stingerAngleJag = new CANJaguar(stingerAngleID, CANJaguar.ControlMode.kPosition);
        bottomShooterJag = new Jaguar(bottomShooterID);
        topShooterJag = new Jaguar(topShooterID);
        feedJag = new Jaguar(feedID);
    }
    
    //shooter method but it wont be impressive
    public void shoot(double speed){
        
        //safety pwm value
        if(speed > 1.0){
            speed = 1.0;
        }
        else if(speed < -1.0){
            speed = -1.0;
        }
        
        //TODO when testing make sure to test which way the motors are placed to see if shooting is negative or positive
        bottomShooterJag.set(speed);
        //this is done to create backspin
        topShooterJag.set(speed - .5);/*+ || - */
    }
    public void noShoot(){
        bottomShooterJag.set(0);
        topShooterJag.set(0);
        feedJag.set(0);
    }
    public void feedShooter(){
        feedJag.set(.3);
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
