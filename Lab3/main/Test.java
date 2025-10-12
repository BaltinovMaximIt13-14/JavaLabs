package ru.baltinov.main;

import ru.baltinov.dataStructures.Array;
import ru.baltinov.geometry.*;
import ru.baltinov.geometry.variablePoint.*;
import ru.baltinov.main.calculatorSum.*;

import static ru.baltinov.main.Power.power;
import static ru.baltinov.main.calculatorSum.SumCalculator.sum;

public class Test {
  Validator validator = new Validator();
  //Выводы меню и условий задач
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
  private void printTask1_6(){
    System.out.println("""
        Отдельные линии.
        Измените сущность Линия из задачи 1.5.3. Необходимо, чтобы Линия соответствовала
        следующим требованиям:
         Две любые линии не могут ссылаться на один и тот же объект точки.
         У Линии можно изменить координаты начала или конца
         У Линии можно запросить координаты начала или конца
        Продемонстрируйте работоспособность решения на примерах.""");
  }
  private void printTask1_12(){
    System.out.println("""
        Квадрат.Создайте сущность Квадрат. Квадрат описывается следующими характеристиками:
         Имеет Точку (из задачи 1.4.1) отмечающую левый верхний угол
         Имеет длину стороны.
         Создается путем указания точки левого верхнего угла и размера стороны
         Создается путем указания координаты xи y левого верхнего угла и размера стороны
         Может быть приведен к строке вида “Квадрат в точке T со стороной N”, где N – длина
        стороны, а T – результат приведения к строке верхнего левого угла
         Может возвращать новую Ломаную (из задачи 1.5.7), точки которой соответствуют
        точкам углов текущего квадрата.
        Необходимо выполнить следующие задачи:
        1. Создайте Квадрат в точке {5;3} со стороной 23
        2. Присвойте в ссылку типа Ломаная результат вызова метода получения Ломаной у ранее
        созданного квадрата
        3. Выведите на экран общую длину полученной Ломаной
        4. Сдвиньте последнюю Точку Ломаной в позицию {15,25}
        5. Снова выведите на экран длину Ломаной""");
  }
  private void printTask2_1(){
    System.out.println("""
        Неизменяемый массив.
        Необходимо разработать сущность НеизменяемыйСписокЗначений, представляющий собой
        обертку над массивом целых чисел, который сохранит функциональные возможности массивов,
        но добавит некоторые дополнительные возможности.
        Состояние сущности описывают следующие сведения:
         Имеет массив целых чисел. Именно он используется для хранения значений.
        Инициализация сущности может быть выполнена следующим образом:
         С указанием значений в виде массива целых чисел.
         С указанием перечня чисел как независимых значений (через запятую)
         С указанием другого Списка, в этом случае копируются все значения указанного списка.
        Поведение сущности описывают следующие действия:
         Получение значения из позицииN. Позиция должна попадать в диапазон от 0 до N-1, где
        N–текущее количество значений, иначе выкинуть ошибку.
         Замена значения в позиции N на новое значение. Позиция должна попадать в диапазон от
        0 до N-1, где N–текущее количество значений, иначе выкинуть ошибку.
         Может быть приведен к строке. Строка должна представлять собой полный перечень всех
        хранимых чисел, причем первый символ строки это ”[“, а последний “]”.
         Можно проверить пуст Список или нет. Список пуст если его размер 0.
         Можно узнать текущий размер.
         Все хранящиеся значения можно запросить в виде стандартного массива.
        Продемонстрируйте работоспособность решения на примерах.""");
  }
  private void printTask3_5(){
    System.out.println("""
        Трехмерная точка.
        Создайте такой подвид сущности Точка из задачи 1.1.1, которая будет иметь не две, а три
        координаты на плоскости: X,Y,Z.
        """);
  }
  private void printTask4_5(){
    System.out.println("""
        Точки.
        Необходимо разработать сущности, которые позволят создавать Точки координат с разными
        характеристиками. Например, мы можем иметь точки координат со следующими
        характеристиками:
         Одна, две или три координаты в пространстве (X,Y,Z: целые числа)
         Цвет точки (строка)
         Время появления точки (строка)
        Обратите внимание, что эти характеристики не составляют исчерпывающий список (так как в
        будущем могут появиться новые характеристики) и могут составлять любые комбинации,
        например:
         Точка в координате 3, красного цвета
         Точка в координате {4,2,5} в 11:00
         Точка в координате {7,7} в 15:35, желтого цвета
        С целью совместимости с последующими задачами, сохраните Двухмерную и Трёхмерную точки
        из задачи 2.3.5 без изменений.""");
  }
  private void printTask5_1(){
    System.out.println("""
        Сложение.
        Разработайте метод, который принимает набор числовых значенийи возвращает их сумму в
        вещественной форме.""");
  }
  private void printTask6_3(){
    System.out.println("""
        Сравнение линий.
        Измените сущность Линия из задачи 2.1.6.Переопределите метод сравнения объектов по
        состоянию таким образом, чтобы две линии считались одинаковыми в том случае, если их начало
        и конец расположены в одинаковых точках.
        """);
  }
  private void printTask7_123(){
    System.out.println("""
        1 Навести порядок.
        Данная задача предполагает реорганизацию ранее написанных классов. Расположите все ранее
        написанные классы по пакетам таким образом, чтобы логически близкие классы оказались
        сгруппированы друг с другом. Имена пакетов должны иметь как минимум трехсоставную форму,
        вида: ru.surname.type. Вместо surname следует подставить свою фамилию, а вместо type
        подставить название логического блока. Например, классы описывающие точку, линию, ломаную
        линию, фигуру, квадрат, треугольник, круг и прямоугольник можно расположить в пакете
        ru.surname.geometry.
        2 Главный метод.
        Создайте пакет ru.surname.main (вместо surname необходимо подставить собственную
        фамилию) в котором расположить класс с точкой входа в исполнение программы (public static void
        main). Также следует проверить, что ни в одном другом пакете нет классов имеющих точку входа
        в исполнение программы. В этом же пакете необходимо расположить класс (или интерфейс) с
        методами из задач блока 2.5 и продемонстрировать их работоспособность.
        3 Возведение в степень.
        Создайте метод принимающий две строки, в которых будут записаны числа X и Y. Возвращает
        метод результат возведения X в степень Y. Для преобразования строки в число следует
        использовать метод Integer.parseInt, а для возведения в степень метод Math.pow. Вызовите
        разработанный метод передав туда параметры командной строки полученные точкой входа в
        программу. Реализуйте метод так, что бы для возведения в степень и преобразования строки
        использовались короткие имена статических методов.
        """);
  }
  private void printTask8_5(){
    System.out.println("""
        Клонирование линии.
        Измените сущность Линия из 2.6.3.
        Переопределите метод клонирования, унаследованный от класса Object, таким образом, чтобы
        при его вызове возвращался новый объект Линии, значения полей которого будут копиями
        оригинальной Линии.""");
  }


