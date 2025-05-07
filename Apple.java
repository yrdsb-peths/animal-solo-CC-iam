import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food for our elephant.
 * 
 * @author Carmen Cheung 
 * @version Apr 28, 2025
 */
public class Apple extends Actor
{
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 1; 
    public void act()
    {
        GreenfootImage image = new GreenfootImage("apple2.png");
        image.scale(50, 50);
        setImage(image); 
        //Let the apple fall.
        setLocation(getX(), getY() + 1);
        
        //Remove apple and draw the game Over when apple gets to bottom
        MyWorld world = (MyWorld)getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this); 
        }
    }
    
    public void setSpeed (int spd)
    {
        speed = spd; 
    }
}
