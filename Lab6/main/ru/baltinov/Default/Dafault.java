package main.ru.baltinov.Default;

import java.lang.annotation.*;

/**
 * <p>Аннотация для указания типа по умолчанию</p>
 * <p>Цель: TYPE (классы), FIELD (поля)</p>
 * <p>Retention: RUNTIME</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface Default {
  /**
   * <p>Класс по умолчанию</p>
   *
   * @return класс по умолчанию
   */
  Class<?> value();
}