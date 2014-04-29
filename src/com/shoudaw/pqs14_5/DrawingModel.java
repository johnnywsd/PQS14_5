package com.shoudaw.pqs14_5;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;



public class DrawingModel {
  private List<DrawingListener> listeners = new LinkedList<DrawingListener>();
  public void drawPoint(Point point){
    for (DrawingListener listener : listeners) {
      listener.drawPoint(point);
    } 
  }
  public void add(DrawingListener drawingListener) {
    listeners.add(drawingListener);
  }
}
