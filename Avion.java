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
     
    /**
     * Moviemiento de los aviones 
     */
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
    /**
     *  Metodo que devuelve true si los aviones estan en los bordes laterales del mundo,false de caso contrario 
     */
    public boolean estaEnLosBordesLaterales()
    {
        World w= getWorld();
        if(getX()>=w.getWidth()-getImage().getWidth()/2||getX()<=getImage().getWidth()/2)
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
        if(getY()>=w.getHeight()-getImage().getHeight()/2||getY()<=getImage().getHeight()/2)
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
