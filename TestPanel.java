import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.geom.*;

public class TestPanel extends JPanel{
  //Properties 
  
  //Determines background color
  boolean blnColour = true;
  
  //check if the mouse is being dragged
  boolean blnDrag = false;
  
  //checking if to start animation
  boolean blnString = false;
  
  //check if mouse is outside console
  boolean blnPause = false;
  int intX = 100;
  int intY = 100;
  int intX1=0;
  Graphics h;
  
  //Methods
  public void paintComponent(Graphics g){
    //Determining background colour
    if(blnColour){
      g.setColor(Color.WHITE);
    }
    if(!blnColour){
      g.setColor(Color.RED);
    }
    g.fillRect(0,0,960,540);
    
    //Checking if to draw sqaure
    if(blnDrag){
      g.setColor(Color.BLUE);
      g.fillRect(intX,intY,50,50);
    }
    
    //Animation
    if(blnString){
      g.setColor(Color.GREEN);
      g.drawString("Animation Test", 480, 540-intX1);
      intX1++;
      if(intX1==540){
        blnString=false;
        intX1=0;
      }
    }
    
    //Pausing feature
    if(blnPause){
      g.setColor(Color.BLACK);
      g.fillRect(0,0,960,540);
      g.setColor(Color.WHITE);
      g.drawString("PAUSED", 480, 270);
      intX1--;
    }
    
    
  }
  
  
  //Constructor
  
  public TestPanel(){
    super();
    
  }
  
}
