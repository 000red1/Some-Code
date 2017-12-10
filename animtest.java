import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.geom.*;


public class animtest implements ActionListener, MouseMotionListener, MouseListener, KeyListener {
  //Properties
  JFrame f;
  TestPanel p;
  Timer time;
  
  //This is used to control JFrame ActionListener 
  //as removing it doesn't seem to stop background from taking inputs when program is pauses
  boolean blnTest;
  //Methods
  
  //ActionListener
  public void actionPerformed(ActionEvent evt){
    if(evt.getSource()==time){
      //repaints the panel
      p.repaint();
    }
  }
  
  //MouseMotionListeners
  public void mouseMoved(MouseEvent evt){
    
  }
  
  public void mouseDragged(MouseEvent evt){
    p.intX=evt.getX()-25;
    p.intY=evt.getY()-25;
    p.blnDrag=true;

  } 
  
  //MouseListener
  public void mouseEntered(MouseEvent evt){
    p.blnPause=false;
    blnTest=false;
  }
  public void mouseExited(MouseEvent evt){
    p.blnPause=true;
    blnTest=true;
  }
  public void mousePressed(MouseEvent evt){
    
  }
  public void mouseReleased(MouseEvent evt){
    p.blnDrag=false;
  }
  public void mouseClicked(MouseEvent evt){
  }
  
  //KeyListeners
  public void keyReleased(KeyEvent evt){
  }
  
  public void keyPressed(KeyEvent evt){
    System.out.println(evt.getKeyCode());
    //Check Key inputs
    if(!blnTest){
      if(evt.getKeyCode()==38){
        p.intX1=0;
        p.blnString=true;
      }
      if(evt.getKeyChar()=='r'){
        p.blnColour=false;
      }
      if(evt.getKeyChar()=='w'){
        p.blnColour=true;
      }
    }
  }
  public void keyTyped(KeyEvent evt){
  }
  
  
  //Constructor
  public animtest(){
    
    f= new JFrame("Animation Keyboard Mouse Test");
    
    p= new TestPanel();
    p.setLayout(null);
    p.setPreferredSize(new Dimension(960,540));
    p.addMouseListener(this);
    p.addMouseMotionListener(this);
    
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setContentPane(p);
    f.pack();
    f.setVisible(true);
    f.addKeyListener(this);
    
    time = new Timer(1000/60,this);
    time.start();
    
  }
  
  public static void main(String[]args){
    try {
      // Set System L&F
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } 
    catch (UnsupportedLookAndFeelException e) {
      // handle exception
    }
    catch (ClassNotFoundException e) {
      // handle exception
    }
    catch (InstantiationException e) {
      // handle exception
    }
    catch (IllegalAccessException e) {
      // handle exception
    }
    new animtest();
  }
  
  
}
