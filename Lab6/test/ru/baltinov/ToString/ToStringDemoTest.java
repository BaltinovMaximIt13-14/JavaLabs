package test.ru.baltinov.ToString;

import main.ru.baltinov.ToString.ToStringDemo;
import static org.junit.jupiter.api.Assertions.*;

/**
 * <p>Тест для класса ToStringDemo</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 */
class ToStringDemoTest extends AbstractToStringTest<ToStringDemo> {

  /**
   * <p>Создает тестируемый объект ToStringDemo</p>
   *
   * @return объект ToStringDemo для тестирования
   */
  @Override
  protected ToStringDemo createTestObject() {
    return new ToStringDemo();
  }

  /**
   * <p>Возвращает класс тестируемого объекта</p>
   *
   * @return класс ToStringDemo
   */
  @Override
  protected Class<ToStringDemo> getTestClass() {
    return ToStringDemo.class;
  }

  /**
   * <p>Проверяет включение корректных полей в строковое представление</p>
   *
   * @param result строковое представление объекта
   */
  @Override
  protected void assertIncludesCorrectFields(String result) {
    checkField(result, "name=John", true, "name с @ToString");
    checkField(result, "age=25", true, "age с @ToString(Mode.YES)");
    checkField(result, "address=Street", true, "address без аннотации");
  }

  /**
   * <p>Проверяет исключение полей с режимом NO из строкового представления</p>
   *
   * @param result строковое представление объекта
   */
  @Override
  protected void assertExcludesFieldsWithModeNo(String result) {
    checkField(result, "password=", false, "password с @ToString(Mode.NO)");
    checkField(result, "salary=", false, "salary с @ToString(Mode.NO)");
    checkField(result, "secret123", false, "значение password");
    checkField(result, "50000.0", false, "значение salary");
  }

  /**
   * <p>Проверяет наличие поля в строковом представлении</p>
   *
   * @param result строковое представление объекта
   * @param field поле для проверки
   * @param shouldExist должно ли поле присутствовать
   * @param description описание поля
   */
  private void checkField(String result, String field, boolean shouldExist, String description) {
    boolean exists = result.contains(field);
    String status;
    if (exists) {
      status = "НАЙДЕНО";
    } else {
      status = "НЕ НАЙДЕНО";
    }
    String expected;
    if (shouldExist) {
      expected = "должно быть";
    } else {
      expected = "НЕ должно быть";
    }

    System.out.printf("  %s: %s [%s, %s]%n",
        description, field, status, expected);

    if (shouldExist) {
      assertTrue(exists, "Поле '" + field + "' должно быть в выводе");
    } else {
      assertFalse(exists, "Поле '" + field + "' не должно быть в выводе");
    }
  }
}