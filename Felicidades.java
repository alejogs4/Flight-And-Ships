import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Felicidades here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Felicidades extends Letreros
{
    public  void pasarDePantalla()
    {
        if(sePresionoClick())
        {
            //Carga segunda pantalla
            Greenfoot.setWorld(new SegundaPantalla());
        }
    }   
}
