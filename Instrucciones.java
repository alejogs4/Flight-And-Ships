import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instrucciones here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instrucciones extends Letreros
{
    public  void pasarDePantalla()
    {
        if(sePresionoClick())
        {
            //Carga las instrucciones
            Greenfoot.setWorld(new InstruccionesJuego());
        }
    } 
}
