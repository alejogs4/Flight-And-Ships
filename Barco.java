import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barco here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barco extends Actor
{
    private int sobrevivientes_rescatados;
    private int puntaje;
    private double combustible;
    private int vidas=3;
    private int time;
    private int intervalo_tiempo;
    private  static final int VELOCIDAD=5; 
    public Barco()
    {
       time = 40;
       puntaje=0;
       sobrevivientes_rescatados=0;
       intervalo_tiempo=0;
    }
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
    public String asignarTiempo()
    {
        return "Tiempo: "+time;
    }
    public void mostrarTiempo()
    {
        World w = getWorld();
        w.showText(asignarTiempo(),1000,25);
    }
    public void correrTiempo()
    {
        if(intervalo_tiempo==50)
        {
            time--;
            intervalo_tiempo=0;
        }
        else
        {
            intervalo_tiempo++;
        }
    }
    
    public void cargarSegundoNivel()
    {
        if(tieneParaPasarAlSegundoNivel())
        {            
            mostrarLetrero(new Felicitaciones());
        }
    }
    public void mostrarLetrero(Letreros l)
    {
        World w = getWorld();
        w.addObject(l,w.getWidth()/2,w.getHeight()/2);
    }
    public boolean tieneParaPasarAlSegundoNivel()
    {
        return this.puntaje>40;
    }
    public int getVidas()
    {
        return vidas;
    }
    public void act() 
    {
        correrTiempo();
        mostrarPuntaje();
        mostrarTiempo();
        moverBarco();
        rescatarSobreviviente();
        cargarSegundoNivel();

    }    
}
