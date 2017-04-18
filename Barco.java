import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barco here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barco extends Actor
{
    private int sobrevivientes_rescatados=0;
    private int puntaje=0;
    private double combustible;
    private int vidas=3;

    private  static final int VELOCIDAD=5;
    
    
   
    public void moverBarco()
    {
        if(estaPresionadaLaTeclaUp())
        {
            rotarYMoverAdelante();
        }
        else if(estaPresionadaLaTeclaDown())
        {
            rotarYMoverAtras();
        }
        
        if(estaPresionadaLaTeclaRight())
        {
            rotarYMoverDerecha();
        }
        else if(estaPresionadaLaTeclaLeft())
        {
            rotarYMoverIzquierda();
        }
    }
    public boolean estaPresionadaLaTeclaUp()
    {
        return Greenfoot.isKeyDown("up");
    }
    public boolean estaPresionadaLaTeclaDown()
    {
        return Greenfoot.isKeyDown("down");
    }
    public boolean estaPresionadaLaTeclaRight()
    {
        return Greenfoot.isKeyDown("right");
    }
    public boolean estaPresionadaLaTeclaLeft()
    {
        return Greenfoot.isKeyDown("left");
    }
    
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
            puntaje= puntaje+5;
        }
    }
    public String asignarPuntaje()
    {
        return "Puntaje"+" : "+puntaje;
    }
    public void mostrarPuntaje()
    {
        World w = getWorld();
        w.showText(asignarPuntaje(),55,25);
    }

    public void bombardearBarco()
    {
        Actor barco =getOneObjectAtOffset(0,0,Obstaculos.class);
        Explosion explosion= new Explosion();
        World world= getWorld();
        if(barco != null)
        {
            world.removeObject(barco);
            world.addObject(explosion,getX(),getY());
            Greenfoot.playSound("explosion.mp3");
            vidas--;
            Greenfoot.stop();
        }
    }
    public int getVidas()
    {
        return vidas;
    }
    public void act() 
    {
        mostrarPuntaje();
        moverBarco();
        rotarRemolino();
        rescatarSobreviviente();
        bombardearBarco();
    }    
}
