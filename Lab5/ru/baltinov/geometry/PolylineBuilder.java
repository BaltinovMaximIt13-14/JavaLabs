package ru.baltinov.geometry;

import java.util.Collection;
import java.util.Comparator;

public class PolylineBuilder {

  public static Polyline buildPolyline(Collection<PointXY> points) {
    if (points == null || points.isEmpty()) {
      throw new IllegalArgumentException("Список точек не может быть null или пустым");
    }

    PointXY[] resultPoints = points.stream()
        .map(p -> new PointXY(p.getX(), Math.abs(p.getY())))
        .distinct()
        .sorted(Comparator.comparingInt(PointXY::getX))
        .toArray(PointXY[]::new);

    if (resultPoints.length < 2) {
      throw new IllegalArgumentException("После обработки осталось менее 2 уникальных точек");
    }

    return new Polyline(resultPoints);
  }
}
