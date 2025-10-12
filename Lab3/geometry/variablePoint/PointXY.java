package ru.baltinov.geometry.variablePoint;

public class PointXY extends PointX {
  private int y;

  //Свойства
  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  //Конструкторы
  public PointXY(int x, int y){
    super(x);
    this.y = y;
  }

  public PointXY(){
    super(0);
    this.y = 0;
  }

  @Override
  public String toString(){
    return "{" + getX() + ";" + this.y + "}";
  }
}