
/**
 * Write a description of class Water here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import apcslib.*;
import chn.util.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Water extends Platform//sends the player back to start
{
    public Water(Loc location)
    {
        super(location, true);
    }

    public Water(Loc location, boolean visibility)
    {
        super(location, visibility);
    }
}

