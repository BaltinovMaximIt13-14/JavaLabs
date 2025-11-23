package main.ru.baltinov.Two;

import java.lang.annotation.*;

/**
 * <p>Аннотация с двумя обязательными свойствами</p>
 * <p>Цель: TYPE</p>
 * <p>Retention: RUNTIME</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Two {
  /**
   * <p>Первое свойство типа String</p>
   *
   * @return строковое значение
   */
  String first();

  /**
   * <p>Второе свойство типа int</p>
   *
   * @return целочисленное значение
   */
  int second();
}