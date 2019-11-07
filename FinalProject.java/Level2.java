import apcslib.*;
import chn.util.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Level2 extends Level
{
    public Level2()
    {
        super(new Loc(1,30,461,540),new Loc(630,650,461,540));
        platforms.add(new Platform(new Loc(0,1,0,600), true));//left
        platforms.add(new Platform(new Loc(0,900,0,1), true));//top
        platforms.add(new Platform(new Loc(900,901,0,601), true));//right
        platforms.add(new Platform(new Loc(0,250,540,570),true));
        moves.add(new MovingPlatform(new Loc(300,380,0,30),true,new Loc(300,380,0,600),1,true,true));
        moves.add(new MovingPlatform(new Loc(420,500,320,350),true,new Loc(420,500,0,350),1,true,false));
        moves.add(new MovingPlatform(new Loc(540,620,350,380),true,new Loc(540,620,350,600),2,true,false));
        
        platforms.add(new Platform(new Loc(620,650,0,120),true)); //Trigger Loc(591,600,341,350)
        platforms.add(new Platform(new Loc(620,630,460, 540), true));
        platforms.add(new Platform(new Loc(620,650,120,600),true));
        platforms.add(new Platform(new Loc(620,700,540,570), true));
        puddles.add(new Water(new Loc(660,750,110,140), true));
        platforms.add(new Platform(new Loc(650, 740, 100, 110), true));
        puddles.add(new Water(new Loc(740,900,310,340), true));
        platforms.add(new Platform(new Loc(750,840,300,310), true));
        puddles.add(new Water(new Loc(650,800,540,570), true));
        platforms.add(new Platform(new Loc(650,740, 530, 540), true));
        
        //Triggers
        triggers.add(new Trigger(new Loc(591,600,341,350),platforms.get(4)));
        addTriggerPlatforms();
        
    }

     public int getLevelNumber()
    {
        return 2;
    }

}
