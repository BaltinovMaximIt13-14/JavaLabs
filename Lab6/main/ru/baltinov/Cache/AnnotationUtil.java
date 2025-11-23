package main.ru.baltinov.Cache;

import main.ru.baltinov.Invoke.Invoke;

import java.lang.reflect.Method;

/**
 * <p>Минимальная утилита для работы с аннотациями</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
public class AnnotationUtil {

  /**
   * <p>Получает области кеширования из аннотации @Cache</p>
   *
   * @param clazz класс для анализа
   * @return массив строк с названиями областей кеширования
   */
  public static String[] getCacheAreas(Class<?> clazz) {
    Cache cacheAnnotation = clazz.getAnnotation(Cache.class);
    return cacheAnnotation != null ? cacheAnnotation.value() : new String[0];
  }

  /**
   * <p>Вызывает методы, помеченные аннотацией @Invoke</p>
   *
   * @param instance объект, методы которого нужно вызвать
   * @return количество успешно вызванных методов
   */
  public static int invokeAnnotatedMethods(Object instance) {
    int count = 0;
    for (Method method : instance.getClass().getDeclaredMethods()) {
      if (method.isAnnotationPresent(Invoke.class)) {
        try {
          method.setAccessible(true);
          method.invoke(instance);
          count++;
        } catch (Exception e) {
          System.out.println("Ошибка вызова метода: " + e.getMessage());
        }
      }
    }
    return count;
  }
}