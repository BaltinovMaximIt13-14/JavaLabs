package main.ru.baltinov.Invoke;

import java.lang.annotation.*;

/**
 * <p>Аннотация для автоматического вызова методов через Reflection API</p>
 * <p>Цель: METHOD (только методы)</p>
 * <p>Retention: RUNTIME (доступна во время выполнения)</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Invoke {
}