package com.shoudaw.pqs14_5;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.LinkedList;

import org.junit.Test;

public class DrawingModelTest {

  @Test
  public void addTest() {
    DrawingListener dl1 = new DrawingListener() {
      @Override
      public void drawPoint(Point point) {
      }
    };
    DrawingListener dl2 = new DrawingListener() {
      @Override
      public void drawPoint(Point point) {
      }
    };
    DrawingListener dl3 = new DrawingListener() {
      @Override
      public void drawPoint(Point point) {
      }
    };
    DrawingModel dm = new DrawingModel();
    dm.add(dl1);
    dm.add(dl2);
    dm.add(dl3);
    LinkedList<DrawingListener> res = dm.getLinsteners();
    assertEquals(dl1, res.get(0));
    assertEquals(dl2, res.get(1));
    assertEquals(dl3, res.get(2));
  }
  
  @Test
  public void drawTest() {
    DrawingListener dl1 = new DrawingListener() {
      @Override
      public void drawPoint(Point point) {
        point.x ++;
        point.y ++;
      }
    };
    DrawingListener dl2 = new DrawingListener() {
      @Override
      public void drawPoint(Point point) {
        point.x ++;
        point.y ++;
      }
    };
    DrawingListener dl3 = new DrawingListener() {
      @Override
      public void drawPoint(Point point) {
        point.x ++;
        point.y ++;
      }
    };
    DrawingModel dm = new DrawingModel();
    dm.add(dl1);
    dm.add(dl2);
    dm.add(dl3);
    Point p = new Point(0, 0);
    dm.drawPoint(p);
    assertEquals(3, p.x);
    assertEquals(3, p.y);
  }

}