  //Алгоритмы тестирования сущностей
  public void number1(){
    printTask1_6();
    try {
      System.out.println("=== Начало работы программы ===");
      Line line1 = new Line(validator.getInt("Вводите координаты точек линии 1:\n" +
          "XStart:"),
          validator.getInt("YStart:"),
          validator.getInt("XEnd:"),
          validator.getInt("YEnd:"));
      System.out.println("Линия 1 создана: " + line1);
      System.out.println("Длина: " + line1.length());

      PointXY sharedPoint = new PointXY(0, 0);
      Line line2 = new Line(sharedPoint, new PointXY(3, 3));
      sharedPoint.setX(100);
      System.out.println("Линия 2 после изменения исходной точки: " + line2);

      line2.setPStart(line1.getPEnd());
      System.out.println("Линия 2 после изменения точки конца геттером: " + line2);

      System.out.println("\n=== Тестирование исключений ===");

      // Эта строка вызовет исключение
      //ru.baltinov.geometry.variablePoint.Line badLine1 = new ru.baltinov.geometry.variablePoint.Line(null, new Point(1, 1))

      // Эта строка вызовет исключение
      //ru.baltinov.geometry.variablePoint.Line badLine2 = new ru.baltinov.geometry.variablePoint.Line(new Point(1, 1), new Point(1, 1));

      // Эта строка вызовет исключение
      //ru.baltinov.geometry.variablePoint.Line badLine3 = new ru.baltinov.geometry.variablePoint.Line(2, 2, 2, 2);


    } catch (IllegalArgumentException e) {
      // Перехватываем ВСЕ IllegalArgumentException из всего блока try
      System.err.println("Произошла ошибка: " + e.getMessage());
    }

    try {

      System.out.println("-------------------------------------------------------------------");
      printTask1_12();
      Square square = new Square(new PointXY(5, 3), 23);
      System.out.println(square);
      Polyline polyline = square.toPolyline();
      System.out.println("Длина ломаной: " + polyline.calculatePolylineLength());
      polyline.replacePoint(4, new PointXY(15, 25));
      System.out.println("Длина ломаной: " + polyline.calculatePolylineLength());
    } catch (IllegalArgumentException e) {
        // Перехватываем ВСЕ IllegalArgumentException из всего блока try
        System.err.println("Произошла ошибка: " + e.getMessage());
    }
  }
  public void number2(){
    try {
      printTask2_1();
      System.out.println("-----------------------------------");
      int[] arrInput = validator.getArrInt("Введите массив целых чисел для создания Списка: ");
      //Конструктор массивом
      Array arr1 = new Array(arrInput);
      //Конструктор копией
      Array arr2 = new Array(arr1);
      //Конструктор перечнем независимых чисел
      Array arr3 = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);


      int cnt = validator.getInt("Введите номер элемента для вывода его из первого списка " +
          "и замены его из второго списка: ");
      int cntRep = validator.getInt("Введите на какое число поменять элемент выше: ");
      System.out.println(cnt + " элемент первого массива: " + arr1.getElement(cnt));
      arr2.replace(cnt, cntRep);
      System.out.println(cnt + " элемент второго массива заменили на " + arr2.getElement(cnt));
      System.out.println("Первый массив: " + arr1);
      System.out.println("Первый массив: " + arr2);
      System.out.println("Третий массив: " + arr3);
      System.out.println("Проверка на пустой третий массив: " + arr3.empty());
      System.out.println("Размер второго массива: " + arr2.size());
    } catch (IllegalArgumentException e) {
      System.err.println("Произошла ошибка: " + e.getMessage());
    }

  }
  public void number3(){

    try {
      printTask3_5();
      int x1, y1, z1;
      //Создание первой точки
      System.out.println("Первая точка:");
      x1 = validator.getInt("Введите координаты для первой точки:\nX: ");
      y1 = validator.getInt("Y: ");
      z1 = validator.getInt("Z: ");
      PointXYZ p1 = new PointXYZ(x1, y1, z1);
      System.out.println("Точка1: " + p1);
      System.out.println("---");

      //Создание второй точки
      PointXYZ p2 = new PointXYZ(p1);
      System.out.println("Вторая точка (копия первой, с измененными координатами):");
      p2.setX(validator.getInt("Поменяйте координату x: "));
      p2.setY(validator.getInt("Поменяйте координату y: "));
      p2.setZ(validator.getInt("Поменяйте координату z: "));
      System.out.println("Точка2: " + p2);
      System.out.println("---");

      //Создание третьей точки
      PointXYZ p3 = new PointXYZ();
      System.out.println("Третья точка, созданная конструктором по умолчанию:");
      System.out.println("Точка3: " + p3);
      p3.setX(validator.getInt("Поменяйте x: "));
      p3.setY(validator.getInt("Поменяйте y: "));
      p3.setZ(validator.getInt("Поменяйте z: "));
      System.out.println("Точка3: " + p3);
      System.out.println("---");
    } catch(IllegalArgumentException e) {
      System.err.println("Произошла ошибка: " + e.getMessage());
    }
  }
  public void number4(){
    printTask4_5();
    try {


      Point point1 = new ColorPoint(new PointX(3), "red");

      // 2. Точка в координате {4,2,5} в 11:00
      Point point2 = new TimePoint(new PointXYZ(4, 2, 5), "11:00");

      // 3. Точка в координате {7,7} в 15:35, желтого цвета
      Point point3 = new ColorPoint(
          new TimePoint(new PointXY(7, 7), "15:35"),
          "yellow"
      );


      System.out.println("Точка 1: " + point1);
      System.out.println("Точка 2: " + point2);
      System.out.println("Точка 3: " + point3);

      System.out.println("Координаты точки 1: " + ((ColorPoint) point1).getCoordinates());
      System.out.println("Координаты точки 2: " + ((TimePoint) point2).getCoordinates());

      Point simple1D = new PointX(5);
      Point simple2D = new PointXY(2, 8);
      Point simple3D = new PointXYZ(1, 2, 3);

      System.out.println("1D точка: " + simple1D);
      System.out.println("2D точка: " + simple2D);
      System.out.println("3D точка: " + simple3D);
    } catch (IllegalArgumentException e){
      System.err.println("Произошла ошибка: " + e.getMessage());
    }

  }
  public void number5(){
    printTask5_1();

    // Первое выражение: 2 + 3/5 + 2.3
    NumericValue[] expr1 = {
        new IntegerValue(2),
        new FractionValue(3, 5),
        new DoubleValue(2.3)
    };
    double result1 = sum(expr1);
    System.out.println("2 + 3/5 + 2.3 = " + result1);

    // Второе выражение: 3.6 + 49/12 + 3 + 3/2
    NumericValue[] expr2 = {
        new DoubleValue(3.6),
        new FractionValue(49, 12),
        new IntegerValue(3),
        new FractionValue(3, 2)
    };
    double result2 = sum(expr2);
    System.out.println("3.6 + 49/12 + 3 + 3/2 = " + result2);

    // Третье выражение: 1/3 + 1
    NumericValue[] expr3 = {
        new FractionValue(1, 3),
        new IntegerValue(1)
    };
    double result3 = sum(expr3);
    System.out.println("1/3 + 1 = " + result3);
  }
  public void number6(){
    printTask6_3();
    try{
      PointXY p1 = new PointXY(0, 0);
      PointXY p2 = new PointXY(3, 4);
      PointXY p3 = new PointXY(5, 5);

      LineEquals line1 = new LineEquals(p1, p2);
      LineEquals line2 = new LineEquals(p2, p1);
      LineEquals line3 = new LineEquals(p1, p3);

      System.out.println("line1 equals line2: " + line1.equals(line2));
      System.out.println("line1 equals line3: " + line1.equals(line3));

    } catch (IllegalArgumentException e){
      System.err.println("Произошла ошибка: " + e.getMessage());
    }
  }
  public void number7(){
    printTask7_123();
  }
  public void number8(){
    printTask8_5();
    int x1 = validator.getInt("Введите координаты линии:\nXS:");
    int y1 = validator.getInt("YS:");
    int x2 = validator.getInt("XE:");
    int y2 = validator.getInt("YE:");
    PointXY p1 = new PointXY(x1, y1);
    PointXY p2 = new PointXY(x2, y2);

    LineEquals original = new LineEquals(p1, p2);
    System.out.println("Оригинал: " + original);

    LineEquals cloned = original.clone();
    System.out.println("Клон: " + cloned);

    System.out.println("Один и тот же объект? " + (original == cloned)); // false
    System.out.println("Равны по содержанию? " + original.equals(cloned)); // true

    cloned.setPStart(new PointXY(1, 1));
    System.out.println("После изменения клона:");
    System.out.println("Оригинал: " + original);
    System.out.println("Клон: " + cloned);

  }
}
