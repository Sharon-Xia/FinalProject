import apcslib.*;
import chn.util.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Level6 extends Level
{
    public Level6()
    {
        super(new Loc(10, 25, 50, 90), new Loc(800,840,455,480));
        platforms.add(new Platform(new Loc(0, 1, 0, 601), true));
        platforms.add(new Platform(new Loc(901, 902, 0, 601), true));
        platforms.add(new Platform(new Loc(1, 901, 0, 1), true));
        platforms.add(new Platform(new Loc(1,50,90,100), true));
        moves.add(new MovingPlatform(new Loc(700,800,120,130), true, new Loc(100,901,120,130), 2, false, true));
        puddles.add(new Water(new Loc(600,700,0,40), true));
        puddles.add(new Water(new Loc(750,850,0,40), true));
        puddles.add(new Water(new Loc(0,600,130,140), true));
        puddles.add(new Water(new Loc(600,650,130,140), true));
        puddles.add(new Water(new Loc(650,901,130,140), true));
        platforms.add(new Platform(new Loc(100,150,140,280), true));
        platforms.add(new Platform(new Loc(325,375,140,280), true));
        platforms.add(new Platform(new Loc(550,600,140,280), true));
        moves.add(new MovingPlatform(new Loc(400,450,280,300), true, new Loc(100,901,280,300), 2, false, false));
        platforms.add(new Platform(new Loc(0,100,300,310), true));
        puddles.add(new Water(new Loc(100,901,300,310), true));
        platforms.add(new Platform(new Loc(1,375,470,480), true));
        platforms.add(new Platform(new Loc(375,400,310,480), true));
        moves.add(new MovingPlatform(new Loc(450,500,580,600), true, new Loc(1,901,580,600),2,false,true));
        puddles.add(new Water(new Loc(800,901,500,600), true));
        puddles.add(new Water(new Loc(400,450,470,490), true));
        platforms.add(new Platform(new Loc(400,450,450,470), true));
        platforms.add(new Platform(new Loc(600,620,310,370), true));
        platforms.add(new Platform(new Loc(600,710,370,380), true));
        platforms.add(new Platform(new Loc(680,710,380,500), true));
        platforms.add(new Platform(new Loc(710,901,490,500), true));
        puddles.add(new Water(new Loc(710,770,370,490), true));
        puddles.add(new Water(new Loc(870,901,370,480), true));
        puddles.add(new Water(new Loc(770,901,480,490), true));
        puddles.add(new Water(new Loc(770,870,380,405), false));
        puddles.add(new Water(new Loc(770,870,405,430), false));
        puddles.add(new Water(new Loc(770,870,430,455), false));
        triggers.add(new Trigger(new Loc(700,750,0,40), puddles.get(3)));
        triggers.add(new Trigger(new Loc(660,670,140,150), platforms.get(6)));
        triggers.add(new Trigger(new Loc(760,770,140,150), platforms.get(5)));
        triggers.add(new Trigger(new Loc(860,870,140,150), platforms.get(4)));
        triggers.add(new Trigger(new Loc(1,20,260,280), platforms.get(7)));
        triggers.add(new Trigger(new Loc(365,375,320,330), platforms.get(8)));
        triggers.add(new Trigger(new Loc(400,420,310,320), platforms.get(11)));
        triggers.add(new Trigger(new Loc(620,650,365,370), puddles.get(11)));
        triggers.add(new Trigger(new Loc(680,710,310,315), puddles.get(12)));
        triggers.add(new Trigger(new Loc(740,770,365,370), puddles.get(13)));
        addTriggerPlatforms();
        
    }
    
    public int getLevelNumber()
    {
        return 6;
    }
}
