//Запускает программу и первичное меню для выбора номера
public class Main {
  public static void main(String[] args) {
    int numberOfTask1;
    Lab1 test = new Lab1();
    Validator validator = new Validator();
    //Меню в выбором номера
    do {
      test.printMenu1();
      numberOfTask1 = validator.getInt("");
      switch (numberOfTask1){
        case 1:
          test.number1();
          break;
        case 2:
          test.number2();
          break;
        case 3:
          test.number3();
          break;
        case 4:
          test.number4();
          break;
        default:
          break;
      }
    }while (numberOfTask1 != 0);

    System.out.println("""
        ________________________________
        Program finished
        """);
  }
}