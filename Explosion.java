import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    private int frame = 1;
    private int contAnimacion = 3;
    
        public void act() 
    {
        animarExplosion();
    }    
    
    /**
     * Anima la explosion y para el juego cuando termina
     */
    private void animarExplosion(){
        if (frame < 10){
            if (contAnimacion <= 0){
                frame++;
                setImage("Explosion-"+frame+".png");
                contAnimacion = 3;
            }
            contAnimacion--;
        }
    }   
}
