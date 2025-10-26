package ru.baltinov.main;

import ru.baltinov.storage.Storage;
import ru.baltinov.geometry.*;
import ru.baltinov.geometry.variablePoint.*;
import ru.baltinov.interfaces_and_methods.*;

import java.util.*;

import static ru.baltinov.main.Validator.*;

public class Test {
  //Вывод меню и текста заданий
  public void printMenu(){
    System.out.print("""
        --------------------
        Choose your task:
        1. Task1;
        2. Task2;
        3. Task3;
        4. Task4;
        5. Task5;
        6. Task6;
        7. Task7;
        0. Exit.
        ->""");
  }
  private void printTask1(){
    System.out.println("""
        Без null.
        Создайте сущность Хранилище, которая обладает следующими характеристиками:
         Может хранить один произвольный объект в один момент времени.
         Хранилище неизменяемо.
         Объект кладется в Хранилище при его создании. В качестве объекта может быть
        сохранено также и значение null.
         Хранилище может вернуть ссылку на Объект.
         Если вместо объекта хранится null, необходимо вернуть какое-либо альтернативное
        значение.
         Метод получения значения должен работать с тем типом данных, который был указан во
        время создания объекта
        Выполните следующие задания:
        
         Создайте Хранилище чисел, положите туда значение null. Передайте Хранилище в какой-
        либо метод, извлеките значение, и выведите его на экран. Альтернативой должно быть
        
        число 0.
        
         Создайте Хранилище чисел, положите туда значение 99. Передайте Хранилище в какой-
        либо метод, извлеките значение, и выведите его на экран. Альтернативой должно быть
        
        число -1.
        
         Создайте Хранилище строк, положите туда значение null. Передайте Хранилище в какой-
        либо метод, извлеките значение, и выведите его на экран. Альтернативой должна быть
        
        строка “default”.
         Создайте Хранилище строк, положите туда значение “hello”. Передайте Хранилище в
        какой-либо метод, извлеките значение, и выведите его на экран. Альтернативой должна
        быть строка “hello world”.
        ---------------------------------------""");
  }
  private void printTask2(){
    System.out.println("""
        Обобщенная линия
        Измените сущность Линия из задачи 2.6.3, таким образом, чтобы
         При создании её объекта можно было точно указать тип точки, на которой расположена
        линия: двухмерная или трехмерная (из задачи 2.3.5).
         Методы получения и установки значения Точки также могли работать с типом указанным
        при создании объекта.
         Граница стирания не может быть хуже двумерной точки.
        Создайте и выведите на экран произвольную линию в трехмерном пространстве.
        -----------------------------------------""");
  }
  private void printTask3(){
    System.out.println("""
        Сдвинуть линию.
        Создайте метод, принимающий Линию из задачи 3.1.5 (с любой допустимой параметризацией)
        сдвигающей точку начала на 10 единиц по оси X. Например, если X был 5, то должен стать 15, если
        X был -7, то должен стать -17.
        --------------------------------------------------""");
  }
  private void printTask4(){
    System.out.println("""
        Функция.
        Разработайте такой метод, который будет принимать список значений типа T, и объект имеющий
        единственный метод apply. Данный метод надо применить к каждому элементу списка, и вернуть
        новый список значений типа P, при этом типы T и P могут совпадать, а могут не совпадать.
        Используйте разработанный метод следующим образом:
        1. Передайте в метод список со значениями:“qwerty”, “asdfg”, “zx”, а получите список чисел,
        где каждое число соответствует длине каждой строки.
        2. Передайте в метод список со значениями: 1,-3,7, а получите список в котором все
        отрицательные числа стали положительными, а положительные остались без изменений
        3. Передайте в метод список состоящий из массивов целых чисел, а получите список в
        котором будут только максимальные значения каждого из исходных массивов
        ----------------------------""");
  }
  private void printTask5(){
    System.out.println("""
        Фильтр.
        Разработайте такой метод, который будет принимать список значений типа T и объект имеющий
        единственный метод test (принимает T и возвращает boolean). Верните новый список типа T, из
        которого удалены все значения не прошедшие проверку условием.
        Используйте разработанный метод следующим образом:
        1. Передайте в метод список со значениями: “qwerty”, “asdfg”, “zx”, и отфильтруйте все
        строки имеющие менее трех символов
        2. Передайте в метод список со значениями: 1,-3,7, и отфильтруйте все положительные
        элементы
        3. Передайте в метод список состоящий из массивов целых чисел, а получите список в
        котором будут только те массивы, в которых нет ни одного положительного элемента
        ------------------------------------------------""");
  }
  private void printTask6(){
    System.out.println("""
        Сокращение.
        Разработайте такой метод, который будет принимать список значений типа T и способ с помощью
        которого список значений можно свести к одному значению типа T, которое и возвращается из
        метода.
        Используйте разработанный метод следующим образом:
        1. Передайте в метод список со значениями: “qwerty”, “asdfg”, “zx”, и сформируйте одну
        большую строку, которая состоит из всех строк исходного списка.
        2. Передайте в метод список со значениями: 1,-3,7, и верните сумму всех значений исходного
        списка.
        3. Имеется список, состоящий из списков целых чисел, получите общеe количество
        элементов во всех списках. Подсказка: решить задачу можно в одно действие или
        последовательно использовать методы из 3.3.1 и 3.3.3.
        Далее необходимо изменить разработанный метод таким образом, чтобы данный метод
        гарантированно не возвращал null и не выбрасывал ошибок в том случае, если исходный список
        пуст.
        ------------------------------------------""");
  }
  private void printTask7(){
    System.out.println("""
        Коллекционирование.
        Разработайте такой метод, который будет возвращать коллекцию типа P со значениями типа T.
        Данный метод будет принимать:
        1. Список исходных значений
        2. Способ создания результирующей коллекции
        3. Способ передачи значений исходного списка в результирующую коллекцию.
        Используйте разработанный метод следующим образом:
        1. Передайте в метод список со значениями: 1,-3,7, и верните их разбитыми на два
        подсписка, в одном из которых будут только положительные числа, а в другом только
        отрицательные.
        2. Передайте в метод список со значениями: “qwerty”, “asdfg”, “zx”, “qw” и верните их
        разбитыми на подсписки таким образом, чтобы в любом подсписке были строки только
        одинаковой длины
        3. Передайте в метод список со значениями: “qwerty”, “asdfg”, “qwerty”, “qw” и верните набор
        такого вида, который не может содержать одинаковые объекты.
        ---------------------------------------""");
  }

