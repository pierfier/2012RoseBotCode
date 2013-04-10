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
public class CowCatcher {
    
    //TODO canjags? find out the pin motor controller
    Jaguar catcherJag;
    
    //state of cowCatcher, up or down
    boolean cowCatcherState;
    //states if the cow catcher has reached placement. Potentiometer position?
    boolean reachedUp = true;
    boolean reachedDown = true;
    
    public CowCatcher(int cowCatcherID){
        catcherJag = new Jaguar(cowCatcherID);
    }
    
    //TODO this method is written mainly in pseudo, not sure how to find stoppage point
    //brings the cowCatcher up
    public void up(){
        if(!reachedUp){
        catcherJag.set(.3);
        }else{
            catcherJag.set(0);
        }
        }
    public void down(){
        if(!reachedDown){
        catcherJag.set(-.3);
        }else{
            catcherJag.set(0);
        }
        }
    
}
