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
    public void setMundo(int mundo)
    {
        this.mundo=mundo;
    }
    public void bombardearBarco()
    {
        Actor barco =getOneObjectAtOffset(0,0,Barco.class);
        Explosion explosion= new Explosion();
        World world= getWorld();
        Mundos mundos = getWorldOfType(Mundos.class);
        if(barco != null&&mundo == 0)
        {
            world.removeObject(barco);
            world.addObject(explosion,getX(),getY());
            mundos.detenerSonido();
            Greenfoot.playSound("explosion.mp3");
            world.addObject(new Perdiste(),world.getWidth()/2,world.getHeight()/2);
        }
        else if(barco != null&&mundo != 0)
        {
            world.removeObject(barco);
            world.addObject(explosion,getX(),getY());
            mundos.detenerSonido();
            Greenfoot.playSound("explosion.mp3");
            world.addObject(new PerdisteSegundoNivel(),world.getWidth()/2,world.getHeight()/2);   
        }
    }    
    public void act() 
    {
        bombardearBarco();
    }    
}
