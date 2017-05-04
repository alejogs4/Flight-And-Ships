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
        Barco b = new Barco();
        Mar mar = getWorldOfType(Mar.class);
        if(barco != null)
        {
            world.removeObject(barco);
            world.addObject(explosion,getX(),getY());
            mar.detenerSonido();
            Greenfoot.playSound("explosion.mp3");
            world.addObject(new Perdiste(),world.getWidth()/2,world.getHeight()/2);
        }
    }
    public void act() 
    {
        bombardearBarco();
    }    
}
