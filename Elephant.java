import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The elephant will move around the collect the bread. 
 * 
 * @ Justin Dong
 * @ May 2023
 */
public class Elephant extends Actor
{   
    
    // Sound effects 
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootSound bombSound = new GreenfootSound("Bomb.mp3");
    
    // Array for sprites 
    GreenfootImage[] idleRight = new GreenfootImage[8]; 
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    
    String facing = "right" ;
    
    // Intervals of the animation changing 
    SimpleTimer animationTimer = new SimpleTimer();
    public Elephant ()
    // Array elements to specific images 
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100,100);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100,100);
        }
        
        animationTimer.mark();
        // Sets intial elephant image 
        setImage(idleRight[0]);
    }

    // Animates the elephant 
    int imageIndex = 0;
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 50)
        {
            return;
        }
        
        animationTimer.mark();
        
        if(facing.equals("right"))
        
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
           move(-3);
           facing = "left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(3);
            facing = "right";
        }
        
        
        
        eat();
        avoid();
        dodge();
        animateElephant();
        
    }
    
    
    
    /**
     * Eats the bread and increases the score. If eaten, it will
     * spawn a new bread.
     */ 
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
    
    /**
     * Eating the apple will spawn more pieces of bread. 
     */
    public void avoid()
    {
         if(isTouching(Apple.class))
         {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            bombSound.play();
            world.createBread(); 
       
            
        }
        
        
    }
    
    /**
     * Eating the orange will decrease the score. 
     */
     public void dodge()
    {
         if(isTouching(Orange.class))
         {
            removeTouching(Orange.class);
            MyWorld world = (MyWorld) getWorld();
            bombSound.play();
            world.decreaseScore();
             
       
            
        }
        
        
    }
   
}   
     

