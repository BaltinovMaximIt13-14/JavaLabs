package main.ru.baltinov.Default;

/**
 * <p>Класс, аннотированный @Default</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
@Default(String.class)
public class DefaultDemo {
  @Default(Integer.class)
  private int number;
  private String text;
}