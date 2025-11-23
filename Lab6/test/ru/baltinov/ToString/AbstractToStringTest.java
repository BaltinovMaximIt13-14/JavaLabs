package test.ru.baltinov.ToString;

import main.ru.baltinov.ToString.ToStringUtils;
import org.junit.jupiter.api.Test;


/**
 * <p>Абстрактный базовый класс для тестирования функциональности @ToString</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
public abstract class AbstractToStringTest<T> {

  /**
   * <p>Создает тестируемый объект</p>
   *
   * @return тестируемый объект
   */
  protected abstract T createTestObject();

  /**
   * <p>Возвращает класс тестируемого объекта</p>
   *
   * @return класс тестируемого объекта
   */
  protected abstract Class<T> getTestClass();

  /**
   * <p>Тестирует включение корректных полей в строковое представление</p>
   *
   * @throws Exception если возникает ошибка при тестировании
   */
  @Test
  void testToStringIncludesCorrectFields() throws Exception {
    // Arrange
    T testObject = createTestObject();
    String className = getTestClass().getSimpleName();

    System.out.println("=== Тест включения полей для " + className + " ===");

    // Act
    String result = ToStringUtils.toString(testObject);
    System.out.println("Результат toString(): " + result);

    // Assert
    System.out.println("Проверяем включенные поля:");
    assertIncludesCorrectFields(result);

    System.out.println(" Все включенные поля присутствуют\n");
  }

  /**
   * <p>Тестирует исключение полей с режимом NO из строкового представления</p>
   *
   * @throws Exception если возникает ошибка при тестировании
   */
  @Test
  void testToStringExcludesFieldsWithModeNo() throws Exception {
    // Arrange
    T testObject = createTestObject();
    String className = getTestClass().getSimpleName();

    System.out.println("=== Тест исключения полей для " + className + " ===");

    // Act
    String result = ToStringUtils.toString(testObject);
    System.out.println("Результат toString(): " + result);

    // Assert
    System.out.println("Проверяем исключенные поля:");
    assertExcludesFieldsWithModeNo(result);

    System.out.println(" Все исключенные поля отсутствуют\n");
  }

  /**
   * <p>Проверяет включение правильных полей (должен быть реализован в подклассах)</p>
   *
   * @param result строковое представление объекта
   */
  protected abstract void assertIncludesCorrectFields(String result);

  /**
   * <p>Проверяет исключение полей с Mode.NO (должен быть реализован в подклассах)</p>
   *
   * @param result строковое представление объекта
   */
  protected abstract void assertExcludesFieldsWithModeNo(String result);
}