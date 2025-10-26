package ru.baltinov.storage;

public class Storage<T>{
  private final T value;
  private final T alternative;

  //Геттер
  public T getValue() {
    if (this.value == null){
      return this.alternative;
    }
    else {
      return this.value;
    }
  }

  //Конструктор
  public Storage(T value, T alternative){
    this.alternative = alternative;
    this.value = value;
  }

  //Текстовое представление
  @Override
  public String toString(){
    return "В хранилище хранится " + getValue();
  }
}
