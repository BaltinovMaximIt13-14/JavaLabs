import java.util.regex.Pattern;

public class Student {
  final private String name;
  private int[] grades;
  Validator validator = new Validator();

  //Свойства
  public String getName() {
    return name;
  }
  public int[] getGrades() {
    return grades;
  }

  public void setGrades(int[] grades) {
    this.grades = grades;
  }

  //Конструктор
  public Student(){
    this.name = null;
    this.grades = null;
  }

  public Student(String name, int[] grades){
    this.grades = grades;
    while (true) {
      if (Pattern.matches("^[a-zA-Zа-яА-ЯёЁ\\s]+$", name)) {
        this.name = name;
        break;
      }
      name = validator.getString("");
      System.out.println("Ошибка: Строка должна содержать только буквы!");
    }
  }

  //Текстовое представление
  @Override
  public String toString(){
    StringBuilder textOutput = new StringBuilder(name + ": ");
    for (int i = 0; i < grades.length; i++){
      textOutput.append(grades[i]+" ");
    }
    return textOutput.toString();
  }
}
