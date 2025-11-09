package ru.baltinov.fraction;
import java.util.function.Supplier;

// Класс, реализующий шаблон Кэширования
class Cache<T> {
  private T value;
  private boolean isValid;
  private final Supplier<T> computation;

  //Конструктор
  public Cache(Supplier<T> computation) {
    this.computation = computation;
    this.isValid = false;
  }

  //геттер
  public T getValue() {
    if (!isValid) {
      value = computation.get();
      isValid = true;
      System.out.println("Вычисление нового значения");
    } else {
      System.out.println("Использование кэшированного значения");
    }
    return value;
  }

  //Инвалидация кэша
  public void invalidate() {
    this.isValid = false;
    this.value = null;
    System.out.println("Кэш очищен");
  }
}
