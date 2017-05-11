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
     * R6:Metodo que implementa el requisito 6
     */
    public void moverAviones()
    {
        move(VELOCIDAD);
        World w= getWorld();        
       if(estaEnLosBordesLaterales())
       {
            darMediaVuelta();
            if(Greenfoot.getRandomNumber(100)<80)
            {
                rotarAleatoriamente();
            }
       }
       if(estaEnLaParteInferiorOSuperior())
       {
            darMediaVuelta();
            if(Greenfoot.getRandomNumber(100)<80)
            {
                rotarAleatoriamente();
            }
       }
    }
    /**
     *  Metodo que determina si el avion esta en los bordes laterales.
     *  @return Returna si el avion esta en los bordes laterales, false de lo contario
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
    
     /**
     *  Metodo que determina si el avion esta en los bordes superiores o inferiores.
     *  @return Returna si el avion esta en los bordes superiores o inferiores, false de lo contario
     */
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
    /**
     * Metodo que se encarga de darle media vuelta al avion
     * @pre El avion esta en los bordes del mundo
     */
    public void darMediaVuelta()
    {
        turn(180);
    }
    /**
     * Metodo que rota el avion aleatoriamente
     * @pre Este metodo se ejecuta con una probabilidad del 80%
     */
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
