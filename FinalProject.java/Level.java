import apcslib.*;
import chn.util.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public abstract class Level
{
    protected int whatHappened = 0;
    protected ArrayList<Platform> platforms;
    protected ArrayList<MovingPlatform> moves;
    protected ArrayList<Trigger> triggers;
    protected ArrayList<Water> puddles;
    protected Loc startOfLvl;
    protected Loc endOfLvl;
    protected Player person;
    protected Checkpoint end;

    public Level(Loc startLoc, Loc endLoc)
    {

        platforms = new ArrayList<Platform>();
        triggers = new ArrayList<Trigger>();
        puddles = new ArrayList<Water>();
        moves = new ArrayList<MovingPlatform>();
        startOfLvl = startLoc;
        endOfLvl = endLoc;
        person = new Player(new Loc(startOfLvl.getXl(), startOfLvl.getXr(), startOfLvl.getYu(), startOfLvl.getYd()));
        end = new Checkpoint(endLoc);

    }

    public Loc getStartLoc()
    {
        return startOfLvl;
    }

    public Loc getEndLoc()
    {
        return endOfLvl;
    }

    public void addTriggerPlatforms()
    {
        for (Trigger t: triggers)
        {
            if (t.getPlatform() instanceof Platform)
                platforms.add(t.getPlatform());
            else if (t.getPlatform() instanceof MovingPlatform)
                moves.add(t.getMovingPlatform());
            else
                puddles.add(t.getWater());
        }
    }

    public void moveOnPlatforms()
    {
        for (MovingPlatform m : moves)
        {
            if ((person.isOnTop(m.getLocation())) || (m.isOnBottom(person.getLocation())))
            {
                if (m.isCompletelyWithin(m.getBorder()))
                {
                    if (m.getType() == true && m.getDirection() == true  && person.canGoUp(this)) 
                        person.getLocation().setUpLoc();
                    else if (m.getType() == true && m.getDirection() == false)
                        person.getLocation().setDownLoc();
                    else if (m.getType() == false && m.getDirection() == true && person.canMoveRight(this))
                        person.getLocation().setRightLoc();
                    else if (m.getType() == false && m.getDirection() == false && person.canMoveLeft(this))
                        person.getLocation().setLeftLoc();
                }
                else
                {
                    if (m.getType() == true && m.getDirection() == true) 
                        person.getLocation().setDownLoc();
                    else if (m.getType() == true && m.getDirection() == false && person.canGoUp(this))
                        person.getLocation().setUpLoc();
                    else if (m.getType() == false && m.getDirection() == true && person.canMoveLeft(this))
                        person.getLocation().setLeftLoc();
                    else if (m.getType() == false && m.getDirection() == false && person.canMoveRight(this))
                        person.getLocation().setRightLoc();

                }

            }
            if ((person.isOnLeft(m.getLocation())) || (m.isOnRight(person.getLocation())))
            {
                if (m.getType() == false && m.getDirection() == false && (m.isCompletelyWithin(m.getBorder())))
                    person.getLocation().setLeftLoc();
            }
            if ((person.isOnRight(m.getLocation())) || (m.isOnLeft(person.getLocation())))
            {
                if (m.getType() == false && m.getDirection() == true && (m.isCompletelyWithin(m.getBorder())))
                    person.getLocation().setRightLoc();
            }
            for (Trigger t: triggers)
            {
                if (t.isOnTop(m.getLocation()))
                {
                    if (m.getType() == true && m.getDirection() == true && !(m.isCompletelyWithin(m.getBorder())))
                        t.getLocation().setUpLoc();
                    else if (m.getType() == true && m.getDirection() == false && !(m.isCompletelyWithin(m.getBorder())))
                        t.getLocation().setDownLoc();
                    else if (m.getType() == false && m.getDirection() == true && !(m.isCompletelyWithin(m.getBorder())))
                        t.getLocation().setRightLoc();
                    else if (m.getType() == false && m.getDirection() == false && !(m.isCompletelyWithin(m.getBorder())))
                        t.getLocation().setLeftLoc();
                }
            }
            m.process();

        }
    }

    
    public void setHappened(int newStatus)
    {
        whatHappened = newStatus;
    }

    public int getHappened()
    {
        return whatHappened;
    }

    public void run()
    {
        if(person.isBorderingOrWithin(endOfLvl))
        {
            whatHappened = 1;
        }
        else if(willPlayerDie())
        {
            whatHappened = 2;
        }
        else
            whatHappened = 0;
    }

    public boolean willPlayerDie()
    {
        for (Water puddle : puddles)
        {
            if ((puddle.isVisible()) && person.isBorderingOrWithin(puddle.getLocation()))
            {
                return true;
            }
        }
        if (!(person.isWithinGrid()))
            return true;
        return false;
    }

    public void testBackToStart()
    {
        if (whatHappened == 2)
        {
            person.setLocation(new Loc(startOfLvl.getXl(), startOfLvl.getXr(), startOfLvl.getYu(), startOfLvl.getYd()));
            person.setState(person.NOT_MOVING);
            for (Trigger t: getTrigs())
            {
                if (t.getStatus() == true)
                    t.reset();

            }
            setHappened(0);
        }

    }

    public abstract int getLevelNumber();

    public ArrayList<Platform> getPlats()
    {
        return platforms;
    }

    public ArrayList<Trigger> getTrigs()
    {
        return triggers;
    }

    public ArrayList<Water> getPuddles()
    {
        return puddles;
    }

    public ArrayList<MovingPlatform> getMoves()
    {
        return moves;
    }

    public Player getPlayer()
    {
        return person;
    }

    public Checkpoint getCheckpoint()
    {
        return end;
    }    

   
    
    
}
