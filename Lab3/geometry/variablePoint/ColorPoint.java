package ru.baltinov.geometry.variablePoint;
//Декоратор для цветной точки
public class ColorPoint extends Point {
  protected Point point;
  private String color;

  //Геттер
  public String getColor() {
    return color;
  }

  //Конструктор
  public ColorPoint(Point point, String color) {
    this.point = point;
    this.color = color;
  }

  //Текстовое представление
  @Override
  public String toString() {
    return point.toString() + ", color: " + color;
  }

  public String getCoordinates() {
    return point.toString();
  }

}