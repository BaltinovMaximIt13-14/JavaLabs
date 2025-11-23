package main.ru.baltinov.ToString;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>Режим для аннотации ToString</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
enum Mode {
  YES, NO
}

/**
 * <p>Аннотация для управления строковым представлением объектов</p>
 * <p>Цель: TYPE, FIELD</p>
 * <p>Retention: RUNTIME</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface ToString {
  Mode value() default Mode.YES;
}