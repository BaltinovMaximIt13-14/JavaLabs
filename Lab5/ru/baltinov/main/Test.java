package ru.baltinov.main;

import ru.baltinov.cats.*;
import ru.baltinov.competiton.Participant;
import ru.baltinov.fraction.Fraction;
import ru.baltinov.lists.ListMerger;
import ru.baltinov.queue.MirroredQueue;
import ru.baltinov.set.TextAnalyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

import static ru.baltinov.competiton.methods.*;
import ru.baltinov.geometry.*;

import static ru.baltinov.geometry.PolylineBuilder.buildPolyline;
import static ru.baltinov.group.PeopleGroup.processFile;
import static ru.baltinov.main.Validator.getInt;
import static ru.baltinov.main.Validator.getListInt;

public class Test {
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
        8. Task8;
        0. Exit.
        ->""");
  }
  private void printTask1(){
    System.out.println("""
        В класс Дробь, добавить интерфейс на два метода: получение вещественного значения, установка
        числителя и установка знаменателя.
        Сгенерировать такую версию дроби, которая будет кэшировать вычисление вещественного
        значения.
        Если раннее в вашем варианте не было Дроби, то создайте сущность Дробь со следующими
        особенностями:
        • Имеет числитель: целое число
        • Имеет знаменатель: целое число
        • Дробь может быть создана с указанием числителя и знаменателя
        • Может вернуть строковое представление вида “числитель/знаменатель”
        • Необходимо корректно обрабатывать отрицательные значения. Учтите, что знаменатель не может
        быть отрицательным.
        • Переопределите метод сравнения объектов по состоянию таким образом, чтобы две дроби
        считались одинаковыми тогда, когда у них одинаковые значения числителя и знаменателя.
        -----------------------------------------""");
  }
  private void printTask2(){
    System.out.println("""
        Количество мяуканий.
        Необходимо воспользоваться классом Кот и методом принимающим всех мяукающих из задачи 2.5.4.
        Необходимо таким образом передать кота в указанный метод, что бы после окончания его работы
        узнать сколько раз мяукал кот за время его работы. На рисунке показан пример работы. Перед вызовом
        метода создаем кота, отправляем ссылку на кота в метод, после окончания его работы выводим
        количество мяуканий на экран. Кота изменять нельзя.
        Если раннее в вашем варианте не было Кота, то создайте
        1. сущность Кот, которая описывается следующим образом:
        • Имеет Имя (строка)
        • Для создания необходимо указать имя кота.
        • Может быть приведен к текстовой форме вида: “кот: Имя”
        • Может помяукать, что приводит к выводу на экран следующего текста: “Имя: мяу!”,
        вызвать мяуканье можно без параметров.
        2. интерфейс Мяуканье: разработайте метод, который принимает набор объектов способных
        мяукать и вызывает мяуканье у каждого объекта. Мяукающие объекты должны иметь метод со
        следующей сигнатурой:
        public void meow();
        -----------------------------------------""");
  }
  private void printTask3(){
    System.out.println("""
        Даны упорядоченные списки L1 и L2. Вставить элементы списка L2 в список L1, не нарушая его
        упорядоченности.
        -----------------------------------------""");
  }
  private void printTask4(){
    System.out.println("""
        На вход программы подаются сведения о результатах соревнований по школьному многоборью.
        Многоборье состоит из соревнований по четырем видам спорта, участие в каждом из которых
        оценивается баллами от 0 до 10 (0 баллов получает ученик, не принимавший участия в
        соревнованиях по данному виду спорта). Победители определяются по наибольшей сумме
        набранных баллов. Известно, что общее количество участников соревнований не превосходит
        100.
        В первой строке вводится количество учеников, принимавших участие в соревнованиях, N. Далее
        следуют N строк, имеющих следующий формат:
        <Фамилия><Имя><Баллы>
        Здесь <Фамилия>– строка, состоящая не более чем из 20 символов;<Имя>– строка, состоящая не
        более чем из 15 символов;<Баллы> - строка, содержащая четыре целых числа, разделенных
        пробелом, соответствующих баллам, полученным на соревнованиях по каждому из четырех
        видов спорта. При этом <Фамилия> и <Имя>, <Имя> и <Баллы> разделены одним пробелом.
        Примеры входных строк:
        Иванова Мария 5 8 6 3
        Петров Сергей 9 9 5 7
        Напишите программу, которая будет выводить на экран фамилии и имена трех лучших
        участников многоборья. Если среди остальных участников есть ученики, набравшие то же
        количество баллов, что и один из трех лучших, то их фамилии и имена также следует вывести.
        При этом имена и фамилии можно выводить в произвольном порядке.
        -----------------------------------------""");
  }
  private void printTask5(){
    System.out.println("""
        Файл содержит текст на русском языке. Сколько разных букв встречается в тексте?
        -----------------------------------------""");
  }
  private void printTask6(){
    System.out.println("""
        По списку L построить очередь (например, по списку из элементов 1, 2, 3 требуется построить
        очередь из элементов 1, 2, 3, 3, 2, 1).
        -----------------------------------------""");
  }
  private void printTask7(){
    System.out.println("""
        Необходимо написать стрим:
        Дан набор объектов типа Point, необходимо взять все Point в разных координатах, убрать с
        одинаковыми X,Y, отсортировать по X, отрицательные Y сделать положительными и собрать это
        все в ломаную (объект типа Polyline)
        Если раннее в вашем варианте не было задание с классом Point и Polyline, то написать их:
        1. класс Point:
        • Координата Х: число.
        • Координата Y: число.
        • Может возвращать текстовое представление вида “{X;Y}”.
        2. класс Line (Линия), расположенная на двумерной плоскости, которая описывается:
        • Координата начала: Точка
        • Координата конца: Точка
        • Может возвращать текстовое представление вида “Линия от {X1;Y1} до {X2;Y2}”
        3. класс Polyline (Ломаная), которая будет представлять собой ломаную линию. Ломаная
        линия представляет собой набор следующих характеристик:
        • Имеет массив Точек, через которые линия проходит.
        • Может быть приведена к строковой форме вида “Линия [Т1,T2,…,TN]”, где TN – это
        результат приведения к строке Точки с номером N
        -----------------------------------------""");
  }
  private void printTask8(){
    System.out.println("""
        Дан текстовый файл со строками, содержащими имя человека и его номер в следующей форме:
        Вася:5
        Петя:3
        Аня:5
        Номера людей могут повторяться. У каких-то людей может не быть номера.
        Необходимо написать стрим выполняющую следующее:
        читаются все люди из файла, все имена приводится к нижнему регистру, но с первой буквой в
        верхнем регистре, убираем из перечня всех людей без номеров, а имена оставшихся группируются
        по их номеру:
        [5:[Вася, Аня], 3:[Петя]]
        -----------------------------------------""");
  }

  //Задачи(1-8)
  public void number1(){
    printTask1();
    try {
    int num = getInt("Введите числитель дроби: ");
    int denom = getInt("Введите знаменатель дроби: ");

    Fraction fraction1 = new Fraction(num, denom);
    System.out.println("Дробь: " + fraction1);

    System.out.println(fraction1.getDecimalValue());
    System.out.println(fraction1.getDecimalValue());
    num = getInt("Введите новый числитель дроби: ");
    denom = getInt("Введите новый знаменатель дроби: ");
    fraction1.setNumeratorAndDenominator(num, denom);
    System.out.println(fraction1.getDecimalValue());
    } catch (Exception e) {
      System.out.println("Произошла ошибка: " + e.getMessage());
    }
  }
  public void number2(){
    printTask2();
    try {
      CounterMeow cat1 = new CounterMeow(new Cat("Барсик"));
      CounterMeow cat2 = new CounterMeow(new Cat("Мурка"));
      Funs.meowsCare(cat1, 10);
      cat1.meow();
      System.out.println(cat1 + " мяукнул " + cat1.getMeowCount());
      cat2.meow();
      Funs.meowsCare(cat2);
      System.out.println(cat2 + " мяукнул " + cat2.getMeowCount());
    } catch (Exception e) {
      System.out.println("Произошла ошибка: " + e.getMessage());
    }
  }
  public void number3(){
    printTask3();
    try{
      // Пример с числами
      System.out.println("Списки с числами:");
      List<Integer> list1 = getListInt("Введите список чисел упорядоченных: ");
      System.out.println(list1);
      List<Integer> list2 = getListInt("Введите список чисел упорядоченных: ");
      System.out.println(list2);

      ListMerger<Integer> integerMerger = new ListMerger<>(list1, list2);
      List<Integer> mergedNumbers = integerMerger.mergeLists();
      System.out.println("Объединенный числовой список: " + mergedNumbers);

      // Пример со строками
      List<String> strings1 = Arrays.asList("apple", "banana", "cherry");
      List<String> strings2 = Arrays.asList("apricot", "blueberry", "date");
      System.out.println("Списки со строками: ");
      System.out.println(strings1);
      System.out.println(strings2);

      ListMerger<String> stringMerger = new ListMerger<>(strings1, strings2);
      List<String> mergedStrings = stringMerger.mergeLists();
      System.out.println("Объединенный строковый список: " + mergedStrings);


    } catch (Exception e) {
      System.out.println("Произошла ошибка: " + e.getMessage());
    }
  }
  public void number4(){
    printTask4();
    try{
      List<Participant> participants = readParticipantsFromFile("Competition.txt");
      TreeMap<Integer, List<Participant>> scoreMap = fillScoreMap(participants);
      printWinners(scoreMap);
    } catch (Exception e) {
      System.out.println("Произошла ошибка: " + e.getMessage());
    }
  }
  public void number5(){
    printTask5();
    try{
      BufferedReader reader = new BufferedReader(new FileReader("Text.txt"));
      StringBuilder sb = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        sb.append(line).append("\n");
      }
      reader.close();

      String text = sb.toString();

      TextAnalyzer analyzer = new TextAnalyzer(text);

      int uniqueCount = analyzer.countUniqueLetters();

      System.out.println("Количество разных букв в тексте: " + uniqueCount);
    } catch (Exception e) {
      System.out.println("Произошла ошибка: " + e.getMessage());
    }
  }
  public void number6(){
    printTask6();
    try{
      List<Integer> L = getListInt("Введите список для создания очереди: ");
      MirroredQueue mirroredQueue = new MirroredQueue(L);
      System.out.println("Очередь: " + mirroredQueue);

      Queue<Integer> q = mirroredQueue.getQueue();
      System.out.println("Работа очереди: ");
      while (!q.isEmpty()) {
        System.out.print(q.poll() + " ");
      }
      System.out.println();
    } catch (Exception e) {
      System.out.println("Произошла ошибка: " + e.getMessage());
    }
  }
  public void number7(){
    printTask7();
    try{
      List<PointXY> inputPoints = Arrays.asList(
          new PointXY(1, -2),
          new PointXY(3, 4),
          new PointXY(1, -2),
          new PointXY(0, -1),
          new PointXY(-2, -3),
          new PointXY(0, 1)
      );

      Polyline polyline = buildPolyline(inputPoints);
      System.out.println(polyline);
      System.out.println("Длина: " + polyline.calculatePolylineLength());
    } catch (Exception e) {
      System.out.println("Произошла ошибка: " + e.getMessage());
    }
  }
  public void number8(){
    printTask8();
    try{
      String fileName = "people.txt";

      Map<Integer, List<String>> result = processFile(fileName);
      System.out.println(result);
    } catch (Exception e) {
      System.out.println("Произошла ошибка: " + e.getMessage());
    }
  }


}
