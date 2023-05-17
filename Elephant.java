import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The elephant will move around the collect the bread. 
 * 
 * @ Justin Dong
 * @ May 2023
 */
public class Elephant extends Actor
{   
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idle = new GreenfootImage[8]; 
    
    
    public Elephant ()
    {
        for(int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("elephant_idle/idle" + i + ".png");
        }
        setImage(idle[0]);
    }

    int imageIndex = 0;
    public void animateElephant()
    {
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
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
        
        if(Greenfoot.isKeyDown("a"))
        {
            move(-1);
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            move(1);
        }
        
        eat();
        
        animateElephant();
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
