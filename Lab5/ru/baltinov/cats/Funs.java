package ru.baltinov.cats;

public class Funs {

  public static void meowsCare(Meowable meowable, int times) {
    if (times <= 0) {
      throw new IllegalArgumentException("Количество мяуканий должно быть положительным");
    }

    for (int i = 0; i < times; i++) {
      meowable.meow();
    }
  }

  public static void meowsCare(Meowable meowable) {
    meowsCare(meowable, 5);
  }
}
