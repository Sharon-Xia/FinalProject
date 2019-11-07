import apcslib.*;
import chn.util.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Level3 extends Level
{
   public Level3()
    {
        
        super(new Loc(1, 31, 511, 591), new Loc(871, 901, 331, 341));
        platforms.add(new Platform(new Loc(0, 1, 0, 601), true));
        platforms.add(new Platform(new Loc(901, 902, 0, 601), true));
        platforms.add(new Platform(new Loc(1, 901, 0, 1), true));
        platforms.add(new Platform(new Loc(1, 62, 593, 601), true));
        platforms.add(new Platform(new Loc(841, 901, 593, 601), true));
        platforms.add(new Platform(new Loc(166, 196, 551, 593), true));
        platforms.add(new Platform(new Loc(301, 331, 511, 593), true));
        platforms.add(new Platform(new Loc(436, 466, 471, 593), true));
        platforms.add(new Platform(new Loc(571, 601, 511, 593), true));
        platforms.add(new Platform(new Loc(706, 736, 551, 593), true));
        platforms.add(new Platform(new Loc(801, 871, 331, 341), true));
        platforms.add(new Platform(new Loc(801, 901, 231, 241), true));
        moves.add(new MovingPlatform(new Loc(436, 466, 232, 330), true, new Loc(436, 896, 232, 330), 5, false, false));
        moves.add(new MovingPlatform(new Loc(61, 161, 331, 341), false, new Loc(61, 681, 331, 341), 5, false, false));
        triggers.add(new Trigger(new Loc(871, 901, 581, 591), moves.get(1)));
        puddles.add(new Water(new Loc(62, 840, 593, 601), true));
        puddles.add(new Water(new Loc(801,901,341,351), true));

    }
    
    public int getLevelNumber()
    {
        return 3;
    }

}
