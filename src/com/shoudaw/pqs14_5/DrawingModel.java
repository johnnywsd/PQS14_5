package com.shoudaw.pqs14_5;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;



public class DrawingModel {
  private List<DrawingListener> listeners = new LinkedList<DrawingListener>();
  protected LinkedList<DrawingListener> getLinsteners(){
    return (LinkedList<DrawingListener>) this.listeners;
  }
  
  /**
   * 
   * @param point, draw a point
   */
  public void drawPoint(Point point){
    for (DrawingListener listener : listeners) {
      listener.drawPoint(point);
    } 
  }
  
  /**
   * Add a drawingListener Object to this model
   * @param drawingListener
   */
  public void add(DrawingListener drawingListener) {
    listeners.add(drawingListener);
  }
}
