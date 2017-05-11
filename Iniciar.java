import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Iniciar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Iniciar extends Letreros
{
      public  void pasarDePantalla()
    {
        if(sePresionoClick())
        {
            // Carga el primer mundo
            Greenfoot.setWorld(new Mar());
        }
    }
}
