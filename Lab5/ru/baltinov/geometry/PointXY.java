package ru.baltinov.geometry;

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
  @Override
  public PointXY copy() {
    return new PointXY(super.getX(), this.y);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || this.getClass() != obj.getClass()) return false;
    if (!super.equals(obj)) return false;

    PointXY other = (PointXY) obj;
    return this.y == other.y;
  }

  @Override
  public int hashCode() {
    return 31 * super.hashCode() + Integer.hashCode(y);
  }
}