

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
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
        
        Elephant e = new Elephant();
        addObject(e, 300, 300);
        
        scorelabel = new Label(0, 80);
        addObject(scorelabel, 50, 50);
        
        
        createBread();
        createApple();
        
        worldSound.playLoop();
    }
    
    
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    public void increaseScore()
    {
        score++;
        scorelabel.setValue(score);
    }
    public void decreaseScore()
    {
        score--;
        scorelabel.setValue(score);
    }
    
    public void createBread()
    {
        Bread bread = new Bread();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(bread, x, y);
        
    }
    
    public void createApple()
    {
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
}
