package main.ru.baltinov.Default;

/**
 * <p>Обработчик для аннотации @Default</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
public class DefaultProcessor {

  /**
   * <p>Обрабатывает аннотацию @Default на классе и полях</p>
   *
   * @param clazz класс для обработки
   */
  public static void process(Class<?> clazz) {
    System.out.println("\n=== Обработка аннотации @Default ===");

    if (clazz.isAnnotationPresent(Default.class)) {
      Default annotation = clazz.getAnnotation(Default.class);
      System.out.println("Класс " + clazz.getSimpleName() +
          " имеет тип по умолчанию: " + annotation.value().getName());
    }

    // Проверяем поля
    for (var field : clazz.getDeclaredFields()) {
      if (field.isAnnotationPresent(Default.class)) {
        Default annotation = field.getAnnotation(Default.class);
        System.out.println("Поле " + field.getName() +
            " имеет тип по умолчанию: " + annotation.value().getName());
      }
    }
  }
}