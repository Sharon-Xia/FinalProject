import apcslib.*;
import chn.util.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class MovingPlatform extends Platform
{
    private Loc myBorder;
    private int mySpeed;
    private boolean ULDR; // true for up-down, false for left-right
    private boolean fOrB; // true for up/right, false for left/down
    
    public MovingPlatform(Loc l, boolean visibility, Loc border, int speed, boolean udlr, boolean direction)
    {
        super(l, visibility);
        myBorder = border;
        mySpeed = speed;
        ULDR = udlr;
        fOrB = direction;
        
    }
    
    public Loc getBorder()
    {
        return myBorder;
    }
    
    public void process()
    {
        if (ULDR == true && fOrB == true && (isCompletelyWithin(myBorder)))
        {
            getLocation().setUpLoc();
            
        }
        else if (ULDR == true && fOrB == true && !(isCompletelyWithin(myBorder)))
            toggleDirection();
        else if (ULDR == true && fOrB == false && (isCompletelyWithin(myBorder)))
        {
            getLocation().setDownLoc();
            
        }
        else if (ULDR == true && fOrB == false && !(isCompletelyWithin(myBorder)))
            toggleDirection();
        else if (ULDR == false && fOrB == true && (isCompletelyWithin(myBorder)))
        {
            getLocation().setRightLoc();
            
        }
        else if (ULDR == false && fOrB == true && !(isCompletelyWithin(myBorder)))
            toggleDirection();
        else if (ULDR == false && fOrB == false && (isCompletelyWithin(myBorder)))
        {
            getLocation().setLeftLoc();
            
        }
        else if (ULDR == false && fOrB == false && !(isCompletelyWithin(myBorder)))
            toggleDirection();
        
    }
    
    
    
    
    
    public boolean getType()
    {
        return ULDR;
    }
    
    public int getSpeed()
    {
        return mySpeed;
    }
    
    public boolean getDirection()
    {
        return fOrB;
    }
    
    public void toggleDirection()
    {
        
        if (ULDR == true && fOrB == true)
            getLocation().setDownLoc();
        if (ULDR == true && fOrB == false)
            getLocation().setUpLoc();
        if (ULDR == false && fOrB == true)
            getLocation().setLeftLoc();
        if (ULDR == false && fOrB == false)
            getLocation().setRightLoc();
        fOrB = !fOrB;
        
        
    }

}
