import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mundos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mundos extends World
{
    private int intervaloMuniciones=0;
    private static final int INTERVALO_MUNICIONES=210;
    private static final int INTERVALO_SOBREVIVIENTE=150;
    private int intervaloSobreviviente=0;
    GreenfootSound sonido;
    public Mundos()
    {    
        super(1100, 600, 1); 
        sonido = new GreenfootSound("fondo.mp3");
    }
      /**
     *Muestra las municiones en el mapa de forma aletoria y en cierto intervalo de tiempo. 
     */
    public void mostrarMuniciones()
    {
        Municiones municion= new Municiones();
        int w = Greenfoot.getRandomNumber(getWidth());
        int h = Greenfoot.getRandomNumber(getHeight());
        if(intervaloMuniciones>=INTERVALO_MUNICIONES)
        {
            addObject(municion,w,h);
            intervaloMuniciones=0;
        }
        else
        {
            intervaloMuniciones++;
        }
        
    }
    
    /**
     *Muestra a los sobrevivientes en el mapa de forma aletoria y en cierto intervalo de tiempo. 
     */
    public void aparecerSobreviviente()
    {
        Sobrevivientes persona = new Sobrevivientes();  
        int x= Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());        
        if(intervaloSobreviviente>=INTERVALO_SOBREVIVIENTE)
        {
            addObject(persona,x,y);
            intervaloSobreviviente = 0;
        }
        else
        {
            intervaloSobreviviente++;
        }               
    }
    
    /**
     *  Metodo que reproduce el sonido de fondo del juego
     *  @pre: El juego se debio haber iniciado antes de reproducir el sonido.
     */
    public void reproducirSonido()
    {
        sonido.playLoop();
    }
    /**
     *Metodo que detiene el sonido de fondo del juego 
     */
    public void detenerSonido()
    {
        sonido.stop();
    }
    public void act() 
    { 
        aparecerSobreviviente();
        mostrarMuniciones();
        if(!sonido.isPlaying())
        {
            reproducirSonido();
        }
    }
}
