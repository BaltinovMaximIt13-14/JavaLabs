package main.ru.baltinov.Validate;

import java.lang.annotation.*;

/**
 * <p>Аннотация для указания типов для валидации</p>
 * <p>Цель: TYPE, ANNOTATION</p>
 * <p>Retention: RUNTIME</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Validate {
  /**
   * <p>Массив классов для валидации</p>
   *
   * @return массив классов
   */
  Class<?>[] value();
}