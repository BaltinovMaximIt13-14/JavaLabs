package main.ru.baltinov.Cache;

import main.ru.baltinov.Invoke.Invoke;

/**
 * <p>Класс с пустым @Cache для тестирования</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
@Cache
public class EmptyCacheDemo {

  /**
   * <p>Метод с аннотацией @Invoke</p>
   */
  @Invoke
  public void incrementCounter() {
    System.out.println("Метод выполнен (кеширование отключено)");
  }
}