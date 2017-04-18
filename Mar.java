import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mar extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private static final int INTERVALOS=200;
    private static final int INTERVALO_SOBREVIVIENTE=150;
    private static final int INTERVALO_MUNICIONES=210;
    
    private int contIntervalos=0;
    private int intervaloSobreviviente=0;
    private int intervaloMuniciones=0;
    private int x=800;
    private int y = 55;
    private int i;
    
    private Barco barco = new Barco();
    private Vidas corazon = new Vidas();   
    GreenfootSound sonido = new GreenfootSound("fondo.mp3");
    public Mar()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 600, 1); 
        setBackground("tile_73.png");
        
        prepare();
        

    }
        public void mostrarMuniciones()
    {
        Municiones municion= new Municiones();
        int w = Greenfoot.getRandomNumber(getWidth());
        int h = Greenfoot.getRandomNumber(getHeight());
        if(intervaloMuniciones>=INTERVALO_MUNICIONES)
        {
            addObject(municion,w,h);
            intervaloMuniciones=0;
        }
        else
        {
            intervaloMuniciones++;
        }
        
    }
    public void mostrarVidas()
    {
        for (i=0;i<=barco.getVidas()-1;i++)
        {
            addObject(new Vidas(),x,y);
            x = x+100;
        }
    }
    public void reproducirSonido()
    {
        sonido.playLoop();
    }
     public void aparecerRemolino()
    {
        Remolinos remolino = new Remolinos();  
        int x= Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());        
        if(contIntervalos>=INTERVALOS)
        {
            addObject(remolino,x,y);
            contIntervalos = 0;
        }
        else
        {
            contIntervalos++;
        }
        
    }
    public void aparecerSobreviviente()
    {
        Sobrevivientes persona = new Sobrevivientes();  
        int x= Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        
        if(intervaloSobreviviente>=INTERVALO_SOBREVIVIENTE)
        {
            addObject(persona,x,y);
            intervaloSobreviviente = 0;
        }
        else
        {
            intervaloSobreviviente++;
        }
          

        
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        Barco barco = new Barco();
        addObject(barco,60,282);
        Avion avion = new Avion();
        addObject(avion,365,179);
        Avion avion2 = new Avion();
        addObject(avion2,556,386);
        Avion avion3 = new Avion();
        addObject(avion3,687,187);
        Avion avion4 = new Avion();
        addObject(avion4,810,390);
        Avion avion5 = new Avion();
        addObject(avion5,363,394);
    }
    
        public void act() 
    {
        aparecerRemolino();  
        aparecerSobreviviente();
        mostrarMuniciones();
        reproducirSonido();
    }
    
}
