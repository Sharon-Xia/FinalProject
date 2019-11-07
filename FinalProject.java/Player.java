import apcslib.*;
import chn.util.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Player extends Object
{
    public static final int NOT_MOVING = 1;
    public static final int MOVING_LEFT = 2;
    public static final int MOVING_RIGHT = 3;
    public static final int JUMPING_UP = 4;
    public static final int JUMPING_LEFT = 5;
    public static final int JUMPING_RIGHT = 6;
    public static final int FALLING = 7;
    private int currentState;
    private int backUpState;
    public Player(Loc location)
    {
        super(location, true);
        currentState = NOT_MOVING;
        backUpState = NOT_MOVING;
    }

    public boolean canMoveLeft(Level level)
    {
        for (Platform p: level.getPlats())
        {
            if (p.isVisible() && (isOnRight(p.getLocation()) || (p.isOnLeft(getLocation()))))
                return false;
        }
        for (MovingPlatform m: level.getMoves())
        {
            if (m.isVisible() && (isOnRight(m.getLocation()) || (m.isOnLeft(getLocation()))))
                return false;
        }
        return true;
    }

    public boolean canMoveRight(Level level)
    {
        for (Platform p: level.getPlats())
        {
            if (p.isVisible() && (isOnLeft(p.getLocation()) || (p.isOnRight(getLocation()))))
                return false;
        }
        for (MovingPlatform m: level.getMoves())
        {
            if (m.isVisible() && (isOnLeft(m.getLocation()) || (m.isOnRight(getLocation()))))
                return false;
        }
        return true;
    }

    public boolean canWalk(Level level)
    {
        for (Platform p: level.getPlats())
        {
            if (p.isVisible() && (isOnTop(p.getLocation()) || (p.isOnBottom(getLocation()))))
                return true;
        }
        for (MovingPlatform m: level.getMoves())
        {
            if (m.isVisible() && (isOnTop(m.getLocation()) || (m.isOnBottom(getLocation()))))
                return true;
        }
        for (Trigger t: level.getTrigs())
        {
            if (t.isVisible() && (isOnTop(t.getLocation()) || (t.isOnBottom(getLocation()))))
                return true;
        }
        return false;
    }

    public boolean canGoUp(Level level)
    {
        for (Platform p: level.getPlats())
        {
            if (p.isVisible() && (isOnBottom(p.getLocation()) || (p.isOnTop(getLocation()))))
                return false;
        }
        for (MovingPlatform m: level.getMoves())
        {
            if (m.isVisible() && (isOnBottom(m.getLocation()) || (m.isOnTop(getLocation()))))
                return false;
        }
        return true;
    }

    public void fall(Level level)
    {
        if(!(canWalk(level)) && 
        (getState() != JUMPING_UP && getState() != JUMPING_LEFT && getState() != JUMPING_RIGHT))
        {
            setState(FALLING);

        }

    }

    public void setState(int state)
    {
        currentState = state;
        if (state != FALLING)
            setBackUpState(currentState);
        else
            backUpState = NOT_MOVING;    
    }

    public int getState()
    {
        return currentState;
    }

    public void setBackUpState(int state)
    {
        backUpState = state;
    }

    public int getBackUpState()
    {
        return backUpState;
    }

    
    //the stick figure
}
