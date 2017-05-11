import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mundos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mundos extends World
{
    private static final int INTERVALO_MUNICIONES=210;
    private static final int INTERVALO_SOBREVIVIENTE=150;
    
    private static final int CANTIDAD_REMOS=3;    
    private static final int INTERVALO_REMOS=300;
    private int intervaloRemos=0;
    private int contadorAyudas=0;
    
    private int intervaloMuniciones=0;
    private int intervaloSobreviviente=0;
    GreenfootSound sonido= new GreenfootSound("fondo.mp3");;
    protected Municiones municion;

    public Mundos()
    {    
        super(1100, 600, 1); 
    }
      /**
     *Muestra las municiones en el mapa de forma aletoria y en cierto intervalo de tiempo. 
     */
    public void mostrarMuniciones()
    {        
        municion= new Municiones();
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
    /*public void aparecerAyudas()
    {
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        Remos remo = new Remos();
        if(intervaloRemos>=INTERVALO_REMOS)
        {
            if(contadorAyudas<=3)
            {
                addObject(remo,x,y);
                intervaloRemos=0;
                contadorAyudas++;
            }      
                       
        }
        else
        {
            intervaloRemos++;
        }
    }*/
    
    /**
     *  Metodo que reproduce el sonido de fondo del juego
     *  @pre: El juego se debio haber iniciado antes de reproducir el sonido.
     */
    public void reproducirSonido()
    {
        sonido.play();
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
        //aparecerAyudas();
        if(!sonido.isPlaying())
        {
            reproducirSonido();
        }
    }
}
