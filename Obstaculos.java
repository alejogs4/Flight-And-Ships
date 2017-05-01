import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstaculos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstaculos extends Actor
{
        public void bombardearBarco()
    {
        Actor barco =getOneObjectAtOffset(0,0,Barco.class);
        Explosion explosion= new Explosion();
        World world= getWorld();
        Mar mar = getWorldOfType(Mar.class);
        if(barco != null)
        {
            world.removeObject(barco);
            world.addObject(explosion,getX(),getY());
            mar.detenerSonido();
            Greenfoot.playSound("explosion.mp3");
            Greenfoot.stop();
        }
    }

    public void act() 
    {
        bombardearBarco();
    }    
}
