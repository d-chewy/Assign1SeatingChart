import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class truck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class truck extends Actor
{
    /**
     * Act - do whatever the truck wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        boolean hit = true;
        
        String truckImage = "truck.png";
        setImage(truckImage);
        
        String truckSFX = "truck.wav";
        GreenfootSound truckSound = new GreenfootSound(truckSFX);
        truckSound.play();
        setLocation(10, 1);
        for (int i = 10; i >= 0; i--) {
            if (touchTruck()) {
                if (hit == true) {
                    Greenfoot.playSound("bonk.wav");
                    hit = false;
                }
                transportStudent();
            }
            setLocation(i, 1);
            Greenfoot.delay(3);
            if (i == 0) {
                despawnTruck();
            }
        }
    }    
    
    
    private boolean touchTruck() {
        Actor Darren = getOneObjectAtOffset(0, 0, DarrenChui.class);
        if(Darren != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private void transportStudent() {
        Actor Darren = getOneObjectAtOffset(0, 0, DarrenChui.class);
        if(Darren != null)
        {
            getWorld().getObjects(Actor.class).get(0).getImage().setTransparency(0);
        }
    }
    
    private void despawnTruck() {
        this.getImage().setTransparency(0);
        Greenfoot.delay(100);
        getWorld().getObjects(Actor.class).get(0).getImage().setTransparency(255);
        getWorld().removeObject(this);
    }
}
