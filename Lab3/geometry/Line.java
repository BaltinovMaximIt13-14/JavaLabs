package ru.baltinov.geometry;

import ru.baltinov.geometry.variablePoint.PointXY;

import java.lang.Math;
public class Line {
  private PointXY PStart;
  private PointXY PEnd;

  //Свойства
  public PointXY getPEnd() {
    return new PointXY(this.PEnd.getX(), this.PEnd.getY());
  }
  public PointXY getPStart() {
    return new PointXY(this.PStart.getX(), this.PStart.getY());
  }

  public void setPEnd(PointXY PEnd) {
    if (PEnd == null) {
      throw new IllegalArgumentException("Конечная точка не может быть null");
    }
    if (PEnd.equals(this.PStart)) {
      throw new IllegalArgumentException("Конечная точка не может совпадать с начальной");
    }
    this.PEnd = new PointXY(PEnd.getX(), PEnd.getY());
  }

  public void setPStart(PointXY PStart) {
    if (PStart == null) {
      throw new IllegalArgumentException("Начальная точка не может быть null");
    }
    if (PStart.equals(this.PEnd)) {
      throw new IllegalArgumentException("Начальная точка не может совпадать с конечной");
    }
    this.PStart = new PointXY(PStart.getX(), PStart.getY());
  }

  //Конструкторы
  public Line(PointXY PStart, PointXY PEnd) {
    if (PStart == null || PEnd == null) {
      throw new IllegalArgumentException("Точки линии не могут быть null");
    }
    if (PStart.equals(PEnd)) {
      throw new IllegalArgumentException("Начальная и конечная точки не могут совпадать");
    }
    this.PStart = new PointXY(PStart.getX(), PStart.getY());
    this.PEnd = new PointXY(PEnd.getX(), PEnd.getY());
  }

  public Line(int xS, int yS, int xE, int yE) {
    if (xS == xE && yS == yE) {
      throw new IllegalArgumentException("Начальная и конечная точки не могут совпадать");
    }
    this.PStart = new PointXY(xS, yS);
    this.PEnd = new PointXY(xE, yE);
  }

  @Override
  public String toString(){
    return "Линия от " + this.PStart + " до " + this.PEnd;
  }

  //Функция вычисления длины
  public int length(){
    int x = (int) Math.pow(this.PEnd.getX()-this.PStart.getX(), 2);
    int y = (int )Math.pow(this.PEnd.getY()-this.PStart.getY(), 2);
    return (int) Math.sqrt(x+y);
  }
}
