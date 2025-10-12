package ru.baltinov.dataStructures;

import java.util.Arrays;
public class Array {
  private int[] list;

  //Свойства
  //Геттеры
  public int[] getArray() {
    return Arrays.copyOf(list, list.length);
  }
  //Конструктор вводом перечня независимых чисел и массивом чисел
  public Array(int... numbers){
    this.list = Arrays.copyOf(numbers, numbers.length);
  }

  //Конструктор копированием исходного Списка
  public Array(Array arr){
    this.list = Arrays.copyOf(arr.list, arr.list.length);
  }


  //Вывод i-ого значения
  public int getElement(int index){
    if ((index < 0) || index >= list.length){
      throw new IllegalArgumentException("Индекс списка не входит в предел [0;" + (list.length-1) + "]!");
    }
    return list[index];
  }

  //Замена i-ого значения
  public void replace(int index, int x){
    if ((index < 0) || index >= list.length){
      throw new IllegalArgumentException("Индекс списка не входит в предел [0;" + (list.length-1) + "]!");
    }
    this.list[index] = x;
  }

  //Текстовое представление
  @Override
  public String toString() {
    if (list.length == 0) {
      return "[]";
    }

    StringBuilder sb = new StringBuilder("[");
    for (int i = 0; i < list.length; i++) {
      sb.append(list[i]);
      if (i < list.length - 1) {
        sb.append(", ");
      }
    }
    sb.append("]");
    return sb.toString();
  }

  //Проверка на пустоту
  public boolean empty(){
    return list.length == 0;
  }

  //Вывод размера
  public int size(){
    return list.length;
  }

}
