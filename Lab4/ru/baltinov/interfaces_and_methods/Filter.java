package ru.baltinov.interfaces_and_methods;

//Функциональный интерфейс фильтрации списка
public interface Filter<T>{
  boolean test(T input);
}
