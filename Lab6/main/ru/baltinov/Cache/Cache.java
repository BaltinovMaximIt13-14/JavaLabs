package main.ru.baltinov.Cache;

import java.lang.annotation.*;

/**
 * <p>Аннотация для указания кешируемых областей</p>
 * <p>Цель: TYPE</p>
 * <p>Retention: RUNTIME</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Cache {
  /**
   * <p>Список областей кеширования</p>
   *
   * @return массив строк с названиями областей
   */
  String[] value() default {};
}