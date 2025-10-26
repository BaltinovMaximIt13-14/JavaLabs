package ru.baltinov.interfaces_and_methods;

import java.util.ArrayList;
import java.util.List;

public class Methods {
  //Обобщенный метод применения функции к спискам
  public static <T, P> List<P> function(List<T> listInput, Function<T, P> function){
    List<P> listOutput = new ArrayList<>();
    for (T item : listInput){
      listOutput.add(function.apply(item));
    }
    return listOutput;
  }

  //Обобщенный метод фильтрации списков
  public static <T> List<T> filter(List<T> listInput, Filter<T> filter){
    List<T> listOutput = new ArrayList<>();
    for (T item : listInput){
      if (filter.test(item)){
        listOutput.add(item);
      }
    }
    return listOutput;
  }

  //Обобщенный метод объединения списков
  public static <T> T decrease(List<T> listInput, Decrease<T> decrease, T nuller){
    T itemOutput = nuller;
    for (T item : listInput){
      itemOutput = decrease.minimize(itemOutput, item);
    }
    return itemOutput;
  }

  //Обобщенный метод создания коллекций и распределения по ним
  public static <T, P> P collect(List<T> listInput, Builder<P> collection, Adder<P, T> itemAdding){
    P output = collection.create();
    for(T item : listInput){
      itemAdding.toAdd(output, item);
    }
    return output;
  }
}
