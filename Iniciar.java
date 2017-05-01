import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Iniciar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Iniciar extends Actor
{
    public void iniciarJuego()
    {
        if(sePresionoClick())
        {
            Greenfoot.setWorld(new Mar());
        }
    }
    public boolean sePresionoClick()
    {
        return Greenfoot.mouseClicked(this);
    }
    public void act() 
    {
        iniciarJuego();
    }    
}
