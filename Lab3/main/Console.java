package ru.baltinov.main;

import static ru.baltinov.main.Power.power;

//Консольный вызов метода:
//java ru/baltinov/main/Console.java 5 6
public class Console {
  public static void main(String[] args) {
    if (args.length < 2) {
      System.err.println("Ошибка: необходимо передать два числа");
      System.exit(1);
    }

    try {
      String base = args[0];
      String exponent = args[1];
      double result = power(base, exponent);

      System.out.printf(base + " ^ " + exponent + " = " + result);

    } catch (NumberFormatException e) {
      System.err.println("Ошибка: оба аргумента должны быть целыми числами");
      System.exit(1);
    }
  }
}