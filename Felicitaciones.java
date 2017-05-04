import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Felicitaciones here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Felicitaciones extends Letreros
{
    public  void pasarDePantalla()
    {
        if(sePresionoClick())
        {
            Greenfoot.setWorld(new SegundaPantalla());
        }
    }
}
