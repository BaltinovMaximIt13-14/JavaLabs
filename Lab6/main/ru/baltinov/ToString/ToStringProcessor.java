package main.ru.baltinov.ToString;

/**
 * <p>Обработчик для формирования строкового представления объектов</p>
 * <p>Альтернативная реализация утилиты toString</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
public class ToStringProcessor {

  /**
   * <p>Генерирует строковое представление объекта на основе аннотаций ToString</p>
   *
   * @param obj объект для преобразования в строку
   * @return строковое представление объекта
   */
  public static String generateToString(Object obj) {
    Class<?> clazz = obj.getClass();
    StringBuilder sb = new StringBuilder();
    sb.append(clazz.getSimpleName()).append("{");

    boolean firstField = true;

    for (var field : clazz.getDeclaredFields()) {
      try {
        field.setAccessible(true);
        Mode fieldMode = Mode.YES;

        // Проверяем аннотацию на поле
        if (field.isAnnotationPresent(ToString.class)) {
          ToString annotation = field.getAnnotation(ToString.class);
          fieldMode = annotation.value();
        } else {
          // Если на поле нет аннотации, проверяем аннотацию на классе
          if (clazz.isAnnotationPresent(ToString.class)) {
            ToString classAnnotation = clazz.getAnnotation(ToString.class);
            fieldMode = classAnnotation.value();
          }
        }

        if (fieldMode == Mode.YES) {
          if (!firstField) {
            sb.append(", ");
          }
          sb.append(field.getName()).append("=").append(field.get(obj));
          firstField = false;
        }
      } catch (IllegalAccessException e) {
        // Пропускаем поле, если нет доступа
      }
    }

    sb.append("}");
    return sb.toString();
  }
}