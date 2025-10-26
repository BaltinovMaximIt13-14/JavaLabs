package ru.baltinov.interfaces_and_methods;

//Функциональный интерфейс для изменения списка
public interface Function<T, P> {
  P apply (T value);
}
