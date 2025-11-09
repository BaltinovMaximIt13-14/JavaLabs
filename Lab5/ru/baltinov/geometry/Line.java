package ru.baltinov.geometry;

public class Line<T extends PointXY>  implements Cloneable{
  private T PStart;
  private T PEnd;

  //Свойства
  public T getPEnd() {
    return createCopy(PEnd);
  }
  public T getPStart() {
    return createCopy(PStart);
  }


  public void setPEnd(T PEnd) {
    if (PEnd == null) {
      throw new IllegalArgumentException("Конечная точка не может быть null");
    }
    if (PEnd.equals(this.PStart)) {
      throw new IllegalArgumentException("Конечная точка не может совпадать с начальной");
    }
    this.PEnd = createCopy(PEnd);
  }

  public void setPStart(T PStart) {
    if (PStart == null) {
      throw new IllegalArgumentException("Начальная точка не может быть null");
    }
    if (PStart.equals(this.PEnd)) {
      throw new IllegalArgumentException("Начальная точка не может совпадать с конечной");
    }
    this.PStart = createCopy(PStart);
  }

  //Конструкторы
  public Line(T PStart, T PEnd) {
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
  public Line(Line<T> other) {
    setPStart( other.PStart);
    setPEnd( other.PEnd);
  }


  //Текстовое представление
  @Override
  public String toString(){
    return "Линия от " + this.PStart + " до " + this.PEnd;
  }

  //Переопределение equals
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;

    if (obj == null || getClass() != obj.getClass()) return false;

    Line<T> other = (Line<T>) obj;

    boolean directMatch =
        this.PStart.equals(other.PStart) &&
            this.PEnd.equals(other.PEnd);

    boolean reverseMatch =
        this.PStart.equals(other.PEnd) &&
            this.PEnd.equals(other.PStart);

    return directMatch || reverseMatch;
  }

  // Метод клонирования
  @Override
  public Line<T> clone() {
    try {
      Line<T> cloned = (Line<T>) super.clone();
      cloned.PStart = createCopy(PStart);
      cloned.PEnd = createCopy(PEnd);
      return cloned;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError("Клонирование не поддерживается", e);
    }
  }

  //Метод создания копии
  private static <T extends PointXY> T createCopy(T point) {
    return (T) new PointXY(point.getX(), point.getY());

  }

  //Функция вычисления длины
  public double length() {
    int dx = PEnd.getX() - PStart.getX();
    int dy = PEnd.getY() - PStart.getY();
    return Math.sqrt(dx * dx + dy * dy);
  }

}
