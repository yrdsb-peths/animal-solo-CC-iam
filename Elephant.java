import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, our hero.
 * 
 * @author Carmen Cheung 
 * @version Apr 28, 2025
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image = new GreenfootImage("elephant.png");
    
    GreenfootSound eatingSound = new GreenfootSound("eating.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];

    
    //Direction the elephant is facing
    String facing = "right"; 
    SimpleTimer animationTimer = new SimpleTimer();
    /**
     * Constructor - the code that gets run one time when object is created 
     */
    public Elephant()
    {
        for (int i = 0; i < 8; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100,100);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally(); 
            idleLeft[i].scale(100,100);
        }
        
        animationTimer.mark(); 
        
        setImage(idleRight[0]); 
    }
    
    /**
     * Animate the elephant 
     */
    int imageIndex = 0;
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 100)
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
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2); 
            facing = "left";
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            move(2); 
            facing = "right";
        }
        
        //Remove apple if elephant eats it
        eat(); 
        
        //Animate the elephant
        animateElephant();
    }
    
    /** 
     * Eat the apple and spawn new apple if an apple is eaten 
     */
    public void eat()
    {
        if (isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld)getWorld();
            world.createApple();
            world.increaseScore();
            eatingSound.play();
        }
    }
}
