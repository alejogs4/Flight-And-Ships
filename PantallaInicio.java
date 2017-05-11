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
     * Constructor de la clase PantallaInicio.
     * 
     */
    public PantallaInicio()
    {
        super(600, 600, 1); 
        prepare();
    }

    /**
     * Metodo que agrega objetos al mundo.
     * 
     */
    private void prepare()
    {
        Iniciar iniciar = new Iniciar();
        addObject(iniciar,323,305);
        iniciar.setLocation(309,310);
        Instrucciones instrucciones = new Instrucciones();
        addObject(instrucciones,304,362);
        instrucciones.setLocation(294,358);
        instrucciones.setLocation(304,433);
    }
}
