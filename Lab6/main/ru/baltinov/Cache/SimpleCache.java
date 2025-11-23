package main.ru.baltinov.Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Минимальная реализация кеша</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
public class SimpleCache {
  private static final Map<String, Object> cache = new HashMap<>();

  /**
   * <p>Добавляет значение в кеш</p>
   *
   * @param key ключ для кеширования
   * @param value значение для кеширования
   */
  public static void put(String key, Object value) {
    cache.put(key, value);
    System.out.println("Добавлено в кеш: " + key);
  }

  /**
   * <p>Проверяет наличие ключа в кеше</p>
   *
   * @param key ключ для проверки
   * @return true если ключ присутствует в кеше, false в противном случае
   */
  public static boolean contains(String key) {
    return cache.containsKey(key);
  }

  /**
   * <p>Очищает кеш</p>
   */
  public static void clear() {
    cache.clear();
  }
}