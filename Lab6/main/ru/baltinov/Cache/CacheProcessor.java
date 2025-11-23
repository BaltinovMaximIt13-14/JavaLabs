package main.ru.baltinov.Cache;

/**
 * <p>Обработчик для аннотации Cache</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
public class CacheProcessor {

  /**
   * <p>Обрабатывает аннотацию @Cache на классе</p>
   *
   * @param clazz класс для обработки
   */
  public static void process(Class<?> clazz) {
    System.out.println("\n=== Обработка аннотации @Cache ===");

    if (clazz.isAnnotationPresent(Cache.class)) {
      Cache annotation = clazz.getAnnotation(Cache.class);
      String[] cacheAreas = annotation.value();

      System.out.println("Класс " + clazz.getSimpleName() +
          " кешируется в областях:");

      if (cacheAreas.length == 0) {
        System.out.println("  - Список кешируемых областей пуст");
      } else {
        for (String area : cacheAreas) {
          System.out.println("  - " + area);
        }
      }
    }
  }
}