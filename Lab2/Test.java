public class Test {
Validator validator = new Validator();
  //Вывод меню
  public void printMenu(){
    System.out.print("""
        --------------------
        Choose your task:
        1. Task1;
        2. Task2;
        3. Task3;
        4. Task4;
        5. Task5;
        0. Exit.
        ->""");
  }
  private void task1Menu(){
    System.out.println("""
        Точка координат.
        Создайте сущность Точка, расположенную на двумерной плоскости, которая описывается:
         Координата Х: число
         Координата Y: число
         Может возвращать текстовое представление вида “{X;Y}”
        Необходимо создать три точки с разными координатами и вывести на экран их текстовое
        представление.
        -----------------""");
  }
  private void task2Menu(){
    System.out.println("""
        Прямая.
        Создайте сущность Линия, расположенную на двумерной плоскости, которая описывается:
         Координата начала: Точка
         Координата конца: Точка
         Может возвращать текстовое представление вида “Линия от {X1;Y1} до {X2;Y2}”
        Для указания координат нужно использовать сущность Точка, разработанную в задании 1.1. Создайте
        линии со следующими характеристиками:
        1. Линия 1 с началом в т. {1;3} и концом в т.{23;8}.
        2. Линия 2, горизонтальная, на высоте 10, от точки 5 до точки 25.
        3. Линия 3, которая начинается всегда там же, где начинается линия 1, и заканчивается всегда там
        же, где заканчивается линия 2. Таким образом, если положение первой или второй линии
        меняется, то меняется и третья линия.
        4. После создания всех трех объектов измените координаты первой и второй линий, причем
        сделайте это таким образом, чтобы положение третьей линии соответствовало требованиям
        пункта 3.
        5. Измените координаты первой линии так, чтобы при этом не изменились, координаты третьей
        линии.
        -----------------""");
  }
  private void task3Menu(){
    System.out.println("""
        Студент.
        Создайте сущность Студент, которая описывается:
         Имя: строка
         Оценки: массив целых чисел.
         Может возвращать текстовое представление вида “Имя: [оценка1, оценка2,...,оценкаN]”
        Необходимо выполнить следующие задачи:
        1. Создать студента Васю с оценками: 3,4,5.
        2. Создать студента Петю и скопировать оценки Васи, присвоив содержимое поля с
        оценками Васи полю с оценками Пети.
        3. Заменить первую оценку Пети на число 5. Вывести на экран строковое представление
        Васи и Пети. Объяснить результат
        4. Создать студента Андрея и скопировать ему оценки Васи так, чтобы изменение оценок
        Васи не влияло на Андрея.
        --------------""");
  }
  private void task4Menu1(){
    System.out.println("""
        Создаем Точку.
        Измените сущность Точка из задачи 1.1. В соответствии с новыми требованиями создать объект
        Точки можно только путем указания обеих координат:X и Y.
        Необходимо выполнить следующие задачи:
         Создайте и выведите на экран точку с координатами 3;5
         Создайте и выведите на экран точку с координатами 25;6
         Создайте и выведите на экран точку с координатами 7;8
        -------------------""");


  }
  private void task4Menu2(){
    System.out.println("""
        Создаем Линию.
        Измените сущность Линия из задачи 2.1. Новые требования включают:
         Создание Линии возможно с указанием Точки начала и Точки конца (Точки из задачи 4.1)
         Создание Линии возможно с указанием координат начала и конца как четырех чисел
        (x1,y1,x2,y2)
        Создайте линии со следующими характеристиками:
        1. Линия 1 с началом в т. {1;3} и концом в {23;8}.
        2. Линия 2, горизонтальная, на высоте 10, от точки 5 до точки 25.
        3. Линия 3 которая начинается всегда там же где начинается линия 1, и заканчивается
        всегда там же, где заканчивается линия 2.""");
  }
  private void task5Menu(){
    System.out.println("""
        Длина Линии.
        Измените сущность Линия из задачи 4.2. Добавьте ей возможность возвращать по запросу
        пользователя расстояние между точками начала и конца (в виде целого числа). Создайте линию
        из точки {1;1} в точку {10;15} и выведите на экран её длину.
        ----------------""");
  }

  //Задание 1
  public void number1(){
    task1Menu();
    int x1, y1;

    //Создание первой точки
    System.out.println("Первая точка:");
    x1 = validator.getInt("Введите координаты для первой точки:\nX: ");
    y1 = validator.getInt("Y: ");
    Point p1 = new Point(x1, y1);
    System.out.println("Точка1: " + p1);
    System.out.println("---");

    //Создание второй точки
    Point p2 = new Point(p1);
    System.out.println("Вторая точка (копия первой, с измененной второй координатой):");
    p2.setY(validator.getInt("Поменяйте координату y: "));
    System.out.println("Точка2: " + p2);
    System.out.println("---");

    //Создание третьей точки
    Point p3 = new Point();
    System.out.println("Третья точка, созданная конструктором по умолчанию:");
    System.out.println("Точка3: " + p3);
    p3.setX(validator.getInt("Поменяйте x: "));
    p3.setY(validator.getInt("Поменяйте y: "));
    System.out.println("Точка3: " + p3);
  }

  //Задание 2
  public void number2(){
    task2Menu();

    //Линия 1
    Line line1 = new Line(new Point(1, 3 ), new Point(23, 8));
    System.out.println("Создана первая линия:\n" + line1);

    //Линия 2
    Line line2 = new Line(5, 10, 25, 10);
    System.out.println("Создана вторая линия:\n" + line2);

    //Линия 3
    Line line3 = new Line(line1.getPStart(), line2.getPEnd());
    System.out.println("Создана третья линия:\n" + line3);
    System.out.println("---------------");

    //Смена координат первой и второй линий.
    int xS = validator.getInt("Поменяйте координаты начала первой линии:\nX: ");
    int yS = validator.getInt("Y: ");
    line1.getPStart().setX(xS);
    line1.getPStart().setY(yS);
    int xE = validator.getInt("Поменяйте координаты конца второй линии:\nX: ");
    int yE = validator.getInt("Y: ");
    line2.getPEnd().setX(xE);
    line2.getPEnd().setY(yE);

    System.out.println("Первая линия:\n" + line1);
    System.out.println("Вторая линия:\n" + line2);
    System.out.println("Третья линия:\n" + line3);
    System.out.println("----------------");

    //Смена координат первой линии без изменения
    int x1S = validator.getInt("Поменяйте координаты начала первой линии:\nX: ");
    int y1S = validator.getInt("Y: ");
    line1.setPStart(new Point(x1S, y1S));
    System.out.println("Первая линия:\n" + line1);
    System.out.println("Третья линия:\n" + line3);

  }

  //Задание 3
  public void number3(){
    task3Menu();

    //Создание Васи
    int[] gradesVasya = {3, 4, 5};
    Student vasya = new Student("Vasya", gradesVasya);
    System.out.println("Создан студент 1: " + vasya);

    //Создание Пети
    Student petya = new Student("Petya", vasya.getGrades());
    System.out.println("Создан студент 2: " + petya);
    System.out.println("--------------");

    //Замена первой оценки Пети
    petya.getGrades()[0] = 5;
    System.out.println("Заменили первую оценку только у Пети.");
    System.out.println("Cтудент 1: " + vasya);
    System.out.println("Cтудент 2: " + petya);
    System.out.println("--------------");

    //Создание Андрея без влияния изменения на Васю
    Student andrew = new Student("Andrew", vasya.getGrades().clone());
    System.out.println("Cтудент 2: " + petya);
    System.out.println("Cтудент 3: " + andrew);
    System.out.println("--------------");

    vasya.getGrades()[1] = 5;
    System.out.println("Заменили первую оценку только у Пети.");
    System.out.println("Cтудент 2: " + vasya);
    System.out.println("Cтудент 3: " + andrew);
    System.out.println("--------------");
  }

  //Задание 4
  public void number4(){
    task4Menu1();

    //Создание и вывод трех точек
    PointEdited point1 = new PointEdited(3, 5);
    System.out.println("1 точка:" + point1);
    PointEdited point2 = new PointEdited(25, 6);
    System.out.println("2 точка:" + point2);
    PointEdited point3 = new PointEdited(7, 8);
    System.out.println("3 точка:" + point3);

    task4Menu2();

    //Создание линий
    LineEdited lineE1 = new LineEdited(new PointEdited(1, 3 ), new PointEdited(23, 8));
    System.out.println("Создана первая линия:\n" + lineE1);

    LineEdited lineE2 = new LineEdited(5, 10, 25, 10);
    System.out.println("Создана вторая линия:\n" + lineE2);

    LineEdited lineE3 = new LineEdited(lineE1.getPStart(), lineE2.getPEnd());
    System.out.println("Создана третья линия:\n" + lineE3);

  }

  //Задание 5
  public void number5(){
    Line5task line1L = new Line5task(1, 1, 10, 15);
    System.out.println("Создана линия:\n" +
        line1L + ". Длина: " + line1L.length());
    int choose;
    do{
      choose = validator.getInt("""
      ---------
      Выберите действие:
      1.Создать линию и вывести длину;
      2.Создать линию;
      0.Выход.
      ->""");
      switch (choose){
        case 1:
          int xLS = validator.getInt("Введите координаты начала линии:\nX:");
          int yLS = validator.getInt("Y:");
          int xLE = validator.getInt("Введите координаты конца линии:\nX:");
          int yLE = validator.getInt("Y:");
          Line5task line2L = new Line5task(xLS, yLS, xLE, yLE);
          System.out.println("Создана линия:\n" +
              line2L + ". Длина: " + line2L.length());
        break;
        case 2:
          int xS = validator.getInt("Введите координаты начала линии:\nX:");
          int yS = validator.getInt("Y:");
          int xE = validator.getInt("Введите координаты конца линии:\nX:");
          int yE = validator.getInt("Y:");
          Line5task line3L = new Line5task(xS, yS, xE, yE);
          System.out.println("Создана линия:\n" +
              line3L);
          break;
        default:
          break;
      }
    } while(choose != 0);
  }
}
