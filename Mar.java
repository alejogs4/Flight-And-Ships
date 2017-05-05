import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mar extends Mundos
{
    private static final int INTERVALOS=200;

    
    private int contIntervalos=0;
    private int x=800;
    private int y = 55;
    private int i;
    
    private Barco barco = new Barco();
    GreenfootSound sonido;    

    public Mar()
    {            
        setBackground("tile_73.png");
        sonido = new GreenfootSound("fondo.mp3");
        prepare();       
    }


    public void reproducirSonido()
    {
        sonido.playLoop();
    }
    public void detenerSonido()
    {
        sonido.stop();
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
}
