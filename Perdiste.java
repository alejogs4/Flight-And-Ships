import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Perdiste here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Perdiste extends Letreros
{
    public  void pasarDePantalla()
    {
        if(sePresionoClick())
        {
			Greenfoot.setWorld(new Mar());            
        }
    }   
}
