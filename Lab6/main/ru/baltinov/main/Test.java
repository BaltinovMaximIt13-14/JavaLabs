package main.ru.baltinov.main;

import main.ru.baltinov.Cache.CacheInvokeDemo;
import main.ru.baltinov.Cache.CacheProcessor;
import main.ru.baltinov.Cache.EmptyCacheDemo;
import main.ru.baltinov.Default.DefaultDemo;
import main.ru.baltinov.Default.DefaultProcessor;
import main.ru.baltinov.Invoke.InvokeDemo;
import main.ru.baltinov.Invoke.InvokeProcessor;
import main.ru.baltinov.ToString.ToStringDemo;
import main.ru.baltinov.ToString.ToStringProcessor;
import main.ru.baltinov.Two.TwoDemo;
import main.ru.baltinov.Two.TwoProcessor;
import main.ru.baltinov.Validate.ValidateDemo;
import main.ru.baltinov.Validate.ValidateProcessor;

/**
 * <p>Класс для тестирования аннотаций</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
public class Test {
  /**
   * <p>Выводит меню выбора задач</p>
   */
  public void printMenu() {
    System.out.print("""
        --------------------
        Choose your task:
        1. Task1;
        2. Task2;
        3. Task3;
        4. Task4;
        5. Task5;
        6. Task6;
        7. Task7;
        8. Task8;
        0. Exit.
        ->""");
  }

  /**
   * <p>Выводит описание задачи 1</p>
   */
  private void printTask1() {
    System.out.println("""
        @Invoke.
        Разработайте аннотацию @Invoke, со следующими характеристиками:
        • Целью может быть только МЕТОД
        • Доступна во время исполнения программы
        • Не имеет свойств
        Создайте класс, содержащий несколько методов, и проаннотируйте хотя бы один из них
        аннотацией @Invoke.
        Реализуйте обработчик (через Reflection API), который находит методы, отмеченные
        аннотацией @Invoke, и вызывает их автоматически.
        -----------------------------------------""");
  }

  /**
   * <p>Выводит описание задачи 2</p>
   */
  private void printTask2() {
    System.out.println("""
        @Default.
        Разработайте аннотацию @Default, со следующими характеристиками:
        • Целью может быть ТИП или ПОЛЕ
        • Доступна во время исполнения программы
        • Имеет обязательное свойство value типа Class
        Проаннотируйте какой-либо класс данной аннотацией, указав тип по умолчанию.
        Напишите обработчик, который выводит имя указанного класса по умолчанию.
        -----------------------------------------""");
  }

  /**
   * <p>Выводит описание задачи 3</p>
   */
  private void printTask3() {
    System.out.println("""
        @ToString.
        Разработайте аннотацию @ToString, со следующими характеристиками:
        • Целью может быть ТИП или ПОЛЕ
        • Доступна во время исполнения программы
        • Имеет необязательное свойство valuec двумя вариантами значений: YES или NO
        • Значение свойства по умолчанию: YES
        Проаннотируйте класс аннотацией @ToString, а одно из полей – с @ToString(Mode.NO).
        Создайте метод, который формирует строковое представление объекта, учитывая только те поля,
        где @ToString имеет значение YES.
        -----------------------------------------""");
  }

  /**
   * <p>Выводит описание задачи 4</p>
   */
  private void printTask4() {
    System.out.println("""
        @Validate.
        Разработайте аннотацию @Validate, со следующими характеристиками:
        • Целью может быть ТИП или АННОТАЦИЯ
        • Доступна во время исполнения программы
        • Имеет обязательное свойство value, типа Class[]
        Проаннотируйте класс аннотацией @Validate, передав список типов для проверки.
        Реализуйте обработчик, который выводит, какие классы указаны в аннотации.
        -----------------------------------------""");
  }

  /**
   * <p>Выводит описание задачи 5</p>
   */
  private void printTask5() {
    System.out.println("""
        @Two.
        Разработайте аннотацию @Two, со следующими характеристиками:
        • Целью может быть ТИП
        • Доступна во время исполнения программы
        • Имеет два обязательных свойства: first типа String и second типа int
        Проаннотируйте какой-либо класс аннотацией @Two, передав строковое и числовое значения.
        Реализуйте обработчик, который считывает и выводит значения этих свойств.
        -----------------------------------------""");
  }

  /**
   * <p>Выводит описание задачи 6</p>
   */
  private void printTask6() {
    System.out.println("""
        @Cache.
        Разработайте аннотацию @Cache, со следующими характеристиками:
        • Целью может быть ТИП
        • Доступна во время исполнения программы
        • Имеет необязательное свойство value, типа String[]
        • Значение свойства по умолчанию: пустой массив
        Проаннотируйте класс аннотацией @Cache, указав несколько кешируемых областей.
        Создайте обработчик, который выводит список всех кешируемых областей или сообщение, что
        список пуст.
        -----------------------------------------""");
  }

  /**
   * <p>Выводит описание задачи 7</p>
   */
  private void printTask7() {
    System.out.println("""
        Напишите тест, используя фреймворк JUnit, к методу toString() (или методу, формирующему
        строковое представление объекта, основанное на аннотации @ToString).
        • Проверить, что в результирующей строке отображаются только те поля, которые имеют
        аннотацию @ToString(Mode.YES) или не аннотированы вовсе.
        • Убедиться, что поля с @ToString(Mode.NO) не попадают в вывод.
        -----------------------------------------""");
  }

  /**
   * <p>Выводит описание задачи 8</p>
   */
  private void printTask8() {
    System.out.println("""
        Создайте тест, используя фреймворк JUnit, проверяющий совместную работу
        аннотаций @Cache и @Invoke на одном классе.
        • Разработайте класс, содержащий аннотацию @Cache({"users", "orders"}) и метод,
        помеченный @Invoke.
        • В тесте c помощью Reflection получите экземпляр аннотированного класса, убедитесь, что
        аннотация @Cache корректно возвращает массив строк ["users", "orders"], автоматически
        вызовите метод с @Invoke и проверьте, что он действительно выполняется.
        • Добавьте проверку, что при пустом массиве @Cache кеширование не активируется
        (например, метод не добавляет данные в фиктивный кеш).
        • Для моделирования кеша можно использовать Mockito или простую
        коллекцию Map<String, Object>.
        -----------------------------------------""");
  }

  /**
   * <p>Выполняет задачу 1 - аннотация @Invoke</p>
   */
  public void number1() {
    printTask1();
    InvokeDemo invokeDemo = new InvokeDemo();
    InvokeProcessor.process(invokeDemo);
  }

  /**
   * <p>Выполняет задачу 2 - аннотация @Default</p>
   */
  public void number2() {
    printTask2();
    DefaultProcessor.process(DefaultDemo.class);
  }

  /**
   * <p>Выполняет задачу 3 - аннотация @ToString</p>
   */
  public void number3() {
    printTask3();
    ToStringDemo toStringDemo = new ToStringDemo();
    String result = ToStringProcessor.generateToString(toStringDemo);
    System.out.println("\n=== Обработка аннотации @ToString ===");
    System.out.println("Результат toString: " + result);
  }

  /**
   * <p>Выполняет задачу 4 - аннотация @Validate</p>
   */
  public void number4() {
    printTask4();
    ValidateProcessor.process(ValidateDemo.class);
  }

  /**
   * <p>Выполняет задачу 5 - аннотация @Two</p>
   */
  public void number5() {
    printTask5();
    TwoProcessor.process(TwoDemo.class);
  }

  /**
   * <p>Выполняет задачу 6 - аннотация @Cache</p>
   */
  public void number6() {
    printTask6();
    CacheProcessor.process(CacheInvokeDemo.class);
    CacheProcessor.process(EmptyCacheDemo.class);
  }

  /**
   * <p>Выполняет задачу 7 - тестирование @ToString</p>
   */
  public void number7() {
    printTask7();
  }

  /**
   * <p>Выполняет задачу 8 - тестирование @Cache и @Invoke</p>
   */
  public void number8() {
    printTask8();
  }
}