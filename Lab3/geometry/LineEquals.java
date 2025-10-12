package ru.baltinov.geometry;

import ru.baltinov.geometry.variablePoint.PointXY;

import java.lang.Math;
public class LineEquals  implements Cloneable{
  private PointXY PStart;
  private PointXY PEnd;

  //Свойства
  public PointXY getPEnd() {
    return this.PEnd;
  }
  public PointXY getPStart() {
    return this.PStart;
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
  public LineEquals(PointXY PStart, PointXY PEnd) {
    if (PStart == null || PEnd == null) {
      throw new IllegalArgumentException("Точки линии не могут быть null");
    }
    if (PStart.equals(PEnd)) {
      throw new IllegalArgumentException("Начальная и конечная точки не могут совпадать");
    }
    setPEnd(PEnd);
    setPStart(PStart);
  }

  // Конструктор для создания копии
  public LineEquals(LineEquals other) {
    this(new PointXY(other.PStart.getX(), other.PStart.getY()),
        new PointXY(other.PEnd.getX(), other.PEnd.getY()));
  }


  @Override
  public String toString(){
    return "Линия от " + this.PStart + " до " + this.PEnd;
  }

  //Переопределение equals
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;

    if (obj == null || getClass() != obj.getClass()) return false;

    LineEquals other = (LineEquals) obj;

    boolean directMatch =
        this.PStart.getX() == other.PStart.getX() &&
            this.PStart.getY() == other.PStart.getY() &&
            this.PEnd.getX() == other.PEnd.getX() &&
            this.PEnd.getY() == other.PEnd.getY();

    boolean reverseMatch =
        this.PStart.getX() == other.PEnd.getX() &&
            this.PStart.getY() == other.PEnd.getY() &&
            this.PEnd.getX() == other.PStart.getX() &&
            this.PEnd.getY() == other.PStart.getY();

    return directMatch || reverseMatch;
  }

  // Метод клонирования
  @Override
  public LineEquals clone() {
    try {
      LineEquals cloned = (LineEquals) super.clone();
      cloned.PStart = new PointXY(this.PStart.getX(), this.PStart.getY());
      cloned.PEnd = new PointXY(this.PEnd.getX(), this.PEnd.getY());
      return cloned;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError("Клонирование не поддерживается", e);
    }
  }

  //Функция вычисления длины
  public int length(){
    int x = (int) Math.pow(this.PEnd.getX()-this.PStart.getX(), 2);
    int y = (int )Math.pow(this.PEnd.getY()-this.PStart.getY(), 2);
    return (int) Math.sqrt(x+y);
  }

}
