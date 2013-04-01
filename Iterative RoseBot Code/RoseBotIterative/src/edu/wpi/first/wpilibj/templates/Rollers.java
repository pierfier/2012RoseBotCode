/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Jaguar;

/**
 *
 * @author Pierre
 */
public class Rollers {
    Jaguar rollerJag;
    public Rollers(int id){
        rollerJag = new Jaguar(id);
    }
    public void pickUp(){
        rollerJag.set(.75);
    }
    public void feed(){
        rollerJag.set(-.75);
    }

    public void stop() {
        rollerJag.set(0);
    }   
}