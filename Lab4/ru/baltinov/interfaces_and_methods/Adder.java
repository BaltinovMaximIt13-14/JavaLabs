package ru.baltinov.interfaces_and_methods;

//Функциональный интерфейс добавления элеммента в коллекцию
public interface Adder<P,T>{
  void toAdd(P collection, T item);
}
