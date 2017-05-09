import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barco here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barco extends Actor
{
    //Atributos de clase
    private int sobrevivientes_rescatados;
    private int puntaje;
    private double combustible;
    private int vidas=3;
    private int time;
    private int intervalo_tiempo;
    
    //Constante de velocidad.
    private  static final int VELOCIDAD=5;     
    public Barco()
    {
       time = 40;
       puntaje=0;
       sobrevivientes_rescatados=0;
       intervalo_tiempo=0;
    }
    /**
     * Metodo encargado del movimiento del barco. 
     */
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
    /**
     * Metodo booleano que devuelve treu si la tecla "up" esta presionada,false de lo contrario. 
     */
    public boolean estaPresionadaLaTeclaUp()
    {
        return Greenfoot.isKeyDown("up");
    }
    /**
     *  Metodo booleano que devuelve true si la tecla "down" esta presionada,false de lo contario. 
     */
    public boolean estaPresionadaLaTeclaDown()
    {
        return Greenfoot.isKeyDown("down");
    }
    /**
     *  Metodo booleano que devuelve true si la tecla "right" esta presionada,false de lo contario 
     */
    public boolean estaPresionadaLaTeclaRight()
    {
        return Greenfoot.isKeyDown("right");
    }
    /**
     * Metodo booleano que devuelve true si la tecla "left" esta presionada, false de lo contario. 
     */
    public boolean estaPresionadaLaTeclaLeft()
    {
        return Greenfoot.isKeyDown("left");
    }
    
    /**
     * Metodo encargado de rotar y mover hacia delante el barco 
     */
    public void rotarYMoverAdelante()
    {
        int x= getX();
        int y= getY();
        setRotation(180);
        setLocation(x,y-VELOCIDAD);
    }
     /**
     * Metodo encargado de rotar y mover hacia atras al barco 
     */
    public void rotarYMoverAtras()
    {
        int x= getX();
        int y= getY();
        setRotation(0);
        setLocation(x,y+VELOCIDAD);
    }
     /**
     * Metodo encargado de rotar y mover hacia la derecha al barco 
     */
    public void rotarYMoverDerecha()
    {
        int x= getX();
        int y= getY();
        setRotation(270);
        setLocation(x+VELOCIDAD,y);
    }
    
     /**
     * Metodo encargado de rotar y mover hacia la izquierda al barco 
     */
    public void rotarYMoverIzquierda()
    {
        int x= getX();
        int y= getY();
        setRotation(90);
        setLocation(x-VELOCIDAD,y);
    }
    
    /**
     *  Rescata al sobreviviente del agua 
     */
    public void rescatarSobreviviente()
    {
        Actor persona = getOneObjectAtOffset(0,0,Sobrevivientes.class);
        if(persona != null)
        {
            getWorld().removeObject(persona);
            puntaje= puntaje+5;
        }
    }
    /*public void recogerRemos()
    {
        Actor remo = getOneObjectAtOffset(0,0,Remos.class);
        if(remo != null)
        {
            getWorld().removeObject(remo);
            time=time+5;
        }
    }*/
    
    /**
     *  Metodo setter que se encarga de asignarle el puntaje al barco; 
     */
    public void setPuntaje(int puntaje)
    {
        this.puntaje=puntaje;        
    }
    
    /**
     * Metodo getter que devuelve un string con el puntaje del barco. 
     */
    public String getPuntaje()
    {
        return "Puntaje"+" : "+puntaje;
    }
    /**
     *  Metodo que muestra en pantalla el puntaje del usuario, usando como contenido el metodo getPuntaje 
     */
    public void mostrarPuntaje()
    {
        World w = getWorld();
        w.showText(getPuntaje(),55,25);
    }
    
    /**
     *  Metodo getter que vuelve un texto con el tiempo del barco; 
     */
    public String getTiempo()
    {
        return "Tiempo: "+time;
    }
    /**
     * Metodo que muestra en pantalla el tiempo del barco. 
     */
    public void mostrarTiempo()
    {
        World w = getWorld();
        w.showText(getTiempo(),1000,25);
    }
    
    /**
     * Metodo encargado de controlar el tiempo.
     */
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

    /**
     *  Metodo que determina si el barco perdio por limite de tiempo. 
     */
    public void perdioPorTiempo()
    {
        if(seAcaboElTiempo())
        {
            mostrarLetrero(new Perdiste());
            getWorld().removeObject(this);
        }
    }
    /**
     *  Metodo que devuelve true si el tiempo es igual a cero,false de lo contrario. 
     */
    public boolean seAcaboElTiempo()
    {
        return time<=0;
    }
    
    
    /**
     *  Metodo que carga el segundo nivel del juego. 
     */
    public void cargarSegundoNivel()
    {
        if(tieneParaPasarAlSegundoNivel())
        {       
            mostrarLetrero(new Felicidades());
            getWorld().removeObject(this); 
        }
    }
    /**
     *  Metodo booleano que devuelve true si el puntaje del barco es igual a 40,false de lo contrario. 
     */
    public boolean tieneParaPasarAlSegundoNivel()
    {
        return this.puntaje==40;
    }
    
    
    /**
     *  Metodo que determina si el usuario ha ganado el juego. 
     */
    public void ganarJuego()
    {
        if(tieneParaGanarElJuego())
        {
            mostrarLetrero(new FelicidadesSegundoNivel());
            getWorld().removeObject(this);
        }
    }    
    /**
     *  Metodo booleano que devuelve true si el puntaje del barco es igual a 100,false de lo contrario. 
     */
    public boolean tieneParaGanarElJuego()
    {
        return this.puntaje==100;
    }    
    
    /**
     *  Metodo que muestra los letreros del juego. 
     */
    public void mostrarLetrero(Letreros l)
    {
        World w = getWorld();
        w.addObject(l,w.getWidth()/2,w.getHeight()/2);        
    }
    
    public void act() 
    {
        correrTiempo();
        mostrarPuntaje();
        mostrarTiempo();
        moverBarco();
        rescatarSobreviviente();
        cargarSegundoNivel();
        perdioPorTiempo();
        ganarJuego();
       // recogerRemos();
    }    
}
