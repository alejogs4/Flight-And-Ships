import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Atras here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Atras extends Letreros
{
    public  void pasarDePantalla()
    {
        if(sePresionoClick())
        {
            //Carga pantalla de inicio
            Greenfoot.setWorld(new PantallaInicio());
        }
    }  
}
