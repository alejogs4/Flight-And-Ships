import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FelicidadesSegundoNivel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FelicidadesSegundoNivel extends Letreros
{
    public void pasarDePantalla()
    {
        if(sePresionoClick())
        {
            //Carga segunda pantalla
            Greenfoot.setWorld(new PantallaInicio());
        }
    }
}
