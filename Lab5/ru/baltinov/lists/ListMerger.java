package ru.baltinov.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListMerger<T extends Comparable<T>> {
  private List<T> firstList;
  private List<T> secondList;

  // Конструкторы

  public ListMerger() {
    this.firstList = new ArrayList<>();
    this.secondList = new ArrayList<>();
  }


  public ListMerger(List<T> firstList, List<T> secondList) {
    if (firstList != null){
      this.firstList = new ArrayList<>(firstList);
    } else {
      this.firstList = new ArrayList<>();
    }
    if (secondList != null){
      this.secondList = new ArrayList<>(secondList);
    } else {
      this.secondList = new ArrayList<>();
    }
  }

  // Геттеры и сеттеры
  public List<T> getFirstList() {
    return new ArrayList<>(firstList);
  }

  public void setFirstList(List<T> firstList) {
    if (firstList != null) {
      this.firstList = new ArrayList<>(firstList);
    } else {
      this.firstList = new ArrayList<>();
    }
  }

  public List<T> getSecondList() {
    return new ArrayList<>(secondList);
  }

  public void setSecondList(List<T> secondList) {
    if (secondList != null) {
      this.secondList = new ArrayList<>(secondList);
    } else {
      this.secondList = new ArrayList<>();
    }  }

  // Метод слияния
  public List<T> mergeLists() {
    if (!isSorted(firstList) || !isSorted(secondList)) {
      throw new IllegalArgumentException("Один из списков не упорядочен");
    }

    List<T> result = new ArrayList<>();
    int i = 0, j = 0;

    // Алгоритм слияния двух упорядоченных списков
    while (i < firstList.size() && j < secondList.size()) {
      T element1 = firstList.get(i);
      T element2 = secondList.get(j);

      if (element1.compareTo(element2) <= 0) {
        result.add(element1);
        i++;
      } else {
        result.add(element2);
        j++;
      }
    }

    while (i < firstList.size()) {
      result.add(firstList.get(i));
      i++;
    }

    while (j < secondList.size()) {
      result.add(secondList.get(j));
      j++;
    }

    return result;
  }

  // Проверка упорядоченности списка
  private boolean isSorted(List<T> list) {
    for (int i = 0; i < list.size() - 1; i++) {
      if (list.get(i).compareTo(list.get(i + 1)) > 0) {
        return false;
      }
    }
    return true;
  }


  // Переопределение toString
  @Override
  public String toString() {
    return "ListMerger{" +
        "firstList=" + firstList +
        ", secondList=" + secondList +
        '}';
  }

  // Переопределение equals и hashCode
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ListMerger<?> that = (ListMerger<?>) o;
    return Objects.equals(firstList, that.firstList) &&
        Objects.equals(secondList, that.secondList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstList, secondList);
  }
}