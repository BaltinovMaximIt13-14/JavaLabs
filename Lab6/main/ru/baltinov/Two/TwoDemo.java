package main.ru.baltinov.Two;

/**
 * <p>Класс с аннотацией Two</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
@Two(first = "Hello", second = 12)
public class TwoDemo {
  private String message;

  /**
   * <p>Конструктор класса TwoDemo</p>
   *
   * @param message сообщение
   */
  public TwoDemo(String message) {
    this.message = message;
  }

  /**
   * <p>Получает сообщение</p>
   *
   * @return сообщение
   */
  public String getMessage() {
    return message;
  }

  /**
   * <p>Устанавливает сообщение</p>
   *
   * @param message сообщение
   */
  public void setMessage(String message) {
    this.message = message;
  }
}