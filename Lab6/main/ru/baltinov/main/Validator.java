package main.ru.baltinov.main;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * <p>Класс для проверки ввода</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
public class Validator {
  private static Scanner scanner;

  static {
    scanner = new Scanner(System.in);
  }

  /**
   * <p>Проверка на целое число</p>
   *
   * @param prompt приглашение для ввода
   * @return целое число
   */
  public static int getInt(String prompt) {
    while (true) {
      try {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.println("Ошибка: Введите целое число!");
      }
    }
  }

  /**
   * <p>Проверка на целое число в диапазоне</p>
   *
   * @param prompt приглашение для ввода
   * @param min минимальное значение
   * @param max максимальное значение
   * @return целое число в указанном диапазоне
   */
  public static int getIntInRange(String prompt, int min, int max) {
    while (true) {
      int value = getInt(prompt);
      if (value >= min && value <= max) {
        return value;
      }
      System.out.println("Ошибка: Число должно быть в диапазоне от " +
          min + " до " + max + ":\n ");
    }
  }

  /**
   * <p>Проверка на длинное целое число</p>
   *
   * @param prompt приглашение для ввода
   * @return длинное целое число
   */
  public static long getLong(String prompt) {
    while (true) {
      try {
        System.out.print(prompt);
        return Long.parseLong(scanner.nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.println("Ошибка: Введите целое число!");
      }
    }
  }

  /**
   * <p>Проверка на символьный тип</p>
   *
   * @param prompt приглашение для ввода
   * @return символ
   */
  public static char getChar(String prompt) {
    while (true) {
      System.out.print(prompt);
      String input = scanner.nextLine().trim();
      if (input.length() == 1) {
        return input.charAt(0);
      }
      System.out.println("Ошибка: Введите один символ!");
    }
  }

  /**
   * <p>Проверка на символьный тип в диапазоне</p>
   *
   * @param prompt приглашение для ввода
   * @param min минимальный символ
   * @param max максимальный символ
   * @return символ в указанном диапазоне
   */
  public static char getCharInRange(String prompt, char min, char max) {
    while (true) {
      char value = getChar(prompt);
      if (value >= min && value <= max) {
        return value;
      }
      System.out.print("Ошибка: Символ должен быть в диапазоне от " +
          min + " до " + max + ":\n ");
    }
  }

  /**
   * <p>Проверка на вещественное с плавающей точкой</p>
   *
   * @param prompt приглашение для ввода
   * @return вещественное число
   */
  public static double getDouble(String prompt) {
    while (true) {
      try {
        System.out.print(prompt);
        return Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
      } catch (NumberFormatException e) {
        System.out.println("Ошибка: Введите вещественное число!");
      }
    }
  }

  /**
   * <p>Проверка на массив целых чисел</p>
   *
   * @param prompt приглашение для ввода
   * @return массив целых чисел
   */
  public static int[] getArrInt(String prompt) {
    while (true) {
      try {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
          System.out.println("Ошибка: Введите числа!");
          continue;
        }
        String[] numbers = input.split("[\\s,;]+");
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
          result[i] = Integer.parseInt(numbers[i].trim());
        }
        return result;
      } catch (NumberFormatException e) {
        System.out.println("Ошибка: Вводите только целые числа, разделенные пробелами!");
      }
    }
  }

  /**
   * <p>Проверка на строковое непустое значение</p>
   *
   * @param prompt приглашение для ввода
   * @return непустая строка
   */
  public static String getString(String prompt) {
    while (true) {
      System.out.print(prompt);
      String input = scanner.nextLine().trim();
      if (!input.isEmpty()) {
        return input;
      }
      System.out.println("Ошибка: Строка не может быть пустой!");
    }
  }

  /**
   * <p>Проверка строки по регулярному выражению</p>
   *
   * @param prompt приглашение для ввода
   * @param regex регулярное выражение
   * @param errorMessage сообщение об ошибке
   * @return строка, соответствующая регулярному выражению
   */
  public static String getStringByPattern(String prompt, String regex, String errorMessage) {
    while (true) {
      String input = getString(prompt);
      if (Pattern.matches(regex, input)) {
        return input;
      }
      System.out.println("Ошибка: " + errorMessage);
    }
  }

  /**
   * <p>Проверка на наличие только букв и пробелов</p>
   *
   * @param prompt приглашение для ввода
   * @return строка, содержащая только буквы и пробелы
   */
  public static String getAlphaSpaceString(String prompt) {
    return getStringByPattern(prompt, "^[a-zA-Zа-яА-ЯёЁ\\s]+$", "Строка должна содержать только буквы и пробелы!");
  }

  /**
   * <p>Проверка на список целых чисел</p>
   *
   * @param prompt приглашение для ввода
   * @return список целых чисел
   */
  public static List<Integer> getListInt(String prompt) {
    while (true) {
      try {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
          System.out.println("Ошибка: Введите числа!");
          continue;
        }
        String[] numbers = input.split("[\\s,;]+");
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
          result.add(Integer.parseInt(numbers[i].trim()));
        }
        return result;
      } catch (NumberFormatException e) {
        System.out.println("Ошибка: Вводите только целые числа, разделенные пробелами!");
      }
    }
  }
}