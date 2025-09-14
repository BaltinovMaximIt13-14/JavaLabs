import java.text.DecimalFormat;
import java.lang.Math;

public class Lab1 {
  Validator validator = new Validator();
  int numberOfTask2;

  //Вывод меню
  public void printMenu1() {
    System.out.print("""
            ___________________________
            Choose your number of task:
            1. Number 1;
            2. Number 2;
            3. Number 3;
            4. Number 4;
            0. Exit.
            ->""");
  }
  private void printMenu2() {
    System.out.print("""
            _________________
            Choose your task:
            1. Task 1;
            2. Task 3;
            3. Task 5;
            4. Task 7;
            5. Task 9;
            0. Exit.
            ->""");
  }

  //Меню с выбором задачи
  public void number1() {
    do {
      printMenu2();
      numberOfTask2 = validator.getInt("");
      switch (numberOfTask2) {
        case 1:
          double fractionX = validator.getDouble("Введите вещественное число для нахождения" +
                  " его дробной части (через запятую): ");
          System.out.print("Дробная часть числа " + fractionX + " равна -> ");
          System.out.println(new DecimalFormat("#.#####").format(fraction(fractionX)));
          break;
        case 2:
          char digit = validator.getCharInRange("Введите цифру от 1 до 9: ", '1', '9');
          System.out.println("Перевел цифру " + charToNum(digit) + " из char в int.");
          break;
        case 3:
          int number3 = validator.getInt("Введите число для проверки двузначное оно или нет: ");
          System.out.println("Результат проверки: " + is2Digits(number3));
          break;
        case 4:
          int aRange = validator.getInt("Введите диапазон от a до b или наоборот, сначала a: ");
          int bRange = validator.getInt("Теперь b: ");
          int numRange = validator.getInt("Теперь введите число для проверки его " +
                  "в диапазоне [a;b]/[b;a]: ");
          System.out.println("Результат: " + isInRange(aRange, bRange, numRange));
          break;
        case 5:
          int num1Equal = validator.getInt("Вводите 3 числа для проверки их " +
                  "эквивалентности одновременно.\nЧисло 1: ");
          int num2Equal = validator.getInt("Число 2: ");
          int num3Equal = validator.getInt("Число 3: ");
          System.out.println("Результат равенства: " + isEqual(num3Equal, num2Equal, num1Equal));
          break;
        default:
          break;
      }
    } while (numberOfTask2 != 0);
  }

  public void number2() {
    do {
      printMenu2();
      numberOfTask2 = validator.getInt("");
      switch (numberOfTask2) {
        case 1:
          int numAbs = validator.getInt("Введите число для последующего вывода его модуля: ");
          System.out.println("Модуль числа: " + abs(numAbs));
          break;
        case 2:
          int num35 = validator.getInt("Введите число для проверки делимость либо на 3, либо на 5: ");
          System.out.println("Результат проверки: " + is35(num35));
          break;
        case 3:
          int num1Max3 = validator.getInt("Введите 3 числа для нахождения максимума:\nЧисло 1: ");
          int num2Max3 = validator.getInt("Число 2: ");
          int num3Max3 = validator.getInt("Число 3: ");
          System.out.println("Максимальное число: " + max3(num1Max3, num3Max3, num2Max3));
          break;
        case 4:
          int num1Sum2 = validator.getInt("Введите 2 числа для нахождения их суммы (если сумма " +
                  "от 10 до 19, то результат: 20):\nЧисло 1: ");
          int num2Sum2 = validator.getInt("Число 2: ");
          System.out.println("Результат суммы: " + sum2(num2Sum2, num1Sum2));
          break;
        case 5:
          int dayOfWeek = validator.getInt("Введите номер недели для его форматирования в слово " +
                  "(от 1 до 7): ");
          System.out.println(dayOfWeek + " день недели это - " + day(dayOfWeek));
          break;
        default:
          break;
      }
    } while (numberOfTask2 != 0);
  }

