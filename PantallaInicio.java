import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PantallaInicio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PantallaInicio extends World
{

    /**
     * Constructor for objects of class PantallaInicio.
     * 
     */
    public PantallaInicio()
    {
        super(600, 600, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Iniciar iniciar = new Iniciar();
        addObject(iniciar,323,305);
        iniciar.setLocation(309,291);
    }
}
