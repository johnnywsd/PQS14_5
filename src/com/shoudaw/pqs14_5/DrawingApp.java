package com.shoudaw.pqs14_5;

public class DrawingApp {
  public static void main(String[] args){
    DrawingModel dm = new DrawingModel();
    new DrawingView(dm);
    new DrawingView(dm);
    new DrawingView(dm);
  }
}
