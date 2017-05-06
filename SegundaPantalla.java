import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SegundaPantalla here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SegundaPantalla extends Mundos
{

    /**
     * Constructor for objects of class SegundaPantalla.
     * 
     */
    public SegundaPantalla()
    {    
        prepare();         
    }
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
