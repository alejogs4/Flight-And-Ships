import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    private int animacion = 1;  
    private int contAnimacion = 3;  
    public void act() 
    {  
        animarExplosionAvion();  
    }    
    /** 
     * Anima la explosion del avion 
     */  
    private void animarExplosionAvion(){  
        if (animacion < 10){  
            if (contAnimacion <= 0){  
               animacion++;  
               setImage("Explosion-"+animacion+".png");  
               contAnimacion = 3;  
            } 
            contAnimacion--;  
        }  
    }       
}
