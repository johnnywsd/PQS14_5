package com.shoudaw.pqs14_5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class DrawingView extends JPanel 
  implements MouseListener,MouseMotionListener, DrawingListener {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  /* point & prpoint are used to keep track of current and
   * previous point to draw the line
   */
  Point point,prpoint; 
  
  private DrawingModel drawingModel = null;

  public DrawingView(DrawingModel drawingModel) {
    /*Initializing*/
    point=null;  
    prpoint=null;
    this.drawingModel = drawingModel;
    drawingModel.add(this);
    this.setBackground(Color.BLACK);
    this.addMouseListener(this);
    this.addMouseMotionListener(this);
    
    JFrame jf = new JFrame("Free Hand Drawing Example");
    
    DrawingView draw = this;
    draw.setBackground(Color.BLACK);
    jf.add(draw);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setSize(600,500);
    jf.setVisible(true);
  }

  @Override
  public void paint(Graphics g) {

    g.setColor(Color.BLACK);
    if(point!=null && prpoint != null)
    {
      g.drawLine(prpoint.x,prpoint.y,point.x,point.y);
    }
  }

  @Override
  public void drawPoint(Point point){
    this.prpoint=this.point;
    this.point=point;
    repaint();
  }
  
  @Override
  public void mouseClicked(MouseEvent arg0) {}

  @Override
  public void mouseEntered(MouseEvent arg0) {}

  @Override
  public void mouseExited(MouseEvent arg0) {}

  @Override
  public void mousePressed(MouseEvent me) {
    point=me.getPoint();
  }

  @Override
  public void mouseReleased(MouseEvent me) {
    point=null;
  }

  @Override
  public void mouseDragged(MouseEvent me) {
    this.drawingModel.drawPoint(me.getPoint());
    prpoint=point;
    point=me.getPoint();
    repaint();
  }

  @Override
  public void mouseMoved(MouseEvent arg0) {}
}