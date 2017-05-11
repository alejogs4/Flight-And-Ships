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
    /**
     *Metodo constructor de la clase Barco
     *@param time Time determina el tiempo que tendra el barco para completar el nivel
     *@param puntaje Puntaje determina el puntaje que tendra el barco al inicio de cada nivel
     */
    public Barco(int time,int puntaje)
    {
       this.time = time;
       this.puntaje=puntaje;
       sobrevivientes_rescatados=0;
       intervalo_tiempo=0;
    }
    /**
     * R02: Metodo encargado de la implementacion del requisito 2 
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
     * Metodo booleano perteneciente al requisito 2
     * @return Devuelve true si la tecla "up" esta presionada,false de lo contrario. 
     */
    public boolean estaPresionadaLaTeclaUp()
    {
        return Greenfoot.isKeyDown("up");
    }
    /**
     * Metodo booleano perteneciente al requisito 2
     * @return Devuelve true si la tecla "down" esta presionada,false de lo contrario. 
     */
    public boolean estaPresionadaLaTeclaDown()
    {
        return Greenfoot.isKeyDown("down");
    }
    /**
     * Metodo booleano perteneciente al requisito 2
     * @return Devuelve true si la tecla "right" esta presionada,false de lo contrario. 
     */
    public boolean estaPresionadaLaTeclaRight()
    {
        return Greenfoot.isKeyDown("right");
    }
    /**
     * Metodo booleano perteneciente al requisito 2
     * @return Devuelve true si la tecla "left" esta presionada,false de lo contrario. 
     */
    public boolean estaPresionadaLaTeclaLeft()
    {
        return Greenfoot.isKeyDown("left");
    }
    
    /**
     * Metodo encargado de rotar y mover hacia delante el barco 
     * @pre: Se debio haber presionado la tecla "up"
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
     * @pre: Se debio haber presionado la tecla "down"
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
     * @pre: Se debio haber presionado la tecla "right"
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
     * @pre: Se debio haber presionado la tecla "left"
     */
    public void rotarYMoverIzquierda()
    {
        int x= getX();
        int y= getY();
        setRotation(90);
        setLocation(x-VELOCIDAD,y);
    }
    
    /**
     *  R3: Rescata al sobreviviente del agua 
     */
    public void rescatarSobreviviente()
    {
        if(siEncontroUnSobreviviente())
        {
            recogerSobreviviente();
        }
    }
    /**
     * Metodo booleano perteneciente al requisito 3
     * @return Devuelve true si se encontro a un sobreviviente, false de lo contrario
     */public boolean siEncontroUnSobreviviente()
    {
        Actor persona = getOneObjectAtOffset(0,0,Sobrevivientes.class);
        return persona != null;
    }
    /**
     *  Metodo que recoge al sobreviviente del agua y le suma 5 puntos al puntaje del barco
     *  @pre El barco debe de haber encontrado un sobreviviente
     */
    public void recogerSobreviviente()
    {
            Actor persona = getOneObjectAtOffset(0,0,Sobrevivientes.class);
            getWorld().removeObject(persona);
            puntaje= puntaje+5;
    }
    /**
     * Metodo getter que devuelve un string con el puntaje del barco. 
     * @return Devuelve String con el puntaje del barco
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
     *  @return Devuelve true si el tiempo es igual menor a cero,false de lo contrario
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
     *  Metodo que determina si el puntaje del barco es el suficiente para pasar.
     *  @return Metodo que devuelve true si el puntaje del barco es igual a 40,false de lo contrario.
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
     *  Metodo que determina si el puntaje es suficiente para ganar el juego.
     *  @return Devuelve true si el puntaje es igual 100,false de lo contrario
     */
    public boolean tieneParaGanarElJuego()
    {
        return this.puntaje==100;
    }    
    
    /**
     *  Metodo que muestra los letreros del juego. 
     *  @param l Parametro que determinara el letrero que se mostrara en el mundo
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
