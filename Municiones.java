import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Municiones here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Municiones extends Actor
{
    /**
     * Act - do whatever the Municiones wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void explotarBarco()
    {
        Actor barco = getOneObjectAtOffset(0,0,Barco.class);
        Explosion explosion= new Explosion();
        if(barco != null)
        {
            getWorld().removeObject(barco);
            getWorld().addObject(explosion,getX(),getY());
            Greenfoot.playSound("explosion.mp3");
            Greenfoot.stop();
        }
    }

    public void act() 
    {
        explotarBarco();
    }    
}