  //Методы выполнения заданий 1-7
  public void number1(){
    printTask1();

    //Создаем 4 хранилища
    Storage<Integer> storage1 = new Storage<>(null, 0);
    Storage<Integer> storage2 = new Storage<>(99, -1);
    Storage<String> storage3 = new Storage<>(null, "default");
    Storage<String> storage4 = new Storage<>("hello", "hello world");

    //Открываем хранилища
    openStorage(storage1);
    openStorage(storage2);
    openStorage(storage3);
    openStorage(storage4);
  }
  public void number2(){
    printTask2();
    try {
      int x1 = getInt("Введите координаты точки начала трехмерной линии:\n" +
          "x:");
      int y1 = getInt("y:");
      int z1 = getInt("z:");
      int x2 = getInt("Введите координаты точки конца трехмерной линии:\n" +
          "x:");
      int y2 = getInt("y:");
      int z2 = getInt("z:");

      Line<PointXYZ> lineXYZ = new Line<>(new PointXYZ(x1, y1, z1), new PointXYZ(x2, y2, z2));
      System.out.println("Создана трехмерная линия:\n" + lineXYZ);
      System.out.println("Длина = " + lineXYZ.length());

      int x3 = getInt("Введите координаты точки начала двумерной линии:\n" +
          "x:");
      int y3 = getInt("y:");
      int x4 = getInt("Введите координаты точки конца двумерной линии:\n" +
          "x:");
      int y4 = getInt("y:");

      Line<PointXY> lineXY = new Line<>(new PointXY(x3, y3), new PointXY(x4, y4));
      System.out.println("Создана двумерная линия:\n" + lineXY);
      System.out.println("Длина = " + lineXY.length());
    } catch (IllegalArgumentException e) {
      System.err.println("Произошла ошибка: " + e.getMessage());
    }
  }
  public void number3(){
    printTask3();

    try {
      int x1 = getInt("Введите координаты точки начала трехмерной линии:\n" +
          "x:");
      int y1 = getInt("y:");
      int z1 = getInt("z:");
      int x2 = getInt("Введите координаты точки конца трехмерной линии:\n" +
          "x:");
      int y2 = getInt("y:");
      int z2 = getInt("z:");

      Line<PointXYZ> lineXYZ = new Line<>(new PointXYZ(x1, y1, z1), new PointXYZ(x2, y2, z2));
      System.out.println("Создана трехмерная линия:\n" + lineXYZ);
      System.out.println("Длина = " + lineXYZ.length());
      shiftLineStartX(lineXYZ);
      System.out.println("Изменена трехмерная линия:\n" + lineXYZ);
      System.out.println("Длина = " + lineXYZ.length());


      int x3 = getInt("Введите координаты точки начала двумерной линии:\n" +
          "x:");
      int y3 = getInt("y:");
      int x4 = getInt("Введите координаты точки конца двумерной линии:\n" +
          "x:");
      int y4 = getInt("y:");

      Line<PointXY> lineXY = new Line<>(new PointXY(x3, y3), new PointXY(x4, y4));
      System.out.println("Создана двумерная линия:\n" + lineXY);
      System.out.println("Длина = " + lineXY.length());
      shiftLineStartX(lineXY);
      System.out.println("Изменена двумерная линия:\n" + lineXY);
      System.out.println("Длина = " + lineXY.length());
    } catch (IllegalArgumentException e) {
      System.err.println("Произошла ошибка: " + e.getMessage());
    }
  }
  public void number4(){
    printTask4();

    //Первая задача
    List<String> list1Input = Arrays.asList("qwerty", "asdfg", "zx");

    Function<String, Integer> lengthFunction = new Function<String, Integer>() {
      @Override
      public Integer apply(String input){
        return input.length();
      }
    };

    List<Integer> list1Output = Methods.function(list1Input, lengthFunction);
    System.out.println("Исходный список: " + list1Input);
    System.out.println("Полученный список длин: "+list1Output);
    System.out.println("-----------------------------------");

    //Вторая задача
    List<Integer> list2Input = Arrays.asList(1,-3,7);

    Function<Integer, Integer> absFunction = new Function<Integer, Integer>() {
      @Override
      public Integer apply(Integer input){
        return Math.abs(input);
      }
    };

    List<Integer> list2Output = Methods.function(list2Input, absFunction);
    System.out.println("Исходный список: " + list2Input);
    System.out.println("Полученный список неотрицательных чисел: "+list2Output);
    System.out.println("-----------------------------------");

    //Третья задача
    int[] arr1 = getArrInt("Введите массивы челых чисел:\nAr1:");
    int[] arr2 = getArrInt("Ar2:");
    int[] arr3 = getArrInt("Ar3:");
    List<int[]> list3Input = Arrays.asList(arr1, arr2, arr3);

    Function<int[], Integer> maxFunction = new Function<int[], Integer>() {
      @Override
      public Integer apply(int[] input){
        int max = input[0];
        for (int num : input) {
          if (num > max) {
            max = num;
          }
        }
        return max;
      }
    };

    List<Integer> list3Output = Methods.function(list3Input, maxFunction);
    System.out.print("Исходный список: ");
    printArrays(list3Input);
    System.out.println("Полученный список максимальных чисел массивов: "+list3Output);
  }
  public void number5(){
    printTask5();

    //Первая задача
    List<String> list1Input = Arrays.asList("qwerty", "asdfg", "zx");

    Filter<String> lower3Filter = new Filter<String>() {
      @Override
      public boolean test(String input){
        return input.length() < 3;
      }
    };

    List<String> list1Output = Methods.filter(list1Input, lower3Filter);
    System.out.println("Исходный список: " + list1Input);
    System.out.println("Полученный список длин: "+list1Output);
    System.out.println("-----------------------------------");

    //Вторая задача
    List<Integer> list2Input = Arrays.asList(1, -3, 7);

    Filter<Integer> positiveFilter = new Filter<Integer>() {
      @Override
      public boolean test(Integer input){
        return input>=0;
      }
    };

    List<Integer> list2Output = Methods.filter(list2Input, positiveFilter);
    System.out.println("Исходный список: " + list2Input);
    System.out.println("Полученный список неотрицательных чисел: "+list2Output);
    System.out.println("-----------------------------------");

    //Третья задача
    int[] arr1 = getArrInt("Введите массивы челых чисел:\nAr1:");
    int[] arr2 = getArrInt("Ar2:");
    int[] arr3 = getArrInt("Ar3:");
    List<int[]> list3Input = Arrays.asList(arr1, arr2, arr3);

    Filter<int[]> nonPositive = new Filter<int[]>() {
      @Override
      public boolean test(int[] input){
        boolean flag = true;
        for (int num : input) {
          if (num > 0) {
            flag = false;
          }
        }
        return flag;
      }
    };

    List<int[]> list3Output = Methods.filter(list3Input, nonPositive);
    System.out.print("Исходный список: ");
    printArrays(list3Input);
    System.out.println("Полученный список массивов неположительных чисел: ");
    printArrays(list3Output);
  }
  public void number6(){
    printTask6();

    //Первая задача
    List<String> list1Input = Arrays.asList("qwerty", "asdfg", "zx");

    Decrease<String> mergeDecrease = new Decrease<String>() {
      @Override
      public String minimize(String input, String inputI){
        return input + inputI;
      }
    };

    String item1Output = Methods.decrease(list1Input, mergeDecrease, "");
    System.out.println("Исходный список: " + list1Input);
    System.out.println("Полученная строка: "+ item1Output);
    System.out.println("-----------------------------------");

    //Вторая задача
    List<Integer> list2Input = Arrays.asList(1, -3, 7);

    Decrease<Integer> sumDecrease = new Decrease<Integer>() {
      @Override
      public Integer minimize(Integer input, Integer inputI){
        return input + inputI;
      }
    };

    Integer item2Output = Methods.decrease(list2Input, sumDecrease, 0);
    System.out.println("Исходный список: " + list2Input);
    System.out.println("Полученное число: "+ item2Output);
    System.out.println("-----------------------------------");

    //Третья задача
    List<Integer> arr1 = getListInt("Введите массивы челых чисел:\nAr1:");
    List<Integer> arr2 = getListInt("Ar2:");
    List<Integer> arr3 = getListInt("Ar3:");
    List<List<Integer>> list3Input = Arrays.asList(arr1, arr2, arr3);

    Function<List<Integer>, Integer> sizeFunction = new Function<List<Integer>, Integer>() {
      @Override
      public Integer apply(List<Integer> input){
        return input.size();
      }
    };

    List<Integer> item3Output = Methods.function(list3Input, sizeFunction);
    Integer Output = Methods.decrease(item3Output, sumDecrease, 0);
    System.out.println("Исходный список: " + list3Input);
    System.out.println("Полученное число: "+ Output);
  }
  public void number7(){
    printTask7();

    //Первая задача
    List<Integer> list1Input = Arrays.asList(1, -3, 7);

    Builder<List<List<Integer>>> createBuilder = new Builder<List<List<Integer>>>() {
      @Override
      public List<List<Integer>> create(){
        List<List<Integer>> allList = new ArrayList<>();
        allList.add(new ArrayList<>());
        allList.add(new ArrayList<>());
        return allList;
      }
    };

    Adder<List<List<Integer>>, Integer> addToColl = new Adder<List<List<Integer>>, Integer>() {
      @Override
      public void toAdd(List<List<Integer>> collection, Integer item){
        if (item >= 0){
          collection.get(0).add(item);
        } else if (item < 0) {
          collection.get(1).add(item);
        }
      }
    };
    List<List<Integer>> list1Output = Methods.collect(list1Input, createBuilder, addToColl);
    System.out.println("Исходный список: " + list1Input);
    System.out.println("Полученная коллекция положительных и отрицательных чисел: "+ list1Output);
    System.out.println("---------------------------------------");

    //Вторая задача
    List<String> str2Input = Arrays.asList("qwerty", "asdfg", "zx", "qw");

    Builder<Map<Integer, List<String>>> mapBuilder = new Builder<Map<Integer, List<String>>>() {
      @Override
      public Map<Integer, List<String>> create() {
        return new HashMap<>();
      }
    };

    Adder<Map<Integer, List<String>>, String> addToCollMap = new Adder<Map<Integer, List<String>>, String>() {
      @Override
      public void toAdd(Map<Integer, List<String>> collection, String item){
        int length = item.length();
        if (!collection.containsKey(length)) {
          collection.put(length, new ArrayList<>());
        }
        collection.get(length).add(item);
      }
    };
    Map<Integer, List<String>> output = Methods.collect(str2Input, mapBuilder, addToCollMap);
    System.out.println("Исходный список: " + str2Input);
    System.out.println("Полученная коллекция строк по длинам: "+ output);
    System.out.println("---------------------------------------");

    //Третья задача
    List<String> str3Input = Arrays.asList("qwerty", "asdfg", "qwerty", "qw");

    Builder<Set<String>> setBuilder = new Builder<Set<String>>() {
      @Override
      public Set<String> create() {
        return new HashSet<>();
      }
    };

    Adder<Set<String>, String> addToCollSet = new Adder<Set<String>, String>() {
      @Override
      public void toAdd(Set<String> collection, String item){
        collection.add(item);
      }
    };

    Set<String> outputSet = Methods.collect(str3Input, setBuilder, addToCollSet);
    System.out.println("Исходный список: " + str3Input);
    System.out.println("Полученная коллекция уникальных строк: "+ outputSet);
  }

  //Вспомогательные методы для заданий
  //Открытие хранилища
  private <T> void openStorage(Storage<T> storage){
    T value = storage.getValue();
    System.out.println("Открыв хранилище, мы нашли - " + value);
  }
  //Сдвиг точки на 10 по X
  private <T extends PointXY> void shiftLineStartX(Line<T> line) {
    T startP = line.getPStart();
    T newPoint;

    if (startP instanceof PointXYZ) {
      PointXYZ xyz = (PointXYZ) startP;
      int shift;
      if (xyz.getX() < 0){
        shift = -10;
      } else {
        shift = 10;
      }
      newPoint = (T) new PointXYZ(xyz.getX() + shift, xyz.getY(), xyz.getZ());
    } else {
      int shift;
      if (startP.getX() < 0) {
        shift = -10;
      }else {
        shift = 10;
      }
      newPoint = (T) new PointXY(startP.getX() + shift, startP.getY());
    }

    line.setPStart(newPoint);
  }
  //Вывод списка массивов
  private void printArrays(List<int[]> list) {
    for (int[] arr : list){
      System.out.print(Arrays.toString(arr) + " ");
    }
    System.out.println("\n");
  }
}
