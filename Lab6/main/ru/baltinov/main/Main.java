package main.ru.baltinov.main;

import static main.ru.baltinov.main.Validator.getInt;

/**
 * <p>Главный класс приложения</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
public class Main {
  /**
   * <p>Точка входа в приложение</p>
   *
   * @param args аргументы командной строки
   */
  public static void main(String[] args) {
    int numberOfTask1;
    Test test = new Test();

    //Меню с выбором номера
    do {
      test.printMenu();
      numberOfTask1 = getInt("");
      switch (numberOfTask1) {
        case 1:
          test.number1();
          break;
        case 2:
          test.number2();
          break;
        case 3:
          test.number3();
          break;
        case 4:
          test.number4();
          break;
        case 5:
          test.number5();
          break;
        case 6:
          test.number6();
          break;
        case 7:
          test.number7();
          break;
        case 8:
          test.number8();
          break;
        default:
          break;
      }
    } while (numberOfTask1 != 0);

    System.out.println("""
        ________________________________
        Program finished
        """);
  }
}