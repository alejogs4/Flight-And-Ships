import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Avion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Avion extends Obstaculos
{
    private static final int VELOCIDAD=6;
    World w= getWorld();
     

    public void moverAviones()
    {
        move(VELOCIDAD);
        World w= getWorld();        
       if(estaEnLosBordesLaterales())
       {
            darMediaVuelta();
            if(Greenfoot.getRandomNumber(100)<90)
            {
                rotarAleatoriamente();
            }
       }
       if(estaEnLaParteInferiorOSuperior())
       {
            darMediaVuelta();
            if(Greenfoot.getRandomNumber(100)<90)
            {
                rotarAleatoriamente();
            }
       }
    }
    public boolean estaEnLosBordesLaterales()
    {
        World w= getWorld();
        if(getX()>=w.getWidth()-getImage().getWidth()/2||getX()<=5)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean estaEnLaParteInferiorOSuperior()
    {
        World w= getWorld();
        if(getY()>=w.getHeight()-5||getY()<=5)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void darMediaVuelta()
    {
        turn(180);
    }
    public void rotarAleatoriamente()
    {
        turn(Greenfoot.getRandomNumber(45));
    }
    
    public void act() 
    {
        moverAviones();  
        bombardearBarco();
    }    
}
