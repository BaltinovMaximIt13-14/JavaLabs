package main.ru.baltinov.ToString;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Универсальная утилита для формирования строкового представления объектов</p>
 * <p>Основан на аннотациях @ToString</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
public class ToStringUtils {

  /**
   * <p>Формирует строковое представление объекта на основе аннотаций @ToString</p>
   *
   * @param obj объект для преобразования в строку
   * @return строковое представление объекта
   * @throws IllegalAccessException если возникает ошибка доступа к полям
   */
  public static String toString(Object obj) throws IllegalAccessException {
    Class<?> clazz = obj.getClass();
    StringBuilder sb = new StringBuilder();
    sb.append(clazz.getSimpleName()).append("{");

    Field[] fields = clazz.getDeclaredFields();
    boolean firstField = true;

    for (Field field : fields) {
      field.setAccessible(true);

      if (shouldIncludeField(field, clazz)) {
        if (!firstField) {
          sb.append(", ");
        }
        sb.append(field.getName()).append("=").append(field.get(obj));
        firstField = false;
      }
    }

    sb.append("}");
    return sb.toString();
  }

  /**
   * <p>Определяет, должно ли поле быть включено в строковое представление</p>
   *
   * @param field проверяемое поле
   * @param clazz класс, к которому принадлежит поле
   * @return true если поле должно быть включено, false в противном случае
   */
  public static boolean shouldIncludeField(Field field, Class<?> clazz) {
    ToString fieldAnnotation = field.getAnnotation(ToString.class);
    ToString classAnnotation = clazz.getAnnotation(ToString.class);

    if (fieldAnnotation != null) {
      return (fieldAnnotation.value() == Mode.YES);
    } else if (classAnnotation != null) {
      return true; // По умолчанию для аннотированного класса
    }

    return true; // Если класс не аннотирован - включаем все поля
  }

  /**
   * <p>Возвращает список полей, которые должны быть включены в toString()</p>
   *
   * @param clazz класс для анализа
   * @return список включаемых полей
   */
  public static List<String> getIncludedFields(Class<?> clazz) {
    List<String> includedFields = new ArrayList<>();
    Field[] fields = clazz.getDeclaredFields();

    for (Field field : fields) {
      if (shouldIncludeField(field, clazz)) {
        includedFields.add(field.getName());
      }
    }

    return includedFields;
  }

  /**
   * <p>Возвращает список полей, которые должны быть исключены из toString()</p>
   *
   * @param clazz класс для анализа
   * @return список исключаемых полей
   */
  public static List<String> getExcludedFields(Class<?> clazz) {
    List<String> excludedFields = new ArrayList<>();
    Field[] fields = clazz.getDeclaredFields();

    for (Field field : fields) {
      if (!shouldIncludeField(field, clazz)) {
        excludedFields.add(field.getName());
      }
    }

    return excludedFields;
  }
}