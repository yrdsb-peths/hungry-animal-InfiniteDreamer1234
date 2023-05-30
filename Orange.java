import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The orange will fall randomly from the sky.
 * 
 * @ Justin Dong  
 * @ May 2023 
 */
public class Orange extends Actor
{
    /**
     * Act - do whatever the Orange wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
         
        // Orange falls downwards. 
        setLocation(getX(), getY() +1);
        
        MyWorld world = (MyWorld) getWorld();
        // If the elephant doens't touch it, the object will dissapear. 
        if(getY() >= world.getHeight())
        {
           
            world.removeObject(this);
            
           
            
             
        }
    }
}