  public void number3(){
    do {
      printMenu2();
      numberOfTask2 = validator.getInt("");
      switch (numberOfTask2){
        case 1:
          int countOfNum = validator.getIntInRange("Введите число x, которое будет служить" +
                  " границей перечисления чисел от 0 до x: ", 0, 2147483647);
          System.out.println("Полученный список от 0 до " + countOfNum + " : " + listNums(countOfNum));
          break;
        case 2:
          int countOfChet = validator.getIntInRange("Введите число x, которое будет служить" +
                  " границей перечисления четных чисел от 0 до x: ", 0, 2147483647);
          System.out.println("Полученный список четных чисел от 0 до " + countOfChet +
                  " : " + chet(countOfChet));
          break;
        case 3:
          long xLen = validator.getLong("Введите число для вычисления его длины: ");
          System.out.println("Длина числа " + xLen + " = " + numLen(xLen));
          break;
        case 4:
          int cntSquare = validator.getIntInRange("Введите длину квадрата для построения" +
                  " его модели: ", 0, 2147483647);
          square(cntSquare);
          break;
        case 5:
          int cntTriangle = validator.getIntInRange("Введите длину треугольника для построения" +
                  " его модели: ", 0, 2147483647);
          rightTriangle(cntTriangle);
          break;
        default:
          break;
      }
    }while (numberOfTask2 != 0);
  }

  public void number4(){
    do {
      printMenu2();
      numberOfTask2 = validator.getInt("");
      switch (numberOfTask2){
        case 1:
          int[] arr1 = validator.getArrInt("Введите элементы массива в строчку через пробел: ");
          printArr(arr1);
          int xFirst = validator.getInt("Введите x, чтобы найти его индекс первого вхождения: ");
          System.out.println("Результат (-1, если нет вхождения числа в массив): " + findFirst(arr1, xFirst));
          break;
        case 2:
          int[] arr2 = validator.getArrInt("Введите элементы массива в строчку через пробел, для " +
                  "нахождения максимального по модулю: ");
          printArr(arr2);
          System.out.println("Максимальное по модулю значение массива: " + maxAbs(arr2));
          break;
        case 3:
          int[] arr3 = validator.getArrInt("Введите элементы первого массива в строчку через пробел: ");
          printArr(arr3);
          int[] ins3 = validator.getArrInt("Введите элементы второго массива для вставки: ");
          printArr(ins3);
          int xPos = validator.getIntInRange("Введите позиицию массив 1, на которую вставить массив 2: ",
                  0, arr3.length);
          System.out.println("Полученный массив: ");
          int[] arrEnd = add(arr3, ins3, xPos);
          for (int i = 0; i < arrEnd.length; i++) {
            System.out.print(arrEnd[i] + " ");
          }
          System.out.print("\n");
          break;
        case 4:
          int[] arr4 = validator.getArrInt("Введите элементы массива для его реверсирования: ");
          printArr(arr4);
          System.out.println("Полученный массив: ");
          int[] arrResRev = reverseBack(arr4);
          for (int i = 0; i < arrResRev.length; i++) {
            System.out.print(arrResRev[i] + " ");
          }
          System.out.print("\n");
          break;
        case 5:
          int[] arr5 = validator.getArrInt("Введите элементы массива: ");
          printArr(arr5);
          int xFind = validator.getInt("Введите элемент, чтобы создать массив с индксами его вхождений: ");
          System.out.println("Полученный массив: ");
          int[] arrFindAll = findAll(arr5, xFind);
          for (int i = 0; i < arrFindAll.length; i++) {
            System.out.print(arrFindAll[i] + " ");
          }
          System.out.print("\n");
          break;
        default:
          break;
      }
    }while (numberOfTask2 != 0);
  }

  //Вспомогательный метод вывода массива
  private void printArr(int[] arr){
    System.out.println("Введенный массив: ");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.print("\n");
  }

  //Методы первого номера
  public double fraction(double x) {
    return Math.abs(x - ((long) x));
  }
  public int charToNum(char x) {
    return x - '0';
  }
  public boolean is2Digits(int x) {
    return (x >= 10 && x <= 99) || (x <= -10 && x >= -99);
  }
  public boolean isInRange(int a, int b, int num) {
    return ((a > b) && (num >= b && num <= a)) || ((a < b) && (num <= b && num >= a)) || ((a == b) && (a == num));
  }
  public boolean isEqual(int a, int b, int c) {
    return (a == b) && (b == c);
  }

