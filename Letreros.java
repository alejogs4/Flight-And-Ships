import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Letreros here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Letreros extends Actor
{
    public abstract void pasarDePantalla();
    public boolean sePresionoClick()
    {
        return Greenfoot.mouseClicked(this);
    }
    public void act() 
    {
        pasarDePantalla();
    }  
}
