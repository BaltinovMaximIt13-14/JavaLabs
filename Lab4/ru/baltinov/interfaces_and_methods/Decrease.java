package ru.baltinov.interfaces_and_methods;

//Функциональный интерфейс сокращения списка
public interface Decrease<T>{
  T minimize(T result, T added);
}
