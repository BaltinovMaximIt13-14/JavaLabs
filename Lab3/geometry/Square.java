package ru.baltinov.geometry;

import ru.baltinov.geometry.variablePoint.PointXY;

// Класс Квадрат
public class Square {
  private PointXY topLeft;
  private int sideLength;

  // Конструктор с точкой
  public Square(PointXY topLeft, int sideLength) {
    setTopLeft(topLeft);
    setSideLength(sideLength);
  }

  // Конструктор с координатами
  public Square(int x, int y, int sideLength) {
    this(new PointXY(x, y), sideLength);
  }

  // Геттеры
  public PointXY getTopLeft() {
    return new PointXY(topLeft.getX(), topLeft.getY());
  }

  public double getSideLength() {
    return sideLength;
  }

  // Сеттеры с валидацией
  public void setTopLeft(PointXY topLeft) {
    if (topLeft == null) {
      throw new IllegalArgumentException("Точка не может быть null");
    }
    this.topLeft = new PointXY(topLeft.getX(), topLeft.getY()); // защитная копия
  }

  public void setSideLength(int sideLength) {
    if (sideLength <= 0) {
      throw new IllegalArgumentException("Длина стороны должна быть положительной: " + sideLength);
    }
    this.sideLength = sideLength;
  }

  // Приведение к строке
  @Override
  public String toString() {
    return ("Квадрат в точке " + topLeft + " со стороной " + sideLength);
  }

  // Возвращает ломаную с точками углов квадрата
  public Polyline toPolyline() {
    PointXY[] corners = calculateCorners();
    return new Polyline(corners);
  }

  // Вспомогательный метод для вычисления углов
  private PointXY[] calculateCorners() {
    PointXY[] corners = new PointXY[5];
    corners[0] = new PointXY(topLeft.getX(), topLeft.getY());
    corners[1] = new PointXY(topLeft.getX() + sideLength, topLeft.getY());
    corners[2] = new PointXY(topLeft.getX() + sideLength, topLeft.getY() - sideLength);
    corners[3] = new PointXY(topLeft.getX(), topLeft.getY() - sideLength);
    corners[4] = new PointXY(topLeft.getX(), topLeft.getY());

    return corners;
  }
}