  //Методы второго номера
  public int abs(int x) {
    if (x < 0) {
      x = -x;
    }
    return x;
  }
  public boolean is35 (int x){
    if (((x % 3 == 0) || (x % 5 == 0)) && ((x % 3 != 0) || (x % 5 != 0))){
      return true;
    } else {
      return false;
    }
  }
  public int max3 (int x, int y, int z){
    int max = x;
    if (y > max) {
      max = y;
    }
    if (z > max){
      max = z;
    }
    return max;
  }
  public int sum2 (int x, int y){
    if (((x+y) >= 10) && ((x+y) <= 19)){
      return 20;
    } else {
      return x+y;
    }
  }
  public String day (int x){
    String result;
    switch (x){
      case 1:
          result = "Понедельник";
        break;
      case 2:
          result = "Вторник";
        break;
      case 3:
          result = "Среда";
        break;
      case 4:
          result = "Четверг";
        break;
      case 5:
          result = "Пятница";
        break;
      case 6:
          result = "Суббота";
        break;
      case 7:
          result = "Воскресенье";
        break;
      default:
          result = "Это не день недели";
        break;
    }
    return result;
  }

  //Методы третьего номера
  public String listNums (int x){
    StringBuilder resultList = new StringBuilder();
    for (int i = 0; i <= x; i++){
      resultList.append(" ").append(i);
    }
    return resultList.toString();
  }
  public String chet (int x){
    StringBuilder resultChet = new StringBuilder();
    for (int i = 0; i <= x; i+=2){
      resultChet.append(" ").append(i);
    }
    return resultChet.toString();
  }
  public int numLen (long x){
    int cntLen = 0;
    while (x != 0){
      x /= 10;
      cntLen++;
    }
    return cntLen;
  }
  public void square (int x){
    for (int i = 0; i < x; i++){
      for (int j = 0; j < x; j++) {
        System.out.print("*");
      }
      System.out.print("\n");
    }
  }
  public void rightTriangle (int x){
    for (int i = 1; i <= x; i++){
      for (int j = 0; j < x-i; j++) {
        System.out.print(" ");
      }
      for (int j = 0; j < i; j++) {
        System.out.print("*");
      }
      System.out.print("\n");
    }
  }

  //Методы четвертого номера
  public int findFirst (int[] arr, int x){
    int i1 = -1;
    for (int i = 0; i < arr.length; i++){
      if (arr[i] == x){
        i1=i;
        break;
      }
    }
    return i1;
  }
  public int maxAbs (int[] arr){
    int maxAr = -1000000000;
    for (int i = 0; i < arr.length; i++){
      if (abs(arr[i]) > maxAr){
        maxAr = arr[i];
      }
    }
    return maxAr;
  }
  public int[] add (int[] arr, int[] ins, int pos){
    int lenHelp = arr.length + ins.length;
    int[] arrHelp = new int[lenHelp];
    for (int i = 0; i < pos; i++){
      arrHelp[i] = arr[i];
    }
    for (int i = pos; i < pos+ins.length; i++){
      arrHelp[i] = ins[i-pos];
    }
    for (int i = pos+ins.length; i < lenHelp; i++){
      arrHelp[i] = arr[i-ins.length];
    }
    return arrHelp;
  }
  public int[] reverseBack (int[] arr){
    int[] resRev = new int[arr.length];
    for (int i = arr.length-1; i >= 0; i--){
      resRev[arr.length-i-1] = arr[i];
    }
    return resRev;
  }
  public int[] findAll (int[] arr, int x){
    int cnt = 0;
    for (int i = 0; i < arr.length; i++){
      if (arr[i] == x){
        cnt++;
      }
    }
    int[] indexArr = new int[cnt];
    int j1 = 0;
    for (int i = 0; i < arr.length; i++){
      if (arr[i] == x){
        indexArr[j1] = i;
        j1++;
      }
    }
    return indexArr;
  }
}