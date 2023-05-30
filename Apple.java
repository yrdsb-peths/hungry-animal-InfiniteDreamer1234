import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Will have the apple fall from the sky.
 * 
 * @ Justin Dong
 * @ May 2023  
 */
public class Apple extends Actor
{
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
         // Apple falls downwards 
        setLocation(getX(), getY() +1);
        MyWorld world = (MyWorld) getWorld();
        // Apple dissapears once it touches the bottom
        
        if(getY() >= world.getHeight())
        {
            
            world.removeObject(this);
            
            
             
        }
       
       
        
        
        
    }
}
