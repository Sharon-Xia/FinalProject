import apcslib.*;
import chn.util.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Level1 extends Level
{
   public Level1()
    {
        super(new Loc(50, 80, 420, 500), new Loc(750, 800, 480, 500));
        platforms.add(new Platform(new Loc(0, 1, 0, 601), true));
        platforms.add(new Platform(new Loc(901, 902, 0, 601), true));
        platforms.add(new Platform(new Loc(1, 901, 0, 1), true));
        platforms.add(new Platform(new Loc(1, 300, 500, 601), true));
        platforms.add(new Platform(new Loc(350, 550, 500, 601), true));
        platforms.add(new Platform(new Loc(600, 900, 500, 601), true));
        puddles.add(new Water(new Loc(300, 350, 500, 601), true));
        puddles.add(new Water(new Loc(550, 600, 500, 601), true));
    }
    
    public int getLevelNumber()
    {
        return 1;
    }

}
