import greenfoot.*;
/**
 * The World our hero lives in. 
 * 
 * @author Carmen Cheung
 * @version Apr 28, 2025
 */
public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);
        
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 200); 
        
        Apple apple = new Apple();
        addObject(apple, 300, 0); 
    }
}
