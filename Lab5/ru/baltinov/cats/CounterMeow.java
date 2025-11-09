package ru.baltinov.cats;
public class CounterMeow implements Meowable {
  private Meowable decorated;
  private int meowCount;

  public CounterMeow(Meowable decorated) {
    this.decorated = decorated;
    this.meowCount = 0;
  }

  @Override
  public void meow() {
    decorated.meow();
    meowCount++;
  }

  public int getMeowCount() {
    return meowCount;
  }

  public void resetMeowCount() {
    meowCount = 0;
  }

  // Геттер
  public Meowable getDecorated() {
    return decorated;
  }

  @Override
  public String toString(){
    return decorated.toString();
  }
}