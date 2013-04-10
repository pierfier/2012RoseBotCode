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
    
    public Controller(){
        driver = new Joystick(1);
        operator = new Joystick(2);
    }
    
    //operator controller left bumper state
    boolean leftBumperPressed = false;
    boolean leftBumperToggle = true;
    public boolean operatorLeftBumbper(){
        if(operator.getRawButton(5) && leftBumperToggle){
            leftBumperToggle = false;
            if(leftBumperPressed){
                leftBumperPressed = false;
            }else{
                leftBumperPressed = true;
            }
        }else if(!operator.getRawButton(5)){
            leftBumperToggle = true;
        }
        return leftBumperPressed;
    }
    
    //operator controller right bumper state
    boolean rightBumperPressed = false;
    boolean rightBumperToggle = true;
    public boolean operatorRightBumbper(){
        if(operator.getRawButton(6) && rightBumperToggle){
            rightBumperToggle = false;
            if(rightBumperPressed){
                rightBumperPressed = false;
            }else{
                rightBumperPressed = true;
            }
        }else if(!operator.getRawButton(6)){
            rightBumperToggle = true;
        }
        return rightBumperPressed;
    }
    //operator controller b button state
    boolean bButton = false;
    public boolean operatorBButton(){
        if(operator.getRawButton(2) && bButton == !operator.getRawButton(2)){
            bButton = true;
        }else{
            bButton = false;
        }
        return bButton;
    }
    //operator controller a button state
    boolean aButton = false;
    public boolean operatorAButton(){
        if(operator.getRawButton(1) && aButton == !operator.getRawButton(1)){
            aButton = true;
            return true;
        }else{
            aButton = false;
            return false;
        }
    }
    
    //operator controller y button state
    boolean yButton = false;
    public boolean operatorYButton(){
        if(operator.getRawButton(4) && yButton == !operator.getRawButton(4)){
            yButton = true;
            return true;
        }else{
            yButton = false;
            return false;
        }
    }
    boolean BButton = false;
    public boolean driverBButton(){
        if(driver.getRawButton(2) && BButton == !driver.getRawButton(2)){
            BButton = true;
            return true;
        }else{
            BButton = false;
            return false;
        }
    }
    
    //TODO make sure these are correct
    public double operatorGetYAxis(){
        if(operator.getY() >= -.1 && operator.getY() <= .1){
            return 0;
        }else{
        return operator.getY();
        }
    }
    
    //TODO make sure these are correct
    public double operatorGetRawAxis(){
        if(operator.getRawAxis(4) >= -.1 && operator.getRawAxis(4) <= .1){
            return 0;
        }else{
        return operator.getRawAxis(4);
    }
    }
    
    //TODO make sure these are correct
    public double driverGetYAxis(){
        if(driver.getY() >= -.1 && driver.getY() <= .1){
            return 0;
        }else{
        return driver.getY();
        }
    }
    
    //TODO make sure these are correct
    public double driverGetRawAxis(){
        if(driver.getRawAxis(4) >= -.1 && driver.getRawAxis(4) <= .1){
            return 0;
        }else{
        return driver.getRawAxis(4);
    }
    }
}