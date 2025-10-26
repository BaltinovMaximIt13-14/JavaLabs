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
  @Override
  public PointX copy() {
    return new PointX(this.x);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || this.getClass() != obj.getClass()) return false;

    PointX other = (PointX) obj;
    return this.x == other.x;
  }

  @Override
  public int hashCode() {
    return Integer.hashCode(x);
  }
}