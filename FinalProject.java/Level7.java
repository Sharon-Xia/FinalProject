import apcslib.*;
import chn.util.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Level7 extends Level
{
    public Level7()
    {
        super(new Loc(885,900, 540, 580), new Loc(635, 680, 210,220));
        platforms.add(new Platform(new Loc(0,1,0,600), true));//left
        platforms.add(new Platform(new Loc(0,900,0,1), true));//top
        platforms.add(new Platform(new Loc(900,901,0,601), true));//right
        platforms.add(new Platform(new Loc(870, 901, 580, 600), true));
        moves.add(new MovingPlatform(new Loc(830, 850, 580, 600), true, new Loc(700, 870, 580, 600), 2, false, false));
        puddles.add(new Water(new Loc(700, 870, 590, 600), true));
        puddles.add(new Water(new Loc(650, 700, 550, 600), true));
        platforms.add(new Platform(new Loc(600, 700, 540, 550), true));
        puddles.add(new Water(new Loc(460, 560, 580, 600), true));
        puddles.add(new Water(new Loc(120, 160,560,600), true));
        moves.add(new MovingPlatform(new Loc(400, 480, 585, 600), true, new Loc(160, 650, 585, 600), 2, false, true));
        platforms.add(new Platform(new Loc(40, 120, 580, 600), true));
        puddles.add(new Water(new Loc(1, 40, 560, 600), true));
        platforms.add(new Platform(new Loc(160, 901, 489, 490), true));//bottom barrier platform
        moves.add(new MovingPlatform(new Loc(1, 40, 500, 540), true, new Loc(0, 40, 400, 560), 2, true, true));
        moves.add(new MovingPlatform(new Loc(40, 80, 300, 340), true, new Loc(40, 80, 250, 400), 2, true, false));
        puddles.add(new Water(new Loc(80, 100, 230, 450), true));
        puddles.add(new Water(new Loc(100, 160, 430, 450), true));
        moves.add(new MovingPlatform(new Loc(100, 120, 200, 240), true, new Loc(100, 120, 100, 370), 2, true, true));
        platforms.add(new Platform(new Loc(120, 160, 370, 410), true));//platform that contains the first trigger
        platforms.add(new Platform(new Loc(160, 161, 100, 490), true));//left barrier platform
        platforms.add(new Platform(new Loc(160, 700, 99, 100), true));//first top barrier platform
        platforms.add(new Platform(new Loc(740, 900, 99, 100), true));//second top barrier platform
        platforms.add(new Platform(new Loc(700, 740, 90, 100), true));//platform that will disappear when first trigger is pressed
        puddles.add(new Water(new Loc(160, 180, 80, 100), true));
        platforms.add(new Platform(new Loc(180, 280, 80, 100), true));
        puddles.add(new Water(new Loc(280, 700, 90, 100), true));
        moves.add(new MovingPlatform(new Loc(300, 340, 70, 90), true, new Loc(280, 380, 70, 90), 2, false, false));
        moves.add(new MovingPlatform(new Loc(640, 680, 70, 90), true, new Loc(450, 900, 70, 90), 2, false, true));
        puddles.add(new Water(new Loc(740, 900, 90, 100), true));
        platforms.add(new Platform(new Loc(695, 700, 100, 430), true));//inside entrance left platform
        platforms.add(new Platform(new Loc(740, 745, 100, 430), true));//inside entrance right platform
        puddles.add(new Water(new Loc(161, 900, 480, 489), true));//bottom water in interior
        moves.add(new MovingPlatform(new Loc(500, 550, 475, 480), true, new Loc(500, 900, 475, 480), 2, false, true));//bottom moving platform
        platforms.add(new Platform(new Loc(745, 800, 380, 400), true));
        platforms.add(new Platform(new Loc(850, 900, 280, 300), true));
        moves.add(new MovingPlatform(new Loc(760, 800, 230, 240), true, new Loc(760, 800, 220, 260), 2, true, false));
        moves.add(new MovingPlatform(new Loc(760, 780, 150, 160), true, new Loc(745, 900, 150, 160), 2, false, false));
        puddles.add(new Water(new Loc(815,820,160,190), true));
        puddles.add(new Water(new Loc(820,880,185, 190), true));
        puddles.add(new Water(new Loc(880,885, 160,190), true));
        platforms.add(new Platform(new Loc(820,880,180,185), true));//platform that contains the second trigger
        moves.add(new MovingPlatform(new Loc(430, 450, 470, 475),true,new Loc(400,500,470,475), 2, false, true));
        puddles.add(new Water(new Loc(390, 420, 450, 470), true));//square water block
        moves.add(new MovingPlatform(new Loc(400, 430, 440, 450), true, new Loc(280, 480, 440, 450), 2, false, false));//moving platform above square water
        moves.add(new MovingPlatform(new Loc(480, 510, 380, 390), true, new Loc(480, 510, 300, 400), 2, true, true));
        puddles.add(new Water(new Loc(510, 550, 320, 430), true));//right tall interior block of water
        platforms.add(new Platform(new Loc(510, 695, 300, 320), true));//platform that contains third trigger
        puddles.add(new Water(new Loc(540, 580, 280, 300), true));//thid trigger will be to the right of this
        puddles.add(new Water(new Loc(640, 680, 280, 300), true));//third trigger will be to the left of this
        puddles.add(new Water(new Loc(420, 435,240, 390), true));//left interior tall block of water
        puddles.add(new Water(new Loc(240,280,240,400),true));
        puddles.add(new Water(new Loc(240, 280, 450, 470), true));
        moves.add(new MovingPlatform(new Loc(240, 280, 460, 480), true, new Loc(240, 280, 240, 480), 2, true, true));
        platforms.add(new Platform(new Loc(200, 240, 460, 480), true));
        moves.add(new MovingPlatform(new Loc(160, 200, 400, 420), false, new Loc(160, 200, 100, 480), 2, true, false));//moving platform, appears when 2nd trigger pressed
        puddles.add(new Water(new Loc(161, 200, 102, 150), true));
        platforms.add(new Platform(new Loc(200,220,100,220), true));//platform that disappears when third trigger is pressed
        puddles.add(new Water(new Loc(200,250,220,240), true));
        platforms.add(new Platform(new Loc(230,695,220,240), true));//platform that holds the 4th trigger
        puddles.add(new Water(new Loc(220, 600, 102, 130), true));//puddle that blocks top of chamber in interior
        puddles.add(new Water(new Loc(300, 340, 200, 220), true));//4th trigger will be to the right of this
        puddles.add(new Water(new Loc(400, 440, 200, 220), true));//4th trigger will be to the left of this
        moves.add(new MovingPlatform(new Loc(350, 380, 200, 210), true, new Loc(260, 550, 200, 210), 2, false, true));
        puddles.add(new Water(new Loc(600, 620, 100, 220), true));//puddle that disappears when 4th trigger is pressed
        puddles.add(new Water(new Loc(620,635,190,220),true));
        platforms.add(new Platform(new Loc(620,640,180,190),true));
        puddles.add(new Water(new Loc(635,695,102,130),true));
        puddles.add(new Water(new Loc(680,695,130,220),true));
        triggers.add(new Trigger(new Loc(140,150,360,370),platforms.get(11)));//first trigger
        triggers.add(new Trigger(new Loc(840,860,175,180),moves.get(14)));//second trigger
        triggers.add(new Trigger(new Loc(600,620,290,300),platforms.get(20)));//third trigger
        triggers.add(new Trigger(new Loc(365,385,210,220),puddles.get(25)));//fourth trigger
        addTriggerPlatforms();    
    }
    
    public int getLevelNumber()
    {
        return 7;
    }
}

