

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main world of the game.
 * 
 * @Justin Dong 
 * @ May 2023
 */

public class MyWorld extends World
{

    GreenfootSound worldSound = new GreenfootSound ("Music.mp3");
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    public int score = 0;
    Label scorelabel;
   
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        // Creates an elephant 
        Elephant e = new Elephant();
        addObject(e, 300, 300);
        
        // Creates a label 
        scorelabel = new Label(0, 80);
        addObject(scorelabel, 50, 50);
        
        
        createBread();
        createApple();
        
        worldSound.playLoop();
    }
    /*
     * Once the bread touches the ground,
     * the text "game over" will be displayed.
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    /*
     * This method will increase the score. Using the score
     * it will spawn various fruits at various scores. 
     */
    
    public void increaseScore()
    {
        score++;
        scorelabel.setValue(score);
        if(score % 5 == 0)
        {
            createApple();
            
        }
        if(score % 2 == 0)
        {
            createOrange();
            
        }
        
        
    }
    /*
     * Method that decrease the score. 
     */
    
    public void decreaseScore()
    {
        score--;
        scorelabel.setValue(score);
    }
    
    
    /*
     * Method that will spawn a piece of bread  
     */
    public void createBread()
    {
        Bread bread = new Bread();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(bread, x, y);
        
    }
    /*
     * Method that will spawn an apple 
     */
    public void createApple()
    {
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
    
    /*
     * Method that will spawn an orange
     */
     public void createOrange()
    {
        Orange orange = new Orange();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(orange, x, y);
    }

    
    
}
