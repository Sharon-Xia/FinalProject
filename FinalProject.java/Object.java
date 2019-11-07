import apcslib.*;
import chn.util.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Object
{
    private Loc myLocation; // gives location of the object
    private boolean visible; // tells whether the object is visible or not, visible for true, invisible for false
    
    /* constructs an object with a location and a boolean that tells whether the object is initially visible or not*/
    public Object(Loc location, boolean visibility) 
    {
        myLocation = location;
        visible = visibility;
    }
    
    /* returns the boolean visible, true means the object is visible, false means it is currently not visible*/
    public boolean isVisible()
    {
        return visible;
    }
    
    /* reverses the object's visibility. For instance, if an object was currently visible, a call to this method on the object would make it invisible, and vice-versa*/
    public void toggleVisibility()
    {
        visible = !visible;
    }
    
    /* sets the object's location to the new location provided in the parameter*/
    public void setLocation(Loc location)
    {
        myLocation = location;
    }
    
    /* returns the object's location*/
    public Loc getLocation()
    {
        return myLocation;
    }
    
    /* returns the width of the object*/
    public int getWidth()
    {
        return getLocation().getXr() - getLocation().getXl();
    }
    
    /* returns the height of the object*/
    public int getHeight()
    {
        return getLocation().getYd() - getLocation().getYu();
    }
    
    /* tests to see all or part of an object is inside a specific area returns true for yes, false for no*/
    public boolean isWithin(Loc oloc)
    {
        if (getLocation().getXl() > oloc.getXl() && getLocation().getXl() < oloc.getXr() && getLocation().getYu() > oloc.getYu() && getLocation().getYu() < oloc.getYd())  
            return true;
        else if (getLocation().getXr() > oloc.getXl() && getLocation().getXr() < oloc.getXr() && getLocation().getYu() > oloc.getYu() && getLocation().getYu() < oloc.getYd())
            return true;
        else if (getLocation().getXr() > oloc.getXl() && getLocation().getXr() < oloc.getXr() && getLocation().getYd() > oloc.getYu() && getLocation().getYd() < oloc.getYd())
            return true;
        else if (getLocation().getXl() > oloc.getXl() && getLocation().getXl() < oloc.getXr() && getLocation().getYd() > oloc.getYu() && getLocation().getYd() < oloc.getYd())
            return true;
        return false;
    }
    
    /* tests to see if all or part of an object is either inside of or bordering a specific area, returns true for yes, false for no*/
    public boolean isBorderingOrWithin(Loc oloc)
    {
        if (getLocation().getXl() >= oloc.getXl() && getLocation().getXl() <= oloc.getXr() && getLocation().getYu() >= oloc.getYu() && getLocation().getYu() <= oloc.getYd())  
            return true;
        else if (getLocation().getXr() >= oloc.getXl() && getLocation().getXr() <= oloc.getXr() && getLocation().getYu() >= oloc.getYu() && getLocation().getYu() <= oloc.getYd())
            return true;
        else if (getLocation().getXr() >= oloc.getXl() && getLocation().getXr() <= oloc.getXr() && getLocation().getYd() >= oloc.getYu() && getLocation().getYd() <= oloc.getYd())
            return true;
        else if (getLocation().getXl() >= oloc.getXl() && getLocation().getXl() <= oloc.getXr() && getLocation().getYd() >= oloc.getYu() && getLocation().getYd() <= oloc.getYd())
            return true;
        return false;
    }
    
    /* tests to see if an object is completely within a specific area, meaning the area of the object is entirely enclosed in a specific area, returns true for yes, false for no*/
    public boolean isCompletelyWithin(Loc oloc)
    {
        if (getLocation().getXl() >= oloc.getXl() && getLocation().getXl() <= oloc.getXr() && getLocation().getYu() >= oloc.getYu() && getLocation().getYu() <= oloc.getYd())  
        {
            if (getLocation().getXr() >= oloc.getXl() && getLocation().getXr() <= oloc.getXr() && getLocation().getYu() >= oloc.getYu() && getLocation().getYu() <= oloc.getYd())
            {
                if (getLocation().getXr() >= oloc.getXl() && getLocation().getXr() <= oloc.getXr() && getLocation().getYd() >= oloc.getYu() && getLocation().getYd() <= oloc.getYd())
                {
                    if (getLocation().getXl() >= oloc.getXl() && getLocation().getXl() <= oloc.getXr() && getLocation().getYd() >= oloc.getYu() && getLocation().getYd() <= oloc.getYd())
                        return true;
                }
            }
        }
        return false;
    }
    
    /* tests to see if the are of an object is completely within the window. Returns true for yes, false for no*/
    public boolean isWithinGrid()
    {
        if (isCompletelyWithin(new Loc(0, 902, 0, 601)))
            return true;
        else
            return false;
    }
    
    /* tests to see if an object is directly above an area. Returns true for yes, false for no*/
    public boolean isOnTop(Loc oloc)
    {
        if (getLocation().getYd() == oloc.getYu() && ((getLocation().getXl() >= oloc.getXl() && getLocation().getXl() <= oloc.getXr()) || 
        getLocation().getXr() >= oloc.getXl() && getLocation().getXr() <= oloc.getXr()))
            return true;
        return false;
    }
    
    /* tests to see if an object is directly below an area. Returns true for yes, false for no*/
    public boolean isOnBottom(Loc oloc)
    {
        if (getLocation().getYu() == oloc.getYd() && ((getLocation().getXl() >= oloc.getXl() && getLocation().getXl() <= oloc.getXr()) || 
        getLocation().getXr() >= oloc.getXl() && getLocation().getXr() <= oloc.getXr()))
            return true;
        return false;
    }
    
    /* tests to see if an object is directly on the left of an area. Returns true for yes, false for no*/
    public boolean isOnRight(Loc oloc)
    {
        if (getLocation().getXl() == oloc.getXr() && ((getLocation().getYu() >= oloc.getYu() && getLocation().getYu() <= oloc.getYd()) || 
        getLocation().getYd() >= oloc.getYu() && getLocation().getYd() <= oloc.getYd()))
            return true;
        return false;
    }
    
    /* tests to see if an object is directly on the right of an area. Returns true for yes, false for no*/
    public boolean isOnLeft(Loc oloc)
    {
        if (getLocation().getXr() == oloc.getXl() && ((getLocation().getYu() >= oloc.getYu() && getLocation().getYu() <= oloc.getYd()) || 
        getLocation().getYd() >= oloc.getYu() && getLocation().getYd() <= oloc.getYd()))
            return true;
        return false;
    }
}
