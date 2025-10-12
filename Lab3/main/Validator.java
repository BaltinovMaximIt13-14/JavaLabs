package ru.baltinov.main;

import java.util.Scanner;
import java.util.regex.Pattern;

//Класс для проверки ввода
public class Validator {
  private Scanner scanner;

  public Validator() {
    this.scanner = new Scanner(System.in);
  }

  //Проверка на целое число
  public int getInt(String prompt) {
    while (true) {
      try {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.println("Ошибка: Введите целое число!");
      }
    }
  }

  //Проверка на целое число в диапазоне
  public int getIntInRange(String prompt, int min, int max) {
    while (true) {
      int value =getInt(prompt);
      if (value >= min && value <= max) {
        return value;
      }
      System.out.println("Ошибка: Число должно быть в диапазоне от " +
          min + " до " + max+ ":\n ");
    }
  }

  //Проверка на длинное целое число
  public long getLong(String prompt) {
    while (true) {
      try {
        System.out.print(prompt);
        return Long.parseLong(scanner.nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.println("Ошибка: Введите целое число!");
      }
    }
  }

  //Проверка на символьный тип
  public char getChar(String prompt) {
    while (true) {
      System.out.print(prompt);
      String input = scanner.nextLine().trim();
      if (input.length() == 1) {
        return input.charAt(0);
      }
      System.out.println("Ошибка: Введите один символ!");
    }
  }

  //Проверка на символьный тип в диапазоне
  public char getCharInRange(String prompt, char min, char max) {
    while (true) {
      char value = getChar(prompt);
      if (value >= min && value <= max) {
        return value;
      }
      System.out.print("Ошибка: Символ должен быть в диапазоне от " +
          min + " до " + max+ ":\n ");
    }
  }

  //Проверка на вещественное с плавающей точкой
  public double getDouble(String prompt) {
    while (true) {
      try {
        System.out.print(prompt);
        return Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
      } catch (NumberFormatException e) {
        System.out.println("Ошибка: Введите вещественное число!");
      }
    }
  }

  //Проверка на массив целых чисел
  public int[] getArrInt(String prompt) {
    while (true) {
      try {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.isEmpty()){
          System.out.println("Ошибка: Введите числа!");
          continue;
        }
        String[] numbers = input.split("[\\s,;]+");
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++){
          result[i] = Integer.parseInt(numbers[i].trim());
        }
        return result;
      } catch (NumberFormatException e) {
        System.out.println("Ошибка: Вводите только целые числа, разделенные пробелами!");
      }
    }
  }

  //Проверка на строковое непустое значение
  public String getString(String prompt) {
    while (true) {
      System.out.print(prompt);
      String input = scanner.nextLine().trim();
      if (!input.isEmpty()) {
        return input;
      }
      System.out.println("Ошибка: Строка не может быть пустой!");
    }
  }

  public String getStringByPattern(String prompt, String regex, String errorMessage) {
    while (true) {
      String input = getString(prompt);
      if (Pattern.matches(regex, input)) {
        return input;
      }
      System.out.println("Ошибка: " + errorMessage);
    }
  }

  // Проверка на наличие только букв и пробелов
  public String getAlphaSpaceString(String prompt) {
    return getStringByPattern(prompt, "^[a-zA-Zа-яА-ЯёЁ\\s]+$", "Строка должна содержать только буквы и пробелы!");
  }

}
