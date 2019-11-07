import apcslib.*;
import chn.util.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Level5 extends Level
{
    public Level5()
    {
        super(new Loc(1, 31, 506, 586), new Loc(871, 901, 500, 580));
        platforms.add(new Platform(new Loc(0, 1, 0, 601), true));
        platforms.add(new Platform(new Loc(901, 902, 0, 601), true));
        platforms.add(new Platform(new Loc(1, 901, 0, 1), true));
        platforms.add(new Platform(new Loc(1, 32, 586, 600), true));
        platforms.add(new Platform(new Loc(1, 60, 100, 115), true));
        platforms.add(new Platform(new Loc(340, 360, 310, 590), true));
        platforms.add(new Platform(new Loc(340, 360, 220, 310), true));
        platforms.add(new Platform(new Loc(340, 360, 1, 220), true));
        platforms.add(new Platform(new Loc(360, 400, 340, 360), true));
        platforms.add(new Platform(new Loc(520, 560, 220, 240), true));
        platforms.add(new Platform(new Loc(560, 580, 100, 600), true));
        platforms.add(new Platform(new Loc(580, 610, 100, 110), true));
        
        
        moves.add(new MovingPlatform(new Loc(180, 240, 438, 448), true, new Loc(180, 240, 245, 468), 5, true, true));
        
        moves.add(new MovingPlatform(new Loc(610, 636, 580, 592), true, new Loc(610, 800, 580, 592), 5, false, false));
        
        triggers.add(new Trigger(new Loc(1, 30, 85, 100), platforms.get(7)));
        addTriggerPlatforms();
        puddles.add(new Water(new Loc(440, 460, 1, 120), true));
        puddles.add(new Water(new Loc(32, 901, 591, 601), true));
        puddles.add(new Water(new Loc(726,900,430,440), true));
        
    }
    
    public int getLevelNumber()
    {
        return 5;
    }

}
