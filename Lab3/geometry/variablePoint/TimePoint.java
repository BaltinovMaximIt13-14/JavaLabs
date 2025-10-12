package ru.baltinov.geometry.variablePoint;

public class TimePoint extends Point {
  protected Point point;
  private String time;

  //Свойства
  public String getTime() {
    return time;
  }
  public void setTimestamp(String timestamp) {
    if (!isValidTime(timestamp)) {
      throw new IllegalArgumentException("Неверный формат времени: " + timestamp +
          ". Используйте формат HH:MM или HH:MM:SS");
    }
    this.time = timestamp;
  }
  //Конструктор
  public TimePoint(Point point, String timestamp) {
    this.point = point;
    setTimestamp(timestamp); // Используем сеттер для проверки
  }

  //Проверка на правильность формата
  private boolean isValidTime(String time) {
    if (time == null || time.isEmpty()) {
      return false;
    }

    String[] parts = time.split(":");
    if (parts.length < 2 || parts.length > 3) {
      return false;
    }

    try {
      int hours = Integer.parseInt(parts[0]);
      int minutes = Integer.parseInt(parts[1]);
      int seconds = parts.length == 3 ? Integer.parseInt(parts[2]) : 0;

      return hours >= 0 && hours <= 23 &&
          minutes >= 0 && minutes <= 59 &&
          seconds >= 0 && seconds <= 59;
    } catch (NumberFormatException e) {
      return false;
    }
  }
  @Override
  public String toString() {
    return point.toString() + ", time: " + time;
  }

  // Дополнительный метод для получения только координат
  public String getCoordinates() {
    return point.toString();
  }
}