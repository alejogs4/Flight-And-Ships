import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstruccionesJuego here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstruccionesJuego extends World
{

    /**
     * Constructor de la clase InstruccionesJuego
     * 
     */
    public InstruccionesJuego()
    {    
        super(600, 400, 1); 
        mostrarInstrucciones();
        prepare();
    }


    /**
     *  Metodo que agrega texto al mundo 
     */
    public void mostrarInstrucciones()
    {
        showText("Primer mundo: Puntaje necesario:40 Tiempo:40",getWidth()/2,getHeight()/2);
        showText("SegundoMundo: Puntaje necesario:100 Tiempo:35 ",getWidth()/2,getHeight()/2+20);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Instrucciones instrucciones = new Instrucciones();
        addObject(instrucciones,299,113);
        Atras atras = new Atras();
        addObject(atras,61,368);
    }
}
