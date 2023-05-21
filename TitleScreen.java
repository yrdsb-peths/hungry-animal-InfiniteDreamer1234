import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    
    GreenfootImage wild = new GreenfootImage("Tree.jpg");
    Label titleLabel = new Label("Elephant's Adventure", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, getWidth()/2, 100);
        prepare();
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,485,329);
        elephant.setLocation(44,318);
        Label label = new Label("Press <Space> to Start", 40);

        addObject(label,558,268);
        label.setLocation(306,276);
        label.setLocation(331,204);
        elephant.setLocation(72,301);
        label.setLocation(244,196);
        label.setLocation(351,187);
        Label label2 = new Label("Use \u2190 and \u2192 to move", 40);
        addObject(label2,332,264);
        label.setLocation(360,205);
        label2.setLocation(297,262);
        label.setLocation(372,197);
        label.setLocation(329,188);
        label.setLocation(285,224);
    }
}
