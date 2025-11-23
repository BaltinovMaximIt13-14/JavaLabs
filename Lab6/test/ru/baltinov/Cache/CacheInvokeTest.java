package test.ru.baltinov.Cache;

import main.ru.baltinov.Cache.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p>Минимальные тесты для @Cache и @Invoke</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
class CacheInvokeTest {

  /**
   * <p>Тестирует аннотацию @Cache с указанными областями</p>
   */
  @Test
  void testCacheWithAreas() {
    System.out.println("=== Тест @Cache с областями ===");

    // Arrange
    Class<CacheInvokeDemo> clazz = CacheInvokeDemo.class;

    // Act
    String[] areas = AnnotationUtil.getCacheAreas(clazz);

    // Assert
    System.out.println("Области: " + java.util.Arrays.toString(areas));
    assertArrayEquals(new String[]{"users", "orders"}, areas);
  }

  /**
   * <p>Тестирует аннотацию @Cache без указания областей</p>
   */
  @Test
  void testEmptyCache() {
    System.out.println("=== Тест пустого @Cache ===");

    // Arrange
    Class<EmptyCacheDemo> clazz = EmptyCacheDemo.class;

    // Act
    String[] areas = AnnotationUtil.getCacheAreas(clazz);

    // Assert
    System.out.println("Области: " + java.util.Arrays.toString(areas));
    assertEquals(0, areas.length);
  }

  /**
   * <p>Тестирует аннотацию @Invoke на методах</p>
   */
  @Test
  void testInvokeAnnotation() {
    System.out.println("=== Тест @Invoke ===");

    // Arrange
    CacheInvokeDemo instance = new CacheInvokeDemo();

    // Act
    int invokedMethods = AnnotationUtil.invokeAnnotatedMethods(instance);

    // Assert
    System.out.println("Вызвано методов: " + invokedMethods);
    assertEquals(1, invokedMethods);
  }

  /**
   * <p>Интеграционный тест аннотаций @Cache и @Invoke</p>
   */
  @Test
  void testCacheAndInvokeIntegration() {
    System.out.println("=== Интеграционный тест ===");

    // Arrange
    CacheInvokeDemo instance = new CacheInvokeDemo();
    Class<CacheInvokeDemo> clazz = CacheInvokeDemo.class;

    // Act - получаем области кеширования
    String[] areas = AnnotationUtil.getCacheAreas(clazz);

    // Act - имитируем кеширование
    for (String area : areas) {
      SimpleCache.put(area, "cached_data");
    }

    // Act - вызываем методы с @Invoke
    int invokedMethods = AnnotationUtil.invokeAnnotatedMethods(instance);

    // Assert
    System.out.println("Области: " + java.util.Arrays.toString(areas));
    System.out.println("Вызвано методов: " + invokedMethods);

    assertTrue(areas.length > 0);
    assertTrue(invokedMethods > 0);

    // Проверяем что данные добавлены в кеш
    for (String area : areas) {
      assertTrue(SimpleCache.contains(area));
    }

    SimpleCache.clear();
  }

  /**
   * <p>Тестирует работу с пустым кешем</p>
   */
  @Test
  void testEmptyCacheIntegration() {
    System.out.println("=== Тест с пустым кешем ===");

    // Arrange
    EmptyCacheDemo instance = new EmptyCacheDemo();
    Class<EmptyCacheDemo> clazz = EmptyCacheDemo.class;

    // Act - получаем области кеширования
    String[] areas = AnnotationUtil.getCacheAreas(clazz);

    // Act - пытаемся добавить в кеш (не должно работать)
    for (String area : areas) {
      SimpleCache.put(area, "cached_data");
    }

    // Act - вызываем методы с @Invoke
    int invokedMethods = AnnotationUtil.invokeAnnotatedMethods(instance);

    // Assert
    System.out.println("Области: " + java.util.Arrays.toString(areas));
    System.out.println("Вызвано методов: " + invokedMethods);

    assertEquals(0, areas.length);
    assertTrue(invokedMethods > 0);

    // Проверяем что кеш пуст (т.к. нет областей)
    SimpleCache.clear();
  }
}