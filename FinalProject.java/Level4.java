import apcslib.*;
import chn.util.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Level4 extends Level
{
    public Level4()
    {
        
        super(new Loc(1,31,450, 530),new Loc(1,50,120,130));
        //instantiating platforms
        platforms.add(new Platform(new Loc(0,1,0,600), true));//left
        platforms.add(new Platform(new Loc(1,900,0,1), true));//top
        platforms.add(new Platform(new Loc(900,901,1,601), true));//right
        platforms.add(new Platform(new Loc(1,260,530,570), true));
        moves.add(new MovingPlatform(new Loc(271,370,530,570),true,new Loc(261,601,530,570),2,false,true));
        
        
        platforms.add(new Platform(new Loc(601,630,431,570),false));//appearing, Trigger Loc(801,850,521,530)
        platforms.add(new Platform(new Loc(631,900,531,570),true));
        platforms.add(new Platform(new Loc(631,780,381,410),false));//appearing, Trigger Loc(851,900,521,530)
        platforms.add(new Platform(new Loc(780,900,241,270),false));//appearing, Trigger Loc(631,680,371,380)
        platforms.add(new Platform(new Loc(601,630,101,431),true));
        platforms.add(new Platform(new Loc(601,902,1,100),true));//disappearing, Trigger Loc(851,900,230,240)
        moves.add(new MovingPlatform(new Loc(451,550,81,110),true,new Loc(451,550,81,350),2,true,true));
        
        moves.add(new MovingPlatform(new Loc(301,400,251,280),true,new Loc(301,400,81,350),1,true,false));
        
        platforms.add(new Platform(new Loc(1,261,130,160),true));

        //add Triggers
        triggers.add(new Trigger(new Loc(801,850,520,530),platforms.get(5)));
        triggers.add(new Trigger(new Loc(851,900,520,530),platforms.get(7)));
        triggers.add(new Trigger(new Loc(631,680,380,390),platforms.get(8)));
        triggers.add(new Trigger(new Loc(851,900,230,240),platforms.get(1)));
        addTriggerPlatforms();

    }
    
    public int getLevelNumber()
    {
        return 4;
    }

}
