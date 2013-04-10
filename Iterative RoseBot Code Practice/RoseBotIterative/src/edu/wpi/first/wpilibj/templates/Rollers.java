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
public class Rollers {
    CANJaguar rollerJag;
    public Rollers(int id){
        try {
            rollerJag = new CANJaguar(id, CANJaguar.ControlMode.kVoltage);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    public void pickUp(){
        try {
            rollerJag.setX(.75);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    public void feed(){
        try {
            rollerJag.setX(-.75);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public void stop() {
        try {
            rollerJag.setX(0);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }   
}