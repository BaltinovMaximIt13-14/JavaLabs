package main.ru.baltinov.Validate;

/**
 * <p>Обработчик для аннотации Validate</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
public class ValidateProcessor {
  /**
   * <p>Обрабатывает аннотацию @Validate на классе</p>
   *
   * @param clazz класс для обработки
   */
  public static void process(Class<?> clazz) {
    System.out.println("\n=== Обработка аннотации @Validate ===");

    if (clazz.isAnnotationPresent(Validate.class)) {
      Validate annotation = clazz.getAnnotation(Validate.class);
      Class<?>[] validationClasses = annotation.value();

      System.out.println("Класс " + clazz.getSimpleName() +
          " требует валидации для типов:");
      for (Class<?> validationClass : validationClasses) {
        System.out.println("  - " + validationClass.getName());
      }
    } else {
      System.out.println("Класс " + clazz.getSimpleName() +
          " не имеет аннотации @Validate");
    }
  }
}