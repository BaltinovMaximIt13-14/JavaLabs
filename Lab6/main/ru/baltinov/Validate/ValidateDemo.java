package main.ru.baltinov.Validate;

/**
 * <p>Класс с аннотацией Validate</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
@Validate({String.class, Integer.class, Double.class})
public class ValidateDemo {
  private String name;
  private Integer age;
  private double weight;
  private boolean flag;
}