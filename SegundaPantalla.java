import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SegundaPantalla here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SegundaPantalla extends Mundos
{
    private Barco barco = new Barco(40,45);
    Avion avion = new Avion();
    Avion avion2 = new Avion();
    Avion avion3 = new Avion();
    Avion avion4 = new Avion();
    Avion avion5 = new Avion();
    /**
     * Constructor de la clase SegundaPantalla
     */
    public SegundaPantalla()
    {    
        prepare();   
        avion.setMundo(1);
        avion2.setMundo(1);
        avion3.setMundo(1);
        avion4.setMundo(1);
        avion5.setMundo(1);
        //municion.setMundo(1);
    }
    
    /**
     * Metodo que agrega objetos al mundo
     */
    private void prepare()
    {        
        addObject(barco,60,282);        
        addObject(avion,365,179);
        addObject(avion2,556,386);
        addObject(avion3,687,187);
        addObject(avion4,810,390);
        addObject(avion5,363,394);
    }

}
