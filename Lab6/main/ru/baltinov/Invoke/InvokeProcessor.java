package main.ru.baltinov.Invoke;

import java.lang.reflect.Method;

/**
 * <p>Обработчик для автоматического вызова методов с аннотацией @Invoke</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
public class InvokeProcessor {
  /**
   * <p>Обрабатывает объект, вызывая методы с аннотацией @Invoke</p>
   *
   * @param obj объект для обработки
   */
  public static void process(Object obj) {
    System.out.println("=== Обработка аннотации @Invoke ===");

    Class<?> clazz = obj.getClass();
    Method[] methods = clazz.getDeclaredMethods();

    for (Method method : methods) {
      if (method.isAnnotationPresent(Invoke.class)) {
        try {
          System.out.print("Вызов метода: " + method.getName() + " -> ");
          method.setAccessible(true);

          // Проверяем параметры метода
          if (method.getParameterCount() == 0) {
            method.invoke(obj);
          } else {
            // Для методов с параметрами передаем значения по умолчанию
            Object[] params = new Object[method.getParameterCount()];
            for (int i = 0; i < params.length; i++) {
              params[i] = "default_value";
            }
            method.invoke(obj, params);
          }
        } catch (Exception e) {
          System.out.println("Ошибка при вызове метода: " + e.getMessage());
        }
      }
    }
  }
}