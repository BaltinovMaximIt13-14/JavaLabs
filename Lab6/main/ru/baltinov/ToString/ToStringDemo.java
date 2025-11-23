package main.ru.baltinov.ToString;

/**
 * <p>Демонстрационный класс для тестирования аннотации ToString</p>
 * <p>Содержит различные поля с разными настройками аннотации ToString</p>
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 * @see ToString
 */
@ToString
public class ToStringDemo {
  /**
   * <p>Имя пользователя</p>
   * <p>Аннотировано @ToString без указания режима (используется по умолчанию YES)</p>
   */
  @ToString
  private String name = "John";

  /**
   * <p>Возраст пользователя</p>
   * <p>Явно указан режим YES для включения в строковое представление</p>
   */
  @ToString(Mode.YES)
  private int age = 25;

  /**
   * <p>Пароль пользователя</p>
   * <p>Явно указан режим NO для исключения из строкового представления</p>
   */
  @ToString(Mode.NO)
  private String password = "secret123";

  /**
   * <p>Зарплата пользователя</p>
   * <p>Явно указан режим NO для исключения из строкового представления</p>
   */
  @ToString(Mode.NO)
  private double salary = 50000.0;

  /**
   * <p>Адрес пользователя</p>
   * <p>Не аннотирован - должен быть включен в вывод по умолчанию</p>
   */
  private String address = "Street";

  /**
   * <p>Возвращает строковое представление объекта на основе аннотаций @ToString</p>
   *
   * @return строковое представление объекта
   */
  @Override
  public String toString() {
    try {
      return ToStringUtils.toString(this);
    } catch (Exception e) {
      return super.toString();
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}