/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Pierre
 */
public class Controller {
    //entire class is dedicated to all the controllers
    //methods start with the controller identifier then there specific button
    
    Joystick driver;
    Joystick operator;
    
    //operator controller bumper states
    boolean leftBumperPressed = false;
    boolean leftBumperCarryOver = false;
    boolean rightBumperPressed = false;
    
    public Controller(){
        driver = new Joystick(1);
        operator = new Joystick(2);
    }
    //TODO populate with get methods for the buttons
    public boolean operatorLeftBumbper(){
        if(operator.getRawButton(5) && !leftBumperPressed){
            leftBumperPressed = true;
            leftBumperCarryOver = true;
        }
        
        if(operator.getRawButton(5) && leftBumperPressed && leftBumperCarryOver){
            leftBumperCarryOver = false;
            leftBumperPressed = false;
        }
        return leftBumperPressed;
    }
}
