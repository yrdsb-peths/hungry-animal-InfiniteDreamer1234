import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The elephant will move around the collect the bread. 
 * 
 * @ Justin Dong
 * @ May 2023
 */
public class Elephant extends Actor
{
    
    
    GreenfootSound elephantSound = new GreenfootSound("Elephant.mp3");
    GreenfootImage idle = new GreenfootImage("elephant images/tile000"); 
    
    
    public Elephant ()
    {
        setImage(idle);
    }
    
    
    
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
           move(-1);
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(1);
        }
        
        if(Greenfoot.isKeyDown("up"))
        {
            
        }
        else if(Greenfoot.isKeyDown("down"))
        {
        
        }
        
        eat();
    }
    
    public void eat()
    {
        if(isTouching(Bread.class))
        {
            removeTouching(Bread.class);
            MyWorld world = (MyWorld) getWorld();
            world.createBread();
            world.increaseScore();
            elephantSound.play();
        }   
        
    }
}
