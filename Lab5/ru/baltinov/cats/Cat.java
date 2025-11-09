package ru.baltinov.cats;

public class Cat implements Meowable{
  private final String name;

  // Конструктор
  public Cat(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Имя кота не может быть пустым");
    }
    this.name = name.trim();
  }

  // Геттер
  public String getName() {
    return name;
  }

  // Приведение к текстовой форме
  @Override
  public String toString() {
    return "кот: " + name;
  }

  // Мяуканье
  public void meow() {
    System.out.println(name + ": мяу!");
  }

  // Мяуканье N раз
  public void meow(int times) {
    if (times <= 0) {
      throw new IllegalArgumentException("Количество мяуканий должно быть положительным");
    }

    if (times == 1) {
      meow();
      return;
    }

    // Создаем строку с N "мяу"
    StringBuilder meowString = new StringBuilder();
    for (int i = 0; i < times; i++) {
      meowString.append("мяу");
      if (i < times - 1) {
        meowString.append("-");
      }
    }

    System.out.println(name + ": " + meowString + "!");
  }
}