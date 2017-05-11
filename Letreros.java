import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Letreros here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Letreros extends Actor
{
    /**
     * Metodo abstracto para pasar de pantalla 
     */
    public abstract void pasarDePantalla();
    /**
     * Metodo que se ejecuta si se da click sobre algun objeto de tipo Letrero 
     * @return Devuelve true si se dio click sobre un objeto de tipo Letrero,false de lo contrario.
     */
    public boolean sePresionoClick()
    {
        return Greenfoot.mouseClicked(this);
    }
    public void act() 
    {
        pasarDePantalla();
    }  
}
