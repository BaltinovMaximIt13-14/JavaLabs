package ru.baltinov.geometry;

import ru.baltinov.geometry.variablePoint.PointXY;

// Класс Ломаная
public class Polyline {
  private PointXY[] points;
  // Геттер
  public PointXY[] getPoints() {
    return points.clone();
  }

  //Конструктор
  public Polyline(PointXY[] points) {
    if (points == null) {
      throw new IllegalArgumentException("Массив точек не может быть null");
    }
    if (points.length < 2) {
      throw new IllegalArgumentException("Ломаная должна содержать минимум 2 точки");
    }
    this.points = points.clone();
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Линия [");
    for (int i = 0; i < points.length; i++) {
      sb.append(points[i]);
      if (i < points.length - 1) {
        sb.append(",");
      }
    }
    sb.append("]");
    return sb.toString();
  }

  // Метод для замены точки по индексу
  public void replacePoint(int index, PointXY newPointXY) {
    if (index < 0 || index >= points.length) {
      throw new IllegalArgumentException("Неверный индекс точки: " + index);
    }
    if (newPointXY == null) {
      throw new IllegalArgumentException("Новая точка не может быть null");
    }
    points[index] = new PointXY(newPointXY.getX(), newPointXY.getY());
  }

  // Метод для рассчета длины ломаной
  public double calculatePolylineLength() {
    double totalLength = 0;
    for (int i = 0; i < points.length - 1; i++) {
      PointXY current = points[i];
      PointXY next = points[i + 1];
      double segmentLength = calculateDistance(current, next);
      totalLength += segmentLength;
    }

    return totalLength;
  }

  // Вспомогательный метод для вычисления расстояния между двумя точками
  private double calculateDistance(PointXY p1, PointXY p2) {
    double dx = p2.getX() - p1.getX();
    double dy = p2.getY() - p1.getY();
    return Math.sqrt(dx * dx + dy * dy);
  }

}