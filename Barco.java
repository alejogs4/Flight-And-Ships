import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barco here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barco extends Actor
{
    private int vidas = 3;
    private int sobrevivientes_rescatados=0;
    private int puntaje=0;
    private double combustible;
    private  static final int VELOCIDAD=1; 
    
    

    public void rotarYMoverAdelante()
    {
        int x= getX();
        int y= getY();
        setRotation(180);
        setLocation(x,y-VELOCIDAD);
    }
    public void rotarYMoverAtras()
    {
        int x= getX();
        int y= getY();
        setRotation(0);
        setLocation(x,y+VELOCIDAD);
    }
    public void rotarYMoverDerecha()
    {
        int x= getX();
        int y= getY();
        setRotation(270);
        setLocation(x+VELOCIDAD,y);
    }
    public void rotarYMoverIzquierda()
    {
        int x= getX();
        int y= getY();
        setRotation(90);
        setLocation(x-VELOCIDAD,y);
    }
    
    public void rotarRemolino()
    {
        Actor remolino = getOneObjectAtOffset(0,0,Remolinos.class);
        World w = getWorld();
        if(remolino != null)
        {
            this.turn(180);
           
        }
        
    }
    public void rescatarSobreviviente()
    {
        Actor persona = getOneObjectAtOffset(0,0,Sobrevivientes.class);
        if(persona != null)
        {
            getWorld().removeObject(persona);
        }
    }
        
    public void act() 
    {
        if(Greenfoot.isKeyDown("up"))
        {
            rotarYMoverAdelante();
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            rotarYMoverAtras();
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            rotarYMoverDerecha();
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            rotarYMoverIzquierda();
        }
        rotarRemolino();
        rescatarSobreviviente();
    }    
}
