import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen
 * 
 * @author Carmen Cheung 
 * @version May 7, 2025
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Lily the Elephant", 60);
    Label subLabel = new Label("Click <space> to enter game",30); 
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, getWidth()/2, 150);
        addObject(subLabel, getWidth()/2, 250);
        prepare();
        setBackground(new GreenfootImage("background.jpg"));
    }

    /**
     * The main world act loop
     */
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
        addObject(elephant,487,330);
        elephant.setLocation(468,295);
        elephant.setLocation(77,323);
        Label label = new Label("Click \u2190 and \u2192 to move", 30);
        addObject(label,293,209);
        label.setLocation(297,209);
    }
}
