package ru.baltinov.geometry.variablePoint;

public class PointX extends Point {
  private int x;

  //Свойства
  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  //Конструкторы
  public PointX(int x){
    this.x = x;
  }

  public PointX(){
    this.x = 0;
  }

  @Override
  public String toString(){
    return "{" + this.x + "}";
  }
}