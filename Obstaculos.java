import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstaculos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstaculos extends Actor
{
    private int mundo;
    public Obstaculos()
    {
        mundo=0;
    }
    /**
     * Metodo setter que determina el mundo donde se encuentra el obstaculo
     * @param Mundo mundo determina el mundo donde se encuentra el obstaculo
     */
    public void setMundo(int mundo)
    {
        this.mundo=mundo;
    }
    
    /**
     * R04: Metodo encargado de la la implementacion del requisito 4
     */
    public void bombardearBarco()
    {
        World world= getWorld();
       if(estaSobreElBarco())
       {
            removerBarco();
            world.addObject(new Perdiste(),world.getWidth()/2,world.getHeight()/2);
       }
       else if(estaSobreElBarcoNivel2())
       {
            removerBarco();
            world.addObject(new PerdisteSegundoNivel(),world.getWidth()/2,world.getHeight()/2);   
       }
    }  
    /**
     *  Metodo booleano perteneciente al requisito 4
     *  @return Devuelve true si el el avion toco el barco y el mundo donde esta el avion es el cero false de caso contrario.
     */
    public boolean estaSobreElBarco()
    {
        Actor barco =getOneObjectAtOffset(0,0,Barco.class);
        return barco!=null&&mundo==0;
    }
     /**
     *  Metodo booleano perteneciente al requisito 4
     *  @return Devuelve true si el el avion toco el barco y el mundo donde esta el avion es el uno false de caso contrario.
     */
    public boolean estaSobreElBarcoNivel2()
    {
        Actor barco =getOneObjectAtOffset(0,0,Barco.class);
        return barco!=null && mundo!=0;
    }
     /**
     *  Metodo perteneciente al requisito 4 que remueve el barco del mundo,añade una explosion y reproduce un sonido
     *  @pre Se debe de cumplir cualquiera de los metodos booleanos pertenecientes al requisito 4
     */
    public void removerBarco()
    {
            Actor barco =getOneObjectAtOffset(0,0,Barco.class);
            Mundos mundos = getWorldOfType(Mundos.class);
            getWorld().removeObject(barco);
            getWorld().addObject(new Explosion(),getX(),getY());
            mundos.detenerSonido();
            Greenfoot.playSound("explosion.mp3");
    }
    public void act() 
    {
        bombardearBarco();
    }    
}
