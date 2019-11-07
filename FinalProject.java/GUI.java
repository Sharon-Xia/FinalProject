import apcslib.*;
import chn.util.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.net.URL;
import java.io.*;
public class GUI extends JFrame implements ActionListener
{
    private ImageIcon standingPerson;
    private Image personImage;
    private Level lev;
    private int jumpingLimit;
    
    
     
    public GUI()
    {
        super("The Adventures of Stob the Sitick Figure");
        jumpingLimit = 0;
        Container container = getContentPane();
        try
        {
            ClassLoader cldr = this.getClass().getClassLoader();
            URL standingURL = cldr.getResource("Standing.PNG");
            standingPerson = new ImageIcon(standingURL);
            personImage = standingPerson.getImage();
        }
        catch (Exception f)
        {
            try
            {
                PrintStream p = new PrintStream(new FileOutputStream(new File("trace.txt")));
                p.println("got here");
                f.printStackTrace(p);
            }
            catch (Exception g)
            {
            }
        }
        lev = new Level1();
        addKeyListener(new KeyHandler());
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
                System.exit(0);
            }
        });
        setSize(902, 601);
        
        setVisible(true);
        repaint();
        new javax.swing.Timer(5, this).start();
    }
    
    public void paint(Graphics g)
    {
       //super.paint(g);
       Image offImage = createImage(902, 601);
       // Creates an off-screen drawable image to be used for
       // double buffering; XSIZE, YSIZE are each of type ‘int’
       Graphics buffer = offImage.getGraphics();
       // Creates a graphics context for drawing to an 
       // off-screen image
       
       paintOffScreen(buffer);      // your own method
       g.drawImage(offImage, 0, 0, null);   
       // draws the image with upper left corner at 0,0
    }  
    public void paintOffScreen(Graphics g)
    {
        // use ‘g.drawImage()’ as needed to draw all the
        // images on the second buffer
        g.setColor(Color.blue);
        for (Water w: lev.getPuddles())
        {
            if (w.isVisible())
                g.fillRect(w.getLocation().getXl(), w.getLocation().getYu(), w.getWidth(), w.getHeight());
        }   
        g.setColor(Color.black);
        if (jumpingLimit > 160)
        {
            g.drawString("Falling",1,40);
        }
        else
        {
            g.drawString("Jetpack Power: " + (160 - jumpingLimit), 1, 40);
        }
           for (Platform p: lev.getPlats())
        {
            if (p.isVisible())
                g.fillRect(p.getLocation().getXl(), p.getLocation().getYu(), p.getWidth(), p.getHeight());
        }
        for (MovingPlatform m: lev.getMoves())
        {
            if (m.isVisible())
                g.fillRect(m.getLocation().getXl(), m.getLocation().getYu(), m.getWidth(), m.getHeight());
        }
        g.setColor(Color.green);
        for (Trigger t: lev.getTrigs())
            {
                 if (t.isVisible())
                    g.fillRect(t.getLocation().getXl(), t.getLocation().getYu(), t.getWidth(), t.getHeight());
            }
        g.setColor(Color.red);
        if (lev.getCheckpoint().isVisible())
            g.fillRect(lev.getCheckpoint().getLocation().getXl(), lev.getCheckpoint().getLocation().getYu(), 
            lev.getCheckpoint().getWidth(), lev.getCheckpoint().getHeight());
        if (lev.getPlayer().isVisible())
            g.drawImage(personImage, lev.getPlayer().getLocation().getXl(), lev.getPlayer().getLocation().getYu(), 
            lev.getPlayer().getWidth(), lev.getPlayer().getHeight(), this); 
    }

    
    public void testNextLevel()
    {
        
        if (lev.getHappened() == 1)
        {
            if (lev.getLevelNumber() == 6)
            {
                lev = new Level7();
                jumpingLimit = 0;
            }
            else if (lev.getLevelNumber() == 5)
            {
                lev = new Level6();
                jumpingLimit = 0;
            }
            else if (lev.getLevelNumber() == 4)
            {
                lev = new Level5();
                jumpingLimit = 0;
            }
            else if (lev.getLevelNumber() == 3)
            {
                lev = new Level4();
                jumpingLimit = 0;
            }
            else if (lev.getLevelNumber() == 2)
            {
                lev = new Level3();
                jumpingLimit = 0;
            }
            else if (lev.getLevelNumber() == 1)
            {
                lev = new Level2();
                jumpingLimit = 0;
            }
            lev.setHappened(0);
        }  
        if (lev.getHappened() ==2)
            jumpingLimit = 0;     
    }
    
    
    public void actionPerformed(ActionEvent event)
    {
       
        lev.run();
        testNextLevel();
        lev.testBackToStart();
        lev.getPlayer().fall(lev);
        if (!(lev.getPlayer().canGoUp(lev)))
        {
            lev.getPlayer().setState(lev.getPlayer().FALLING);
        }
        lev.moveOnPlatforms();
        //lev.tryPushPlayer();
        if (lev.getPlayer().getState() == Player.MOVING_LEFT && (lev.getPlayer().canWalk(lev)) && (lev.getPlayer().canMoveLeft(lev)))
        {
            lev.getPlayer().getLocation().setLeftLoc();
        }
        else if (lev.getPlayer().getState() == Player.MOVING_RIGHT && (lev.getPlayer().canWalk(lev)) && (lev.getPlayer().canMoveRight(lev)))
        {
            lev.getPlayer().getLocation().setRightLoc();
        }
        else if (lev.getPlayer().getState() == Player.JUMPING_UP)
        {
            if ((lev.getPlayer().canGoUp(lev)) && jumpingLimit <= 160)
            {
                lev.getPlayer().getLocation().setUpLoc();
                jumpingLimit++;
            }
            else 
            {
                lev.getPlayer().setState(lev.getPlayer().FALLING);
                jumpingLimit = 161;
            }
            
        }
        else if (lev.getPlayer().getState() == Player.JUMPING_LEFT)
        {
            if ((lev.getPlayer().canGoUp(lev)) && (lev.getPlayer().canMoveLeft(lev)) && jumpingLimit <= 160)
            {
                lev.getPlayer().getLocation().setUpLeftLoc();
                jumpingLimit++;
            }
            else if (!(lev.getPlayer().canMoveLeft(lev)) && !(lev.getPlayer().canWalk(lev)))
            {
                lev.getPlayer().setState(lev.getPlayer().FALLING);
                jumpingLimit = 161;
            }
            else if ((lev.getPlayer().canMoveLeft(lev)) && !(lev.getPlayer().canWalk(lev)))
            {
                lev.getPlayer().getLocation().setDownLeftLoc();
                jumpingLimit = 161;
            }
            else if (lev.getPlayer().canWalk(lev))
            {
                jumpingLimit = 0;
                lev.getPlayer().setState(lev.getPlayer().NOT_MOVING);
            }
        }
        else if (lev.getPlayer().getState() == Player.JUMPING_RIGHT)
        {
            if ((lev.getPlayer().canGoUp(lev)) && (lev.getPlayer().canMoveRight(lev)) && jumpingLimit <= 160)
            {
                lev.getPlayer().getLocation().setUpRightLoc();
                jumpingLimit++;
            }
            else if (!(lev.getPlayer().canMoveRight(lev)) && !(lev.getPlayer().canWalk(lev)))
            {
                lev.getPlayer().setState(lev.getPlayer().FALLING);
                jumpingLimit = 161;
            }
            else if ((lev.getPlayer().canMoveRight(lev)) && !(lev.getPlayer().canWalk(lev)))
            {
                lev.getPlayer().getLocation().setDownRightLoc();
                jumpingLimit = 161;
            }
            else if (lev.getPlayer().canWalk(lev))
            {
                jumpingLimit = 0;
                lev.getPlayer().setState(lev.getPlayer().NOT_MOVING);
            }
        }
        if (lev.getPlayer().getState() == Player.FALLING)
        {
            if (!(lev.getPlayer().canWalk(lev)))
                lev.getPlayer().getLocation().setDownLoc();
            else
            {
                lev.getPlayer().setState(lev.getPlayer().NOT_MOVING);
                jumpingLimit = 0;
            }
        }
        for (Trigger t : lev.getTrigs())
        {
            t.processPlayer(lev.getPlayer());
        }
        repaint();
       
    }        
     private class KeyHandler implements KeyListener
    {
        public void keyPressed(KeyEvent event)
        {
            
            if ((lev.getPlayer().canGoUp(lev)) && (lev.getPlayer().canMoveLeft(lev)) && 
            event.getKeyCode() == KeyEvent.VK_Q)
            {
                
                lev.getPlayer().setState(lev.getPlayer().JUMPING_LEFT);
            }
            if ((lev.getPlayer().canGoUp(lev)) && (lev.getPlayer().canMoveRight(lev)) && 
            event.getKeyCode() == KeyEvent.VK_W)
            {
                
                lev.getPlayer().setState(lev.getPlayer().JUMPING_RIGHT);
            }
            if ((lev.getPlayer().canWalk(lev)) && (lev.getPlayer().canMoveLeft(lev)) && event.getKeyCode() == KeyEvent.VK_LEFT )
            {
                
                lev.getPlayer().setState(lev.getPlayer().MOVING_LEFT);
            }
            if ((lev.getPlayer().canWalk(lev)) && (lev.getPlayer().canMoveRight(lev)) && event.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                
                lev.getPlayer().setState(lev.getPlayer().MOVING_RIGHT);
            }
            if ((lev.getPlayer().canGoUp(lev)) && event.getKeyCode() == KeyEvent.VK_UP)
            {
                
                lev.getPlayer().setState(lev.getPlayer().JUMPING_UP);
            }
            
           
        }

        public void keyReleased(KeyEvent event)
        {
            if ((lev.getPlayer().canWalk(lev)) && event.getKeyCode() == KeyEvent.VK_RIGHT && lev.getPlayer().getState() == 
            lev.getPlayer().MOVING_RIGHT)
                lev.getPlayer().setState(lev.getPlayer().NOT_MOVING);
            if ((lev.getPlayer().canWalk(lev)) && lev.getPlayer().getState() == lev.getPlayer().MOVING_LEFT && event.getKeyCode() ==
            KeyEvent.VK_LEFT)
                lev.getPlayer().setState(lev.getPlayer().NOT_MOVING);
            if (lev.getPlayer().getState() == lev.getPlayer().JUMPING_UP && event.getKeyCode() == KeyEvent.VK_UP)
            {
                if (lev.getPlayer().canWalk(lev))
                    lev.getPlayer().setState(lev.getPlayer().NOT_MOVING);
                else
                    lev.getPlayer().setState(lev.getPlayer().FALLING);
            }
            if ((event.getKeyCode() == KeyEvent.VK_Q) && 
            lev.getPlayer().getState() == lev.getPlayer().JUMPING_LEFT)
            {
                if (lev.getPlayer().canWalk(lev))
                    lev.getPlayer().setState(lev.getPlayer().NOT_MOVING);
                else
                    lev.getPlayer().setState(lev.getPlayer().FALLING);
            }
            if ((event.getKeyCode() == KeyEvent.VK_W) && 
            lev.getPlayer().getState() == lev.getPlayer().JUMPING_RIGHT)
            {
                if (lev.getPlayer().canWalk(lev))
                    lev.getPlayer().setState(lev.getPlayer().NOT_MOVING);
                else
                    lev.getPlayer().setState(lev.getPlayer().FALLING);
            }
           
        }
        
    public void keyTyped(KeyEvent event)
    {
    }
    }    
}








