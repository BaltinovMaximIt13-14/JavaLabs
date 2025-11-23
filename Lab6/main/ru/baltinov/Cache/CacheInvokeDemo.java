package main.ru.baltinov.Cache;

import main.ru.baltinov.Invoke.Invoke;

/**
 * <p>Минимальный класс для тестирования @Cache и @Invoke</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
@Cache({"users", "orders"})
public class CacheInvokeDemo {

  /**
   * <p>Метод с аннотацией @Invoke</p>
   */
  @Invoke
  public void cachedMethod() {
    System.out.println("Метод с @Invoke выполнен");
  }

  /**
   * <p>Обычный метод без аннотации</p>
   */
  public void regularMethod() {
    System.out.println("Обычный метод без аннотации");
  }
}