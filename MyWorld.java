import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private static final int INTERVALOS=200;
    private static final int INTERVALO_SOBREVIVIENTE=100;
    private int contIntervalos=0;
    private int intervaloSobreviviente=0;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(120, 60, 10); 
        setBackground("tile_73.png");
        Greenfoot.playSound("fondo.mp3"); 
        prepare();
        
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
        addObject(barco,5,29);
        Avion avion = new Avion();
        addObject(avion,20,12);
        Avion avion2 = new Avion();
        addObject(avion2,31,33);
        Avion avion3 = new Avion();
        addObject(avion3,55,12);
        Avion avion4 = new Avion();
        addObject(avion4,14,48);
        Avion avion5 = new Avion();
        addObject(avion5,56,51);
    }
    
        public void act() 
    {
        aparecerRemolino();  
        aparecerSobreviviente();
    }
    
}
