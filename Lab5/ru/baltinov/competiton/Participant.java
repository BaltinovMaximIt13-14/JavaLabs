package ru.baltinov.competiton;

public class Participant {
  String surname;
  String name;
  int[] scores = new int[4];

  //Конструктор
  public Participant(String surname, String name, int[] scores) {
    this.surname = surname;
    this.name = name;
    this.scores = scores;
  }

  //Свойства
  public int[] getScores() {
    return scores;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public int getTotalScore() {
    int sum = 0;
    for (int score : scores) {
      sum += score;
    }
    return sum;
  }

  @Override
  public String toString() {
    return surname + " " + name;
  }
}

