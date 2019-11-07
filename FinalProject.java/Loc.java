import apcslib.*;
import chn.util.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Loc
{
    
    private int myXl;
    private int myYu;
    private int myXr;
    private int myYd;
    
    /* Constructs a Loc, or location. The xl stands for the leftmost x-coordinate of the object's current location, the xr
       stands for the rightmost x-coordinate, the yu stands for the top y-coordinate of the object's current location, and the 
       yd stands for the lowest y-coordinate. For instance, if a rectangle was drawn with its top-left corner at the coordinates 
       (50, 60) and has a width of 40 and a height of 50, it's xl would be 50, it's yu would be 60, it's xr would be 50 + 40 = 90
       and it's yd would be 60 + 50 =110.*/ 
    public Loc(int xl, int xr, int yu, int yd) 
    {
        myXl = xl;
        myXr = xr;
        myYu = yu;
        myYd = yd;
    }
    
    /* sets the Xl, the leftmost x-coordinate of the object's current location, to the new integer given in the parameter*/
    public void setXl(int xl)
    {
        myXl = xl;
    }
    
    /* returns the leftmost x-coordinate of the object's current location*/
    public int getXl()
    {
        return myXl;
    }
    
    /* sets the Yu, the upmost y-coordinate of the object's current location, to the new integer given in the parameter*/
    public void setYu(int yu)
    {
        myYu = yu;
    }
    
    /* returns the topmost y-coordinate of the object's current location*/
    public int getYu()
    {
        return myYu;
    }
    
    /* sets the Xr, the rightmost x-coordinate of the object's current location, to the new integer given in the parameter*/
    public void setXr(int xr)
    {
        myXr = xr;
    }
    
    /* returns the rightmost x-coordinate of the object's current location*/
    public int getXr()
    {
        return myXr;
    }
    
    /* sets the Yd, the lowermost y-coordinate of the object's current location, to the new integer given in the parameter*/
    public void setYd(int yd)
    {
        myYd = yd;
    }
    
    /* returns the lowermost y-coordinate of the object's current location*/
    public int getYd()
    {
        return myYd;
    }
    
    /* moves an object one unit to the left*/
    public void setLeftLoc()
    {
        setXl(myXl - 1);
        setXr(myXr - 1);
    }
    
    /* moves an object one unit to the right*/
    public void setRightLoc()
    {
        setXl(myXl + 1);
        setXr(myXr + 1);
    }
    
    /* moves an object one unit up*/
    public void setUpLoc()
    {
        setYu(myYu - 1);
        setYd(myYd - 1);
    }
    
    /*moves an object one unit up and one unit left*/
    public void setUpLeftLoc()
    {
       setLeftLoc();
       setUpLoc();
    }
    
    /* moves an object one unit up and one unit right*/
    public void setUpRightLoc()
    {
        setRightLoc();
        setUpLoc();
    }
    
    /* moves an object one unit down*/
    public void setDownLoc()
    {
        setYu(myYu +1);
        setYd(myYd + 1);
    }
    
    /* moves an object one unit down and one unit left*/
    public void setDownLeftLoc()
    {
        setLeftLoc();
        setDownLoc();
    }
    
    /* moves an object one unit down and one unit right*/
    public void setDownRightLoc()
    {
        setRightLoc();
        setDownLoc();
    }

}
