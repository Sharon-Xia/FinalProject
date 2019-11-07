import java.awt.*;          // access to Container
import java.awt.event.*;    // access to WindowAdapter, WindowEvent
import javax.swing.*;       // access to JFrame and Jcomponents
import javax.swing.event.*;     // access to JSlider events
import apcslib.*;
import chn.util.*;
import java.util.*;
public class Trigger extends Object
{
     //triggers appearing/disappearing platforms
    private Platform myPlatform;
    private boolean appearOrDisappear; // true for will appear, false for will disappear
    private boolean triggered;
    //private boolean moveOrNot;
    
    public Trigger(Loc location, Platform plat /*boolean aod, boolean move*/)
    {
        super(location, true);
        triggered = false;
        //appearOrDisappear = aod;
        //moveOrNot = move;
        myPlatform = plat;
    }
    
    public Trigger(Loc location, MovingPlatform plat)
    {
        super(location, true);
        triggered = false;
        //appearOrDisappear = aod;
        //moveOrNot = move;
        myPlatform = plat;
    }
    
    public Trigger(Loc location, Water wat)
    {
        super(location, true);
        triggered = false;
        //appearOrDisappear = aod;
        //moveOrNot = move;
        myPlatform = wat;
    }
    
    
    public void setOffTrigger()
    {
        myPlatform.toggleVisibility(); 
        triggered = true;
        //change appearance of trigger... color maybe
    }
    
    
    public void reset()
    {
        triggered = false;
        myPlatform.toggleVisibility();
            
    }

    
    public boolean getStatus() //returns true if already triggered, false if not
    {
        return triggered;
    }
    
    public Platform getPlatform()
    {
        return myPlatform;
    }
    
    public MovingPlatform getMovingPlatform()
    {
        return (MovingPlatform) myPlatform;
    }
    
    public Water getWater()
    {
        return (Water) myPlatform;
    }
    
    /*public boolean getEffect()
    {
        return appearOrDisappear;
    }*/
    
    public void processPlayer(Player player)
    {
        if((player.isBorderingOrWithin(getLocation()) || isBorderingOrWithin(player.getLocation())) && !triggered)
        {
            setOffTrigger();
        }
    }

}
