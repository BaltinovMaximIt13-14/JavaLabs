package main.ru.baltinov.Two;

/**
 * <p>Обработчик для аннотации Two</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
public class TwoProcessor {

  /**
   * <p>Обрабатывает аннотацию @Two на классе</p>
   *
   * @param clazz класс для обработки
   */
  public static void process(Class<?> clazz) {
    System.out.println("\n=== Обработка аннотации @Two ===");

    if (clazz.isAnnotationPresent(Two.class)) {
      Two annotation = clazz.getAnnotation(Two.class);
      System.out.println("Класс " + clazz.getSimpleName() +
          " имеет свойства:");
      System.out.println("  first: \"" + annotation.first() + "\"");
      System.out.println("  second: " + annotation.second());
    }
  }
}