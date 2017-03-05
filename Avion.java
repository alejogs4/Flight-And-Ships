import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Avion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Avion extends Actor
{
    private static final int VELOCIDAD=2;
    
     Explosion explosion= new Explosion();
    public void bombardearBarco()
    {
    Actor barco=getOneObjectAtOffset(0,0,Barco.class);
    World world= getWorld();
    if(barco != null)
    {
        world.removeObject(barco);
        world.addObject(explosion,getX(),getY());
        Greenfoot.playSound("explosion.mp3");
        Greenfoot.stop();
    }
    }
    public void movimientoAviones()
    {
        move(2);
        World w= getWorld();
        if(getX()>=w.getWidth()-5||getX()<=5)
        {
            turn(180);
            if(Greenfoot.getRandomNumber(100)<90)
            {
                turn(Greenfoot.getRandomNumber(45));
            }
        }
       if(getY()>=w.getHeight()-5||getY()<=5)
        {
            turn(180);
            if(Greenfoot.getRandomNumber(100)<90)
            {
                turn(Greenfoot.getRandomNumber(45));
            }
        }
    }
    
    public void act() 
    {
        movimientoAviones();
        bombardearBarco();
    }    
}
