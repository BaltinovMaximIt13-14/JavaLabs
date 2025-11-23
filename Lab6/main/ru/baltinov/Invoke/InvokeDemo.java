package main.ru.baltinov.Invoke;

/**
 * <p>Класс с методами, отмеченными аннотацией @Invoke</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
public class InvokeDemo {

  /**
   * <p>Метод с аннотацией @Invoke</p>
   */
  @Invoke
  public void method1() {
    System.out.println("Метод 1 вызван автоматически!");
  }

  /**
   * <p>Обычный метод без аннотации</p>
   */
  public void method2() {
    System.out.println("Метод 2 (без аннотации)");
  }

  /**
   * <p>Приватный метод с аннотацией @Invoke</p>
   */
  @Invoke
  private void method3() {
    System.out.println("Приватный метод 3 также вызван!");
  }

  /**
   * <p>Метод с параметрами и аннотацией @Invoke</p>
   *
   * @param message сообщение
   */
  @Invoke
  public void methodWithParams(String message) {
    System.out.println("Метод с параметрами: " + message);
  }
}